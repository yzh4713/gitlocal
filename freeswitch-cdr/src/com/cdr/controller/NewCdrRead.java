package com.cdr.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdr.bean.NewCdr;
import com.cdr.service.NewCdrService;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

/**
 * 1.frrswitch服务写入话单数据 ---post 请求 xml 参数
 * 
 * 2.接受话单数据---解析xml参数获取对应值，插入数据表xxxx
 * 
 * @author PCyzh
 *
 */

@Controller
@RequestMapping("/cdr")
public class NewCdrRead {

	protected static Logger log = LoggerFactory.getLogger(NewCdrRead.class.getName());

	@Autowired
	private NewCdrService cdrServcie;

	@RequestMapping("/read")
	public void getDocument(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println("接受话单数据并解析插入数据库");

		Document doc = null;
		InputStream ins = null;
		SAXReader sr = null;
		Element root = null;
		Element foo;
		List<Element> elementList = null;

		try {
			System.out.println("拿到uuid：" + req.getParameter("uuid"));
			ins = req.getInputStream();
			String type = req.getContentType();
			System.out.println("内容类型：" + type);

			sr = new SAXReader();
			doc = sr.read(ins);

			String xmlStr = doc.asXML();			
			xmlStr.substring(4, xmlStr.length() - 4);

			// 把获取的xml参数，生成本地文件
			Found_LocalFile localFile = new Found_LocalFile();
			localFile.AppendWriteFile(req.getParameter("uuid"),xmlStr);

			ByteInputStream bis = new ByteInputStream();
			ByteArrayInputStream bais = new ByteArrayInputStream(xmlStr.getBytes());

			doc = sr.read(bais);
			root = doc.getRootElement();// 根节点
			System.out.println("根节点" + root.getName());

			elementList = root.elements();// 获取根节点下面的所有子节点(不包括子节点的子节点)
			for (Element eroot : elementList) {
				System.out.println("根节点下面的节点：" + eroot.getName());
			}

			NewCdr cdr = new NewCdr();
			boolean insert;
			if (elementList.size() > 1) {// 判断是否存在子节点
				String node;
				for (Element eroot : elementList) {
					node = eroot.getName();
					if (node.equals("variables")) { // 递归获取需要的值
						for (Iterator i = root.elementIterator("variables"); i.hasNext();) {
							foo = (Element) i.next();

							cdr.setUuid(foo.elementText("uuid"));// 唯一id

							String ani = root.element("callflow").element("caller_profile").elementText("ani");
							String dnis = root.element("callflow").element("caller_profile")
									.elementText("destination_number");
							cdr.setAni(ani);// 主叫号
							cdr.setDnis(dnis);// 被叫号

							cdr.setCallType(1);// acd呼入
							// 发起呼叫的日期/时间 此值为“ 2008-07-31％2011％3A35％3A38”（2008-07-31 11:35:38）
							Date start_stamp = strApend(foo.elementText("start_stamp"));
							cdr.setStartStamp(start_stamp);
							System.out.println("45644**********" + start_stamp.getTime());
							Date end_stamp = strApend(foo.elementText("end_stamp"));
							cdr.setEndStamp(end_stamp);

							cdr.setAnswerEpoch(Integer.valueOf(foo.elementText("answer_epoch")));// 应答时间
							cdr.setStartEpoch(Integer.valueOf(foo.elementText("start_epoch")));// 通话开始时间
							cdr.setEndEpoch(Integer.valueOf(foo.elementText("end_epoch")));// 通话结束时间

							int callDuraling = Integer.valueOf(foo.elementText("end_epoch"))
									- Integer.valueOf(foo.elementText("start_epoch"));
							cdr.setCallDuraling(callDuraling);//通话时长

							Date date = new Date();
							log.info("当前日期时间："+date);
							cdr.setCreatTime(date);// 当前时间
							cdr.setUpdateTime(date);// 修改时间

							String value = "is null";
							cdr.setValue1(value);// 预留字段
							cdr.setValue2(value);
							cdr.setValue3(value);
							cdr.setValue4(value);

							int inset = cdrServcie.insert(cdr);
							
							if (inset <= 0 ) {
								
								log.info("插入数据失败.....");
								
							} else {
								
								resp.setStatus(200);
								resp.setCharacterEncoding("utf-8");
								resp.setContentType("application/json; charset=utf-8");
								
								PrintWriter respWriter = resp.getWriter();
								Map<String, Object> map = new HashMap<>();
								map.put("status", resp.getStatus());
								map.put("msg", "OK");
								String name = "返回的状态为：";
								respWriter.write(name+map.get("status")+" "+map.get("msg"));
							}

						}
					}
				}
			}

			/*
			 * Element element = root.element("variables");// 获取根节点下的子节点 List<Element> list
			 * = element.elements(); for (Element e : list) {
			 * System.out.println("variables子节点下面的节点：" + e.getName()); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ins != null) {
					ins.close();
					ins = null;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * TODO:方法描述 
	 * 1.把获取到的字符串拆成字符串日期 
	 * 2.转成date类型返回	 * 
	 * @version 2019年11月3日下午2:00:20
	 * @author IdeaProjects
	 * @param str
	 */
	private Date strApend(String str) {
		// “ 2008-07-31％2011％3A35％3A38”（2008-07-31 11:35:38）
		String strTxt = str.subSequence(0, 10) + " " + str.subSequence(13, 15) + ":" + str.subSequence(18, 20) + ":"
				+ str.subSequence(23, 25);

		System.out.println("获取数据：" + str + "\n" + "截取数据：" + strTxt);

		SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = slf.parse(strTxt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

}