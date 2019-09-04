<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resource/css/index_work.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
function add(){
	var param = $("form").serialize();
	alert(param);
	$.post("add",param,function(flag){
		if(flag){
			alert("添加成功");
			location="list";
		}
	},"json")
	
	
}


</script>
</head>
<body>
   <form >
     <tr>
     <td>名称</td>
     <td><input type="text" name="name" ></td>
     
     </tr><br><br>
   
    <tr>
     <td>描述</td>
     <td><input type="text" name="con" ></td>
     
     </tr><br><br>
   
    <tr>
     <td>导演</td>
     <td><input type="text" name="doc" ></td>
     
     </tr><br><br>
   
    <tr>
     <td>日期</td>
     <td><input type="text" name="date" ></td>
     
     </tr><br><br>
   
    <tr>
     <td>类型</td>
      <c:forEach items="${list}" var="e">
       <input type="checkbox" name="tids" value="${e.tid}">${e.dname}
      </c:forEach>

     </tr><br><br>
     <tr>
     <td></td>
     <td><input type="button" value="添加" onclick="add()"></td>
     
     </tr>
   
   
   
   
   </form>
</body>
</html>