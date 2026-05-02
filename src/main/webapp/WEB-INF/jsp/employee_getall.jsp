<!-- employee_getall.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employees Directory — Employee Management</title>
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
            <a href="${pageContext.request.contextPath}/department/getall">Departments</a>
            <a href="${pageContext.request.contextPath}/employee/getall" class="active">Employees</a>
        </div>
    </nav>

    <div class="container">

        <div class="page-header">
            <h1>👨‍💼 Employees Directory</h1>
            <a href="${pageContext.request.contextPath}/employee/add" class="btn btn-primary">➕ Add New Employee</a>
        </div>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">✅ ${successMessage}</div>
        </c:if>

        <div class="card fade-in">
            <div class="card-header">All Employees</div>
            <div class="table-wrapper">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Active</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="employee" items="${employees}" varStatus="s">
                            <tr>
                                <td>${s.index + 1}</td>
                                <td><strong>${employee.name}</strong></td>
                                <td>${employee.email}</td>
                                <td>₹${employee.salary}</td>
                                <td><span class="badge badge-category">${employee.department.name}</span></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${employee.is_active}">
                                            <span class="badge badge-success">✓ Active</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge badge-danger">✗ Inactive</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/employee/getbyid/${employee.id}" class="btn btn-info">👁️ View</a>
                                    <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}" class="btn btn-warning">✏️ Edit</a>
                                    <a href="${pageContext.request.contextPath}/employee/delete/${employee.id}" class="btn btn-danger" onclick="return confirm('Delete this employee?');">🗑️ Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty employees}">
                            <tr>
                                <td colspan="7" style="text-align:center;color:#999;padding:1.5rem;">
                                    No employees found. <a href="${pageContext.request.contextPath}/employee/add">Add one now</a>
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