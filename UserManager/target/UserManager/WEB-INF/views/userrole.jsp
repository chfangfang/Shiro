<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel" style="height: 500px;">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>设置角色</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/user/useraddrole.do?userid=${id}">
            <div class="form-group">
                <div class="label">
                    <label>用户账户：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${username}" name="username"  disabled="disabled"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>设置角色：</label>
                </div>
                <div class="field">
                    <select name="roleid" class="input w50" placeholder="请选择角色">
                        <c:if test="${empty isrole.id}">
                            <option value="null"  selected = "selected" disabled="disabled">请选择角色</option>
                        </c:if>

                        <c:forEach items="${rolelist}" var="role">
                            <c:if test="${isrole.id eq role.id}">
                                <option value="${role.id}" selected="selected">${role.rolename}</option>
                            </c:if>
                            <c:if test="${isrole.id ne role.id}">
                                <option value="${role.id}">${role.rolename}</option>
                            </c:if>
                        </c:forEach>

                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
