/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import beans.hostBean;
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
public class HostLogin extends HttpServlet 
{

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        hostBean hb=null;
        try
        {
            db.database db=new db.database();
            if(db.checkUiD((String)req.getParameter("username"),"host")==0) 
            {
                res.sendRedirect("index.jsp?s=ude");
            }
            else 
            {
                if(db.checkHostPw((String)req.getParameter("password"),"host")==0)
                {
                    res.sendRedirect("index.jsp?s=wp");
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
