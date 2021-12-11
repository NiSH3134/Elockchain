<%-- 
    Document   : voting
    Created on : 11 Dec, 2021, 11:34:04 PM
    Author     : A 04 Nishant Badlani
--%>
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
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/top.css">
    <link rel="stylesheet" href="../css/login2.css">
    
</head>
<body>
    <div class="wrapper">
        <div class="navbar">
            <div class="navcontainer">
                <img src="../images/l.png" alt="" width="300px">
                <%
                     HttpSession vids=request.getSession(false);
                     ArrayList<election2> arr2=(ArrayList<election2>)vids.getAttribute("VDet");
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
        <center>
            <div >
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
                <table class="box">
                    <tr>
                        <center>
                            <td>
                                <img src="<%=path%>"  width="200px">
                            </td>
                            <td>
                                <h1><%=obj.getElectionName2((String)vids.getAttribute("eid"))%></h1>
                            </td>
                        </center>
                    </tr>
                </table>

                <table class="box2">
                    <tr>
                        <td width="20%">
                            <h1>Candidate Logo </h1>
                        </td>
                        <td width="20%">
                            <h1>Candidate Name </h1>
                        </td>
                        <td width="20%">
                            <h1>Candidate ID</h1>
                        </td>
                        <td width="20%">
                            <h1>Description</h1>
                        </td>
                        <td width="20%">
                            <h1>Vote</h1>
                        </td>
                    </tr>
                    <%
                        ArrayList<election2> a2=new ArrayList<election2>();
                        a2=obj.getPermDetailsforCandidates((String)vids.getAttribute("eid"));
                        election2 obj2=null;
                        
                        for(int i=0;i<a2.size();i++)
                        {
                            obj2=a2.get(i);
                            
                            File file2 =  new File(obj2.getPath());
                            FileInputStream fileInputStreamReader2 = new FileInputStream(file2);
                            byte[] bytes2 = new byte[(int)file2.length()];
                            fileInputStreamReader2.read(bytes2);
                            String abc2=new String(Base64.getEncoder().encode(bytes2), "UTF-8");
                            

                            String path2="data:image/png;base64,"+abc2;
                            
                            
                            %>
                            
                            <tr>
                            <td width="20%">
                                <img src="<%=path2%>"  width="100px">
                            </td>
                            <td width="20%">
                                <h1><%=obj2.getName()%></h1>
                            </td>
                            <td width="20%">
                                <h1><%=obj2.getId()%></h1>
                            </td>
                            <td width="20%">
                                <h1><%=obj2.getDescC()%></h1>
                            </td>
                            <td width="20%">
                                <button class="btn">vote</button>
                            </td>
                    </tr>
                            <%
                        }
                    %>
                </table>
            </div>
        </center>
    </div>
</body>
</html>
