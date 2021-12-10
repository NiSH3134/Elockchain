/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import beans.hostBean;
import beans.minerBean;
/**
 *
 * @author A 04 Nishant Badlani
 */
public class database 
{
    public Connection c=null;
    public ResultSet rs=null;
    public String query=null;
    static long millis=System.currentTimeMillis();  
    static java.sql.Timestamp d=new java.sql.Timestamp(millis);
    public void connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/elockchaindb?autoReconnect=true&useSSL=false","root","1234");
        }
        catch(SQLException e) { e.printStackTrace(); }
        catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (Exception ex) { ex.printStackTrace(); }
    }
    
    public void disconnect() 
    { 
        try
        {
            if(c!=null && c.isClosed()) { c.close(); }
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    //This method will get data from JSP form and store it in database table "hostdata"
    public int saveHostDetail(hostBean hb)
    {
        int r=0;
        try
        {
            connect();
            query="insert into hostdata values(?,?,?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, hb.getFname());
            ps.setString(2, hb.getLname());
            ps.setString(3, hb.getHiD());
            ps.setString(4, hb.getEmail());
            ps.setString(5, hb.getPhno());
            ps.setString(6, hb.getPassword());
            r=ps.executeUpdate(); 
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return r;
    }
    
    public String getHostName(String hid)
    {
       String fname=null;
        try
        {
            connect();
            query="select * from hostdata where HiD='"+hid+"'";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                fname=rs.getString(1)+rs.getString(2);
            }
            rs=null;
            disconnect();
            query=null;
            
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
       return fname;
    }
    
    public int saveMinerDetail(minerBean mb)
    {
        int r=0;
        try
        {
            connect();
            query="insert into miner values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, mb.getFname());
            ps.setString(2, mb.getLname());
            ps.setString(3, mb.getMiD());
            ps.setString(4, mb.getEmail());
            ps.setString(5, mb.getPhone());
            ps.setString(6, mb.getAcc_no());
            ps.setString(7, mb.getAcc_ifsc());
            ps.setString(8, mb.getPassword());
            r=ps.executeUpdate(); 
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return r;
    }

    public int checkUiD(String UiD,String type)
    {
        int chk=0;
        try
        {
            connect();
            if(type.equals("host"))
            {
                query="select HiD from hostdata where HiD='"+UiD+"'";
            }
            else if(type.equals("miner"))
            {
                query="select MiD from miner where MiD='"+UiD+"'";
            }
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int checkPhno(String phone,String type)
    {
        int chk=0;
        try
        {
            connect();
            if(type.equals("host"))
            {
                query="select HiD from hostdata where phone='"+phone+"'";
            }
            else if(type.equals("miner"))
            {
                query="select MiD from miner where phone='"+phone+"'";
            }
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int checkEmail(String email,String type)
    {
        int chk=0;
        try
        {
            connect();
            if(type.equals("host"))
            {
                query="select HiD from hostdata where email='"+email+"'";
            }
            else if(type.equals("miner"))
            {
                query="select MiD from miner where email='"+email+"'";
            }
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int checkHostPw(String pw,String type)
    {
        int chk=0;
        try
        {
            connect();
            if(type.equals("host"))
            {
                query="select HiD from hostdata where password='"+pw+"'";
            }
            else if(type.equals("miner"))
            {
                query="select MiD from miner where password='"+pw+"'";
            }
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int CheckEmailForID(String UID,String Email,String type)
    {
        int chk=0;
        try
        {
            connect();
            if(type.equals("host"))
            {
                query="select HiD from hostdata where HiD='"+UID+"' and email='"+Email+"';";
            }
            else if(type.equals("miner"))
            {
                query="select MiD from miner where MiD='"+UID+"' and email='"+Email+"';";
            }
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public String UIDforEmail(String Email,String type)
    {
        String UiD=null;
        try
        {
            connect();
            if(type.equals("host"))
            {
                query="select * from hostdata where email='"+Email+"';";
            }
            else if(type.equals("miner"))
            {
                query="select * from miner where email='"+Email+"';";
            }
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                UiD=rs.getString(3);
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return UiD;
    }
}
