<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot Password</title>
<link rel="stylesheet" href="loginCSS.css" type="text/css"/>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icon.png"/>
</head>
<body >
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
					<div class="login100-pic js-tilt" data-tilt>
						<img src="images/img-01.png" alt="IMG">
					</div>
					
					<form class="login100-form validate-form" action="compotpverify">
					<span class="login100-form-title">
						Forgot Password
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email" placeholder="Email" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
	${msg}					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Send Otp
						</button>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>