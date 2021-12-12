<%-- 
    Document   : vote_finish
    Created on : 12 Dec, 2021, 3:38:06 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="beans.pendingBean"%>
<%@page import="db.blocks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pending Transaction</title>
    </head>
    <body>
        <%
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
                out.println("Success");
            }
            else
            {
                out.println("Failed");
            }
            System.out.println("EID: "+eid+" and VID: "+vid+" and CID: "+cid);
        %>
    </body>
</html>
