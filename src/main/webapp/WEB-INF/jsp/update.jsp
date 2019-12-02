<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
<form action="/con/edit" method="post">
    <input type="hidden" id="user_id" name="user_id" value="${requestScope.user.user_id}">
    用户编号:<input type="text" id="user_num" name="user_num" value="${requestScope.user.user_num}" > <br>
    姓名:<input type="text" id="user_name" name="user_name" value="${requestScope.user.user_name}"><br>
    详细地址:<input type="text" id="user_addr" name="user_addr" value="${requestScope.user.user_addr}"><br>
    时间:<input type="date" id="create_date" name="create_date" value="<fmt:formatDate value='${requestScope.user.create_date}' pattern='yyyy-MM-dd'/>"><br>
    <input type="submit" value="提交" onclick="return myfunction1()">
    <input type="reset" value="重置">
</form>
</body>
<script type="text/javascript">
    function myfunction1() {
        var num = document.getElementById("user_num").value;
        var name = document.getElementById("user_name").value;
        var addr = document.getElementById("user_addr").value;
        var date = document.getElementById("create_date").value;
        var flag1 =num.length;
        var regex2 = new  RegExp(/^[\u4E00-\u9FA5A-Za-z]+$/);
        var flag2 = regex2.test(name);
        var regex3 = new  RegExp(/^[\u4e00-\u9fa5]+$/);
        var flag3 = regex3.test(addr);
        if (num==""){
            alert("用户编码不能为空");
            return false;
        }
        if (flag1!=11){
            alert("用户编码必须是11位");
            return false;
        }
        if (name==""){
            alert("姓名不能为空");
            return false;
        }
        if (!flag2){
            alert("姓名格式不正确,姓名是中文或者英文");
            return false;
        }
        if (addr==""){
            alert("地址不能为空");
            return false;
        }
        if (!flag3){
            alert("地址格式不正确,必须是中文");
            return false;
        }
        if (date==""){
            alert("日期不能为空");
            return false;
        }

        return true;
    }


</script>
</html>
