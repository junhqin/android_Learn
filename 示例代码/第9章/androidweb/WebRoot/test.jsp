<%@ page contentType="text/html; charset=GBK" %>
<%
   request.setCharacterEncoding("GBK");
   String str=(String)request.getParameter("str");
   if(str!=null)
   {
	   out.print("���ã�"+str+",��ӭʹ��http����");
	}

%>