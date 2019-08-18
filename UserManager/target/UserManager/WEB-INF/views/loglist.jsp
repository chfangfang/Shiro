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
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head">
        <strong class="icon-reorder"> 日志列表</strong>
        <a class="button border-yellow icon-apple" style="padding:3px 10px; margin:0 15px;" href=""> 导出日志</a>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="5%">ID</th>
            <th>操作用户</th>
            <th>日志名称</th>
            <th>主机IP地址</th>
            <th>请求路径</th>
            <th>请求方式</th>
            <th>操作时间</th>
        </tr>

        <c:forEach items="${loglist}" var="log">
            <tr>
                <td>${log.id}</td>
                <td>${log.username}</td>
                <td>${log.logname}</td>
                <td>${log.addressip}</td>
                <td>${log.permcode}</td>
                <td>${log.request}</td>
                <td>${log.logtime}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
