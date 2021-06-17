<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link
            href="<c:url value="/resources//bootstrap/css/bootstrap.min.css" />"
            rel="stylesheet">
    <link href="<c:url value="/resources/css/styles.css" />"
          rel="stylesheet">
</head>
<body class="login-bg">
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <!-- Logo -->
                <div class="logo">
                    <h1></h1>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="page-content container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-wrapper">
                <div class="box">
                    <div class="content-wrap">
                        <form:form modelAttribute="newContact">
                            <label>Name*</label>
                            <form:input class="form-control" path="name" />
                            <form:errors path="name"></form:errors>

                            <label>Surname*</label>
                            <form:input class="form-control" path="surname" />
                            <form:errors path="surname"></form:errors>

                            <label>Middlename*</label>
                            <form:input class="form-control" path="middlename" />

                            <label>Email</label>
                            <form:input class="form-control" path="email" />
                            <form:errors path="email"></form:errors>

                            <label>Work Phone</label>
                            <form:input class="form-control" path="workphone" />

                            <label>Mobile Phone*</label>
                            <form:input class="form-control" path="mobilephone" />
                            <form:errors path="mobilephone"></form:errors>

                            <label>Address</label>
                            <form:input class="form-control" path="address" />


                            <div class="action">
                                <button type="submit" class="btn btn-primary signup">
                                    <c:if test="${editing}">Edit contact</c:if>
                                    <c:if test="${adding }">Add new contact</c:if>
                                </button>
                            </div>
                        </form:form>
                    </div>
                </div>
                <div class="already">
                    <p></p>
                    <a href="/home">Back</a>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/js/custom.js"></script>
</body>
</html>