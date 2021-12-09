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
/**
 *
 * @author A 04 Nishant Badlani
 */
public class ForgotPassSev extends HttpServlet 
{

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        pw.println("UserId: "+req.getParameter("username"));
        pw.println("<Br>");
        pw.println("UserEmail: "+req.getParameter("email"));
        pw.println("<Br>");
        HttpSession usertype=req.getSession(false);
        HttpSession otp_session=req.getSession(true);
        pw.println("UserType: "+usertype.getAttribute("usertype"));
        //usertype.invalidate();
        database obj=null;
        try
        {
            obj=new database();
            if(obj.checkUiD(req.getParameter("username"), (String)usertype.getAttribute("usertype"))>0)
            {
                if(obj.CheckEmailForID(req.getParameter("username"), req.getParameter("email"), (String)usertype.getAttribute("usertype"))>0)
                {
                    String otp=RandomGen.randomGen(6);
                    otp_session.setAttribute("otp", otp);
                    String r=req.getParameter("email");
                    String s="Your OTP for Elockchain Password Reset";
                    String m="A forgot Password request on Elockchain website was done for your ID : "+req.getParameter("username")+" , your OTP is : "+otp;
                    Email.transferEmail(MailDetails.getHost(), MailDetails.getUser(), Pw.getPass(), MailDetails.getPort(), r, s, m);
                    pw.println("Mail Sent!!");
                    pw.println("FOund");
                    if(usertype.getAttribute("usertype").equals("host"))
                    {
                        res.sendRedirect("forgotDetails.jsp?fd=rp&st=host");
                    }
                    else if(usertype.getAttribute("usertype").equals("miner"))
                    {
                        res.sendRedirect("forgotDetails.jsp?fd=rp&st=miner");
                    }
                    else {}
                }
                else
                {
                    if(usertype.getAttribute("usertype").equals("host"))
                    {
                        res.sendRedirect("index.jsp?s=fpe");
                    }
                    else if(usertype.getAttribute("usertype").equals("miner"))
                    {
                        res.sendRedirect("miner_user/miner_reg.jsp?s=fpe");
                    }
                    else {}
                }
            }
            else
            {
                if(usertype.getAttribute("usertype").equals("host"))
                    {
                        res.sendRedirect("index.jsp?s=ude");
                    }
                    else if(usertype.getAttribute("usertype").equals("miner"))
                    {
                        res.sendRedirect("miner_user/miner_reg.jsp?s=ude");
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
