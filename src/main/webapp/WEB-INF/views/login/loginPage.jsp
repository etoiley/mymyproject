<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginPage</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
</head>
<body>
<div class="container">
	<form class="form-signin" method="post" action="/login-process.lo">
		<p>
			<img src="/resources/image/jordy.jpg" class="img-thumbnail" alt="안냥" style="width:100px; height : 100px;">
		</p>
		<p>
			<label for="userId" class="sr-only">아이디</label>
			<input type="text" id="userId" name="userId" class="form-control" placeholder="아이디" >
		</p>
		<p>
			<label for="userPassword" class="sr-only">비밀번호</label>
			<input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="비밀번호" >
		</p>
		<button class="btn btn-lg btn-primary" type="submit" id="login_btn">로그인</button>
	</form>
	<button id="registerBtn">회원가입</button>
</div>
</body>
<script>
	
	
	$('#registerBtn').on("click", function(){
		
		location.href = "/registerForm.lo"
	})
	
</script>
</html>