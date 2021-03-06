/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import OtherClasses.CopyFile;
import OtherClasses.MakePDF;
import beans.election;
import db.blocks;
import db.election_create;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;



/**
 *
 * @author A 04 Nishant Badlani
 */
public class createES4 extends HttpServlet 
{

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter pw=response.getWriter();
        HttpSession id=request.getSession(false);
        election_create obj=new election_create();
        election e=null;
        
        
        String new_folder="F:/Elockchain/Main/Elections/"+id.getAttribute("hid")+"/";
            File file=new File(new_folder);
          if(!file.exists())
          {
              file.mkdirs();
          }
        CopyFile.moveFile((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
         
          
          
        obj.createTB((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
        try
        {
            ArrayList<election> arr=new ArrayList<>();
            arr=obj.getAllDetails((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
            String path=null;
            String updatedPath=null;
            for(int i=0;i<arr.size();i++)
            {
                e=(election)arr.get(i);
                blocks b=new blocks();
                if(e.getType().equals("ED"))
                {
                    path=e.getLogoE();
                    updatedPath=StringUtils.replace(path, "Temp", "Main");
                    e.setLogoE(updatedPath);
                    obj.insertMainED(e, (String)id.getAttribute("eid"));
                    path=null;
                }
                else if(e.getType().equals("CD"))
                {
                    path=e.getPhotoC();
                    updatedPath=StringUtils.replace(path, "Temp", "Main");
                    e.setPhotoC(updatedPath);
                    obj.insertMainCD(e, (String)id.getAttribute("eid"));
                    b.create_wallet_c(e.getCid(), (String)id.getAttribute("eid"));
                    path=null;
                }
                else if(e.getType().equals("VD"))
                {
                    if(e.getvT().equals("Pass"))
                    {
                        obj.insertMainVD_pass(e, (String)id.getAttribute("eid"));
                    }
                    else if(e.getvT().equals("OTP"))
                    {
                        obj.insertMainVD_otp(e, (String)id.getAttribute("eid"));
                    }
                    else
                    {
                        path=e.getPhotoV();
                        updatedPath=StringUtils.replace(path, "Temp", "Main");
                        e.setPhotoV(updatedPath);
                        obj.insertMainVD_photo(e, (String)id.getAttribute("eid"));
                        path=null;
                    }
                }
                e=null;
            }
//             String temp_folder="F:/Elockchain/Temp/Elections/"+id.getAttribute("hid")+"/"+id.getAttribute("eid")+"/";
//             File file2=new File(temp_folder);
//             FileUtils.deleteDirectory(file2);
             
             MakePDF m=new MakePDF();
             String confirm=m.pdf((String)id.getAttribute("hid"), (String)id.getAttribute("eid"));
             if(confirm.equals("Finished PDF"))
             {
                 response.sendRedirect("host_user/finish_election.jsp");
             }
             else
             {
                 pw.println("ERROR in making PDF");
             }
             
             
        }
        catch(Exception ee) { ee.printStackTrace(); }
        
    }

    
}
