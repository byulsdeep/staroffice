<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
</head>
<body>
	<s:iterator value="productList">
		<%-- <s:property value="isdeleted"/> --%>
		result:
		<s:if test="isdeleted == 'false'">
			if
		</s:if>
		<s:else>
			else
		</s:else>
		<br />
	</s:iterator>
	<h1>zzxx</h1>
</body>
</html>