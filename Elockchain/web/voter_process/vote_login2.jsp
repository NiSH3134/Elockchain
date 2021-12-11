<%-- 
    Document   : vote_login
    Created on : 24 Oct, 2021, 8:47:10 PM
    Author     : A 04 Nishant Badlani
--%>


<%@page import="OtherClasses.Pw"%>
<%@page import="OtherClasses.MailDetails"%>
<%@page import="OtherClasses.Email"%>
<%@page import="OtherClasses.RandomGen"%>
<%@page import="beans.election2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.election_create"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="org.apache.commons.io.output.ByteArrayOutputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.File"%>
<%@page import="javax.persistence.Convert"%>
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
            border-radius: 10%;
            width: 300px;

        }
    </style>
    
    <script>
        <%
        HttpSession otp_session=request.getSession(false);
        HttpSession vids=request.getSession(false);
         ArrayList<election2> arr2=(ArrayList<election2>)vids.getAttribute("VDet");
         String pass=null;
         for(int i=0;i<arr2.size();i++)
         {
            election2 ee=arr2.get(0);                     
            pass=ee.getPassword_voter();
        }
    %>
              

        var check = function() {
       const button = document.querySelector('button');
  if (document.getElementById('otp_v').value === '<%=otp_session.getAttribute("otp")%>') 
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
  
  
  var check2 = function() {
       const button = document.querySelector('button');
       
  if (document.getElementById('password').value === '<%=pass%>') 
  {
    document.getElementById('message2').style.color = 'green';
    document.getElementById('message2').innerHTML = "matching";
    button.disabled = false;
  } 
  else {
    document.getElementById('message2').style.color = 'red';
    document.getElementById('message2').innerHTML = "not matching";
    button.disabled = true;
  }
    </script>
</head>
<body>
    <div class="wrapper">
        <div class="navbar">
            <div class="navcontainer">
                <img src="../images/l.png" alt="" width="300px">
                <%
                     
                     
                    String vname=null;
                    String vid2=null;   
                    for(int i=0;i<arr2.size();i++)
                    {
                        election2 ee=arr2.get(0);                     
                        vname=ee.getName();
                        vid2=ee.getId();
                    }
                %>
                <ul>
                    <li class="">Hii <%=vname%></li>
                    <li class="active">VID: <%=vid2%></li>
                    <li class="active">About</li>
                    <li class="active">Logout</li>
                </ul>
            </div>
        </div>
    <div class="container">
        <div class="box";>
            <!--<center><img src="E:\Elockchain FILES\Elockchain_GIT\Elockchain\web\images\l.png" id="img"></center>-->
            <!--../images/l.png";-->
            <%
                   
                election_create obj=new election_create();
                
                
                String input=obj.getElectionLogo2((String)vids.getAttribute("eid"));
                String vid=(String)vids.getAttribute("vid");
                    File file =  new File(input);
                    FileInputStream fileInputStreamReader = new FileInputStream(file);
                    byte[] bytes = new byte[(int)file.length()];
                    fileInputStreamReader.read(bytes);
                    String abc=new String(Base64.getEncoder().encode(bytes), "UTF-8");
                    ArrayList<election2> arr=(ArrayList<election2>)vids.getAttribute("VDet");
                    
                    String path="data:image/png;base64,"+abc;
                    
           
            %>
            <center><img src="<%=path%>" id="img"></center>
            <h1 id="election_name"><%=obj.getElectionName2((String)vids.getAttribute("eid"))%></h1>
            <div class="user">
            <%
                election2 ee=arr.get(0);
                if(ee.getVtype().equals("Pass"))
                {
                    %>
                    <div id="password"><form action="voting.jsp">
                    <input 
                    type="text"
                    name="password"
                    id="password"
                    maxlength="6"
                    minlength="6"
                    autocomplete="off"
                    onkeyup='check2();'
                    placeholder="OTP" required
                        />
                        <span id='message2'></span>
                    /><br><button type="Submit">Next</button></form>
                </div>
                    <%
                }
                else if(ee.getVtype().equals("OTP"))
                {
                    
                    String otp=RandomGen.randomGen(6);
                    otp_session=request.getSession(true);
                    otp_session.setAttribute("otp", otp);
                    String r=ee.getEmailV();
                    String s="Your OTP for Elockchain Voter Login";
                    String m="Hello, "+ee.getName()+", your Voter ID : "+ee.getId()+" and your Login OTP is : "+otp;
                    Email.transferEmail(MailDetails.getHost(), MailDetails.getUser(), Pw.getPass(), MailDetails.getPort(), r, s, m);
                    out.println("Mail Sent!!");
                    out.println("FOund");
                      %>
                      <div id="otp"><form action="voting.jsp">
                    <input 
                    type="text"
                    name="otp_v"
                    id="otp_v"
                    maxlength="6"
                    minlength="6"
                    autocomplete="off"
                    onkeyup='check();'
                    placeholder="OTP" required
                        />
                        <span id='message'></span>
                        /><br><button type="Submit">Next</button></form>
                    </div>
                      <%
                }
                else
                {
                    response.sendRedirect("face_snap.jsp");
                }
            %>
    
            </div>
            
        </div>
    </div>
</body>
<script>
    document.getElementById("election_name").innerHTML="Election Name";
</script>
</html>
