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
public class createES2 extends HttpServlet {

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
            HttpSession id=request.getSession(false);
            String name=request.getParameter("nameC");
            String desC=request.getParameter("desC");
            Part filePart = request.getPart("photoC");
            String HiD=(String) id.getAttribute("hid");
            String EiD=(String) id.getAttribute("eid");
            out1.println("HiD: "+HiD+"\nEiD :"+EiD);
            String photo="";
            String CiD="C"+RandomGen.randomGen(5);
            String path="E:/Elockchain FILES/Elockchain_GIT/Elockchain/web/images/Elockchain/Temp/Elections/"+HiD+"/"+EiD+"/"+"candidate_"+CiD+"/";
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
       b.setCid(CiD);
       b.setNameC(name);
       b.setDesC(desC);
       b.setPhotoC(photo);
        if(1==obj.insert2(b, HiD, EiD))
       {
           response.sendRedirect("host_user/create_election.jsp?st=candidate");
       }
       else
       {
           out1.println("Failed Insert Candidate");
       }
      }
    }
}