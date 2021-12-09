/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

import OtherClasses.Email;
import OtherClasses.Hashing;
import OtherClasses.MailDetails;
import OtherClasses.Pw;
import OtherClasses.RandomGen;
import beans.minerBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class MinerServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        minerBean mb=null;
        String MiD=null;
        String password=null;
        //(String fname, String lname, String miD, String email, String phone, String acc_no, String acc_ifsc, String password)
        try
        {   
            password=Hashing.returnHash((String)req.getParameter("password"));
            db.database db=new db.database();
            MiD="M"+RandomGen.randomGen(5);
            if(db.checkUiD(MiD,"miner")>0) {MiD="M"+RandomGen.randomGen(5);}
            HttpSession mreg=req.getSession(false);
          
            String r=(String)mreg.getAttribute("email");
            String s="Your LOGIN UID for Elockchain";
            String m="Thankyou for creating ID on our website Elockchain as Miner User, Your login ID is : "+MiD+" .";
            Email.transferEmail(MailDetails.getHost(), MailDetails.getUser(), Pw.getPass(), MailDetails.getPort(), r, s, m);
            mb=new minerBean((String)mreg.getAttribute("fname"),(String)mreg.getAttribute("lname"),MiD,(String)mreg.getAttribute("email"),(String)mreg.getAttribute("phone"),req.getParameter("account"),req.getParameter("ifsc"),password);
            db.saveMinerDetail(mb);
            db=null;
            mb=null;
            mreg.invalidate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
//        RequestDispatcher rd=req.getRequestDispatcher("index.jsp#lession1");
//        rd.forward(req, res);
        res.sendRedirect("miner_user/miner_reg.jsp?s=sl");
    }
}
