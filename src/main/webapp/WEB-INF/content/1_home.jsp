<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>★ Star Office 1.0</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel='stylesheet' href='./css/style.css' />
<style>
.features_wrap > * {
	cursor: unset;
}
.features_wrap > *:hover {
	color: black;
	background-color: var(--star);
	border: 1px solid black;
}
</style>
</head>
<body>
	<article>
		<h1 onclick="location.href='<c:url value="/" />'">
			<i class="fa-solid fa-star"></i>
			Star Office 1.0
		</h1>
		<div class='sub_title'>シンプル協力システム</div>
		<div class='features_wrap'>
			<div>連絡網</div>
			<div>文書</div>
			<div>メッセンジャー</div>
		</div>
		<form action='login' method='post'>
			<input value="byul" name='loginUserInfo.employeeId' value='${loginUserInfo.employeeId}' placeholder='ID' />
			<input value="byul" name='loginUserInfo.employeePassword' value='${loginUserInfo.employeePassword}' placeholder='password' type='password' />
			<div class='buttons_wrap'>
				<button>アクセス</button>
				<button onclick="event.preventDefault(); location.href='<c:url value="/sign_up_init" />'">登録</button>
			</div>
		</form>
		<div class='future_features_wrap'>
			<div>2.0に追加予定：</div>
			<div>
				<div>作業管理</div>
				<div>e-mail</div>
			</div>
		</div>
	</article>
</body>
<script>
document.querySelector('input[name="loginUserInfo.employeeId"]').focus()
if (`${message}` !== ``) alert(`${message}`)
</script>
</html>