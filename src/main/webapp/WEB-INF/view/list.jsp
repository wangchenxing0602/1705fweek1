<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resource/css/index_work.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
function add(){
	alert("fadsf");
	location="toadd";
}
function del(id){
	alert(id);
	$.post("delete",{"id":id},function(flag){
		if(flag){
			alert("删除成功");
			location="list";
		}
	},"json")
}
function update(id){
	alert("fadsf");
	location="toupdate?id="+id;
}
//全选
function qx(){
	$("[name='ck']").attr("checked",true);
}
//全不选
function qbx(){
	$("[name='ck']").attr("checked",false);
}
//反选
function fx(){
	$("[name='ck']").each(function(){
		$(this).attr("checked",!$(this).attr("checked"));
	})
}
</script>
</head>
<body>
<form action="list" method="post">
  <input type="text"  name="mohu" value="${mohu}">
  <input type="submit" value="查询">

</form>
  <table >
     <tr> 
     <td>
     
                <input type="button" value="全选" onclick="qx()"/>
				<input type="button" value="全不选" onclick="qbx()"/>
				<input type="button" value="反选" onclick="fx()"/>
     </td>
     <td>编号</td>
     <td>名称</td>
     <td>简介</td>
     <td>导演</td>
     <td>时间</td>
     <td>分类</td>
     <td>操作</td>
     </tr>
     <c:forEach items="${list}" var="m">

        <tr>
        <td>
				<input type="checkbox" name="ck" value="${m.mid }"/>
			</td>
           <td>${m.id}</td>
           <td>${m.name}</td>
           <td>${m.con}</td>
     	    <td>${m.doc}</td>
            <td>${m.date}</td>
             <td>${m.dname}</td>
             <td>
            
              <button onclick="update(${m.id})">修改</button> 
              <button onclick="del(${m.id})">删除</button>
             
             </td>
     
       </tr>
  
   </c:forEach>
     <tr> 
       <td colspan="10">
       <button onclick="add()">添加</button>
        当前页是${info.pageNum}/共${info.pages}页 /共${info.total}条数据
        <a href="list?pageNum=1">首页</a>
        <a href="list?pageNum=${info.prePage}">上一页</a>
        <a href="list?pageNum=${info.nextPage}">下一页</a>
        <a href="list?pageNum=${info.pages}">尾页</a>
       </td>
     
     </tr>
  
  </table>
</body>
</html>