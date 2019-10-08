<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Account</title>
<link rel="stylesheet" href="companyRegisterCSS.css" type="text/css"/>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icon.png"/>
</head>
<body background="images/background.jpg">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
					<div class="login100-pic js-tilt" data-tilt>
						<img src="images/img-01.png" alt="IMG">
					</div>
					
					<form class="login100-form validate-form" action="addcompany" onsubmit="validateit()">
					<span class="login100-form-title">
						New Account
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Company Name required">
						<input class="input100" type="text" name="name" placeholder="Name" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="email" name="email" placeholder="Email" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					
			`		<div class="wrap-input100 validate-input" data-validate = "location required">
						<input class="input100" type="text" name="location" placeholder="Location" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Contact required">
						<input class="input100"   type="tel"   pattern="[0-9]{10}" name="contact"  placeholder="Contact"  required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Website required">
						<input class="input100" type="url" name="website" placeholder="Website" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" placeholder="Password" id="pass" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Confirm Password">
						<input class="input100" type="password" name="cpass" placeholder="Confirm Password" id="cpass" required>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Create Account
						</button>
					</div>
					 <script>
                    function validateit()
                    {
                    	var pwd=document.getElementById("pass").value;
                    	var cpwd=document.getElementById("cpass").value;
                    	
              
                    	if(pwd!=cpwd)
                    	{
                    		alert("password does not match");
                    		return false;
                    	}
                    	else
                    	return true;
                    }
                    </script>
                    
					
					

				</form>
			</div>
		</div>
	</div>
</body>
</html>