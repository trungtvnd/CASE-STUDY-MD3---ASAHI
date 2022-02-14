<%--
  Created by IntelliJ IDEA.
  User: LTC
  Date: 2/11/2022
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">

    <title>Title</title>
    <link rel="stylesheet" href="viewDetail.css">

    <style>
        body {
            background: rgb(99, 39, 120)
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #BA68C8
        }

        .profile-button {
            background: rgb(99, 39, 120);
            box-shadow: none;
            border: none
        }

        .profile-button:hover {
            background: #682773
        }

        .profile-button:focus {
            background: #682773;
            box-shadow: none
        }

        .profile-button:active {
            background: #682773;
            box-shadow: none
        }

        .back:hover {
            color: #682773;
            cursor: pointer
        }

        .labels {
            font-size: 11px
        }

        .add-experience:hover {
            background: #BA68C8;
            color: #fff;
            cursor: pointer;
            border: solid 1px #BA68C8
        }

    </style>

</head>
<body>
<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
                                                                                         width="150px"
                                                                                         src="${user.image}"
                                                                                         alt=""><span
                    class="font-weight-bold">${user.name}</span><span
                    class="text-black-50">${user.email}</span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-12"><label class="labels"></label><input type="hidden" readonly="readonly"
                                                                                class="form-control"
                                                                                 placeholder="id"
                                                                                value="${user.id}"></div>
                </div>
                <div class="row mt-2">
                    <div class="col-md-12"><label class="labels">Name</label><input type="text" readonly="readonly"
                                                                                    class="form-control"
                                                                                    placeholder="Username"
                                                                                    value="${user.name}"></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">Mobile Number</label><input readonly="readonly"
                                                                                             type="text"
                                                                                             class="form-control"
                                                                                             placeholder="Phone Number"
                                                                                             value="${user.phoneNumber}">
                    </div>
                    <div class="col-md-12"><label class="labels">Birth</label><input type="text" readonly="readonly"
                                                                                     class="form-control"
                                                                                     placeholder="Birth"
                                                                                     value="${user.birth}"></div>
                    <div class="col-md-12"><label class="labels">Email</label><input type="text" readonly="readonly"
                                                                                     class="form-control"
                                                                                     placeholder="Email"
                                                                                     value="${user.email}"></div>
                </div>
                <span></span>
                <c:if test="${requestScope['user'] == null}">
                    <div class="mt-3 text-center">
                        <div class="mt-3 text-center">
                            <button disabled="disabled" class="btn btn-primary profile-button" type="button"><a
                                    style="color: white; text-decoration: none"
                                    href="${pageContext.request.contextPath}/register?action=editUser&id=${user.id}">EDIT
                                PROFILE</a></button>

                            <button class="btn btn-primary profile-button" type="button"><a
                                    style="color: white; text-decoration: none"
                                    href="${pageContext.request.contextPath}/register?action=createUser&username=${username}">CREATE
                                PROFILE</a></button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${requestScope['user'] != null}">
                    <div class="mt-3 text-center">
                        <div class="mt-3 text-center">
                            <button class="btn btn-primary profile-button" type="button"><a
                                    style="color: white; text-decoration: none"
                                    href="${pageContext.request.contextPath}/register?action=editUser&id=${user.id}">EDIT
                                PROFILE</a></button>
                        </div>
                    </div>
                </c:if>
                <c:if test="${requestScope['checkEdit'] == true}">
                    <div class="mt-3 text-center">
                        <div class="mt-3 text-center">
<%--                            <button disabled="disabled" class="btn btn-primary profile-button" type="button"><a--%>
<%--                                    style="color: white; text-decoration: none"--%>
<%--                                    href="${pageContext.request.contextPath}/register?action=editUser&id=${user.id}">EDIT--%>
<%--                                PROFILE</a></button>--%>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <c:if test="${requestScope['checkEdit'] == true}">
        <div class="col-md-4">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Edit</h4>
                </div>
                <form action="${pageContext.request.contextPath}/register?action=editUser&id=${user.id}" method="post">
                    <div class="row mt-2">
                        <div class="col-md-12"><label class="labels"></label><input type="hidden" class="form-control"
                                                                                    name="id" value="${user.id}"></div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-12"><label class="labels">New Name</label><input type="text" name="name"
                                                                                            class="form-control"
                                                                                            placeholder="first name"
                                                                                            value="${user.name}"></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">New Mobile Number</label><input type="text"
                                                                                                     name="phone"
                                                                                                     class="form-control"
                                                                                                     placeholder="enter phone number"
                                                                                                     value="${user.phoneNumber}">
                        </div>
                        <div class="col-md-12"><label class="labels">New Birth</label><input type="text" name="birth"
                                                                                             class="form-control"
                                                                                             value="${user.birth}">
                        </div>
                        <div class="col-md-12"><label class="labels">Email</label><input readonly="readonly" type="text"
                                                                                             class="form-control"
                                                                                             name="email"
                                                                                             value="${user.email}">
                        </div>
                        <div class="col-md-12"><label class="labels">New Image</label><input type="text"
                                                                                             class="form-control"
                                                                                             name="image"
                                                                                             value="${user.image}">
                        </div>
                    </div>
                        <%--                    <div class="mt-3 text-center"><button class="btn btn-primary profile-button" type="button"><a style="color: white; text-decoration: none" href="${pageContext.request.contextPath}/register?action=editUser&id=${user.id}">Submit</a></button></div>--%>
                    <div class="mt-3 text-center"><input type="submit" class="btn btn-primary profile-button"
                                                         value="Save">
                    </div>
                </form>
            </div>
        </div>
    </div>
    </c:if>
</div>

</body>
</html>
