/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import OtherClasses.RandomGen;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import db.election_create;
import beans.election;
/**
 *
 * @author A 04 Nishant Badlani
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, 
maxFileSize=1024*1024*10, 
maxRequestSize=1024*1024*50)
public class createES1 extends HttpServlet {

    private String getFileName(final Part part) 
{
    final String partHeader = part.getHeader("content-disposition");
    
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
   
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        election_create obj=null;
        election b=null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out1 = response.getWriter()) {
            
            String name=request.getParameter("name");
            Part filePart = request.getPart("elogo");
            HttpSession id=request.getSession(false);
            String HiD=(String) id.getAttribute("hid");
            out1.println("Welcome HID: "+HiD+"<br>");
            String photo="";
            String EiD="E"+RandomGen.randomGen(5);
            id.setAttribute("eid",EiD);
            String path="F:/Elockchain/Temp/Elections/"+HiD+"/"+EiD+"/"+"election_logo/";
          File file=new File(path);
          if(!file.exists())
          {
              file.mkdirs();
          }
          int len=file.list().length+1;
          String fileName = len+"_"+getFileName(filePart);
          OutputStream out = null;
          
            InputStream filecontent = null;
            
            PrintWriter writer = response.getWriter();
           
        out = new FileOutputStream(new File(path + File.separator
                + fileName));
        
        filecontent = filePart.getInputStream();
     
 
        int read = 0;
        final byte[] bytes = new byte[1024];
 
        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
           
            photo=path+fileName;
            
            
        }
       b=new election();
       obj=new election_create();
       b.setEid(EiD);
       b.setNameE(name);
       b.setLogoE(photo);
       if(1==obj.insert1(b, HiD))
       {
           response.sendRedirect("host_user/create_election.jsp?st=candidate");
       }
       else
       {
           out1.println("Failed Insert Basic");
       }
       
        
    }
catch(Exception e)
     {
         e.printStackTrace();
         
     }

    }

  
}