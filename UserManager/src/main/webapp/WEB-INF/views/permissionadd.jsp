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
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>新增权限</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/perm/dopermissionadd.do">
            <div class="form-group">
                <div class="label">
                    <label>权限名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="permname" value=""/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>菜单路径：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="permurl" value=""/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>资源类型：</label>
                </div>
                <div class="field">
                    <select name="permtype" class="input w75">
                        <option value="菜单">菜单</option>
                        <option value="按钮">按钮</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>父节点名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="parentid" value=""/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>字段代码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="permcode" value=""/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>权限状态：</label>
                </div>
                <div class="field">
                    <select name="islocked" class="input w75">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>角色描述：</label>
                </div>
                <div class="field">
                    <textarea class="input w50" name="permdesc" style=" height:90px;"></textarea>
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
