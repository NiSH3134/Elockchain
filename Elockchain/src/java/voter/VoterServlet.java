/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voter;

import beans.election2;
import db.blocks;
import db.election_create;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class VoterServlet extends HttpServlet 
{


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter pw=response.getWriter();
        String eid=request.getParameter("eid");
        String vid=request.getParameter("vid");
        HttpSession vids=request.getSession(true);
        vids.setAttribute("eid", eid);
        vids.setAttribute("vid", vid);
        election_create obj=new election_create();
        String chk=obj.checkEiD(eid);
        if(chk.equals("ok"))
        {
            ArrayList<election2> arr=new ArrayList<>();
            arr=obj.getPermDetailsforViD(eid, vid);
            if(arr.size()==0)
            {
                response.sendRedirect("voter_process/vote_login1.jsp?st=3");
                
            }
            else
            {
                blocks b=new blocks();
                     if(b.checkVid((String)vids.getAttribute("vid"), (String)vids.getAttribute("eid"))==0)
                     {
                         vids.setAttribute("VDet", arr);
                            response.sendRedirect("voter_process/vote_login2.jsp");
                            pw.println("HOLD");
                            pw.println(vids.getAttribute("vid"));
                     }
                     else
                     {
                         if(b.checkBalanceVid((String)vids.getAttribute("vid"), (String)vids.getAttribute("eid"))!=1)
                         {
                             response.sendRedirect("voter_process/vote_login1.jsp?st=7");
                         }
                         else
                         {
                             vids.setAttribute("VDet", arr);
                            response.sendRedirect("voter_process/vote_login2.jsp");
                            pw.println("HOLD");
                            pw.println(vids.getAttribute("vid"));
                         }
                     }
                
            }
           
        }
        else if(chk.equals("ended"))
        {
            response.sendRedirect("voter_process/vote_login1.jsp?st=1");
        }
        else
        {
            response.sendRedirect("voter_process/vote_login1.jsp?st=2");
        }
    }

    

}
