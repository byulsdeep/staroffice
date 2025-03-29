<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<title><tiles:getAsString name="title" /></title>
</head>
<body>

<%@  include file="/WEB-INF/include/layout_header.jsp" %>
<tiles:insertAttribute name="content" />

</body>
</html>