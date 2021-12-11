<%-- 
    Document   : vote_login
    Created on : 24 Oct, 2021, 8:47:10 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voter</title>
    <link rel="stylesheet" href="../css/css1.css">
    <style>
        img
        {
            border-radius: 50%;
            width: 200px;

        }
    </style>
</head>
<body>
    <div class="container">
        <div class="box";>
            <center><img src="../images/mahi.jpg" id="img"></center>
            <h1 id="election_name"></h1>
            <div class="user">
                

                <i class="fas fa-user"></i>
                <input 
                type="text"
                name="uid"
                id="uid"
                autocomplete="off"
                placeholder="UID"
                />

                <div class="login-btn">
                    <button id="d1" class="btn">Next</button><br>              
                </div>
            </div>
            <div hidden>
                <div id="otp">
                    <input 
                    type="text"
                    name="otp"
                    id="otp"
                    autocomplete="off"
                    placeholder="OTP"
                    />
                </div>
                <div id="password">
                    <input 
                    type="text"
                    name="password"
                    id="password"
                    autocomplete="off"
                    placeholder="Password"
                    />
                </div>
            </div>
            
        </div>
    </div>
</body>
<script>
    document.getElementById("election_name").innerHTML="Election Name";
</script>
</html>
