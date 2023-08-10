<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div class="container">
	<form class="form-signin" method="post" action="/register-process.lo">
		<p>
			<label for="userId" class="sr-only">아이디</label>
			<input type="text" id="userId" name="userId" class="form-control" placeholder="아이디" required>
		</p>
		<p>
			<label for="userPassword" class="sr-only">비밀번호</label>
			<input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="비번" required >
		</p>
		<p>
			<label for="userName" class="sr-only">이름</label>
			<input type="text" id="userName" name="userName" class="form-control" placeholder="이름" required>
		</p>
		<p>
			<label for="userEmail" class="sr-only">이메일</label>
			<input type="email" id="userEmail" name="userEmail" class="form-control" placeholder="이메일" >
		</p>
		<p>
			<label for="userPhone" class="sr-only">비밀번호</label>
			<input type="text" id="userPhone" name="userPhone" class="form-control" placeholder="핸드폰" >
		</p>
		<button class="btn btn-lg btn-primary" type="submit" id="register_btn">가입하기</button>
	</form>
</div>

</body>
</html>