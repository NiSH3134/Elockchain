/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

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
import javax.servlet.RequestDispatcher;

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
            if(db.checkEmail((String)req.getParameter("email"),"host")>0) {} //send error back to login page
            if(db.checkPhno((String)req.getParameter("mobile"),"host")>0) {}   //send error back to login page
            hb=new hostBean(req.getParameter("fname"),req.getParameter("lname"),HiD,req.getParameter("email"),req.getParameter("mobile"),password);
            db.saveHostDetail(hb);
            db=null;
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

