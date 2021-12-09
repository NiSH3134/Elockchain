<%-- 
    Document   : forgotPass
    Created on : 27 Nov, 2021, 12:53:16 PM
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
<script>
    <%
        HttpSession otp_session=request.getSession(false);
        
    %>
    var check = function() {
       const button = document.querySelector('button');
  if (document.getElementById('otp_u').value === '<%=otp_session.getAttribute("otp")%>') 
  {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = "matching";
    button.disabled = false;
  } 
  else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = "not matching";
    button.disabled = true;
  }
}
</script>
<body>
    <%
        String chk=null;
        String status=request.getParameter("st");
        chk=request.getParameter("fd");
        HttpSession usertype=request.getSession();    
        usertype.setAttribute("usertype", status);
        try
        {
            if(chk.equals("fp"))
            {
                %>
        <form action="ForgotPassSev" method="POST">
        <div id="d1" style="display: block;">
            <div class="container">
                <div id="block1">
                    <img src="images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                    <div id="errors" style="display: block;">You will receive OTP on your Email ID</div>
                </div>
                <div class="box"; id="block2">
                    <h1>Forgot Password</h1>
                    <div class="user">
                        
                        <i class="fas fa-user"></i>
                        <input 
                        type="text"
                        name="username"
                        id="username"
                        autocomplete="off"
                        placeholder="username"
                        required
                        />
                        
                        <i class="fas fa-user"></i>
                        <input 
                        type="email"
                        name="email"
                        id="email"
                        autocomplete="off"
                        placeholder="email id" required
                        />
        
                    </div>
                    
                    <div class="login-btn">
                        <button type="Submit" id="d1" class="btn">Next</button><br> 
                        <%
                            if(status.equals("host"))
                            { %>
                        <a href="index.jsp?s=loginpage"><button type="button" class="btn">Back</button></a> 
                        <% }
                            else if (status.equals("miner")) {
                           %>
                        <a href="miner_user/miner_reg.jsp?s=loginpage"><button type="button" class="btn">Back</button></a> 
                        <%  
                        }
                        else {}
                        %>
                    </div>
                </div>
            </div>
        </div></form>
                <%
            }

            else if(chk.equals("fid"))
            {
                %>
                <form action="ForgotIdSev" method="POST">
        <div id="d1" style="display: block;">
            <div class="container">
                <div id="block1">
                    <img src="images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                    <div id="errors" style="display: block;">You will receive UserID on your Email ID</div>
                </div>
                <div class="box"; id="block2">
                    <h1>Forgot ID</h1>
                    <div class="user">
                        
                        <i class="fas fa-user"></i>
                        <input 
                        type="email"
                        name="email"
                        id="email"
                        autocomplete="off"
                        placeholder="email id" required
                        />
        
                    </div>
                    
                    <div class="login-btn">
                        <button type="Submit" id="d1" class="btn">Next</button><br> 
                        <%
                            if(status.equals("host"))
                            { %>
                        <a href="index.jsp?s=loginpage"><button type="button" class="btn">Back</button></a> 
                        <% }
                            else if (status.equals("miner")) {
                           %>
                        <a href="miner_user/miner_reg.jsp?s=loginpage"><button type="button" class="btn">Back</button></a> 
                        <%  
                        }

                        
                        else {}
                        %>
                    </div>
                </div>
            </div>
        </div></form>
                <%
            }
            else if(chk.equals("rp"))
            {
                %>
        <form action="ResetPassSev" method="POST">
        <div id="d1" style="display: block;">
            <div class="container">
                <div id="block1">
                    <img src="images/l.png" width="400"><br>
                    <h1>Make Your Own New World</h1>
                    <h3 style="color: black;"><em>GIVE VOTE AND CHOOSE YOUR OWN LEADER<br> WITH ELOCKCHAIN</em></h3>
                    <div id="errors" style="display: block;">Enter OTP received on your Email ID</div>
                </div>
                <div class="box"; id="block2">
                    <h1>Reset Password</h1>
                    <div class="user">
                        
                        <i class="fas fa-user"></i>
                        <input 
                        type="text"
                        name="otp_u"
                        id="otp_u"
                        maxlength="6"
                        minlength="6"
                        autocomplete="off"
                        onkeyup='check();'
                        placeholder="OTP" required
                        />
                        <span id='message'></span>
        
                        <i class="fas fa-unlock-alt"></i>
                        <input 
                        type="password"
                        name="password"
                        id="password"
                        autocomplete="off"
                        placeholder="password" 
                        required
                        />
        
                        <i class="fas fa-unlock-alt"></i>
                        <input 
                        type="password2"
                        name="password2"
                        id="password2"
                        autocomplete="off"
                        placeholder="confirm password"
                        required
                        />
        
                    </div>
                    
                    <div class="login-btn">
                        <button type="Submit" id="d1" class="btn" id="submitbutton">Reset</button><br> 
                        <%
                            if(status.equals("host"))
                            { %>
                        <a href="index.jsp?s=loginpage"><button type="button" class="btn">Cancel Reset</button></a> 
                        <% }
                            else if (status.equals("miner")) {
                           %>
                        <a href="miner_user/miner_reg.jsp?s=loginpage"><button type="button" class="btn">Cancel Reset</button></a> 
                        <%  
                        }
                        else {}
                        %>
                    </div>
                </div>
            </div>
        </div></form>
                <%
            }
        else{}
        }
        catch(Exception e) {}
    %>
   }
</body>
<!--Disable Enter Key for form Submission-->
<script>document.addEventListener('keypress', function (e) {
            if (e.keyCode === 13 || e.which === 13) {
                e.preventDefault();
                return false;
            }
            
        });</script>
<script src="js/host.js"></script>
