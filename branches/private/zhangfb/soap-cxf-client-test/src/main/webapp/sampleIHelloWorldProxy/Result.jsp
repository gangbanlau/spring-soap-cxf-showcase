<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleIHelloWorldProxyid" scope="session" class="com.maingel.soap.web.IHelloWorldProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleIHelloWorldProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleIHelloWorldProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleIHelloWorldProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.maingel.soap.web.IHelloWorld getIHelloWorld10mtemp = sampleIHelloWorldProxyid.getIHelloWorld();
if(getIHelloWorld10mtemp == null){
%>
<%=getIHelloWorld10mtemp %>
<%
}else{
        if(getIHelloWorld10mtemp!= null){
        String tempreturnp11 = getIHelloWorld10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String age_2id=  request.getParameter("age18");
        int age_2idTemp  = Integer.parseInt(age_2id);
        String name_3id=  request.getParameter("name20");
            java.lang.String name_3idTemp = null;
        if(!name_3id.equals("")){
         name_3idTemp  = name_3id;
        }
        String gender_4id=  request.getParameter("gender22");
        int gender_4idTemp  = Integer.parseInt(gender_4id);
        String id_5id=  request.getParameter("id24");
        long id_5idTemp  = Long.parseLong(id_5id);
        %>
        <jsp:useBean id="com1maingel1soap1web1UserDTO_1id" scope="session" class="com.maingel.soap.web.UserDTO" />
        <%
        com1maingel1soap1web1UserDTO_1id.setAge(age_2idTemp);
        com1maingel1soap1web1UserDTO_1id.setName(name_3idTemp);
        com1maingel1soap1web1UserDTO_1id.setGender(gender_4idTemp);
        com1maingel1soap1web1UserDTO_1id.setId(id_5idTemp);
        java.lang.String addUser13mtemp = sampleIHelloWorldProxyid.addUser(com1maingel1soap1web1UserDTO_1id);
if(addUser13mtemp == null){
%>
<%=addUser13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addUser13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 26:
        gotMethod = true;
        com.maingel.soap.web.UserDTO[] findAllUser26mtemp = sampleIHelloWorldProxyid.findAllUser();
if(findAllUser26mtemp == null){
%>
<%=findAllUser26mtemp %>
<%
}else{
        String tempreturnp27 = null;
        if(findAllUser26mtemp != null){
        java.util.List listreturnp27= java.util.Arrays.asList(findAllUser26mtemp);
        tempreturnp27 = listreturnp27.toString();
        }
        %>
        <%=tempreturnp27%>
        <%
}
break;
case 29:
        gotMethod = true;
        String text_6id=  request.getParameter("text32");
            java.lang.String text_6idTemp = null;
        if(!text_6id.equals("")){
         text_6idTemp  = text_6id;
        }
        java.lang.String sayHi29mtemp = sampleIHelloWorldProxyid.sayHi(text_6idTemp);
if(sayHi29mtemp == null){
%>
<%=sayHi29mtemp %>
<%
}else{
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sayHi29mtemp));
        %>
        <%= tempResultreturnp30 %>
        <%
}
break;
case 34:
        gotMethod = true;
        String id_7id=  request.getParameter("id45");
        long id_7idTemp  = Long.parseLong(id_7id);
        com.maingel.soap.web.UserDTO findUserById34mtemp = sampleIHelloWorldProxyid.findUserById(id_7idTemp);
if(findUserById34mtemp == null){
%>
<%=findUserById34mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">age:</TD>
<TD>
<%
if(findUserById34mtemp != null){
%>
<%=findUserById34mtemp.getAge()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(findUserById34mtemp != null){
java.lang.String typename39 = findUserById34mtemp.getName();
        String tempResultname39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename39));
        %>
        <%= tempResultname39 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">gender:</TD>
<TD>
<%
if(findUserById34mtemp != null){
%>
<%=findUserById34mtemp.getGender()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(findUserById34mtemp != null){
%>
<%=findUserById34mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>