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
				setTimeout(initClock, 10000)
			}
		</script>
	</header>
	<article>
		<div class='sub_title'>メッセンジャー</div>
		<div class="section_wrap">
			<section class="chat_room">
				<c:forEach var="conversation" items="${conversations}">
					<div class="chat_room_datetime">${conversation.date}</div>
					<c:forEach var="msg" items="${conversation.messages}">
						<c:choose>
							<c:when test="${msg.messageSender == sessionScope.accessInfo.employeeId}">
								<div class="sent">
									<div class="timestamp_wrap">
										<div class="timestamp">${msg.messageSent.substring(11,16)}</div>
									</div>
									<div class="sent_message">${msg.messageBody}</div>
								</div>
							</c:when>
							<c:when test="${msg.messageReceiver == sessionScope.accessInfo.employeeId}">
								<div class="received">
									<div class="sender_image_wrap">
										<img src="${partnerInfo.partnerPhoto}" />
									</div>
									<div class="sender_wrap">
										<div class="sender_name">${partnerInfo.partnerLastname}${partnerInfo.partnerFirstname}</div>
										<div class="received_message">${msg.messageBody}</div>
									</div>
									<div class="timestamp_wrap">
										<div class="timestamp">${msg.messageSent.substring(11,16)}</div>
									</div>
								</div>
							</c:when>
						</c:choose>
					</c:forEach>
				</c:forEach>
			</section>
			<section class="send_message_wrap">
				<input value="${chatInfo.messageBody}" onkeydown="if (event.keyCode === 13) sendMessage(this.value)" />
				<button onclick="sendMessage(this.parentNode.children[0].value)">送信</button>
			</section>
		</div>
		<button class="chat_room_return_button" onclick="location.href = '<c:url value="/messenger_init" />'">戻る</button>
	</article>
</body>
<script>
const chat_room = document.querySelector('.chat_room')
chat_room.scrollTop = chat_room.scrollHeight
/* chat_room.scrollTo(0, sessionStorage.getItem('scrollPosition')) */
const input = document.querySelector('input')
input.focus()
input.selectionStart = input.selectionEnd = input.value.length
/* setInterval(() => {
	location.href = '<c:url value="/chat_init"/>' +
	'?chatInfo.messageReceiver=${sessionScope.accessInfo.employeeId}&chatInfo.messageSender=${partnerInfo.partnerId}' +
	'&chatInfo.messageBody=' + input.value
}, 3000) */
	/* sessionStorage.setItem('scrollPosition', chat_room.scrollTop) */

function sendMessage(messageBody) {
	if (messageBody.trim().length === 0) return
	console.log('${sessionScope.accessInfo.employeeId}')
	console.log('${partnerInfo.partnerId}')
	location.href = '<c:url value="/send_message"/>' +
	'?chatInfo.messageSender=${sessionScope.accessInfo.employeeId}&chatInfo.messageReceiver=${partnerInfo.partnerId}' +
	'&chatInfo.messageBody=' + messageBody.trim()
}
</script>
</html>