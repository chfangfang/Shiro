<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" href="../../css/my-style.css">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
</head>
<body>
<% int id = 1; %>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder"> 角色列表</strong>
        </div>

        <table class="table table-hover text-center">
            <tr style="background-color: #f9f9f9;">
                <th colspan="6" style="text-align:left; padding:19px 0;padding-left:20px;">
                    <span style="margin-right: 20px">
                        <input type="checkbox" id="checkall"/>全选
                    </span>

                    <a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;"
                       onclick="DelSelect()">
                        删除
                    </a>
                    <a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;"
                       class="button border-blue icon-edit" onclick="sorts()">
                        排序
                    </a>
                    <a href="/role/roleadd.do" style="float:right; padding:5px 15px; margin:0 10px;"
                       class="button border-blue icon-plus-square-o">
                        <strong>添加角色</strong>
                    </a>
                </th>
            </tr>
            <tr style="background-color: #f9f9f9;">
                <th width="80px" style="text-align:center; ">ID</th>
                <th width="10%">角色名</th>
                <th>角色描述</th>
                <th width="10%">创建时间</th>
                <th width="7%">状态</th>
                <th width="26%">操作</th>
            </tr>
            <c:forEach items="${rolelist}" var="role">
                <tr>
                    <td style="text-align:left; padding-left:15px;">
                        <input type="checkbox" name="id[]" value=""/>
                        <%=id++ %>
                    </td>
                    <td>${role.rolename}</td>
                    <td>${role.roledesc}</td>
                    <td>${role.createtime}</td>
                    <td>
                        <c:if test="${role.islocked == 1}">
                            <span class="state_class state_ok">
                                启用
                            </span>
                        </c:if>
                        <c:if test="${role.islocked == 0}">
                            <span class="state_class state_no">
                                禁用
                            </span>
                        </c:if>

                    </td>
                    <td>
                        <div class="button-group">
                            <a class="button border-main" href="/role/roleupdate.do?id=${role.id}">
                                <span class="icon-edit"></span> 修改
                            </a>
                            <a class="button border-yellow" href="/role/rolepermission.do?id=${role.id}">
                                <span class="icon-wrench"></span> 设置权限
                            </a>
                            <a class="button border-red" href="/role/roledelete.do?id=${role.id}"
                               onclick="javascript:if(!confirm('确定要删除选择的信息吗？\n此操作不可以恢复！')) { return false; }">
                                <span class="icon-trash-o"></span> 删除
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    <div class="pagelist"><a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
                            href="">3</a><a href="">下一页</a><a href="">尾页</a></div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch() {

    }

    //单个删除
    function del(id, mid, iscid) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    //全选
    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
            $("#listform").submit();
        }
        else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        }
        else {
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        }
        else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {


            $("#listform").submit();
        }
        else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        }
        else {
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        }
        else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var i = 0;
            $("input[name='id[]']").each(function () {
                if (this.checked == true) {
                    i++;
                }
            });
            if (i > 1) {
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected", "selected");
            } else {

                $("#listform").submit();
            }
        }
        else {
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected", "selected");
            return false;
        }
    }

</script>
</body>
</html>
