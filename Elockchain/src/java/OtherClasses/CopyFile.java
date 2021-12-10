/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
 
import java.io.File;
import java.io.IOException;
/**
 *
 * @author A 04 Nishant Badlani
 */
public class CopyFile 
{
    
    public static void main(String[] args)
    {
        File from = new File("E:\\Elockchain FILES\\Elockchain_GIT\\Elockchain\\web\\images\\Elockchain\\Temp\\Elections\\");
        File to = new File("E:\\Elockchain FILES\\Elockchain_GIT\\Elockchain\\web\\images\\Elockchain\\Main\\Elections\\");
 
        try {
            FileUtils.moveDirectory(from, to);
            System.out.println("Directory moved successfully.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void moveFile(String hid,String eid)
    {
        File from = new File("E:\\Elockchain FILES\\Elockchain_GIT\\Elockchain\\web\\images\\Elockchain\\Temp\\Elections\\"+hid+"\\"+eid);
        File to = new File("E:\\Elockchain FILES\\Elockchain_GIT\\Elockchain\\web\\images\\Elockchain\\Main\\Elections\\"+hid+"\\"+eid);
 
        try {
            FileUtils.moveDirectory(from, to);
            System.out.println("Directory moved successfully.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error in moveFile: "+ ex);
        }
    }

}
