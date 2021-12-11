<%-- 
    Document   : finish_election
    Created on : 11 Dec, 2021, 12:57:55 PM
    Author     : A 04 Nishant Badlani
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Election Successfully Created</h4>
        <form action="../createES5" method="POST">
            <input type="submit" value="DOWNLOAD PDF">
        </form>
    </body>
</html>
