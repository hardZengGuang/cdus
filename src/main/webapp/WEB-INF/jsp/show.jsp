<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<div align="center">
<h1>页面展示</h1>
</div>

<table border="1" cellpadding="10" cellspacing="0" bgcolor="#7fffd4" align="center">
    <tr>
        <td>账户id</td>
        <td>账户编号</td>
        <td>姓名</td>
        <td>详细地址</td>
        <td>创建日期</td>
        <td>操作|<input type="button" onclick="location.href='add'" value="新增"></td>
    </tr>
    <c:forEach var="user" items="${pagemsg.lists}">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.user_num}</td>
            <td>${user.user_name}</td>
            <td>${user.user_addr}</td>
            <td><fmt:formatDate value="${user.create_date}" pattern="yyyy-MM-dd"/></td>
            <td><input type="button" onclick="location.href='/con/get/${user.user_id}'" value="修改">|<a onclick="return confirm('确定删除吗')" href="/con/deleteById/${user.user_id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<table align="center">
    <tr>
        <td class="td2">
            <span>第${pagemsg.currPage }/ ${pagemsg.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
            <span>
                <a href="${pageContext.request.contextPath }/con/main?currentPage=1">[首页]</a>&nbsp;&nbsp;

       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/con/main?currentPage=${requestScope.pagemsg.currPage-1 }">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/con/main?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;

       </c:if>
                <a href="${pageContext.request.contextPath }/con/main?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
   </span>
        </td>
    </tr>

</table>
<!--js部分-->
<script>
    function goPage(page) {
        var total=${sessionScope.page.totalPage};

        if(page>total){
            page=total;
        }
        if(page<1){
            page=1;
        }

        $("#pageNum").val(page);
        $("#myForm").submit()
    }
    function toPage() {
        var page=$("#go").val();
        goPage(page)
    }
</script>

</body>
</html>
