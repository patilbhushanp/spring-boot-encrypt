<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Encrypt Decrypt Page</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Encrypt Decrypt Utility</a>
				</div>
			</div>
			<div class="container">
				<div id="navbar" class="collapse navbar-collapse">
					<form action="/decryptData" method="post">
						<div class="form-group">
					      <label for="comment" class="navbar-brand">Encrypted Data:</label>
					      <textarea class="form-control" rows="20" name="encryptData" id="encryptData"><%=request.getAttribute("encryptedData") == null ? "" : request.getAttribute("encryptedData")%></textarea>
					      <br/><br/>
					      <button type="submit" class="btn btn-primary">Decrypt</button>
					      <br/><br/>
					    </div>
					</form>
				</div>
			</div>
		</nav>
	</body> 
</html>