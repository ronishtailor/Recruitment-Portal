<>
<html>
<title>Profile</title>
<head>
<link rel="stylesheet" href="studProfileCSS.css" type="text/css"/>
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
<form align="center" action="studProfile" >
<label><span>Name</span><input class="fields" type="text" name="name" value=${name} readonly></label><br/>
<label><span>E-Mail</span><input class="fields" type="email" name="email" value=${email} readonly></label><br/>
<label><span>Roll-no</span><input class="fields" type="text" name="rollno" value=${rollno} readonly></label><br/>
<label><span>Branch</span><input class="fields" type="text" name="branch" readonly value=${branch} ></label><br/>
<label><span>Father's Name</span><input class="fields" type="text" name="fatherName" readonly value=${fname} ></label><br/>
<label><span>Mother's Name</span><input class="fields" type="text" name="motherName" readonly value=${mname} ></label><br/>
<label><span>Date of Birth</span> <input class="fields" type="date" name="dob" readonly value=${dob} ></label><br/>
<label><span>Gender</span><input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female" readonly>Female<input type="radio" name="gender" value="other" readonly>Others</label><br/>
<label><span>Aggregate</span><input class="fields" type="number" min="0" max="100"  step=".01" name="aggregate" readonly value=${aggregate} ></label><br/>
<label><span>Number of Backlogs</span><input class="fields" type="number" min="0" max="48" name="back" readonly value=${back} ></label><br/>
<label><span>Passing Year</span><input class="fields" type="number" min="2000" max="3000" name="passingYear"  readonly value=${passingyear} ></label><br/>
<label><span>12th Percentage</span><input class="fields" type="number" min="0" max="100"  step=".01" name="per12" readonly value=${per12} ></label><br/>
<label><span>10th Percentage</span><input class="fields" type="number" min="0" max="100"  step=".01" name="per10" readonly value=${per10} ></label><br/>
<label><span>Contact</span><input class="fields" type="tel" pattern="[0-9]{10}" name="contact" readonly value=${contact} ></label><br/>
<label><span>Address</span><input class="fields" type="text" name="address" readonly value=${address} ></label><br/>
<label><span>Password</span><input class="fields" type="text" name="password" value=${password} readonly></span></label><br/>
<label><span>Skills</span><input class="fields" type="text" name="skills"placeholder="Separate with commas" readonly value=${skills} ></span></label><br/>

<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Update Your Information
						</button>
					</div>
<br/><br/><br/>
</form>
</div>
<br/><br/>
</body>
</html>