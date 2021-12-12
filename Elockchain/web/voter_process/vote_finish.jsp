<%-- 
    Document   : vote_finish
    Created on : 12 Dec, 2021, 3:38:06 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="db.election_create"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.election2"%>
<%@page import="beans.pendingBean"%>
<%@page import="db.blocks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pending Transaction</title>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/top.css">
    <link rel="stylesheet" href="../css/login.css">
    </head>
    <body>
        <%
            
            HttpSession vids=request.getSession(false);
            ArrayList<election2> arr2=(ArrayList<election2>)vids.getAttribute("VDet");
            String eid=request.getParameter("eid");
            String vid=request.getParameter("vid");
            String cid=request.getParameter("cid");
            blocks b=new blocks();
            String to=b.getWalletId(cid);
            String from=b.getWalletId(vid);
            //(String to, String from, String time, String previous_hash, int amount)
            pendingBean pb=new pendingBean(to,from,"t",blocks.getPrevious_hash(),1);
            if(b.addPendingBlock(pb)>0)
            {
                b.updateBalance(from, 0);
                //out.println("Success");
                %>
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
                    
                </ul>
            </div>
        </div>
        <center>
            <br><br>
            <%
                HttpSession id=request.getSession(false);
                election_create obj=new election_create();
                
                String input=obj.getElectionLogo2((String)id.getAttribute("eid"));
                //out.println(input);
                    File file =  new File(input);
                    FileInputStream fileInputStreamReader = new FileInputStream(file);
                    byte[] bytes = new byte[(int)file.length()];
                    fileInputStreamReader.read(bytes);
                    String abc=new String(Base64.getEncoder().encode(bytes), "UTF-8");
                    
                
                    String path="data:image/png;base64,"+abc;
            
            %>
            <table class="box">
                <tr>
                    <td>
                         <img src="<%=path%>"  width="200px">
                    </td>
                    <td>
                        <h1><%=obj.getElectionName2( (String)id.getAttribute("eid"))%></h1>
                    </td>
                    <td>
                        <h1><%=(String)id.getAttribute("eid")%></h1>
                    </td>
                </tr>
            </table>
            <br><br>
                <table width="80%">
                    <tr>
                        <td>
                            <marquee behavior="alternate">
                                <h1 style="color: blue;">Your Vote has been Casted Successfully...!!!</h1>
                            </marquee>
                        </td>
                    </tr>
                </table>
                <br><br>
            <div class="box">
                <div>
                    <h1><%=vid2%></h1>
                </div>
                <div>
                    <h1><%=vname%></h1>
                </div>
                
                <div>
                    <a href="vote_login1.jsp"> <button class="btn">Exit</button></a>
                </div>
            </div>
        </center>
    </div>
                <%
            }
            else
            {
                out.println("Failed");
            }
            System.out.println("EID: "+eid+" and VID: "+vid+" and CID: "+cid);
        %>
        
    </body>
</html>
