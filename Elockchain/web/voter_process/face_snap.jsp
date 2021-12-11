<%-- 
    Document   : face_snap
    Created on : 11 Dec, 2021, 8:39:00 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/login.css">
    <link rel="stylesheet" href="../css/top.css">
    <style>
        #my_camera{
           
            height: 200px;
            
            border-radius: 70%;
       }
    </style>
    </head>
    <body>
        
        <div class="wrapper">
            <div class="navbar">
                <div class="navcontainer">
                    <img src="../images/l.png" alt="" width="300px">
                    
                </div>
            </div>
            <center>
                
                <div class="box">
                    <%
                        if(request.getParameterMap().containsKey("st"))
                        {
                            if(request.getParameter("st").equals("2"))
                            {
                                %>
                                <div>Face did not match, Try Again or contact Election Host</div>
                                <%
                            }
                            if(request.getParameter("st").equals("1"))
                            {
                                %>
                                <div>Face was not detected, try again</div>
                                <%
                            }
                        }
                    %>
                    <form name="foo" action="../checkImg"  method="post">
                    <div id="my_camera"><h2>Press Configure Button Now</h2></div><br>
                    <div id="results" ></div>
                    <button class="btn" type="button" onclick="configure()">Configure</button><br>
                    <button class="btn" type="button" onclick="take_snapshot()">Take Photo</button><br>
                    <input type="text" value="abcd" id="txt" name="dataURI" hidden>
                    <button class="btn" type="submit">Next</button> 
                    </form>
                </div>
            </center>
        </div>
    
    </body>
    <script type="text/javascript" src="webcam.min.js"></script>
 <script language="JavaScript">
 
 // Configure a few settings and attach camera
 function configure(){
    Webcam.set({
       width: 320,
       height: 240,
       image_format: 'jpeg',
       jpeg_quality: 90
    });
    Webcam.attach( '#my_camera' );
 }
 

var data="a";
 function take_snapshot() {
    // play sound effect
   

    // take snapshot and get image data
    Webcam.snap( function(data_uri) {
       // display results in page
       data=data_uri;
       document.getElementById('results').innerHTML = 
           '<img id="imageprev" src="'+data_uri+'"/>';
     } );
     var a=document.getElementById("txt");
     a.value=data;
     console.log(data);
     console.log(a.value);
     Webcam.reset();
    
 }



</script>
</html>
