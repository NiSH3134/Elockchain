/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voter;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
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
public class checkImg extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String str = request.getParameter("dataURI");
        PrintWriter pw=response.getWriter();
        //pw.println(str);
     
        byte[] imagedata = java.util.Base64.getDecoder().decode(str.substring(str.indexOf(",") + 1));
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
        HttpSession vids=request.getSession(false);
        String vid=(String)vids.getAttribute("vid");
        String eid=(String)vids.getAttribute("eid");
        
        System.out.println("VID: "+vid+" EID: "+eid);
        String path="F:/Elockchain/Voter_Verify/"+eid+"/";
        String fileName=vid+".JPG";
        ImageIO.write(bufferedImage, "JPG", new File("E:/TestImages/"+vid+".JPG"));
        HttpSession s1=request.getSession(false);
        s1.setAttribute("path2","E:/TestImages/"+vid+".JPG");
        if(facedetect.fc("E:/TestImages/"+vid+".JPG").equals("False"))
        {
            response.sendRedirect("face_snap.jsp?st=1");
        }
        else
        {
            RequestDispatcher rd=request.getRequestDispatcher("compareImg");
            rd.forward(request, response);
        }
    }  
}
