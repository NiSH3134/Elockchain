<%-- 
    Document   : newjsp
    Created on : 1 Oct, 2021, 5:10:03 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/css1.css">
    
    
    <title>Host</title>
</head>

<body>
    
   
    <form action="HostServlet" method="POST">
        <div id="d1" style="display: block;">
            <div class="container">
                <div id="block1">
                    <img src="images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                </div>
                <div class="box"; id="block2">
                    <h1>Host Sign up</h1>
                    <div class="user">
                        
        
                        <i class="fas fa-user"></i>
                        <input 
                        type="text"
                        name="fname"
                        id="fname"
                        autocomplete="off"
                        placeholder="first name"
                        />
                        
                        <i class="fas fa-user"></i>
                        <input 
                        type="text"
                        name="lname"
                        id="lname"
                        autocomplete="off"
                        placeholder="last name"
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
                        <button type="button" id="d1" class="btn" onclick="switchd('d1','1','d')">Next</button><br>  
                        <button type="button" class="btn" onclick="switchd('d1','2','d')">login</button>            
                    </div>
                </div>
            </div>
        </div>
        

         <div id="d2" style="display: none;">
            <div class="container">
                <div id="block1">
                    <img src="images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                </div>
                <div class="box" id="block2">
                    <h1>Host Sign up</h1>
                    <div class="user">
                        
        
                        <i class="fas fa-user"></i>
                        <input 
                        type="number"
                        name="otp"
                        id="otp"
                        autocomplete="off"
                        placeholder="OTP"
                        />
                        <!--
                        <i class="fas fa-user"></i>
                        <input 
                        type="text"
                        name="username"
                        id="username"
                        autocomplete="off"
                        placeholder="create username"
                        />-->
        
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
        
                    </div>
                    
                    <div class="login-btn">
                        <button class="btn" type="submit">Submit</button>
                        <p class="pre" onclick="switchd('d2','3','d')">Previous-Page</p>
                        
                    </div>
                </div>
            </div>
        </div>
        </form>
    
<form action="HostLogin" method="POST">
    <div id="d3" style="display: none;"> 
            <div class="container">
                <div id="block1">
                    <img src="images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                    <div id="confirmation" style="display: block;"></div>
                </div>
                <div class="box" id="block2">
                    <h1>Host Log In</h1>
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
                        name="lpassword"
                        id="lpassword"
                        autocomplete="off"
                        placeholder="password"
                        />
        
                    </div>
                    
                    <div class="login-btn">
                        <button class="btn" type="submit">Submit</button>
                        <p class="reset-password">Forgot Password</p>
                        <button class="btn" type="button" onclick="switchd('d3','4','d')">Create New Account</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
<script>document.addEventListener('keypress', function (e) {
            if (e.keyCode === 13 || e.which === 13) {
                e.preventDefault();
                return false;
            }
            
        });</script>
<script src="js/host.js"></script>

 <%
        String chk=null;
        
        chk=request.getParameter("s");
        try
        {
            if(chk.equals("sl")) 
        {
            %>
            <script>
            document.getElementById("confirmation").innerHTML = "Your ID is created successfully, kindly check your mail for UserID";
            switchd('d1','2','d')
           </script>
            <%
            }
            else if(chk.equals("wp"))
            {
               %>
            <script>
            document.getElementById("confirmation").innerHTML = "Wrong Password";
            switchd('d1','2','d')
           </script>
            <%
            }
            else if(chk.equals("ude"))
            {
               %>
            <script>
            document.getElementById("confirmation").innerHTML = "This UserID doesnt exist, kindly check your ID <br> To create account click <a href='index.jsp'>here</a>";
            switchd('d1','2','d')
           </script>
            <%
            }
            else {}
        }
        
        
        catch(Exception e) {}
    %>
</html>