<%-- 
    Document   : vote_login1
    Created on : 11 Dec, 2021, 6:02:40 PM
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
    <link rel="stylesheet" href="../css/top.css">
    
    
</head>
<body>
    <div id="basic">
            <div class="wrapper">
        <div class="navbar">
            <div class="navcontainer">
                <img src="../images/l.png" alt="" width="300px">
            </div>
            <Center><h3>VOTER LOGIN PAGE</h3></center>
        </div> </div>
        
    <div class="container">
        <div class="box">
            
            <form action="../VoterServlet" method="POST">
            <div class="user">
                <%
                    if(request.getParameterMap().containsKey("st"))
                    {
                        if(request.getParameter("st").equals("1"))
                        {
                            %>
                            <div id="msg">This Election has been Terminated</div><Br<br><Br>
                            <%
                        }
                        if(request.getParameter("st").equals("2"))
                        {
                            %>
                            <div id="msg">Incorrect Election ID</div><Br<br><Br>
                            <%
                        }
                        if(request.getParameter("st").equals("3"))
                        {
                            %>
                            <div id="msg">This Voter is not registered for the entered Election</div><Br<br><Br>
                            <%
                        }
                        if(request.getParameter("st").equals("7"))
                        {
                            %>
                            <div id="msg">You have already Voted.</div><Br<br><Br>
                            <%
                        }
                    }
                %>
                
                <h4>ID of Election</h4><br>
                <i class="fas fa-user"></i>
                <input 
                type="text"
                name="eid"
                id="eid"
                autocomplete="off"
                placeholder="Election ID"
                required
                maxlength="6"
                minlength="6"
                /><br><br>
                
                <h4>ID of Voter</h4><br>
                <i class="fas fa-user"></i>
                <input 
                type="text"
                name="vid"
                id="vid"
                autocomplete="off"
                placeholder="Voter ID"
                maxlength="6"
                minlength="6"
                required
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
            </form>
        </div>
    </div>
</body>
<script>
    document.getElementById("election_name").innerHTML="Election Name";
</script>
</html>
