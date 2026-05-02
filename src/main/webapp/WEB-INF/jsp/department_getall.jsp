<!-- department_getall.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Departments Directory — Employee Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>

    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/" class="navbar-brand">
            <span class="icon">👥</span>
            <span class="brand-text">EmployeeMS</span>
        </a>
        <div class="navbar-links">
            <a href="${pageContext.request.contextPath}/">Home</a>
            <a href="${pageContext.request.contextPath}/department/getall" class="active">Departments</a>
            <a href="${pageContext.request.contextPath}/employee/getall">Employees</a>
        </div>
    </nav>

    <div class="container">

        <div class="page-header">
            <h1>📂 Departments Directory</h1>
            <a href="${pageContext.request.contextPath}/department/add" class="btn btn-primary">➕ Add New Department</a>
        </div>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">✅ ${successMessage}</div>
        </c:if>

        <div class="card fade-in">
            <div class="card-header">All Departments</div>
            <div class="table-wrapper">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Department Name</th>
                            <th>Active Status</th>
                            <th>Created At</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="department" items="${departments}" varStatus="s">
                            <tr>
                                <td>${s.index + 1}</td>
                                <td><strong>${department.name}</strong></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${department.is_active}">
                                            <span class="badge badge-success">✓ Active</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge badge-danger">✗ Inactive</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td><small class="text-muted">${department.created_at}</small></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/department/getbyid/${department.id}" class="btn btn-info">👁️ View</a>
                                    <a href="${pageContext.request.contextPath}/department/edit/${department.id}" class="btn btn-warning">✏️ Edit</a>
                                    <a href="${pageContext.request.contextPath}/department/delete/${department.id}" class="btn btn-danger" onclick="return confirm('Delete this department?');">🗑️ Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty departments}">
                            <tr>
                                <td colspan="5" style="text-align:center;color:#999;padding:1.5rem;">
                                    No departments found. <a href="${pageContext.request.contextPath}/department/add">Create one now</a>
                                </td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

</body>
</html>