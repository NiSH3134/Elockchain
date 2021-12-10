/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import OtherClasses.Hashing;
import beans.hostBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            String password=Hashing.returnHash((String)req.getParameter("lpassword"));
            if(db.checkUiD((String)req.getParameter("username"),"host")==0) 
            {
                res.sendRedirect("index.jsp?s=ude");
            }
            else 
            {
                if(db.checkHostPw(password,"host")==0)
                {
                    res.sendRedirect("index.jsp?s=wp");
                }
                else
                {
                    HttpSession id=req.getSession(true);
                    id.setAttribute("hid", (String)req.getParameter("username"));
//                    RequestDispatcher rd=req.getRequestDispatcher("host_user/home.jsp");
//                    rd.forward(req, res);
                    res.sendRedirect("host_user/home.jsp");
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
