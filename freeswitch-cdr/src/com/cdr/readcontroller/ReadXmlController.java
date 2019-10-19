package com.cdr.readcontroller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletInputStream;

@Controller
@RequestMapping("/read")
public class ReadXmlController {

	@RequestMapping("/dom")
	public void dom4jXml(HttpServletRequest requst,String xml) throws Exception {

		Document parseText = DocumentHelper.parseText(xml);
		
		System.out.println("sfdf"+parseText);
		
		
		ServletInputStream inputStream = requst.getInputStream();
		InputStreamReader streamReader = new InputStreamReader(inputStream, requst.getCharacterEncoding());
		BufferedReader read = new BufferedReader(streamReader);

		// 截取
//		StringBuilder sb = new StringBuilder();
//		
//		String line="";
//		while((line=read.readLine())!=null) {
//			sb.append(line);
//		}
		System.out.println("再怎么空指针+" + inputStream.toString());

		List<Element> elementList = null;

		SAXReader sr = new SAXReader();
        Document document = sr.read(new ByteArrayInputStream(inputStream.toString().getBytes())); // 传入需要解析的数据
		Element root = document.getRootElement();
		elementList = root.elements();
		for (Element e : elementList) {
			// 解析标签下一级标签
			Element e1 = e.element("welcome-file-list");
			List<Element> elementList1 = e1.elements();
			for (Element el : elementList1) {
				System.out.println(e1.elementText("welcome-file"));
			}
		}
	}

}

///**
// * 获取解析post请求的xml参数，并插入数据库
// * @author PCyzh
// *
// */
////@SuppressWarnings(value = { "unused" })
//@Controller
//@RequestMapping("/read")
//public class ReadXmlController {
//
//	protected static Logger log = LoggerFactory.getLogger(ReadXmlController.class.getName());
//	
//	@Autowired
//	private CrdDataService crdDataService;
//
//	@RequestMapping("/dom")
//	public void ReadXml(String xmlStr) throws Exception{
//		
//		System.out.println("hello...");
//		
//		long lasting = System.currentTimeMillis();
//		Call call = new Call();
//
//		System.out.println(lasting);
//		
//		System.out.println(xmlStr);
//		
//		List<Element> elementList=null;
//
//			SAXReader reder = new SAXReader();
//			Document doc = reder.read(new ByteArrayInputStream(xmlStr.getBytes()));//传入需要解析的数据
//			Element root = doc.getRootElement();
//			elementList = root.elements();
//			
//			for (Element e : elementList) {
//	            // 解析标签下一级标签
//	            Element e1 = e.element("welcome-file-list");
//	            List<Element> elementList1 = e1.elements();
//	            for (Element el:elementList1){
//	                System.out.println(e1.elementText("welcome-file-list"));            
//	            }
//	        }
//	    }
//			 
////			boolean in;
////			for (Iterator i = root.elementIterator("caller_profile"); i.hasNext();) {
////				foo = (Element) i.next();
////				System.out.println("服务地址:" + foo.elementText("chan_name"));
////				call.setUuid(foo.elementText("uuid"));
////				call.setAniName(foo.elementText("caller_id_name"));
////				call.setAniNumber(foo.elementText("caller_id_number"));
////				call.setDnisNumber(foo.elementText("destination_number"));
////				
////				in = crdDataService.insert(call);
////			}
////			if(in = true) {
////				System.out.println("插入完成....");
////			}
////
////		} catch (DocumentException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
//////		request.getRequestDispatcher("/index.html").forward(request, respon);
////		respon.sendRedirect("/cdrserver/index.html");
//
//}
