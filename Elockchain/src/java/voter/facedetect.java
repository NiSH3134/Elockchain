package voter;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A 04 Nishant Badlani
 */
public class facedetect 
{
    
public static String fc(String path)
{
    String op=null;
    try{
        
        System.out.println("Main Started");
            ProcessBuilder builder = new ProcessBuilder("python","E:\\Elockchain FILES\\Elockchain_GIT\\Elockchain\\src\\java\\voter\\new_main.py",path);
            Process process = builder.start();
           
            BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error=new BufferedReader(new InputStreamReader(process.getErrorStream()));
            //System.out.println(System.getProperty("user.dir"));
            String lines=null;
            while((lines=reader.readLine())!=null)
            {
                System.out.println("Result2: "+lines);
                op=lines;
            }
            
            String err=null;
            while((err=reader.readLine())!=null)
            {
                System.out.println("Error Lines: "+err);
            }
            System.out.println(System.getProperty("user.dir"));
            System.out.println("Main Executed");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        return op;
        
}

public static void main(String []p)
{
    System.out.println("Output:"+facedetect.fc("E:/TestImages/img.JPG"));
}
}
