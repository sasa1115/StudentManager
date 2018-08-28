<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>学生一覧管理</title>
<link rel="stylesheet" type="text/css" href="./css/all.css"/>
<style type="text/css">
</style>
<script type="text/javascript" >
	function addCheckForm() {
		var form = document.getElementById('addForm');

	    var input_name= document.getElementById('addname').value;
	    var input_birthday= document.getElementById('addbirthday').value;
	    var input_age= document.getElementById('addage').value;
	    var input_score= document.getElementById('addscore').value;

	    if (input_name == "" || input_name == null) {
	    	alert("请输入学員氏名！！！");
	    	return false;
	    }

	    if (input_birthday == "" || input_birthday == null) {
	    	alert("请输入学員生年月日！！！");
	    	return false;
	    }

	    if (input_age == "" || input_age == null) {
	    	alert("请输入学員年齢！！！");
	    	return false;
	    }

	    if (input_score == "" || input_score == null) {
	    	alert("请输入学員成绩！！！");
	    	return false;
	    }

		form.submit();
		return true;
	}

	function delCheckForm() {
		var form = document.getElementById('delForm');

	    var input_id= document.getElementById("delid").value;
	    if (input_id == "" || input_id == null) {
	    	alert("请输入削除学員id！！！");
	    	return false;
	    }

		form.submit();
		return true;
	}

	function editCheckForm() {
		var form = document.getElementById('editForm');

	    var input_id= document.getElementById('editid');
	    var input_name= document.getElementById('editname');
	    var input_birthday= document.getElementById('editbirthday');
	    var input_age= document.getElementById('editage');
	    var input_score= document.getElementById('editscore');

	    if (input_id == "" || input_id == null) {
	    	alert("请输入学員id！！！");
	    	return false;
	    }

	    if (input_name == "" || input_name == null) {
	    	alert("请输入学員氏名！！！");
	    	return false;
	    }

	    if (input_birthday == "" || input_birthday == null) {
	    	alert("请输入学員生年月日！！！");
	    	return false;
	    }

	    if (input_age == "" || input_age == null) {
	    	alert("请输入学員年齢！！！");
	    	return false;
	    }

	    if (input_score == "" || input_score == null) {
	    	alert("请输入学員成绩！！！");
	    	return false;
	    }

		form.submit();
		return true;
	}

	//*********************************
	 <meta charset="UTF-8">
  <title>先生一覧管理</title>
<link rel="stylesheet" type="text/css" href="./css/all.css"/>
<style type="text/css">
</style>
<script type="text/javascript" >
	function addCheckForm() {
		var form = document.getElementById('addForm');

	    var input_teachername= document.getElementById('addteachername').value;
	    var input_id= document.getElementById('addid').value;
	    var input_course= document.getElementById('addcourse').value;

	    if (input_teachername == "" || input_teachername == null) {
	    	alert("请输入先生氏名！！！");
	    	return false;
	    }

	    if (input_id == "" || input_id == null) {
	    	alert("请输入学員id！！！");
	    	return false;
	    }

	    if (input_course == "" || input_course == null) {
	    	alert("请输入课程！！！");
	    	return false;
	    }



		form.submit();
		return true;
	}

	function delCheckForm() {
		var form = document.getElementById('delForm');

	    var input_id= document.getElementById("delid").value;
	    if (input_id == "" || input_id == null) {
	    	alert("请输入削除先生id！！！");
	    	return false;
	    }

		form.submit();
		return true;
	}

	function editCheckForm() {
		var form = document.getElementById('editForm');

	    var input_id= document.getElementById('editid');
	    var input_teachername= document.getElementById('editteachername');
	    var input_course= document.getElementById('editcourse');

	    if (input_id == "" || input_id == null) {
	    	alert("请输入先生id！！！");
	    	return false;
	    }

	    if (input_teachername == "" || input_teachername == null) {
	    	alert("请输入先生氏名！！！");
	    	return false;
	    }

	    if (input_course == "" || input_course == null) {
	    	alert("请输入先生课程！！！");
	    	return false;
	    }


		form.submit();
		return true;
	}
</script>
</head>
<body>
<img src="./images/header.jpg" />
${msg}
<h1 align="center">学员信息管理</h1>

