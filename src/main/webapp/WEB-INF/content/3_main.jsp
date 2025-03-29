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
		<h1>
			<i class="fa-solid fa-star"></i>
			Star Office 1.0
		</h1>
		<div class='sub_title'>シンプル協力システム</div>
		<div class='features_wrap'>
			<div onclick="location.href='<c:url value="/contacts_init" />'">連絡先検索🔍</div>
			<div onclick="location.href='<c:url value="/doc_init?doc.query=&doc.documentDepartmentCode=&doc.currentPage=1&doc.myDoc=false&doc.sort=newest" />'">文書📁</div>
			<div onclick="location.href='<c:url value="/messenger_init" />'">メッセンジャー💬</div>
			<div onclick="location.href='<c:url value="/account_init" />'">アカウント🔒</div>
			<div onclick="location.href='<c:url value="/notification_init" />'">通知🔔</div>
		</div>
		<div class='quick_access_wrap section_wrap'>
			<section>
				<div onclick="location.href='<c:url value="/doc_init?doc.query=&doc.documentDepartmentCode=&doc.currentPage=1&doc.myDoc=false&doc.sort=newest" />'">文書📁</div>
				<c:forEach var="doc" items="${newDocs}">
					<div onclick="viewDoc('${doc.documentDepartmentCode}', '${doc.documentNumber}')">【${doc.departmentName}】${doc.documentTitle}</div>
				</c:forEach>
			</section>
			<section>
				<div onclick="location.href='<c:url value="/doc_init?doc.query=&doc.documentDepartmentCode=&doc.currentPage=1&doc.myDoc=true&doc.sort=newest" />'">保管文書📁</div>
				<c:forEach var="doc" items="${myDocs}">
					<div onclick="viewDoc('${doc.documentDepartmentCode}', '${doc.documentNumber}')">【${doc.departmentName}】${doc.documentTitle}</div>
				</c:forEach>
			</section>
			<section>
				<div onclick="location.href='<c:url value="/notification_init" />'">通知🔔</div>
				<c:forEach var="notification" items="${notifications}">
					<c:choose>
						<c:when test="${notification.notificationNotificationTypeCode == 1}">
							<div onclick="location.href = '<c:url value="/view_doc_init?doc.documentDepartmentCode=${notification.notificationDocumentDepartmentCode}&doc.documentNumber=${notification.notificationDocumentNumber}&notification.notificationCreated=${notification.notificationCreated}" />'">
						</c:when>
						<c:when test="${notification.notificationNotificationTypeCode == 2}">
							<div onclick="location.href = '<c:url value="/chat_init?chatInfo.messageReceiver=${sessionScope.accessInfo.employeeId}&chatInfo.messageSender=${notification.notificationSender}" />'">
						</c:when>
					</c:choose>
								【${notification.notificationTypeName}】
								<c:choose>
									<c:when test="${notification.notificationNotificationTypeCode == 1}">
										${notification.departmentName}に新しい文書が投稿されました
									</c:when>
									<c:when test="${notification.notificationNotificationTypeCode == 2}">
										${notification.employeeLastname}${notification.employeeFirstname}様から新しいメッセージが届きました
									</c:when>
								</c:choose>
							</div>
						</c:forEach>
					</section>
				</div>
			</article>
		</body>
		<script>
		function viewDoc(documentDepartmentCode, documentNumber) {
			location.href = '<c:url value="/view_doc_init" />' + '?doc.documentDepartmentCode=' + documentDepartmentCode + '&doc.documentNumber=' + documentNumber
		}
		</script>
		</html>