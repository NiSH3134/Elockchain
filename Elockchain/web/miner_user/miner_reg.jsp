<%-- 
    Document   : newjsp
    Created on : 12 Oct, 2021, 7:13:56 PM
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
    <link rel="stylesheet" href="../css/css1.css">
    
    <title>Miner</title>
</head>
<body>
        
        
        <div id="d1" style="display: block;">
            <div class="container">
                <div id="block1">
                    <img src="../images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                </div>
                <div class="box"; id="block2">
                    <h1>Miner Sign up</h1>
                    <div class="user">
                        
        
                        <i class="fas fa-user"></i>
                        <input 
                        type="text"
                        name="name"
                        id="name"
                        autocomplete="off"
                        placeholder="full name"
                        />
        
                        <i class="fas fa-user"></i>
                        <input 
                        type="number"
                        name="mobile"
                        id="mobile"
                        autocomplete="off"
                        placeholder="mobile number"
                        />
        
                        <i class="fas fa-user"></i>
                        <input 
                        type="email"
                        name="email"
                        id="email"
                        autocomplete="off"
                        placeholder="email id"
                        />
        
                    </div>
                    
                    <div class="login-btn">
                        <button id="d1" class="btn" onclick="switchd('d1','1','d')">Next</button><br>  
                        <button class="btn" onclick="switchd('d1','2','d')">Miner login</button>            
                    </div>
                </div>
            </div>
        </div>


         <div id="d2" style="display: none;">
            <div class="container">
                <div id="block1">
                    <img src="../images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                </div>
                <div class="box" id="block2">
                    <h1>Miner Sign up</h1>
                    <div class="user" onclick="disable">
                        
        
                        <i class="fas fa-user"></i>
                        <input 
                        type="number"
                        name="otp"
                        id="otp"
                        autocomplete="off"
                        placeholder="OTP"
                        />

                        <i class="fas fa-unlock-alt"></i>
                        <input 
                        type="password"
                        name="password"
                        id="password"
                        autocomplete="off"
                        placeholder="password"

                        />
        
                        <i class="fas fa-unlock-alt"></i>
                        <input 
                        type="password2"
                        name="password2"
                        id="password2"
                        autocomplete="off"
                        placeholder="confirm password"
                        />
        
        
                        <i class="fas fa-unlock-alt"></i>
                        <input 
                        type="number"
                        name="account"
                        id="account"
                        autocomplete="off"
                        placeholder="Account Number"

                        />
        
                        <i class="fas fa-unlock-alt"></i>
                        <input 
                        type="ifsc"
                        name="ifsc"
                        id="ifsc"
                        autocomplete="off"
                        placeholder="IFSC Code"
                        />
        
                    </div>
                    
                    <div class="login-btn">
                        <button class="btn">Next</button>
                        <p class="pre" onclick="switchd('d2','3','d')">Previous-Page</p>
                        
                    </div>
                </div>
            </div>
        </div>


        <div id="d3" style="display: none;">
            <div class="container">
                <div id="block1">
                    <img src="../images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                </div>
                <div class="box" id="block2">
                    <h1>Miner Log In</h1>
                    <div class="user">
                        <i class="fas fa-user"></i>
                        <input 
                        type="text"
                        name="username"
                        id="username"
                        autocomplete="off"
                        placeholder="username"
                        />
        
                        <i class="fas fa-unlock-alt"></i>
                        <input 
                        type="password"
                        name="password"
                        id="password"
                        autocomplete="off"
                        placeholder="password"
                        />
        
                    </div>
                    
                    <div class="login-btn">
                        <button class="btn" type="submit">Submit</button>
                        <p class="reset-password">Forgot Password</p>
                        <button class="btn" type="submit" onclick="switchd('d3','4','d')">New Miner</button>
                    </div>
                </div>
            </div>
        </div>
</body>
<script src="../js/miner.js"></script>
</html>