<div id="all_comm" class="all"  >
  <h2 align="center">学员信息一览</h2>
  <table id="items" >
	<tr>
		<td>id</td>
		<td>氏名</td>
		<td>生年月日</td>
		<td>年齢</td>
		<td>成績</td>
	</tr>

    <c:forEach items="${students}" var="student" >
	    <tr>
			<td id="id${student.id }">${student.id}</td>
			<td id="name${student.id }">${student.name}</td>
			<td id="birthday${student.id}">${student.birthday}</td>
			<td id="age${student.id }">${student.age}</td>
			<td id="score${student.id}">${student.score}</td>
		 </tr>
	 </c:forEach>
  </table>
    <table id="teacheritems" >
	<tr>
		<td>id</td>
		<td>氏名</td>
		<td>生年月日</td>
	</tr>

    <c:forEach items="${teachers}" var="teacher" >
	    <tr>
			<td id="id${teacher.id }">${teacher.id}</td>
			<td id="teachername${teacher.id }">${teacher.teachername}</td>
			<td id="course${teacher.id}">${teacher.course}</td>

		 </tr>
	 </c:forEach>
  </table>




</div>

	<div id="add_comm" class="all" align="left">
	  <h2>学生の検索</h2>
	  <form action="queryByName" method="post" >
		<input type="text" placeholder="氏名" name="name" >
		<input type="submit" value="学生の検索" >
	  </form>

	  <h2 id="edit_title">学生の追加</h2>
		<form  id="addForm" action="add" method="post" >
		<input id="addname" type="text" placeholder="氏名" name="name" />
		<input id="addbirthday" type="text" placeholder="生年月日" name="birthday" />
		<input id="addage" type="text" placeholder="年齢" name="age" />
		<input id="addscore" type="text" placeholder="成績" name="score" />
		<input type="button" value="添加" onClick="addCheckForm()"/>
	  </form>
	</div>

	<div id="edit_comm" class="all">
	  <h2>删除学员</h2>
	  <form id="delForm" action="deleteById" method="post" >
		<input id="delid" type="text" placeholder="要删除的id" name="id" />
		<input type="button" value="删除学员" onclick="delCheckForm()"/>
	  </form>

	  <h2 id="edit_title">学生編集</h2>
	  <form id = "editForm"action="update" method="post">
		<input id="editid" type="text" placeholder="要修改的id" id="edit_id" name="id" value="要修改的id为"/><br>
		<input id="editname" type="text" placeholder="氏名" name="name" />
		<input id="editbirthday" type="text" placeholder="生年月日" name="birthday" />
		<input id="editage" type="text" placeholder="年齢" name="age" />
		<input id="editscore" type="text" placeholder="成績" name="score" />
		<input type="button" value="修正確認" onclick="editCheckForm()"/>
	  </form>
	</div>
	//*******************************************
	<img src="./images/header.jpg" />
${msg}
<h1 align="center">先生信息管理</h1>

<div id="all_comm" class="all"  >
  <h2 align="center">先生信息一览</h2>
  <table id="items" >
	<tr>
		<td>id</td>
		<td>氏名</td>
		<td>课程</td>

	</tr>

    <c:forEach items="${teacher}" var="teacher" >
	    <tr>
			<td id="id${teacher.id }">${teacher.id}</td>
			<td id="teachername${teacher.id }">${teacher.teachername}</td>
			<td id="course${teacher.id}">${teacher.course}</td>

		 </tr>
	 </c:forEach>
  </table>
</div>

	<div id="add_comm" class="all" align="left">
	  <h2>先生の検索</h2>
	  <form action="queryByName" method="post" >
		<input type="text" placeholder="氏名" name="name" >
		<input type="submit" value="先生の検索" >
	  </form>

	  <h2 id="edit_title">先生の追加</h2>
		<form  id="addForm" action="add" method="post" >
		<input id="addname" type="text" placeholder="氏名" name="name" />
		<input id="addid" type="text" placeholder="id" name="id" />
		<input id="addcourse" type="text" placeholder="课程" name="course" />

	  </form>
	</div>

	<div id="edit_comm" class="all">
	  <h2>删除先生</h2>
	  <form id="delForm" action="deleteById" method="post" >
		<input id="delid" type="text" placeholder="要删除的id" name="id" />
		<input type="button" value="删除先生" onclick="delCheckForm()"/>
	  </form>

	  <h2 id="edit_title">先生編集</h2>
	  <form id = "editForm"action="update" method="post">
		<input id="editid" type="text" placeholder="要修改的id" id="edit_id" name="id" value="要修改的id为"/><br>
		<input id="editname" type="text" placeholder="氏名" name="name" />
		<input id="editcourse" type="text" placeholder="课程" name="course" />

		<input type="button" value="修正確認" onclick="editCheckForm()"/>
	  </form>
	</div>
</body>
</html>