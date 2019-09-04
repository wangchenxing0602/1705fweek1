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
$(function(){
	var id="${param.id}";
	alert(id);
	$.post("getupdate",{id:id},function(obj){
		alert(obj);
		var m=obj.movie;
		$("[name=name]").val(m.name);
		$("[name=con]").val(m.con);
		$("[name=doc]").val(m.doc);
		$("[name=date]").val(m.date);
		var list=obj.list;
	    for( var i in list){
	    	$("[name=tids][value='"+list[i].tid+"']").attr("checked",true);
	    }
	},"json")
	
})


function add(){
	var param = $("form").serialize();
	alert(param);
	$.post("update",param,function(flag){
		if(flag){
			alert("修改成功");
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
     <td>
     <input type="hidden" name="id"  value="${param.id}">
     <input type="text" name="name" ></td>
     
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