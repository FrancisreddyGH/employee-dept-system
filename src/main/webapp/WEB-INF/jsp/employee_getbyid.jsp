<!-- employee_getbyid.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details — Employee Management</title>
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
            <h1>👨‍💼 Employee Details</h1>
            <a href="${pageContext.request.contextPath}/employee/getall" class="btn btn-secondary">← Back to Employees</a>
        </div>

        <div class="card fade-in" style="max-width: 600px;">
            <div class="card-header">
                <span class="icon">👤</span> ${employee.name}
            </div>
            <div class="card-body">
                <table class="detail-table">
                    <tr>
                        <td>ID</td>
                        <td>${employee.id}</td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><strong>${employee.name}</strong></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${employee.email}</td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td>₹${employee.salary}</td>
                    </tr>
                    <tr>
                        <td>Department</td>
                        <td><span class="badge badge-category">${employee.department.name}</span></td>
                    </tr>
                    <tr>
                        <td>Active</td>
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
                    </tr>
                    <tr>
                        <td>Created At</td>
                        <td><small class="text-muted">${employee.created_at}</small></td>
                    </tr>
                    <tr>
                        <td>Updated At</td>
                        <td><small class="text-muted">${employee.updated_at}</small></td>
                    </tr>
                </table>

                <div class="form-actions">
                    <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}" class="btn btn-warning">✏️ Edit</a>
                    <a href="${pageContext.request.contextPath}/employee/getall" class="btn btn-secondary">← Back</a>
                </div>
            </div>
        </div>

    </div>

</body>
</html>