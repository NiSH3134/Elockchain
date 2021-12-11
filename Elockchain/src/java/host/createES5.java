/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import beans.election2;
import db.election_create;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class createES5 extends HttpServlet {

    

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        election_create obj=new election_create();
        HttpSession id=request.getSession(false);
        
        String name=obj.getElectionName((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
            String name2= StringUtils.replace(name," ","_");
            String fileName="E:/Elockchain FILES/Elockchain_GIT/Elockchain/web/images/Elockchain/Main/Elections/"+(String)id.getAttribute("hid")+"/"+(String)id.getAttribute("eid")+"/"+name2+".pdf";
         String fileType = "application/pdf";
         //String fileName="E:/Elockchain FILES/Elockchain_GIT/Elockchain/web/images/Elockchain/Main/Elections/H2ED2H/E7J51N/TESTING_PDF.pdf";
         response.setContentType(fileType);

         
         response.setHeader("Content-disposition","attachment; filename="+name+".pdf");

         File my_file = new File(fileName);

        
         OutputStream out = response.getOutputStream();
         FileInputStream in = new FileInputStream(my_file);
         byte[] buffer = new byte[4096];
         int length;
         while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
         }
         in.close();
         out.flush();
    }

    

}
