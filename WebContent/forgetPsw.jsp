<!DOCTYPE html>
<html lang="en">
<head>
	<title>Reset Password </title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
<%	String sendMail = (String) request.getAttribute("sendMail");
	if (sendMail != null) {
	%>
	<script type="text/javascript">
 		alert("${sendMail}");

	</script>
		<%
			}
		%>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41"> Reset Password </span>
				<form action="forgetPsw"
					class="login100-form validate-form p-b-33 p-t-5" method="post">

					<div class="wrap-input100 validate-input"
						data-validate="Enter username">
						<input class="input100" type="text" name="username"
							placeholder="User name"> <span class="focus-input100"
							data-placeholder="&#xe82a;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Enter Email-ID">
						<input class="input100" type="email" name="emailID" placeholder="Email-ID">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					
								
					<div class="container-login100-form-btn m-t-32">
						<input type="submit" class="login100-form-btn" value="Get Verification Code">
							
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>