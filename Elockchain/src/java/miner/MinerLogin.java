/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

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
public class MinerLogin extends HttpServlet 
{

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        minerBean mb=null;
        try
        {
            db.database db=new db.database();
            if(db.checkUiD((String)req.getParameter("username"),"miner")==0) 
            {
                res.sendRedirect("miner_user/miner_reg.jsp?s=ude");
            }
            else 
            {
                if(db.checkHostPw((String)req.getParameter("password"),"miner")==0)
                {
                    res.sendRedirect("miner_user/miner_reg.jsp?s=wp");
                }
                else
                {
                    pw.println("id found");
                    //forward to home page
                }    
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}