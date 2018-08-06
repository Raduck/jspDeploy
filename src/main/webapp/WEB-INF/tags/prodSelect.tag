<%@tag import="kr.or.ddit.lprod.model.LprodVo"%>
<%@tag import="java.util.List"%>
<%@tag import="org.apache.ibatis.session.SqlSession"%>
<%@tag import="kr.or.ddit.mybatis.SqlMapSessionFactory"%>
<%@tag import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select>
  <option value prod_id >prod_name</option>
</select>
<%!private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	List<LprodVo> lprodList;%>
<%
SqlSession session2 = sqlSessionFactory.openSession();
lprodList = session2.selectList("lprod.getLprodLguList","P101");
session2.close();
%>
<table>
<c:forEach items="${lprodList }" var="vo">
<td>${vo.lprod_id }</td>
<td>${vo.lprod_gu }</td>
<td>${vo.lprod_nm }</td>
</c:forEach>
</table>