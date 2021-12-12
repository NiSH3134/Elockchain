<%-- 
    Document   : mined
    Created on : 12 Dec, 2021, 8:42:23 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="db.blocks"%>
<%@page import="beans.ChainBean"%>
<%@page import="beans.pendingBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String from=request.getParameter("from");
            HttpSession minerD=request.getSession(false);
            String to=request.getParameter("to");
            String time_transaction=request.getParameter("time");
            int amount=Integer.valueOf(request.getParameter("amt"));
            String ph=blocks.getPrevious_hash();
            //(String from,String to, String previoushash, String hash, String time_block, String time_transaction, int amount)
            ChainBean cb=new ChainBean(from,to,ph,"nh","2021-01-01",time_transaction,amount);
            cb.mineBlck(4);
            blocks b=new blocks();
            int bal=b.getBalancefromWiD(to)+1;
            b.updateBalance(to, bal);
            String minerWID=b.getWalletId((String)minerD.getAttribute("mid"));
            int minerBal=b.getBalancefromWiD(minerWID)+3;
            b.removePending(from);
            b.updateBalance(minerWID, minerBal);
            response.sendRedirect("mining.jsp?st=1");
        %>
    </body>
</html>
