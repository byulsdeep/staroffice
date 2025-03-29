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
		<div class='sub_title'>メッセンジャー</div>
		<div class="section_wrap">
			<section class="contact_search">
				<input onkeyup="search(this.value)" />
				<button onclick="location.href='<c:url value="/user_contacts?queryInfo.query=&queryInfo.employeeDepartmentCode=&followInfo.userContact=true" />'">✚</button>
				<%-- <button class="new_chat_button" onclick="location.href='<c:url value="/user_contacts?queryInfo.query=&queryInfo.employeeDepartmentCode=&followInfo.userContact=true" />'">✚</button> --%>
			</section>
			<section class="chat_history">
 				<c:forEach var="partner" items="${partnersInfo}" varStatus="i">
					<%-- <div onclick="enterRoom(${i.index})"> --%>
					<div onclick="chatInit('${partner.partnerId}')">
						<div>
							<div class="chat_image_wrap">
								<img src="${partner.partnerPhoto}" />
							</div>
							<div>
								<div>${partner.partnerLastname}${partner.partnerFirstname}</div>
								<div>${partner.lastMessageBody}</div>
							</div>
						</div>
						<div>
							<c:choose>
								<c:when test="${sessionScope.accessInfo.accessTime.substring(0, 10) == partner.lastMessageSent.substring(0, 10)}">
									${partner.lastMessageSent.substring(11, 16)}
								</c:when>
								<c:otherwise>
									${partner.lastMessageSent.substring(5, 10)}
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${partner.unreadCount > 0}">
									<div class="unread_count">${partner.unreadCount}</div>
								</c:when>
								<c:otherwise>
									<div style="visibility: hidden;" class="unread_count"></div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</section>
		</div>
	</article>
</body>
<script>
function search(query) {
	const partnerDivs = Array.from(document.querySelector('.chat_history').children)
	partnerDivs.forEach((div) => {
		const name = div.children[0].children[1].children[0].textContent
		if (name.toUpperCase().includes(query.toUpperCase())) {
			div.style.display = 'flex'
		} else {
			div.style.display = 'none'
		}
	})
}
function chatInit(messageSender) {
	location.href = '<c:url value="/chat_init"/>' +
	'?chatInfo.messageReceiver=${sessionScope.accessInfo.employeeId}&chatInfo.messageSender=' +
	messageSender
}
</script>
</html>