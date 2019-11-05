package com.cdr.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:类功能介绍
 * 		1.把xml参数生成本地。xml文件
 * @version 2019年11月1日下午3:55:15
 * @author PCyzh
 */
public class Found_LocalFile {

	protected static Logger log = LoggerFactory.getLogger(Found_LocalFile.class);
	
	/**
	 * TODO:方法描述
	 *		生成文件的具体方法
	 * @version 2019年11月1日下午4:10:55
	 * @author IdeaProjects
	 * @param file  文件路径+文件名称
	 * @param conent 文件内容
	 */
	public void AppendWriteFile(String uuid,String conent) {
		String file = "C:\\Users\\PCyzh\\Desktop\\kun\\hh\\";
		log.info("开始已追加的形式写文件到：["+file+"]");
		
		if(uuid == null || uuid == "") {
			uuid = UUID.randomUUID().toString();
		}
		file=file+uuid+".xml";
		
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(conent);
			
			log.info("写文件：["+file+"]完成....");
			
		} catch (Exception e) {
			log.error("写文件：["+file+"]异常，异常信息为：["+e.getMessage()+"]");
		}finally {
			log.info("开始关闭输出流...");
			try {
				out.close();
			} catch (IOException e) {
				log.info("关闭输出流异常，异常信息为：["+e.getMessage()+"]");
			}
		}
		
	}
	
}
