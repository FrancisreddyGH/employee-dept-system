<!-- index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home — Employee Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/" class="navbar-brand">
            <span class="icon">👥</span>
            <span class="brand-text">EmployeeMS</span>
        </a>
        <div class="navbar-links">
            <a href="${pageContext.request.contextPath}/" class="active">Home</a>
            <a href="${pageContext.request.contextPath}/department/getall">Departments</a>
            <a href="${pageContext.request.contextPath}/employee/getall">Employees</a>
        </div>
    </nav>

    <div class="container">
        <div class="hero">
            <h1>Employee Management System</h1>
            <p>Manage your departments and employees efficiently.</p>
            <div class="hero-actions">
                <a href="${pageContext.request.contextPath}/department/getall" class="btn btn-primary btn-lg">📂 Manage Departments</a>
                <a href="${pageContext.request.contextPath}/employee/getall" class="btn btn-success btn-lg">👨‍💼 Manage Employees</a>
            </div>
        </div>

        <div class="stat-grid">
            <div class="stat-card">
                <span class="stat-icon">📂</span>
                <div class="stat-number">${totalDepartments != null ? totalDepartments : 0}</div>
                <div class="stat-label">Total Departments</div>
            </div>
            <div class="stat-card">
                <span class="stat-icon">👨‍💼</span>
                <div class="stat-number">${totalEmployees != null ? totalEmployees : 0}</div>
                <div class="stat-label">Total Employees</div>
            </div>
            <div class="stat-card">
                <span class="stat-icon">✅</span>
                <div class="stat-number">${activeEmployees != null ? activeEmployees : 0}</div>
                <div class="stat-label">Active Employees</div>
            </div>
            <div class="stat-card">
                <span class="stat-icon">🏢</span>
                <div class="stat-number">${activeDepartments != null ? activeDepartments : 0}</div>
                <div class="stat-label">Active Departments</div>
            </div>
        </div>

        <div class="card">
            <div class="card-header"><span class="icon">⚡</span> Quick Actions</div>
            <div class="card-body">
                <div class="action-grid">
                    <a href="${pageContext.request.contextPath}/department/add" class="btn btn-primary">➕ Add Department</a>
                    <a href="${pageContext.request.contextPath}/employee/add" class="btn btn-success">➕ Add Employee</a>
                    <a href="${pageContext.request.contextPath}/department/getall" class="btn btn-secondary">📋 View Departments</a>
                    <a href="${pageContext.request.contextPath}/employee/getall" class="btn btn-secondary">📋 View Employees</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>