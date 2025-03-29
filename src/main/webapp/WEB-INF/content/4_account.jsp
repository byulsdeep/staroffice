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
	<header>
		<div class='header_top'>
			<div class='home_button' onclick="location.href='<c:url value="/" />'">
				<i class="fa-solid fa-star"></i>
				Star Office 1.0
			</div>
			<div>ようこそ、<s:property value="#session.accessInfo.employeeLastname" /><s:property value="#session.accessInfo.employeeFirstname" />様。所属：<s:property value="#session.accessInfo.departmentName" /> 接続時間：<s:property value="#session.accessInfo.accessTime" /></div>
			<div onclick="location.href='<c:url value="/logout" />'">ログオフ</div>
		</div>
		<div class='header_bottom'>
			<div onclick="location.href='<c:url value="/contacts_init" />'">連絡先検索🔍</div>
			<div onclick="location.href='<c:url value="/doc_init?doc.query=&doc.documentDepartmentCode=&doc.currentPage=1&doc.myDoc=false&doc.sort=newest" />'">文書📁</div>
			<div onclick="location.href='<c:url value="/doc_init?doc.query=&doc.documentDepartmentCode=&doc.currentPage=1&doc.myDoc=true&doc.sort=newest" />'">保管文書📁</div>
			<div onclick="location.href='<c:url value="/messenger_init" />'">メッセンジャー💬</div>
			<div onclick="location.href='<c:url value="/account_init" />'">アカウント🔒</div>
			<div class='datetime'></div>
			<div onclick="location.href='<c:url value="/notification_init" />'">通知🔔</div>
		</div>
		<script>
			initClock()
			function initClock() {
				document.querySelector('.datetime').textContent = new Date()
				setTimeout(initClock, 1000)
			}
		</script>
	</header>
	<article>
		<div class='sub_title'>アカウント情報</div>
		<div class='section_wrap'>
			<section class='account_image_update'>
				<div>
					<img onclick="location.href='${sessionScope.accessInfo.employeePhoto}'" src='${sessionScope.accessInfo.employeePhoto}' />
				</div>
				<button class='button' onclick="document.querySelector('#employeePhoto').click()">写真変更</button>
				<input style="display: none;" type="file" id="employeePhoto" onchange="editUserImage(this, this.parentNode.children[0].children[0])" accept=".jpg, .jpeg, .png" />
			</section>
			<section>
				<table>
					<tr>
						<th>ID</th>
						<td><input name='editUserInfo.employeeId' value='<s:property value="#session.accessInfo.employeeId" />' disabled /></td>
					</tr>
					<tr>
						<th>e-mail</th>
						<td><input name='editUserInfo.employeeEmail' type='email' value='<s:property value="#session.accessInfo.employeeEmail" />' /></td>
					</tr>
					<tr>
						<th>氏名</th>
						<td>
							<input name='editUserInfo.employeeLastname' value='<s:property value="#session.accessInfo.employeeLastname" />' />
							<input name='editUserInfo.employeeFirstname' value='<s:property value="#session.accessInfo.employeeFirstname" />' />
						</td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><input name='editUserInfo.employeePhone' type='tel' value='<s:property value="#session.accessInfo.employeePhone" />' /></td>
					</tr>
					<tr>
						<th>部署</th>
						<td>
							<input name='editUserInfo.departmentName' value='<s:property value="#session.accessInfo.departmentName" />' disabled />
						</td>
					</tr>
					<tr>
						<th>職級</th>
						<td><input name='editUserInfo.gradeName' value='<s:property value="#session.accessInfo.gradeName" />' disabled /></td>
					</tr>
					<tr>
						<th colspan='2' onclick="editUser()">情報変更</th>
					</tr>
				</table>
			</section>
			<section class='password_update_account_delete_wrap'>
				<div class='password_update'>
					<input name='editUserInfo.employeePassword' placeholder='新しいパスワード' value='' type='password' />
					<input placeholder='新しいパスワード確認' value='' type='password' />
					<div>
						<button onclick="editUserPassword()">パスワード変更</button>
					</div>
				</div>
				<button onclick="deleteUser()">アカウント削除</button>
			</section>
		</div>
	</article>
</body>
<script src="./js/script.js"></script>
<script>
if (`${message}` !== ``) alert(`${message}`)
function editUserImage(inputElement, imageElement) {
	const reader = new FileReader()
	reader.readAsDataURL(inputElement.files[0])
	reader.onload = () => imageElement.src = reader.result
	postAjaxMultipartFormData('<c:url value="/edit_user_image" />', { file : inputElement.files[0], fileName : inputElement.files[0].name }, 'callback')
}
function callback(message) {
	alert(JSON.parse(message))
}
function deleteUser() {
	if (!confirm('本当に削除しますか？')) {
		return
	}
	location.href = '<c:url value="/delete_user" />'
}
function editUserPassword() {
	const form = document.createElement('form')
	form.action = 'edit_user_password'
	form.method = 'post'
	form.style.display = 'none'
	const input = document.querySelectorAll('input[type="password"]')
	if (input[0].value.length < 1) {
		alert('パスワードを入力してください')
		return
	}
	if (input[0].value !== input[1].value) {
		alert('パスワードが違います')
		return
	}
	form.appendChild(input[0])
	document.body.appendChild(form)
	form.submit()
}
function editUser() {
	const form = document.createElement('form')
	form.action = 'edit_user'
	form.method = 'post'
	form.style.display = 'none'
	const input = document.querySelectorAll('input:not([type="password"])')
	input.forEach((element) => form.appendChild(element))
	document.body.appendChild(form)
	console.log(form.innerHTML)
	form.submit()
}
</script>
</html>