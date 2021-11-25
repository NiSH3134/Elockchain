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
/**
 *
 * @author A 04 Nishant Badlani
 */
public class database 
{
    public Connection c=null;
    public ResultSet rs=null;
    public String query=null;
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
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return r;
    }
    
    public int checkHiD(String HiD)
    {
        int chk=0;
        try
        {
            connect();
            query="select HiD from hostdata where HiD='"+HiD+"'";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int checkPhno(String phone)
    {
        int chk=0;
        try
        {
            connect();
            query="select HiD from hostdata where phone='"+phone+"'";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int checkEmail(String email)
    {
        int chk=0;
        try
        {
            connect();
            query="select HiD from hostdata where email='"+email+"'";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int checkHost(hostBean hb)
    {
        int chk=0;
        try
        {
            connect();
            query="select HiD from hostdata where HiD='"+hb.getHiD()+"'";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
    
    public int checkHostPw(hostBean hb)
    {
        int chk=0;
        try
        {
            connect();
            query="select HiD from hostdata where HiD='"+hb.getHiD()+"' and password='"+hb.getPassword()+"'";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                chk++;
            }
            disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return chk;
    }
}
