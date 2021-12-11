/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClasses;

import beans.election2;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import db.election_create;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class MakePDF 
{
    public String pdf(String hid,String eid)
    {
        try
        {
            election_create obj=new election_create();
            election2 e=null;
            
            
            String EiD=eid;
            String HiD=hid;
            ArrayList<election2> arr=new ArrayList<>();
            arr=obj.getPermDetails(eid);
            String name=obj.getElectionName(hid, eid);
            String name2= StringUtils.replace(name," ","_");
            String file_name="E:/Elockchain FILES/Elockchain_GIT/Elockchain/web/images/Elockchain/Main/Elections/"+HiD+"/"+EiD+"/"+name2+".pdf";
        
            Document document=new Document();

            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            
            BufferedImage bImage = ImageIO.read(new File("E:/Elockchain FILES/Elockchain_GIT/Elockchain/web/images/l2.png"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", bos );
            byte [] data = bos.toByteArray();
            //Paragraph para=new Paragraph("This is testing2");
            
            
            document.add(Image.getInstance(data));
            PdfPTable table_election=new PdfPTable(3);
            table_election.addCell("Election Logo");
            table_election.addCell("Election ID");
            table_election.addCell("Election Name");
            table_election.setHeaderRows(1);
            
            PdfPTable table_candidate=new PdfPTable(3);
            table_candidate.addCell("Candidate Logo");
            table_candidate.addCell("Candidate ID");
            table_candidate.addCell("Candidate Name");
            table_candidate.setHeaderRows(1);
            
            PdfPTable table_voter_OTP=new PdfPTable(3);
            table_voter_OTP.addCell("Voter ID");
            table_voter_OTP.addCell("Voter Name");
            table_voter_OTP.addCell("Voter Email");
            table_voter_OTP.setHeaderRows(1);
            
            PdfPTable table_voter_Pass=new PdfPTable(4);
            table_voter_Pass.addCell("Voter ID");
            table_voter_Pass.addCell("Voter Name");
            table_voter_Pass.addCell("Voter Email");
            table_voter_Pass.addCell("Voter Password");
            table_voter_Pass.setHeaderRows(1);
            
            PdfPTable table_voter_Photo=new PdfPTable(4);
            table_voter_Photo.addCell("Voter ID");
            table_voter_Photo.addCell("Voter Name");
            table_voter_Photo.addCell("Voter Email");
            table_voter_Photo.addCell("Voter Photo");
            table_voter_Photo.setHeaderRows(1);
            
           
            for(int i=0;i<arr.size();i++)
            {
                e=(election2)arr.get(i);
                BufferedImage bImage2=null;
                ByteArrayOutputStream bos2=null;
                byte [] data2=null;
                if(e.getType().equals("ED"))
                {
                    bImage2 = ImageIO.read(new File(e.getPath()));
                    bos2 = new ByteArrayOutputStream();
                    ImageIO.write(bImage2, "png", bos2 );
                    data2 = bos2.toByteArray();
                    
                    table_election.addCell(Image.getInstance(data2));
                    table_election.addCell(e.getId());
                    table_election.addCell(e.getName());  
                    
                }
                else if(e.getType().equals("CD"))
                {
                    bImage2 = ImageIO.read(new File(e.getPath()));
                    bos2 = new ByteArrayOutputStream();
                    ImageIO.write(bImage2, "png", bos2 );
                    data2 = bos2.toByteArray();
                    
                    table_candidate.addCell(Image.getInstance(data2));
                    table_candidate.addCell(e.getId());
                    table_candidate.addCell(e.getName());
                }
                else if(e.getType().equals("VD"))
                {
                    if(e.getVtype().equals("Pass"))
                    {
                        table_voter_Pass.addCell(e.getId());
                        table_voter_Pass.addCell(e.getName());
                        table_voter_Pass.addCell(e.getEmailV());
                        table_voter_Pass.addCell(e.getPassword_voter());
                    }
                    else if(e.getVtype().equals("OTP"))
                    {
                        table_voter_OTP.addCell(e.getId());
                        table_voter_OTP.addCell(e.getName());
                        table_voter_OTP.addCell(e.getEmailV());
                    }
                    else
                    {
                        bImage2 = ImageIO.read(new File(e.getPath()));
                        bos2 = new ByteArrayOutputStream();
                        ImageIO.write(bImage2, "png", bos2 );
                        data2 = bos2.toByteArray();
                        table_voter_Photo.addCell(e.getId());
                        table_voter_Photo.addCell(e.getName());
                        table_voter_Photo.addCell(e.getEmailV());
                        table_voter_Photo.addCell(Image.getInstance(data2));
                    }
                }
                e=null;
            }
            
          
        
        document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" "));
        document.add(new Paragraph("ELECTION DETAILS"));  document.add(new Paragraph(" "));
        document.add(table_election);
        document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" "));
        document.add(new Paragraph("LIST OF CANDIDATE"));  document.add(new Paragraph(" "));
        document.add(table_candidate);
        document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" ")); document.add(new Paragraph(" "));
        document.add(new Paragraph("VOTER WITH VERIFICATION TYPE OTP"));  document.add(new Paragraph(" "));
        document.add(table_voter_OTP);
        document.add(new Paragraph("VOTER WITH VERIFICATION TYPE Password"));  document.add(new Paragraph(" "));
        document.add(table_voter_Pass);
        document.add(new Paragraph("VOTER WITH VERIFICATION TYPE Photo"));  document.add(new Paragraph(" "));
        document.add(table_voter_Photo);
        document.close();
        System.out.println("Finished PDF");
       
        
        }
        catch(Exception e) {
        System.out.println(e);}
        return "Finished PDF";
    }
}
