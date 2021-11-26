/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

import OtherClasses.Hashing;
import OtherClasses.RandomGen;
import beans.minerBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            if(db.checkEmail((String)req.getParameter("email"),"miner")>0) {} //send error back to login page
            if(db.checkPhno((String)req.getParameter("mobile"),"miner")>0) {}   //send error back to login page
            mb=new minerBean(req.getParameter("fname"),req.getParameter("lname"),MiD,req.getParameter("email"),req.getParameter("mobile"),req.getParameter("account"),req.getParameter("ifsc"),password);
            db.saveMinerDetail(mb);
            db=null;
            mb=null;
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
