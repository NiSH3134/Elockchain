/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClasses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.database;
import OtherClasses.Email;
import OtherClasses.MailDetails;
import OtherClasses.Pw;
/**
 *
 * @author A 04 Nishant Badlani
 */
public class ForgotIdSev extends HttpServlet {

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        database obj=null;
        HttpSession usertype=req.getSession(false);
        try
        {
            obj=new database();
            
                if(obj.checkEmail(req.getParameter("email"), (String)usertype.getAttribute("usertype"))>0)
                {
                    String r=req.getParameter("email");
                    String s="Your UID for Elockchain";
                    String UiD=obj.UIDforEmail(req.getParameter("email"), (String)usertype.getAttribute("usertype"));
                    String m="A forgot Username request on Elockchain website was done for your ID, your ID is : "+UiD;
                    Email.transferEmail(MailDetails.getHost(), MailDetails.getUser(), Pw.getPass(), MailDetails.getPort(), r, s, m);
                    pw.println("Sent!!");
                }
                else
                {
                    if(usertype.getAttribute("usertype").equals("host"))
                    {
                        res.sendRedirect("index.jsp?s=eri");
                    }
                    else if(usertype.getAttribute("usertype").equals("miner"))
                    {
                        res.sendRedirect("miner_user/miner_reg.jsp?s=eri");
                    }
                    else {}
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            pw.println(e);
        }
        
        
    }

}
