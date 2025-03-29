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
		<div class='sub_title'>連絡先検索</div>
		<div class="section_wrap">
			<section class="contact_search">
				<select name="queryInfo.employeeDepartmentCode">
					<option value="">すべて</option>
					<option value="1">システム開発事務部</option>
					<option value="2">S・I本部</option>
					<option value="3">管理本部</option>
					<option value="4">営業戦略推進部</option>
				</select>
				<button onclick="location.href='<c:url value="/user_contacts?queryInfo.query=" />' + this.parentNode.children[2].value + '&queryInfo.employeeDepartmentCode=' + this.parentNode.children[0].value + '&followInfo.userContact=true'" >保存連絡先検索</button>
				<input name="queryInfo.query" value="${queryInfo.query}" onkeydown="if (event.keyCode === 13) location.href='<c:url value="/search_user?queryInfo.query=" />' + this.value + '&queryInfo.employeeDepartmentCode=' + this.parentNode.children[0].value" />
				<button onclick="location.href='<c:url value="/search_user?queryInfo.query=" />' + this.parentNode.children[2].value + '&queryInfo.employeeDepartmentCode=' + this.parentNode.children[0].value + '&followInfo.userContact=false'">全体検索</button>
			</section>
			<section class="contact_search_result">
				<c:forEach var="contact" items="${contacts}" varStatus="i">
					<div onclick="openModal(
					'${contact.employeeId }',
					'${contact.employeeLastname}',
					'${contact.employeeFirstname}',
					'${contact.departmentName}',
					'${contact.employeeEmail}',
					'${contact.employeePhone}',
					'${contact.gradeName}',
					'${contact.myContact}',
					'${contact.employeePhoto}'
					)">
						<div>${contact.employeeLastname}${contact.employeeFirstname}</div>
						<div>${contact.departmentName}</div>
						<div>${contact.employeeEmail}</div>
						<div>${contact.employeePhone}</div>
						<div>
	   						<c:choose>
								<c:when test="${contact.myContact}">
									⭐
								</c:when>
								<c:otherwise>
									☆
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</section>
		</div>
	</article>
	<div class="modal_wrap">
		<div class="modal">
			<div class="modal_top">
				<div class="modal_image_wrap">
					<img />
				</div>
				<div class="modal_contact_info">
					<table>
						<tr>
							<th>氏名</th>
							<td></td>
						</tr>
						<tr>
							<th>e-mail</th>
							<td></td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td></td>
						</tr>
						<tr>
							<th>部署</th>
							<td></td>
						</tr>
						<tr>
							<th>職級</th>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="modal_bottom">
				<button onclick="chatInit()">メッセージ送信</button>
				<button class="add_or_remove" onclick="addOrRemoveContact()">wtf</button>
				<button onclick="this.parentNode.parentNode.parentNode.style.display = 'none'">戻る</button>
			</div>
			<button onclick="this.parentNode.parentNode.style.display = 'none'">✖</button>
		</div>
	</div>
</body>
<script>
let addOrRemove
let contactsFollowee
if (`${message}` !== ``) alert(`${message}`)
if (`${queryInfo.employeeDepartmentCode}` !== ``) document.querySelector('select[name="queryInfo.employeeDepartmentCode"]').value = `${queryInfo.employeeDepartmentCode}`
function addOrRemoveContact() {
	const form = document.createElement('form')
	form.action = addOrRemove ? 'add_contact' : 'remove_contact'
	form.method = 'post'
	form.style.display = 'none'
	const input = document.createElement('input')
	input.type = 'hidden'
	input.name = 'followInfo.contactsFollowee'
	input.value = contactsFollowee
	const input2 = document.createElement('input')
	input2.type = 'hidden'
	input2.name = 'followInfo.userContact'
	let s = window.location.search
	input2.value = s.substring(s.indexOf('userContact=') + 12, s.indexOf('userContact=') + 13) === 't'

	form.appendChild(document.querySelector('input[name="queryInfo.query"]'))
	form.appendChild(document.querySelector('select[name="queryInfo.employeeDepartmentCode"]'))
	form.appendChild(input)
	form.appendChild(input2)
	document.body.appendChild(form)
	form.submit()
}
function openModal(employeeId, employeeLastname, employeeFirstname, departmentName, employeeEmail, employeePhone, gradeName, myContact, employeePhoto) {
	const td = document.querySelectorAll('td')
	td[0].textContent = employeeLastname + employeeFirstname
	td[1].textContent = employeeEmail
	td[2].textContent = employeePhone
	td[3].textContent = departmentName
	td[4].textContent = gradeName
	document.querySelector('img').src = employeePhoto
	document.querySelector('.modal_image_wrap').setAttribute('onclick', 'showPhoto("' + employeePhoto + '")')
	const add_or_remove = document.querySelector('.add_or_remove')
	if (myContact === 'true') {
		add_or_remove.textContent = '連絡先削除⭐'
		addOrRemove = false
		/* add_or_remove.onclick = removeContact(employeeId) */
	} else {
		addOrRemove = true
		add_or_remove.textContent = '連絡先保存☆'
		/* add_or_remove.onclick = addContact(employeeId) */
	}
	contactsFollowee = employeeId
	document.querySelector('.modal_wrap').style.display = 'flex'
}
function showPhoto(employeePhoto) {
	location.href = employeePhoto
}
function chatInit() {
	location.href = '<c:url value="/chat_init"/>' +
	'?chatInfo.messageReceiver=${sessionScope.accessInfo.employeeId}&chatInfo.messageSender=' +
	contactsFollowee
}
document.querySelector('input').focus()
</script>
</html>