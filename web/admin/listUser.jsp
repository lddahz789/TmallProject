<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>


<title>用户管理</title>
<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_user_list">所有用户</a></li>
	</ol>
	<div class="listDataTableDiv">
		<table
			class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>用户ID</th>
					<th>用户名称</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${userList}" var="userList">
					<tr>
						<th>${userList.id}</th>
						<th>${userList.name}</th>
					</tr>
				</c:forEach>
			</tbody>



		</table>


	</div>
	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp" %>
	</div>

</div>


<%@include file="../include/admin/adminFooter.jsp"%>