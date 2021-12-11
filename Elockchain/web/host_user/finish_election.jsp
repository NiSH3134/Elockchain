<%-- 
    Document   : finish_election
    Created on : 11 Dec, 2021, 12:57:55 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="db.database"%>
<%@page import="beans.election2"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable"%>
<%@page import="com.itextpdf.text.pdf.PdfPCell"%>
<%@page import="com.itextpdf.text.Phrase"%>

<%@page import="db.election_create"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.election"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/try.css">
    <link rel="stylesheet" href="../css/top.css">
    <link rel="stylesheet" href="../css/login.css">
    </head>
    <body>
        
        
        <div class="wrapper">
        <div class="navbar">
            <div class="navcontainer">
                <img src="../images/l.png" alt="" width="300px">
                <%database d=new database(); HttpSession id=request.getSession(false);%>
                    <ul> 
                        <li class="">Hello,  <%=d.getHostName((String)id.getAttribute("hid"))%></li>
                    <li class="active">Home</li>
                    <li class="active">About</li>
                    <li class="active">Logout</li>
                </ul>
            </div>
        </div>

        <div class="socialicons">
            <a href="" class="icon">Basic</a>
            <a href="" class="icon">Candidate</a>
            <a href="" class="icon">Voter</a>
            <a href="#" class="icon">Preview</a>
            <a href="#" class="icon">Finish</a>
        </div>
        <center>
            <br><br>
            <table class="box4">
                <tr>
                    <td>
                        <h1>Logo</h1>
                    </td>
                    <td>
                        <h1>Election ID</h1>
                    </td>
                    <td>
                        <h1>Election Name</h1>
                    </td>
                </tr>
            </table>
            <br><br>
            <table width="80%">
                <tr>
                    <td>
                        <marquee behavior="alternate">
                            <h1 style="color: blue;">Your Election is created Successfully...!!!</h1>
                        </marquee>
                    </td>
                </tr>
            </table>
            <br><br>
            <table class="box4">
                <tr>
                    <td>
                        <h2>
                            Click Download Button to get your election Details.
                        </h2>
                    </td>
                    <td><form action="../createES5" method="POST">
                        <button class="btn3" type="submit">Download</button></form>
                    </td>
                </tr>
            </table>
        </center>
    </div>
        
    </body>
</html>
