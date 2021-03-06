<%-- 
    Document   : create_election
    Created on : 6 Dec, 2021, 12:05:32 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="db.database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.election_create"%>
<%@page import="beans.election"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basic</title>
    <link rel="stylesheet" href="../css/try.css">
    <link rel="stylesheet" href="../css/top.css">
    <link rel="stylesheet" href="../css/login.css">
    
    <link rel="stylesheet" href="../css/candidate.css">
    <link rel="stylesheet" href="../css/description.css">
    <style>@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');</style>
    </head>
    <body>
        <div id="basic">
            <div class="wrapper">
        <div class="navbar">
            <div class="navcontainer">
                <img src="../images/l.png" alt="" width="300px">
               <%database d=new database(); HttpSession id=request.getSession(false);%>
                    <ul> 
                        <li class="">Hello,  <%=d.getHostName((String)id.getAttribute("hid"))%></li>
                    <li class="active">Home</li>
                    <li class="active">About</li>
                    <li class="active"><a href="../index.jsp?s=loginpage">Logout</a></li>
                </ul>
            </div>
        </div>
        
        
                
        <%
            if(request.getParameterMap().containsKey("st"))
            {
                String chk=request.getParameter("st");
                if(chk.equals("basic"))
                {
                    %>
                    <div class="socialicons">
            <p class="icon">Basic</p>
            <button class="icon">Candidate</button>
            <button class="icon">Voter</button>
            <button class="icon">Preview</button>
            <button class="icon">Finish</button>
        </div>
                    <div class="box" id="block2">
            <form action="../createES1" method="post" enctype="multipart/form-data">
            <h1>Start Creating Election</h1>
            <div class="user">
                
                <h5>Name Of Election</h5>
                <i class="fas fa-user"></i>
                <input 
                type="text"
                name="name"
                id="name"
                autocomplete="off"
                placeholder="Name Of Election"
                />

                <h5>Choose Logo for Election</h5>
                <i class="fas fa-user"></i>
                <input 
                type="file"
                name="elogo"
                id="elogo"
                autocomplete="off"
                accept="image/png, image/jpeg"
                value="Upload"
                />
                <!--
                <i class="fas fa-user"></i>
                <h5>Date Of Election</h5>
                <input 
                type="datetime-local"
                name="election_date"
                id="election_date"
                autocomplete="off"
                placeholder="Name Of Election"
                />-->
                
                    
            </div>
            
            <div class="login-btn">
                <button id="d1" type="submit" class="btn">Next</button>
            </div>
            </form>
        </div>
                    <%
                }
                else if(chk.equals("candidate"))
                {
                    %>
                    <div class="socialicons">
            <a href="create_election.jsp?st=basic" style="text-decoration: none;"><p class="icon">Basic</p></a>
            <p class="icon">Candidate</p>
            <button class="icon">Voter</button>
            <button class="icon">Preview</button>
            <button class="icon">Finish</button>
        </div>
                    <div class="box" id="block2">
                        <form action="../createES2" method="post" enctype="multipart/form-data">
            <h1>Adding Candidate for Election</h1>
            <div class="user">
                
                <h5>Name Of Candidate</h5>
                <i class="fas fa-user"></i>
                <input 
                type="text"
                name="nameC"
                id="nameC"
                autocomplete="off"
                placeholder="Candidate's Name"
                />

                
                
                <h5>Description About Candidate</h5>
                <i class="fas fa-user"></i>
                <textarea id="desC" name="desC" rows="6" cols="41" placeholder="Candidate's Description"></textarea>
<!--                <div class="container_d">
                    <a href="#open-modal" class="button">Candidate Shorts Description</a>
                </div>
                <div id="open-modal" class="modal-window">
                    <div>
                        <a href="#" title="Close" class="modal-close">x</a>
                        <h1>Hey Everyone</h1>
                        <div>Hii Trying this</div>
                    </div>
                </div>-->


                <Br><Br>
                <h5>Candidate Photo or Logo</h5>
                <i class="fas fa-user"></i>
                <input 
                type="file"
                name="photoC"
                id="photoC"
                autocomplete="off"
                accept="image/png, image/jpeg"
                value="Upload"
                />
                
                
            </div>
            <div class="login-btn">
                <button id="add" type="submit" class="btn">Add Candidate</button>    
            </div></form>
            <br>
            
            
                        
        </div>
                    <table class="box2" id="block6">
                <tr>
                <td width="33%">
                    <h3 style="color: blue;">Candidate Name</h3>
                </td>
                <td width="33%">
                    <h3 style="color: blue;">Candidate Description</h3>
                </td>
                <td width="33%">
                    <h3 style="color: blue;">Remove Candidate</h3>
                </td>
            </tr>
                <%
                    election_create obj=new election_create();
                    
                    ArrayList<election> a=obj.getCandidate((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
                    election b=null;
                    for(int i=0;i<a.size();i++)
                    {
                        b=(election)a.get(i);
                        
                        %>
                        <tr>
                            <td width="33%"><h4><%out.println(b.getNameC());%></h4></td>
                            <td width="33%"><h4><%out.println(b.getDesC());%></h4></td>
                            <td width="33%"><a href="remove_candidate.jsp?cid=<%=b.getCid()%>" style="text-decoration: none;"><button class="btn">Remove</button></a></td>
                        </tr>
                        <%
                    }
                    b=null;
                %>
                 <tr>
                <Td></Td>
                <td><div class="login-btn">
                <a href="create_election.jsp?st=voter" style="text-decoration: none;"><button id="d1" type="button" class="btn">Next</button></a>
            </div></td>
                <td></td>
            </tr>
            </table>
                    
                    <%
                }
                else if(chk.equals("voter"))
                {
                    %>
                    <div class="socialicons">
            <a href="create_election.jsp?st=basic" style="text-decoration: none;"><p class="icon">Basic</p></a>
            <a href="create_election.jsp?st=candidate" style="text-decoration: none;"><p class="icon">Candidate</p></a>
            <p class="icon">Voter</p>
            <button class="icon">Preview</p></button>
            <button class="icon">Finish</p></button>
        </div>
                    <div class="box" id="block2">
                        <form action="../createES3" method="post" enctype="multipart/form-data">
            <h1>Adding Voter for Election</h1>
            <div class="user">
                
                <h5>Voter's Name</h5>
                <i class="fas fa-user"></i>
                <input 
                type="text"
                name="nameV"
                id="nameV"
                autocomplete="off"
                placeholder="Voter's Name"
                />

                <h5>Voter's Email ID</h5>
                <i class="fas fa-user"></i>
                <input 
                type="email"
                name="emailV"
                id="emailV"
                autocomplete="off"
                placeholder="Voter's Email"
                />

                <h5>Voter's Phone Number</h5>
                <i class="fas fa-user"></i>
                <input 
                type="text"
                name="phoneV"
                id="phoneV"
                maxlength="10"
                minlength="10"
                autocomplete="off"
                placeholder="Voter's Phone Number"
                />
                
                <h5>Voter's Login Verification Method</h5>
                <i class="fas fa-user"></i>
                <select name="vtype" onchange="yesnoCheck(this);">
                    <option value="OTP" selected>On Email OTP</option>
                    <option value="Pass" >Password</option>
                    <option value="Face" >Face Verification</option>
                </select> <br><br>
                
                <div id="ifFace" style="display: none;">
                <h5>Voter's Photo</h5>
                <i class="fas fa-user"></i>
                <input 
                type="file"
                name="photo_voter"
                id="photo_voter"
                autocomplete="off"
                accept="image/png, image/jpeg"
                value="Upload"
                /></div>
  
            </div>
            <div class="login-btn">
                <button id="add" type="submit" class="btn">Add Voter</button>    
            </div> </form>
            <br>
           
                        
        </div>
               <table class="box2" id="block6" border="0">
            <tr>
                <td width="11%">
                    <h3 style="color: blue;">Voter ID</h3>
                </td>
                <td width="25%">
                    <h3 style="color: blue;">Voter Name</h3>
                </td>
                <td width="32%">
                    <h3 style="color: blue;">Voter Email</h3>
                </td>
                <td width="26%">
                    <h3 style="color: blue;">Remove Voter</h3>
                </td>
            </tr>
            <tr>
                <%
                    election_create obj=new election_create();
                    
                    ArrayList<election> a=obj.getVoter((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
                    election b=null;
                    for(int i=0;i<a.size();i++)
                    {
                        b=(election)a.get(i);
                        
                        %>
                        <tr>
                            <td width="11%"><h4><%out.println(b.getVid());%></h4></td>
                            <td width="25%"><h4><%out.println(b.getNameV());%></h4></td>
                            <td width="32%"><h4><%out.println(b.getEmailV());%></h4></td>
                            <td width="26%"><a href="remove_voter.jsp?vid=<%=b.getVid()%>" style="text-decoration: none;"><button class="btn" style="width:90%;">Remove</button></a></td>
                        </tr>
                        <%
                    }
                    b=null;
                %>
            </tr>
            <tr>
                <Td></Td>
                <td><div class="login-btn">
                <a href="preview.jsp?st=1" style="text-decoration: none;"><button id="d1" type="button" class="btn">Next</button></a>
            </div></td>
                <td></td>
            </tr>
        </table>     
                    <%
                }    
else{} }
                    %>
            
       
    </div>
        </div>
    </body>
    
    <script>
        function yesnoCheck(that) {
        if (that.value == "Face") {
            document.getElementById("ifFace").style.display = "block";
            document.getElementById("photo_voter").required = true;
        } else {
            document.getElementById("ifFace").style.display = "none";
            document.getElementById("photo_voter").required = false;
        }
}
    </script>
</html>
