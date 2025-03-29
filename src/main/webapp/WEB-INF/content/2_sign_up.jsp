<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>★ Star Office 1.0</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel='stylesheet' href='./css/style.css' />
</head>
<body>
	<article>
		<h1 onclick="location.href='<c:url value="/" />'">
			<i class="fa-solid fa-star"></i>
			Star Office 1.0
		</h1>
		<div class='sub_title'>登録</div>
		<form action='sign_up' method='post'>
			<input name='createUserInfo.employeeId' value='${createUserInfo.employeeId}' placeholder='ID' />
			<input name='createUserInfo.employeePassword' value='${createUserInfo.employeePassword}' placeholder='password' type='password' />
			<input value='${createUserInfo.employeePassword}' placeholder='password確認' type='password' />
			<input name='createUserInfo.employeeEmail' value='${createUserInfo.employeeEmail}' placeholder='e-mail' type='email' />
			<div>
				<input name='createUserInfo.employeeLastname' value='${createUserInfo.employeeLastname}' placeholder='氏' />
				<input name='createUserInfo.employeeFirstname' value='${createUserInfo.employeeFirstname}' placeholder='名' />
			</div>
			<input name='createUserInfo.employeePhone' value='${createUserInfo.employeePhone}' placeholder='電話番号' type='tel' />
			<select name='createUserInfo.employeeDepartmentCode'>
				<option>部署</option>
				<option value='1'>システム開発事務部</option>
				<option value='2'>S・I本部</option>
				<option value='3'>管理本部</option>
				<option value='4'>営業戦略推進部</option>
			</select>
			<div class='buttons_wrap'>
				<button onclick="event.preventDefault(); location.href='<c:url value="/" />'">戻る</button>
				<button onclick="event.preventDefault(); createUser(this.parentNode.parentNode)">登録</button>
			</div>
		</form>
	</article>
</body>
<script>
document.querySelector("input[name='createUserInfo.employeeId']").focus()
const select = document.querySelector('select')
if (`${createUserInfo.employeeDepartmentCode}` !== ``) select.value = `${createUserInfo.employeeDepartmentCode}`
if (`${message}` !== ``) alert(`${message}`)
function createUser(form) {
	const passwords = document.querySelectorAll('input[type="password"]')
	if (passwords[0].value !== passwords[1].value) {
		alert('パスワードが違います')
		return
	}
	if (select.value === '部署') {
		alert('部署を選択してください')
		return
	}
	const input = Array.from(document.querySelectorAll('input'))
	for (let i = 0; i < input.length; i++) {
		if (input[i].value === '') {
			alert('全ての入力を完了してください')
			return
		}
	}
	form.submit()
}
</script>
</html>