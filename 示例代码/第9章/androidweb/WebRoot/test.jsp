<%@ page contentType="text/html; charset=GBK" %>
<%
   request.setCharacterEncoding("GBK");
   String str=(String)request.getParameter("str");
   if(str!=null)
   {
	   out.print("您好，"+str+",欢迎使用http连接");
	}

%>