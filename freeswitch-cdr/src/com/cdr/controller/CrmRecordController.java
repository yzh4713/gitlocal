package com.cdr.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
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

import com.cdr.bean.CrmRecord;
import com.cdr.mapper.CrmRecordMapper;
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
@RequestMapping("/crm")
public class CrmRecordController {

	protected static Logger log = LoggerFactory.getLogger(CrmRecordController.class.getName());

	@Autowired
	private CrmRecordMapper crmService;

	@RequestMapping("/read")
	public void getDocument(HttpServletRequest req,HttpServletResponse resp) throws Exception {

		System.out.println("接受话单数据并解析插入数据库");

		Document doc = null;
		InputStream ins = null;
		SAXReader sr = null;
		Element root = null;
		Element foo;
		List<Element> elementList = null;

		try {
			ins = req.getInputStream();
			

			sr = new SAXReader();
			doc = sr.read(ins);
			String xmlStr = doc.asXML();
//			System.out.println("获取xml字符串" + xmlStr);
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

			CrmRecord crm = new CrmRecord();
			
			boolean insert;
			if (elementList.size() > 1) {// 判断是否存在子节点
				String node;
				for (Element eroot : elementList) {
					node = eroot.getName();
					if (node.equals("variables")) { // 递归获取需要的值
						for (Iterator i = root.elementIterator("variables"); i.hasNext();) {
							foo = (Element) i.next();
							System.out.println("唯一id:" + foo.elementText("uuid"));
							crm.setUuid(foo.elementText("uuid")); //
							crm.setRecordId("");
							crm.setTenantId(foo.elementText("tenantid"));
							crm.setTenantId(foo.elementText("userCode"));
							crm.setTenantId(foo.elementText("organId"));
							crm.setTenantId(foo.elementText("userId"));
							crm.setTenantId(foo.elementText("createTime"));
							crm.setTenantId(foo.elementText("agentId"));
							crm.setTenantId(foo.elementText("platformType"));
							crm.setTenantId(foo.elementText("recordPlatformId"));
							crm.setTenantId(foo.elementText("serviceId"));
							crm.setTenantId(foo.elementText("callId"));
							crm.setTenantId(foo.elementText("connectTime"));
							crm.setTenantId(foo.elementText("dnis"));
							crm.setTenantId(foo.elementText("ani"));
							crm.setTenantId(foo.elementText("customerId"));
							crm.setTenantId(foo.elementText("callType"));
							crm.setTenantId(foo.elementText("disconnectTime"));
							crm.setTenantId(foo.elementText("recordduration"));
							crm.setTenantId(foo.elementText("originUuid"));
							crm.setTenantId(foo.elementText("uuid"));
							crm.setTenantId(foo.elementText("phoneStatus"));
							crm.setTenantId(foo.elementText("phonePlatform"));
							crm.setTenantId(foo.elementText("servId"));
							
							
							insert = crmService.insert(crm);
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


}