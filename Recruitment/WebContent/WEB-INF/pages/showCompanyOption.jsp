<html>
<head><title>Recruitment Portal</title>
<link rel="stylesheet" href="showStOptionCSS.css" type="text/css"/>
</head>
<body >
    <div class="limiter">
        <div id="top">
            <div id="clgLogo">
                <img src="images\logo.png"/ align="left">
                <img src="images\logo.png"/ align="right">
                
                <div id="name">
                <h1></br><center>Recruitment Portal</center></h1>
                </div>
            </div>
            <div id="topImage">
                <img src="images\clg.png"/ width="100%" height="50%">
            </div>
        <center>
            <div id="optiontop">
                <div id="option">
                    <ul>
                        <li><a href="/">About</a></li>
                        <li><a href="postderive?cemail=${email}">Post Drives</a></li>
                        <li><a href="viewApplications?cemail=${email}">View Applications</a></li>
                        <li><a href="cmpProfile?email=${email}">Profile</a></li>
						<li><a href="companylogout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </center>
        </div>
        <br/>
        <br/>
        <br/>
        <div id="imageLoop">
        <br/>
        <br/>
            <img src="images/portalcompanies.png" / width="100%" height="60%"><br/></img>
            <br/>
        </div>
        <div id="image">
        <br/>
        <br/>
        <script>
            var image = new Array();
            for(int i=1;i<4;i++){
                image[i] = new Image();
                image[i].src = "images/img" + i + ".jpg"; // file path
            }
        </script>
        </div>
        <div id="blankLine">
        <br/>
        <br/>
        <br/>
        <br/>
        
        </div>
    </div>
</body>
</html>