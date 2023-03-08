<%@ page import="hello.demo.domain.member.Member" %>
<%@ page import="hello.demo.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: jungmin
  Date: 2023/03/07
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // request response 는 그냥 사용가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");;
    String username= request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member= new Member(username,age);

    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
