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
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加用户</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/user/doadd.do">
            <div class="form-group">
                <div class="label">
                    <label>用户账号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="username"
                           data-validate="required:请输入a-zA-Z0-9的6-12位符号组合"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="password" value=""/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>确认密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="password2" value=""/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>账号状态：</label>
                </div>
                <div class="field">
                    <select name="islocked" class="input w50">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <!--<div class="form-group">
                <div class="label">
                    <label>其他属性：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    首页 <input id="ishome" type="checkbox"/>
                    推荐 <input id="isvouch" type="checkbox"/>
                    置顶 <input id="istop" type="checkbox"/>

                </div>
            </div>-->
            <div class="form-group">
                <div class="label">
                    <label>设置角色：</label>
                </div>
                <div class="field">
                    <select name="cid" class="input w50" placeholder="请选择角色">
                        <option value="" selected="selected" disabled="disabled">请选择角色</option>
                        <option value="">董事长</option>
                        <option value="">产品经理</option>
                        <option value="">销售经理</option>
                        <option value="">码农</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>账号描述：</label>
                </div>
                <div class="field">
                    <textarea class="input w50" name="userdesc" style=" height:90px;"></textarea>
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
