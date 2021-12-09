/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

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
public class MinerReg1 extends HttpServlet {

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        db.database db=new db.database();
        HttpSession otp_session=req.getSession(true);
        if(db.checkEmail((String)req.getParameter("email"),"miner")>0) 
        {
            res.sendRedirect("miner_user/miner_reg.jsp?s=eae");
        } //send error back to login page
        else if(db.checkPhno((String)req.getParameter("mobile"),"miner")>0) 
        {
            res.sendRedirect("miner_user/miner_reg.jsp?s=pae");
        }   //send error back to login page
        else
        {
            HttpSession mreg=req.getSession();  
            mreg.setAttribute("fname",(String)req.getParameter("fname"));
            mreg.setAttribute("lname",(String)req.getParameter("lname"));
            mreg.setAttribute("email",(String)req.getParameter("email"));
            mreg.setAttribute("phone",(String)req.getParameter("mobile"));
            System.out.println("Phase 1 Successfull");
            try
            {
            String r=(String)mreg.getAttribute("email");
            String s="Your OTP for Elockchain Miner Regestration";
            String otp=RandomGen.randomGen(6);
            otp_session.setAttribute("otp", otp);
            String m="Your OTP for creating ID at our website Elockchain is: "+otp;
            Email.transferEmail(MailDetails.getHost(), MailDetails.getUser(), Pw.getPass(), MailDetails.getPort(), r, s, m);
            }
            catch(Exception e) {e.printStackTrace();}
            res.sendRedirect("miner_user/miner_reg.jsp?s=d2");  
        }
    }
}
