/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClasses;

import db.database;
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
public class ResetPassSev extends HttpServlet {

    

    

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out=response.getWriter();
        String password=request.getParameter("password");
        try
        {
            String password2=Hashing.returnHash(password);
            HttpSession usertype=request.getSession(false);
            String username=(String)usertype.getAttribute("uid");
            String ut=(String)usertype.getAttribute("usertype");
            out.println(password+username+ut);
            database db=new database();
            db.updatePw(username, ut, password2);
            if(usertype.getAttribute("usertype").equals("host"))
                    {
                        response.sendRedirect("index.jsp?s=loginpage");
                    }
                    else if(usertype.getAttribute("usertype").equals("miner"))
                    {
                        response.sendRedirect("miner_user/miner_reg.jsp?s=loginpage");
                    }
                    else {}
        }
        catch(Exception e) { e.printStackTrace(); }
        
    }


}
