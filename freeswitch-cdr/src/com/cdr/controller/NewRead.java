package com.cdr.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
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

import com.cdr.bean.CallDetail;
import com.cdr.bean.NewCdr;
import com.cdr.service.CallDetailService;
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
public class NewRead {

	protected static Logger log = LoggerFactory.getLogger(NewRead.class.getName());

	@Autowired
	private CallDetailService callservcie;

	@RequestMapping("/insert")
	public void getDocument(HttpServletRequest req,HttpServletResponse resp) throws Exception {

		System.out.println("接受话单数据并解析插入数据库");

		Document doc = null;
		InputStream ins = null;
		SAXReader sr = null;
		Element root = null;
		Element foo;
		List<Element> elementList = null;

		try {
			System.out.println("拿到uuid："+req.getParameter("uuid"));
			ins = req.getInputStream();
			String type = req.getContentType();
			System.out.println("内容类型："+type);
			
			sr = new SAXReader();
			doc = sr.read(ins);
			
			String xmlStr = doc.asXML();
			xmlStr.substring(4, xmlStr.length()-4);
			
			//把获取的xml参数，生成本地文件
			Found_LocalFile localFile = new Found_LocalFile();
			localFile.AppendWriteFile("C:\\Users\\PCyzh\\Desktop\\kun\\cdr2019110101.xml", xmlStr);
			
//			log.error("错误信息："+xmlStr);
			System.out.println("获取xml字符串" + xmlStr);
//			log.warn("好差。。" + xmlStr);

			ByteInputStream bis = new ByteInputStream();
			ByteArrayInputStream bais = new ByteArrayInputStream(xmlStr.getBytes());

			doc = sr.read(bais);
			root = doc.getRootElement();// 根节点
			System.out.println("根节点" + root.getName());

			elementList = root.elements();// 获取根节点下面的所有子节点(不包括子节点的子节点)
			for (Element eroot : elementList) {
				System.out.println("根节点下面的节点：" + eroot.getName());
			}

			CallDetail call = new CallDetail();
			NewCdr cdr = new NewCdr();
			boolean insert;
			if (elementList.size() > 1) {// 判断是否存在子节点
				String node;
				for (Element eroot : elementList) {
					node = eroot.getName();
					if (node.equals("variables")) { // 递归获取需要的值
						for (Iterator i = root.elementIterator("variables"); i.hasNext();) {
							foo = (Element) i.next();
							System.out.println("唯一id:" + foo.elementText("uuid"));
							call.setUuid(foo.elementText("uuid")); //
							call.setAniName(foo.elementText("sip_auth_username"));
							call.setAniNumber(foo.elementText("sip_number_alias"));
							call.setDnisNumber(foo.elementText("sip_to_user"));
							call.setCreateTime(new Date());
							call.setUpdateTime(new Date());
							
							insert = callservcie.insert(call);
							if(insert=true) {
								resp.setStatus(200);
								resp.setCharacterEncoding("utf-8");
								resp.setContentType("application/json; charset=utf-8");
								PrintWriter writer = resp.getWriter();
//								Map<String, String> map = new HashMap<>();
//								map.put("status", "完美");
								String name="djkaf";
								writer.write(name.toString());
							}else {
								resp.setCharacterEncoding("utf-8");
								resp.setContentType("application/json; charset=utf-8");
								PrintWriter writer = resp.getWriter();
								Map<String, String> map = new HashMap<>();
								map.put("status", "失败");
								writer.write(map.toString());
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

	private Date Date(String elementText) {
		// TODO Auto-generated method stub
		return null;
	}


}