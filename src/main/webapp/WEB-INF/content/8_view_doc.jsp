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
		<div class='sub_title'>文書閲覧</div>
		<div class="section_wrap">
			<section class="doc_info">
				<div class="doc_title">${doc.documentTitle}</div>
				<div class="doc_info_metadata">
					<div>
						<div class="dept_value">${doc.departmentName}</div>
						<div>${doc.employeeLastname}${doc.employeeFirstname}</div>
						<button onclick="location.href='<c:url value="/search_user?queryInfo.query=${doc.documentEmployeeId}" />'">連絡先</button>
					</div>
					<div>
						<div><s:property value="doc.documentCreated.substring(0, 10)" /></div>
						<div><s:property value="doc.documentCreated.substring(11, 19)" /></div>
						<div>閲覧数<s:property value="doc.documentViewCount" /></div>
						<div>
							コメント
							<c:choose>
								<c:when test="${doc.comments.size() > 0}">
									${doc.comments.size()}
								</c:when>
								<c:otherwise>
									0
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
				<div class="doc_info_attachment">
					<div>添付ファイル：</div>
					<div>
						<c:forEach var="file" items="${doc.files}">
							<div>
								<a href="${file.filesRelativePath}" download="${file.filesName}">${file.filesName}</a>
								<button onclick="location.href=`${file.filesRelativePath}`">開く</button>
								<button onclick="this.parentNode.children[0].click()">ダウンロード</button>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="doc_info_body">${doc.documentBody}</div>
			</section>
			<div class="doc_buttons">
				<c:choose>
					<c:when test="${doc.savedDocumentEmployeeId == null}">
						<button onclick="location.href='<c:url value="/save_doc?saveInfo.savedDocumentDepartmentCode=${doc.documentDepartmentCode}&saveInfo.savedDocumentNumber=${doc.documentNumber}" />'">保管📁</button>
					</c:when>
					<c:otherwise>
						<button onclick="location.href='<c:url value="/unsave_doc?saveInfo.savedDocumentDepartmentCode=${doc.documentDepartmentCode}&saveInfo.savedDocumentNumber=${doc.documentNumber}" />'">保管取り消し❌</button>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${doc.documentEmployeeId == sessionScope.accessInfo.employeeId}">
						<button onclick="location.href='<c:url value="/edit_doc_init?doc.documentDepartmentCode=${doc.documentDepartmentCode}&doc.documentNumber=${doc.documentNumber}" />'">修正</button>
						<button onclick="deleteDoc('${doc.documentDepartmentCode}', '${doc.documentNumber}')">削除❌</button>
					</c:when>
				</c:choose>
				<button onclick="window.history.back()">戻る</button>
			</div>
			<section class="comments">
				<c:forEach var="comment" items="${doc.comments}">
					<div id="${comment.commentsEmployeeId}_${comment.commentsCreated.substring(0, 10)}_${comment.commentsCreated.substring(11, 19)}">
						<div>${comment.employeeLastname}${comment.employeeFirstname}</div>
						<div>${comment.commentsBody}</div>
						<div>
							<div>${comment.commentsCreated.substring(0, 10)}</div>
							<div>${comment.commentsCreated.substring(11, 19)}</div>
						</div>
						<div>
							<c:choose>
								<c:when test="${sessionScope.accessInfo.employeeId == comment.commentsEmployeeId}">
									<button onclick="updateComment('${comment.commentsEmployeeId}_${comment.commentsCreated.substring(0, 10)}_${comment.commentsCreated.substring(11, 19)}')">修正</button>
									<button onclick="deleteComment('${comment.commentsEmployeeId}_${comment.commentsCreated.substring(0, 10)}_${comment.commentsCreated.substring(11, 19)}')">削除</button>
								</c:when>
							</c:choose>
						</div>
					</div>
				</c:forEach>
				<div>
					<div>
						${sessionScope.accessInfo.employeeLastname}${sessionScope.accessInfo.employeeFirstname}
					</div>
					<input />
					<button onclick="insertComment(this.parentNode.children[1].value)">コメント</button>
				</div>
			</section>
		</div>
	</article>
	<script>
	const employeeId = `${sessionScope.accessInfo.employeeId}`
	if (`${message}` !== ``) alert(`${message}`)
	function insertComment(commentsBody) {
		if (commentsBody === '') return
    	$.ajax({
    		url: 'insert_comment',
    		type: 'post',
    		data: {
    	    	'commentInfo.commentsEmployeeId': '${sessionScope.accessInfo.employeeId}',
    	    	'commentInfo.commentsDocumentDepartmentCode': '${doc.documentDepartmentCode}',
    	    	'commentInfo.commentsDocumentNumber': '${doc.documentNumber}',
    	    	'commentInfo.commentsBody': commentsBody
    		},
    		success: (doc) => {
    			refresh(doc)
    		},
    		error: (err, req) => {
    			console.log(err)
    			console.log(req)
	    	}
    	})
	}
	function deleteComment(id) {
		if (!confirm('本当に削除しますか？')) {
			return
		}
		const updateInfo = id.split("_")
    	$.ajax({
    		url: 'delete_comment',
    		type: 'post',
    		data: {
    	    	'commentInfo.commentsEmployeeId': updateInfo[0],
    	    	'commentInfo.commentsDocumentDepartmentCode': '${doc.documentDepartmentCode}',
    	    	'commentInfo.commentsDocumentNumber': '${doc.documentNumber}',
    	    	'commentInfo.commentsCreated': updateInfo[1] + ' ' + updateInfo[2]
    		},
    		success: (doc) => {
    			refresh(doc)
    		},
    		error: (err, req) => {
    			console.log(err)
    			console.log(req)
    		}
    	})
	}
	function updateComment2(id) {
	    if (!confirm('修正しますか？')) {
	    	return
	    }
		console.log(id)
	    const updateInfo = id.split("_")
	    /* 'byul', '2023-11-21', '13:30:52' */
    	$.ajax({
    		url: 'edit_comment',
    		type: 'post',
    		data: {
    	    	'commentInfo.commentsEmployeeId': updateInfo[0],
    	    	'commentInfo.commentsDocumentDepartmentCode': '${doc.documentDepartmentCode}',
    	    	'commentInfo.commentsDocumentNumber': '${doc.documentNumber}',
    	    	'commentInfo.commentsCreated': updateInfo[1] + ' ' + updateInfo[2],
    	    	'commentInfo.commentsBody': document.getElementById(id + '_input').value
    		},
    		success: (doc) => {
    			refresh(doc)
    		},
    		error: (err, req) => {
    			console.log(err)
    			console.log(req)
    		}
    	})
	}
	function updateComment(id) {
		const div = document.getElementById(id)
		const temp = div.children[1].textContent
		div.removeChild(div.children[1])
		div.removeChild(div.children[1])
		div.removeChild(div.children[1])
		div.innerHTML += '<input id="' + id + '_input" value="' + temp + '" /><button onclick="updateComment2(`' + id + '`)">修正確認</button>'
		const input = document.getElementById(id + '_input')
		input.focus()
		input.selectionStart = input.selectionEnd = input.value.length
	}

	function deleteDoc(documentDepartmentCode, documentNumber) {
		console.log(documentDepartmentCode)
		console.log(documentNumber)
		if (!confirm('本当に削除しますか？')) {
			return
		}
		location.href = '<c:url value="/delete_doc" />' + '?doc.documentDepartmentCode=${doc.documentDepartmentCode}&doc.documentNumber=${doc.documentNumber}'
	}
	function refresh(doc) {
		const commentSection = document.querySelector('.comments')
		commentSection.innerHTML = ``
		doc.comments.forEach((comment) => {
			commentSection.innerHTML +=
			`
			<div id="` + comment.commentsEmployeeId + `_` + comment.commentsCreated.substring(0, 10) + `_` + comment.commentsCreated.substring(11, 19) + `">
				<div>` + comment.employeeLastname + comment.employeeFirstname + `</div>
				<div>` + comment.commentsBody + `</div>
				<div>
					<div>` + comment.commentsCreated.substring(0, 10) + `</div>
					<div>` + comment.commentsCreated.substring(11, 19) + `</div>
				</div>
				<div>` +
					(employeeId === comment.commentsEmployeeId ?
						`<button onclick="updateComment('` + comment.commentsEmployeeId + `_` + comment.commentsCreated.substring(0, 10) + `_` + comment.commentsCreated.substring(11, 19) + `')">修正</button>
						<button onclick="deleteComment('` + comment.commentsEmployeeId + `_` + comment.commentsCreated.substring(0, 10) + `_` + comment.commentsCreated.substring(11, 19) + `')">削除</button>`
						: ``) +
				`</div>
			</div>
			`
		})

		commentSection.innerHTML +=
		`
		<div>
			<div>
				${sessionScope.accessInfo.employeeLastname}${sessionScope.accessInfo.employeeFirstname}
			</div>
			<input />
			<button onclick="insertComment(this.parentNode.children[1].value)">コメント</button>
		</div>
		`
	}
	</script>
</body>
</html>