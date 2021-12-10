/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host;

import OtherClasses.CopyFile;
import beans.election;
import db.election_create;
import java.io.File;
import java.io.IOException;
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
        HttpSession id=request.getSession(false);
        election_create obj=new election_create();
        election e=null;
        
        
        String new_folder="E:/Elockchain FILES/Elockchain_GIT/Elockchain/web/images/Elockchain/Main/Elections/"+id.getAttribute("hid")+"/";
            File file=new File(new_folder);
          if(!file.exists())
          {
              file.mkdirs();
          }
        
          String temp_folder="E:/Elockchain FILES/Elockchain_GIT/Elockchain/web/images/Elockchain/Main/Elections/"+id.getAttribute("hid")+"/"+id.getAttribute("eid")+"/";
          File file2=new File(temp_folder);
          FileUtils.deleteDirectory(file2);
          
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
        }
        catch(Exception ee) { ee.printStackTrace(); }
        
    }

    
}
