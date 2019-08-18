<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>网站信息</title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <link rel="stylesheet" href="../../css/my-style.css">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
</head>
<body>
<%int id = 1; %>
<div class="panel admin-panel">
    <div class="panel-head">
        <strong class="icon-reorder"> 权限列表</strong>
        <a href="/perm/permissionadd.do" style="float: right;margin-right: 20px;">
            <strong><span class="icon-plus-square-o"></span> 添加权限</strong>
        </a>
    </div>
    <table class="table table-hover text-center">
        <tr style="background-color: #f9f9f9;">
            <th width="5%">ID</th>
            <th>权限名称</th>
            <th>权限类型</th>
            <th>资源路径</th>
            <th>权限代码</th>
            <th>权限状态</th>
            <th width="250">操作</th>
        </tr>

        <c:forEach items="${permlist}" var="perm">
            <tr>
                <td><%=id++ %>
                </td>
                <td>${perm.permname}</td>
                <td>${perm.permtype}</td>
                <td>${perm.permurl}</td>
                <td>${perm.permcode}</td>
                <td>
                    <c:if test="${perm.islocked == 1}">
                        <span class="state_class state_ok">
                            启用
                        </span>
                    </c:if>
                    <c:if test="${perm.islocked == 0}">
                        <span class="state_class state_no">
                            禁用
                        </span>
                    </c:if>
                </td>
                <td>
                    <div class="button-group">
                        <a type="button" class="button border-main" href="/perm/permissionupdate.do?id=${perm.id}">
                            <span class="icon-edit"></span>修改
                        </a>
                        <a class="button border-red" href="/perm/permissiondelete.do?id=${perm.id}" onclick="return del()">
                            <span class="icon-trash-o"></span> 删除
                        </a>
                    </div>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
<script>
    function del(id) {
        if (confirm("您确定要删除吗?")) {
            return true;
        }else{
            return false;
        }
    }
</script>
</body>
</html>
