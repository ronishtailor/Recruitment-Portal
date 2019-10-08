<html>
<title>Profile</title>
<head>
<link rel="stylesheet" href="cmpProfileCSS.css" type="text/css"/>
<link rel="icon" type="image/png" href="images/icon.png"/>
</head>
<body>
<br/>
<br/>
<div id="formBlock">
<br/>
<br/>
<div id="heading">Profile</div>
<br/>
<br/>
<br/>
<form align="center" action="updateCompanyDetails">
<label><span>Name</span><input class="fields" type="text" name="name" value=${cname}></label><br/>
<label><span>E-Mail</span><input class="fields" type="email" name="email" value=${cemail}></label><br/>
<label><span>Website</span><input class="fields" type="text" name="website" value=${cwebsite}></label><br/>
<label><span>Location</span><input class="fields" type="text" name="location" value=${clocation}></label><br/>
<label><span>Contact</span><input class="fields" type="text" name="contact" value=${ccontact}></label><br/>
<label><span>Password</span><input class="fields" type="text" name="pass" value=${cpass}></label><br/>

<div class="container-login100-form-btn">
                        <button class="login100-form-btn">
                            Update
                        </button>
                    </div>
<br/><br/><br/>
</form>
</div>
<br/><br/>
</body>
</html>