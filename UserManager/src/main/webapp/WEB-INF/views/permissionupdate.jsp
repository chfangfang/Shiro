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
        <form method="post" class="form-x" action="/perm/doupdate.do?id=${perm.id}">
            <div class="form-group">
                <div class="label">
                    <label>权限名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="permname" value="${perm.permname}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>菜单路径：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="permurl" value="${perm.permurl}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>资源类型：</label>
                </div>
                <div class="field">
                    <select name="permtype" class="input w75">
                        <c:if test="${perm.permtype eq  '菜单'}">
                            <option value="菜单" selected="selected">菜单</option>
                            <option value="按钮">按钮</option>
                        </c:if>
                        <c:if test="${perm.permtype eq '按钮'}">
                            <option value="菜单">菜单</option>
                            <option value="按钮" selected="selected">按钮</option>
                        </c:if>

                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>父节点名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="parentid" value="${perm.parentid}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>字段代码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w75" name="permcode" value="${perm.permcode}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>权限状态：</label>
                </div>
                <div class="field">
                    <select name="islocked" class="input w75">
                    <c:if test="${perm.islocked == 1}">
                            <option value="1" selected="selected">启用</option>
                            <option value="0">禁用</option>
                    </c:if>
                    <c:if test="${perm.islocked == 0}">
                            <option value="1">启用</option>
                            <option value="0" selected="selected">禁用</option>
                    </c:if>
                    </select>

                    <div class="tips"></div>
                </div>

            </div>
            <div class="form-group">
                <div class="label">
                    <label>角色描述：</label>
                </div>
                <div class="field">
                    <textarea class="input w75" name="permdesc" style=" height:90px;">${perm.permdesc}</textarea>
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
