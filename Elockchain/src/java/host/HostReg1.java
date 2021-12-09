/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import OtherClasses.Email;
import OtherClasses.MailDetails;
import OtherClasses.Pw;
import OtherClasses.RandomGen;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class HostReg1 extends HttpServlet 
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        db.database db=new db.database();
        HttpSession otp_session=req.getSession(true);
        if(db.checkEmail((String)req.getParameter("email"),"host")>0) 
        {
            res.sendRedirect("index.jsp?s=eae");
        } //send error back to login page
        else if(db.checkPhno((String)req.getParameter("mobile"),"host")>0) 
        {
            res.sendRedirect("index.jsp?s=pae");
        }   //send error back to login page
        else
        {
            HttpSession reg=req.getSession();  
            reg.setAttribute("fname",(String)req.getParameter("fname"));
            reg.setAttribute("lname",(String)req.getParameter("lname"));
            reg.setAttribute("email",(String)req.getParameter("email"));
            reg.setAttribute("phone",(String)req.getParameter("mobile"));
            System.out.println("Phase 1 Successfull");
            try
            {
                String r=(String)reg.getAttribute("email");
            String s="Your OTP for Elockchain User Regestration";
            String otp=RandomGen.randomGen(6);
            otp_session.setAttribute("otp", otp);
            String m="Your OTP for creating ID at our website Elockchain is: "+otp;
            Email.transferEmail(MailDetails.getHost(), MailDetails.getUser(), Pw.getPass(), MailDetails.getPort(), r, s, m);
            }
            catch(Exception e) {e.printStackTrace();}
            res.sendRedirect("index.jsp?s=d2");  
        }
        
        
    }
}
