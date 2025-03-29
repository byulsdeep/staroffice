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
		<div class='sub_title'>文書修正</div>
		<div class="section_wrap">
			<section class="write_doc">
				<div>
					<div>部署</div>
					<div class="dept_value">${doc.departmentName}</div>
					<div>タイトル</div>
					<div><input name="doc.documentTitle" value="${doc.documentTitle}" /></div>
				</div>
				<div>
					<div>添付</div>
					<div><input name="attachedFiles" type="file" multiple /></div>
					<div>写真追加</div>
					<div><input type="file" accept=".jpg, .jpeg, .png" onchange="uploadDocImage(this)"/></div>
				</div>
				<div class="editor" contenteditable="true">
					${doc.documentBody}
				</div>
				<div class="write_doc_buttons">
					<button onclick="editDoc()">修正</button>
					<button onclick="window.history.back()">戻る</button>
				</div>
			</section>
		</div>
	</article>
</body>
<script src="./js/script.js"></script>
<script>
document.querySelector('input[name="doc.documentTitle"]').focus()
const editor = document.querySelector('.editor')

function insertImageToEditor(imageUrl) {
	imageUrl = JSON.parse(imageUrl)
    function check() {
        const image = new Image()
        image.src = imageUrl
        image.onload = () => {
            const img = document.createElement('img')
            img.src = imageUrl
            editor.appendChild(img)
        }
        image.onerror = () => setTimeout(check, 1000)
    }
    check()
}
function uploadDocImage(inputElement) {
    postAjaxMultipartFormData('<c:url value="/uploadDocImage" />', { file : inputElement.files[0], fileName : inputElement.files[0].name }, 'insertImageToEditor')
}
function editDoc() {
	if (!confirm('修正しますか？')) {
		return
	}
	const form = document.createElement('form')
	form.action = 'edit_doc'
	form.method = 'post'
	form.enctype = 'multipart/form-data'
	form.style.display = 'none'
	const input = []
	input[0] = document.createElement('input')
	input[0].name = 'doc.documentDepartmentCode'
	input[0].value = '${sessionScope.accessInfo.employeeDepartmentCode}'
	input[1] = document.createElement('input')
	input[1].name = 'doc.documentNumber'
	input[1].value = '${doc.documentNumber}'
	input[2] = document.createElement('input')
	input[2].name = 'doc.documentCreated'
	input[2].value = '${doc.documentCreated.substring(0, 19)}'
	input[3] = document.createElement('input')
	input[3].name = 'doc.documentEmployeeId'
	input[3].value = '${sessionScope.accessInfo.employeeId}'
	input[4] = document.createElement('input')
	input[4].name = 'doc.documentTitle'
	input[4].value = document.querySelector('input[name="doc.documentTitle"]').value
	input[5] = document.createElement('input')
	input[5].name = 'doc.documentBody'
	input[5].value = document.querySelector('.editor').innerHTML
	input[6] = document.querySelector('input[name="attachedFiles"]')
	input.forEach((i) => form.appendChild(i))
	const attachedFileNames = []
	for (let i = 0; i <  input[6].files.length; i++) {
		console.log(input[6].files[i].name)
		attachedFileNames[i] = document.createElement('input')
		attachedFileNames[i].name = 'attachedFileNames[' + i + ']'
		attachedFileNames[i].value = input[6].files[i].name
	}
	attachedFileNames.forEach((attachedFileName) => form.appendChild(attachedFileName))
	document.body.appendChild(form)
	form.submit()
}
</script>
</html>