<%-- 
    Document   : reallogin
    Created on : Jan 30, 2016, 12:31:09 PM
    Author     : Tom_ngai_ja_krai_la
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title> Attendance Checker </title>
	<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="stylelogin.css">
	<link href='https://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
</head>
            <%
            Cookie[] cks = request.getCookies(); // Cookies stores as array.(pack)
            String value = "", state="";
            if (cks != null){
                for(Cookie ck : cks){
                    if (ck.getName().equals("usCookie")){
                        value = ck.getValue();
                        state = "checked";
                    }
                }
            }
            %>
<body>
	<div class="circle">
		<br><br>
		<div class="content"> 
			<h1 class="title"> Attendance Checker System </h1>
                        <span id="aleart"> Please Login! </span><br>
			<form action="Authentication" method="POST">
				<ul>
					<li>
						<label for="name" id="laname"> <strong> Username </strong> </label> <!--Color=#98FB98-->
                                                <input id="name" name="username" type="text" value="<%=value%>">
					</li>
					<li>
						<label for="pass" id="lapass"> <strong> Password </strong> </label> <!--Color=#F4A460-->
						<input id="pass" name="password" type="password">
					</li>
					<li>
						<label for="chkbox" id="memme"> Remember me? </label> 
                                                <input <%=state%> id="chkbox" type="checkbox" name="remember">
					</li>
					<li>
						<input id="loginbut" type="submit" value="Login">
					</li>
				</ul>
			</form>
			<br><br><br>
			<h3> Beta Version 1.0 </h3>
		</div>
	</div>
	<footer>
		<a href="http://www.it.kmitl.ac.th/"><img src="image/logo.png" alt="it_logo" id="it_logo"></a>
		<a href="https://www.facebook.com/groups/151559601884658/"> <img src="image/facebook_2.png" alt="facebook_logo" id="face_logo"></a>
		<span> <a href="http://elearning.it.kmitl.ac.th/course/view.php?id=361" id="elearn_logo">E-Learning</a> </span>
		<h4> Create by Group 5 Section 1 </h4>
		<br><br>
		<ol> 
			<li>
				Chayut Ruksomya	57070026
			</li>
			<li>
				Thanapa Thamrongthanyawong  5700049
			</li>
			<li>
				Tharathip   Malaimarn 57070054
			</li>
			<li>
				Pawarisa Thongngoen 	57070068
			</li>
			<li>
				Pongsathorn Sangyim 57070074
			</li>
		</ol>
	</footer>
</body>
</html>

