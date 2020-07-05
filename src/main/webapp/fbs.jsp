<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Hibana
  Date: 2019/11/7
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setCharacterEncoding("GBK");
//response.setContentType("text/html;charset=GBK");//设置传输编码
    String ip = request.getHeader("x-forwarded-for");
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
    {
        ip = request.getHeader("Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
    {
        ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
    {
        ip = request.getRemoteAddr();
    }

    int n = ip.lastIndexOf(".");
    String ip2 = ip.substring(n+1);
    PrintWriter o=response.getWriter();
    o.println("你的ip="+ip+"<br>");
    o.println("你的ip的最后一组数是："+ip2+"<br>");
    int ip3=Integer.parseInt(ip2);
    o.println("最后一组数转成整数是："+ip3+"<br>");
    int ip4=(ip3)%3;
    o.println("ip地址最后一个数模除3余数是："+ip4);
//下面是根据余数进行分布式跳转，达到平衡网站压力；
//下面三个网站数据必须连接红帽子mysql_cluster
    if(ip4 == 0){
        response.sendRedirect("http://172.16.81.141");
    }
    else if(ip4 == 1){
        response.sendRedirect("http://172.16.81.150");
    }
    else if(ip4 == 2){
        response.sendRedirect("http://172.16.81.151");
    }
    else
    {
        o.println("很遗憾，你的网络不通，不能打开网页！");}

%>

</body>
</html>
