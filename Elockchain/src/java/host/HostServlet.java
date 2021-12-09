/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import OtherClasses.Email;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.hostBean;
import db.*;
import OtherClasses.RandomGen;
import OtherClasses.Hashing;
import OtherClasses.MailDetails;
import OtherClasses.Pw;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class HostServlet extends HttpServlet 
{

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        hostBean hb=null;
        String HiD=null;
        String password=null;
        //(String fname, String lname, String hiD, String email, String phno, String password)
        try
        {   
            db.database db=new db.database();
            HiD="H"+RandomGen.randomGen(5);
            password=Hashing.returnHash((String)req.getParameter("password"));
            if(db.checkUiD(HiD,"host")>0) {HiD="H"+RandomGen.randomGen(5);}
            HttpSession reg=req.getSession(false);
            String r=(String)reg.getAttribute("email");
            String s="Your UID for Elockchain";
            String m="Thankyou for creating ID on our website Elockchain as Host User, Your login ID is : "+HiD+" .";
            
            Email.transferEmail(MailDetails.getHost(), MailDetails.getUser(), Pw.getPass(), MailDetails.getPort(), r, s, m);
            
            hb=new hostBean((String)reg.getAttribute("fname"),(String)reg.getAttribute("lname"),HiD,(String)reg.getAttribute("email"),(String)reg.getAttribute("phone"),password);
            db.saveHostDetail(hb);
            db=null;
            reg.invalidate();
            hb=null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
//        RequestDispatcher rd=req.getRequestDispatcher("index.jsp#lession1");
//        rd.forward(req, res);
//pw.println("Hello");
        res.sendRedirect("index.jsp?s=sl");
    }
}

