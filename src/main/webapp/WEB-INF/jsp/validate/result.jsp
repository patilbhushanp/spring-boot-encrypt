<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Encrypted Link Validation</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<%
			String isLinkExpired = request.getAttribute("isLinkExpired") == null ? "true" : request.getAttribute("isLinkExpired").toString();
		%>
	</head>
	<body>
		<h3>&nbsp;&nbsp;Is Encrypted Link Expired - <%=isLinkExpired%></h3>
	</body>
</html>