<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<style>
.reg-form {
    width: 400px;
    padding: 15px 30px 30px;
    background-color: #eee;
    margin: auto;
}
.reg-form .title {
    font-size: 22px;
    font-weight: bold;
    line-height: 24px;
    color: #000;
    font-weight: lighter;
    color: #333;
    text-align: center;
    margin: 0 0 13px;
}
.reg-form .subtitle {
    font-size: 16px;
    font-weight: bold;
    line-height: 18px;
    color: #000;
    font-weight: lighter;
    color: #333;
    text-align: center;
    margin: 0 0 18px;
}

.reg-form label {
    font-size: 12px;
    line-height: 14px;
    color: #66696a;
    margin-bottom: 2px;
}

.reg-form label, .reg-form input {
    display: block;
}

.reg-form input {
    background: #fdfdfd;
    vertical-align: middle;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    -ms-border-radius: 2px;
    -o-border-radius: 2px;
    border-radius: 2px;
    padding: 5px 6px 4px;
    -webkit-box-shadow: 0 0 3px rgba(0,0,0,0.1) inset;
    -moz-box-shadow: 0 0 3px rgba(0,0,0,0.1) inset;
    box-shadow: 0 0 3px rgba(0,0,0,0.1) inset;
    border: 1px solid #c1c1c1;
    font-size: 13px;
    color: #333;
    font-size: 16px;
    font-weight: normal;
    line-height: 18px;
    color: #434649;
    padding: 0 0 0 6px;
    border: 1px solid #BFBFBF;
    height: 32px;
    width: 100%;
    margin-bottom: 15px;
}

.header {
    height: 70px;
    background-color: #333;
}

.login-form {
    display: inline-flex;
    position: relative;
    align-items: flex-start;
    justify-content: flex-end;
    text-align: right;
}

.login-form label {
    position: absolute !important;
    height: 1px;
    width: 1px;
    overflow: hidden;
    clip: rect(1px, 1px, 1px, 1px);
}

.login-form input {
    display: inline-block;
    margin: 10px 12px 0 0;
    background: #fdfdfd;
    vertical-align: middle;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    -ms-border-radius: 2px;
    -o-border-radius: 2px;
    border-radius: 2px;
    padding: 5px 6px 4px;
    -webkit-box-shadow: 0 0 3px rgba(0,0,0,0.1) inset;
    -moz-box-shadow: 0 0 3px rgba(0,0,0,0.1) inset;
    box-shadow: 0 0 3px rgba(0,0,0,0.1) inset;
    border: 1px solid #c1c1c1;
    font-size: 13px;
    color: #333;
    width: 200px;
}

.login-form button {
    display: inline-block;
    margin: 10px 12px 0 0;
    background: lightblue;
    vertical-align: middle;
    border-radius: 2px;
    padding: 5px 6px 4px;
    box-shadow: 0 0 3px rgba(0,0,0,0.1) inset;
    border: 1px solid #c1c1c1;
    font-size: 13px;
    color: #333;
    width: 200px;
}
.header .wrapper {
    display: flex;
    justify-content: space-between;
    width: 800px;
    height: 100%;
    margin: 0 auto;
}
.logo{
	margin-left: 5px;
}

.paddy{
	margin-top: 50px;
}
</style>


<title>
GeoFriend: Log In or Sign Up
</title>

</head>

<body>


<div class="header">
<div class="wrapper">
<!--img class="logo" alt="GeoFriend" src=""-->

<form:form method="post" action='${pageContext.request.contextPath}/loginForm.htm' cssClass="login-form" modelAttribute="customerLogin">  
<%-- <form class="login-form " action="login" method="POST" > --%>
<form:input path="email" cssClass="login-email" id="login-email" placeholder="Email or phone number" autofocus="autofocus"/>
<form:input path="password" type="password" cssClass="login-password" id="login-password" aria-required="true" tabindex="1" placeholder="Password"/>
<button type="submit" value="Sign in">Sign in</button>
<a class="link-forgot-password" tabindex="1" href="">Forgot password?</a>

<%-- </form> --%>
</form:form>
</div>
</div>

<div class="paddy"></div>
<div class="mainBody">

<form:form id="regForm" class="reg-form" action='${pageContext.request.contextPath}/registration.htm' modelAttribute="customerRegistration" method="POST" data-jsenabled="check" data-autologin="" data-smartlock-save-on-signup="false">
<h2 class="title">Sign-up and have fun</h2>
<h3 class="subtitle">Get started - it's free.</h3>
<label for="reg-firstName">First name</label><form:input path="firstName" type="text" name="firstName" id="reg-firstname" class="reg-firstname" tabindex="1" autofocus="autofocus"/>
<label for="reg-lastName">Last name</label><form:input path="lastName" type="text" tabindex="1" name="lastName" id="reg-lastname" class="reg-lastname" aria-required="true"/><label for="reg-email">Email or phone number</label><input type="text" name="session_key" class="reg-email" autocapitalize="off" tabindex="1" id="reg-email" autofocus="autofocus">
<label for="reg-password">Password (6 or more characters)</label><form:input path="password" type="password" name="session_password" class="reg-password" id="reg-password" aria-required="true" tabindex="1" autocomplete="new-password"/><input tabindex="1" id="registration-submit" class="registration submit-button" type="submit" value="Join now"></form:form>

</div>

</body>


</html>