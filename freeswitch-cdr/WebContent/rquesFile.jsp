<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>

 <SCRIPT type="text/javascript">
 function changeFileSize(obj) {
     //try{
       $("insert").disabled = true;
       //创建一个文件对象
       var path = obj.value;
             var  actObj = new ActiveXObject("Scripting.FileSystemObject");
              var fileObj = actObj.GetFile(path);
              var len = fileObj.size / 1024 / 1024;{}
       if (len > 10) {
           alert("上传文件超过10M不能上传");
           obj.value = "";
       } else {
           $("insert").disabled = false;
       }
     //}catch(e){}
   }
 </SCRIPT>

<body>
	
	<TABLE>
		<tr height="30">
				<td width="15%">名单上传</td>
				<td width="60%" colspan="3"><input
					style="width: 70%" id="filepath"
					validate='notNull' type="file"
					onchange="changeFileSize(this)"></td>
			</tr>
	</TABLE>
	
</body>
</html>
</jsp:root>