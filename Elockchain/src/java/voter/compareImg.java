/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voter;

import beans.election2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class compareImg extends HttpServlet {

    

   

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession vids=request.getSession(false);
                ArrayList<election2> arr=(ArrayList<election2>)vids.getAttribute("VDet");
                String path=null;
                
                for(int i=0;i<arr.size();i++)
                {
                    election2 ee=arr.get(0);                     
                    path=ee.getPath();
                }
            HttpSession s1=request.getSession(false);
            
            String path2=(String)s1.getAttribute("path2");
            out.println("Path from session: "+path);
            out.println("Path2 from session: "+path2);
            out.println(System.getProperty("user.dir"));
            String op="cde";
                try
        {
            out.println("Main Started");
            ProcessBuilder builder = new ProcessBuilder("python","E:\\Elockchain FILES\\Elockchain_GIT\\Elockchain\\src\\java\\voter\\new_main1.py",path,path2);
            Process process = builder.start();
            
            BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error=new BufferedReader(new InputStreamReader(process.getErrorStream()));
            //System.out.println(System.getProperty("user.dir"));
            out.println("inside try");
            System.out.println("inside try");
            String lines="abcd";
            out.println(lines);
            
//            lines=reader.readLine();
//            out.println("Line: "+lines);
            int lc=0;
            while((lines=reader.readLine())!=null)
            {
                System.out.println("Lines: "+lines);
                out.println(lines);
                op=lines;
                lc++;
            }
            out.println(op);
            System.out.println(op);
            out.println("Loop COunt: "+lc);
            String err=null;
            while((err=reader.readLine())!=null)
            {
                System.out.println("Error Lines: "+err);
                out.println("Error: "+err);
            }
            
            out.println("Main Executed");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
            out.println(e);
        }
        
        out.println("<a href='newjsp.jsp'>START</a>");
        
        if(op.equals("Result:  [True]"))
        {
            response.sendRedirect("voter_process/voting.jsp");
        }
        else
        {
            response.sendRedirect("voter_process/face_snap.jsp?st=2");
        }
    }

    
}
