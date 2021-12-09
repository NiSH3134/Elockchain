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
import beans.election;
/**
 *
 * @author A 04 Nishant Badlani
 */
public class election_create 
{
    public Connection c=null;
    public ResultSet rs=null;
    public String query=null;
    static long millis=System.currentTimeMillis();  
    static java.sql.Timestamp t=new java.sql.Timestamp(millis);
    
    public static void main(String p[])
    {
        System.out.println(t);
    }
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
    
    public int insert1(election obj, String HiD)
    {
        int r=0;
        try
        {
            connect();
            query="insert into temp_ec(hid,eid,name_election,logo_election_path,date_time,type) values(?,?,?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            System.out.println(obj.getEid()+" "+obj.getNameE()+" "+obj.getLogoE()+" HiD: "+HiD);
            ps.setString(1, HiD);
            ps.setString(2, obj.getEid());
            ps.setString(3, obj.getNameE());
            ps.setString(4, obj.getLogoE());
            ps.setString(5, t.toString());
            ps.setString(6, "ED");
            r=ps.executeUpdate();
            disconnect();
        }
        catch(Exception e) { e.printStackTrace(); }
        return  r;
    }
    
    public int insert2(election obj, String HiD, String EiD)
    {
        int r=0;
        try
        {
            connect();
            query="insert into temp_ec(hid,eid,cid,name_candidate,des_candidate,photo_candidate_path,date_time,type) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            System.out.println(obj.getCid()+" "+obj.getNameC()+" "+obj.getDesC()+" HiD: "+HiD+" EiD: "+EiD);
            ps.setString(1, HiD);
            ps.setString(2, EiD);
            ps.setString(3, obj.getCid());
            ps.setString(4, obj.getNameC());
            ps.setString(5, obj.getDesC());
            ps.setString(6, obj.getPhotoC());
            ps.setString(7, t.toString());
            ps.setString(8, "CD");
            r=ps.executeUpdate();
            disconnect();
        }
        catch(Exception e) { e.printStackTrace(); }
        return  r;
    }
    
    public int insert3(election obj, String HiD, String EiD)
    {
        int r=0;
        try
        {
            connect();
            query="insert into temp_ec(hid,eid,name_voter,email_voter,vid,vtype,phone_voter,password_voter,photo_voter_path,date_time,type) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, HiD);
            ps.setString(2, EiD);
            ps.setString(3, obj.getNameV());
            ps.setString(4, obj.getEmailV());
            ps.setString(5, obj.getVid());
            ps.setString(6, obj.getvT());
            ps.setString(7, obj.getPhotoV());
            ps.setString(8, obj.getPasswordV());
            ps.setString(9, obj.getPhotoV());
            ps.setString(10, t.toString());
            ps.setString(11, "VD");
            r=ps.executeUpdate();
            disconnect();
        }
        catch(Exception e) { e.printStackTrace(); }
        return  r;
    }
    
    public ArrayList<election> getCandidate(String hid, String eid)
    {
        ArrayList<election> a=new ArrayList<>();
        try
        {
            connect();
            query="select * from temp_ec where hid='"+hid+"' and eid='"+eid+"' and type='CD';";
            PreparedStatement ps=c.prepareStatement(query);
//public election(String eid, String nameE, String logoE, String cid, String nameC, String desC, String photoC, String vid, String nameV, String emailV, String phoneV, String passwordV, String photoV, String vT)
rs=ps.executeQuery();
while(rs.next())
            {
               a.add(new election(rs.getString("name_candidate"),rs.getString("des_candidate")));
            }
            disconnect();
        }
        catch(Exception e) { e.printStackTrace(); }
        return a;
    }
    
    //            query="INSERT INTO `elockchaindb`.`temp_ec` (`hid`, `eid`, `name_election`, `logo_election_path`, `cid`, `name_candidate`, `des_candidate`, `new_tablecol`, `photo_candidate_path`, `name_voter`, `email_voter`, `vid`, `phone_voter`, `password_voter`, `photo_voter_path`, `date_time`, `date`) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?);";
    public ArrayList<election> getVoter(String hid, String eid)
    {
        ArrayList<election> a=new ArrayList<>();
        try
        {
            connect();
            query="select * from temp_ec where hid='"+hid+"' and eid='"+eid+"' and type='VD';;";
            PreparedStatement ps=c.prepareStatement(query);
//public election(String eid, String nameE, String logoE, String cid, String nameC, String desC, String photoC, String vid, String nameV, String emailV, String phoneV, String passwordV, String photoV, String vT)
            rs=ps.executeQuery();
            while(rs.next())
            {
               a.add(new election(rs.getString("name_voter"),rs.getString("vid"),rs.getString("email_voter")));
            }
            disconnect();
        }
        catch(Exception e) { e.printStackTrace(); }
        return a;
    }
    
}
