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
		<div class='sub_title'>文書</div>
		<div class="section_wrap">
			<section class="contact_search">
				<select name="doc.documentDepartmentCode" onchange="getDocuments()">
					<option value="" selected>全ての部署</option>
					<option value="1">システム開発事務部</option>
					<option value="2">S・I本部</option>
					<option value="3">管理本部</option>
					<option value="4">営業戦略推進部</option>
				</select>
				<button class="my_doc_button" onclick="getSavedDocuments()">保管文書📁</button>
				<input name="doc.query" onkeydown="if (event.keyCode === 13) getDocuments()"/>
				<button onclick="getDocuments()">検索</button>
				<button onclick="sortByViewCount()">閲覧順</button>
				<button onclick="sortByNewest()">最新順</button>
				<button onclick="location.href='<c:url value="/write_doc_init" />'">投稿</button>
			</section>
			<section class="doc_list">
				<div>
					<div>番号</div>
					<div>部署</div>
					<div>タイトル</div>
					<div>コメント</div>
					<div>投稿者</div>
					<div>投稿日時</div>
					<div>閲覧数</div>
				</div>
				<c:forEach var="doc" items="${docs}">
					<div onclick="viewDoc('${doc.documentDepartmentCode}', '${doc.documentNumber}')">
						<div>${doc.documentNumber}</div>
						<div>${doc.departmentName}</div>
						<div>${doc.documentTitle}</div>
						<div>${doc.commentsCount}</div>
						<div>${doc.employeeLastname}${doc.employeeFirstname}</div>
						<div>${doc.documentCreated.substring(0, 19)}</div>
						<div>${doc.documentViewCount}</div>
					</div>
				</c:forEach>
			</section>
			<section class="pagination_wrap"></section>
		</div>
	</article>
</body>
<script>
if (`${message}` !== ``) alert(`${message}`)
const query = document.querySelector('input[name="doc.query"]')
query.value = "${param['doc.query']}"
query.focus()
const documentDepartmentCode = document.querySelector('select[name="doc.documentDepartmentCode"]')
if ("${param['doc.documentDepartmentCode']}" !== "")
	documentDepartmentCode.value = "${param['doc.documentDepartmentCode']}"
let myDoc = "${param['doc.myDoc']}"
let sort = "${param['doc.sort']}"
const my_doc_button = document.querySelector('.my_doc_button')
my_doc_button.textContent = myDoc === 'true' ? '全体文書📁' : '保管文書📁'

let currentPage = Number("${param['doc.currentPage']}")
const pagination_wrap = document.querySelector('.pagination_wrap')

if (currentPage > 1) pagination_wrap.innerHTML += '<div onclick="movePage(1)">&lt;&lt;</div><div onclick="movePage(currentPage - 1)">&lt;</div>'
const documentCount = Number('${documentCount}')
const pageCount = Math.ceil(documentCount / 10)

for (let i = 1; i <= pageCount; i++) {
	pagination_wrap.innerHTML += '<div' + (i === currentPage ? ' class="current_page"' : '') + ' onclick="movePage(' + i + ')">' + i + '</div>'
}
if (currentPage < pageCount) pagination_wrap.innerHTML += '<div onclick="movePage(' + (currentPage + 1) + ')">&gt;</div><div onclick="movePage(' + pageCount + ')">&gt;&gt;</div>'

function getDocuments() {
	location.href = '<c:url value="/doc_init" />' + '?doc.query=' + query.value + '&doc.documentDepartmentCode=' +
	documentDepartmentCode.value + '&doc.currentPage=' + currentPage + '&doc.myDoc=' + myDoc +
	'&doc.sort=' + sort
}
function sortByViewCount() {
	sort = 'mostViewed'
	getDocuments()
}
function sortByNewest() {
	sort = 'newest'
	getDocuments()
}
function getSavedDocuments() {
	console.log(myDoc)
	myDoc = myDoc === 'true' ? 'false' : 'true'
	console.log(myDoc)
	getDocuments()
}
function movePage(page) {
	currentPage = page
	getDocuments()
}
function viewDoc(documentDepartmentCode, documentNumber) {
	location.href = '<c:url value="/view_doc_init" />' + '?doc.documentDepartmentCode=' + documentDepartmentCode + '&doc.documentNumber=' + documentNumber
}
</script>
</html>