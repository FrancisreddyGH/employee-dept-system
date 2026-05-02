<!-- department_add.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Department — Employee Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>

    <nav class="navbar">
        <a href="/" class="navbar-brand">
            <span class="icon">👥</span>
            <span class="brand-text">EmployeeMS</span>
        </a>
        <div class="navbar-links">
            <a href="/">Home</a>
            <a href="/department/getall">Departments</a>
            <a href="/employee/getall">Employees</a>
        </div>
    </nav>

    <div class="container">

        <div class="page-header">
            <h1>Add New Department</h1>
            <a href="/department/getall" class="btn btn-secondary">← Back to Departments</a>
        </div>

        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">✅ ${successMessage}</div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">❌ ${errorMessage}</div>
        </c:if>

        <div class="card fade-in" style="max-width: 520px;">
            <div class="card-header">
                <span class="icon">📁</span> New Department
            </div>
            <div class="card-body">
                <form:form method="POST" action="/department/save" modelAttribute="departmentDto">
                    <div class="form-group">
                        <label for="name">
                            Department Name <span class="req">*</span>
                        </label>
                        <form:input
                            type="text"
                            id="name"
                            path="name"
                            cssClass="form-control"
                            placeholder="e.g. IT, HR, Finance…" />
                        <form:errors path="name" cssClass="invalid-feedback" />
                    </div>



                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">💾 Save Department</button>
                        <a href="/department/getall" class="btn btn-secondary">Cancel</a>
                    </div>
                </form:form>
            </div>
        </div>

    </div>

</body>
</html>