<%-- 
    Document   : checker
    Created on : 11 Dec, 2021, 9:59:15 PM
    Author     : A 04 Nishant Badlani
--%>

<%@page import="beans.election2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="d1" style="display: none">
           
        </div>
        <%
             
                if (request.getParameterMap().containsKey("st")) 
                {
                    if(request.getParameter("st").equals("p1"))
                    {
                        %>
                        <script>
                            document.getElementById("d1").style.display = "block";
                        </script>
                        <%
                    }
                }
                HttpSession vids=request.getSession(false);
                ArrayList<election2> arr=(ArrayList<election2>)vids.getAttribute("VDet");
                String path=null;
                
                for(int i=0;i<arr.size();i++)
                {
                    election2 ee=arr.get(1);                     
                    path="‪E:/TestImages/Nishant/9p3.jpg";
                }
            HttpSession s1=request.getSession(false);
            
            String path2=(String)s1.getAttribute("path2");
            out.println("Path from session: "+path);
            out.println("Path2 from session: "+path2);
            out.println(System.getProperty("user.dir"));
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
            String op="cde";
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
        %>
    </body>
</html>
