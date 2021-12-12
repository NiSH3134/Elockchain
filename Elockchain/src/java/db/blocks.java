/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import OtherClasses.RandomGen;
import beans.ChainBean;
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
import beans.pendingBean;
/**
 *
 * @author A 04 Nishant Badlani
 */
public class blocks 
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
    
    public int create_wallet_c(String cid,String eid)
    {
        int r=0;
        try
        {
            connect();
            query="insert into wallet values(?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, eid);
            ps.setString(2, cid);
            ps.setString(3, RandomGen.randomGen(16).toLowerCase());
            ps.setInt(4, 0);
           
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
    
    public int create_wallet_m(String mid)
    {
        int r=0;
        try
        {
            connect();
            query="insert into wallet values(?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, "na");
            ps.setString(2, mid);
            ps.setString(3, RandomGen.randomGen(16).toLowerCase());
            ps.setInt(4, 0);
           
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
    
    public int create_wallet_v(String vid,String eid)
    {
        int r=0;
        try
        {
            connect();
            query="insert into wallet values(?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, eid);
            ps.setString(2, vid);
            ps.setString(3, RandomGen.randomGen(16).toLowerCase());
            ps.setInt(4, 1);
           
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
    
    public int checkVid(String vid, String eid)
    {
        int r=0;
        try
        {
            connect();
            query="select * from wallet where id='"+vid+"' and eid='"+eid+"';";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                r++;
            }
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
    
    public int checkBalanceVid(String vid, String eid)
    {
        int r=0;
        try
        {
            connect();
            query="select Wallet_Balance from wallet where id='"+vid+"' and eid='"+eid+"';";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                r=rs.getInt("Wallet_Balance");
            }
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
    
    public int getBalance(String id)
    {
        int r=0;
        try
        {
            connect();
            query="select Wallet_Balance from wallet where ID='"+id+"';";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                r=rs.getInt("Wallet_Balance");
            }
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
    
    public static String getPrevious_hash()
    {
        String ph=null;
         String query2=null;
         ResultSet rs2=null;
         blocks b=null;
         try
        {
            b=new blocks();
            b.connect();
            Connection c=b.c;
            query2="select hash from main_chain ORDER BY time_block DESC LIMIT 1;";
            PreparedStatement ps=c.prepareStatement(query2);
            rs2=ps.executeQuery(); 
            while(rs2.next())
            {
                ph=rs2.getString(1);
            }
            b.disconnect();
            query2=null;
            rs2=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return ph;
    }
    
    public int addPendingBlock(pendingBean obj)
    {
        int r=0;
        try
        {
            connect();
            query="insert into pending_transaction values(?,?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, obj.getTo());
            ps.setString(2, obj.getFrom());
            ps.setString(3, d.toString());
            ps.setInt(4, obj.getAmount());
            ps.setString(5, obj.getPrevious_hash());
            
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
    
    public int addChainBlock(ChainBean obj)
    {
        int r=0;
        try
        {
            connect();
            query="insert into main_chain  values(?,?,?,?,?,?)";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1, obj.getFrom());
            ps.setString(2, obj.getTo());
            ps.setString(3, obj.getTime_transaction());
            ps.setString(4, d.toString());
            ps.setString(5, obj.getPrevioushash());
            ps.setString(6, obj.getHash());
            
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
    
    public static void main(String p [])
    {
        System.out.println(getPrevious_hash());
    }
    
    public String getWalletId(String uid)
    {
        String r=null;
        try
        {
            connect();
            query="select Wallet_ID from wallet where id='"+uid+"'";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                r=rs.getString(1);
            }
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
    
    public int updateBalance(String wid, int bal)
    {
        int r=0;
        try
        {
            connect();
            query="update wallet set Wallet_Balance=? where Wallet_ID='"+wid+"'";
            PreparedStatement ps=c.prepareStatement(query);
            ps.setInt(1, bal);
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
    
    public ArrayList<pendingBean> getPendingTransaction()
    {
        ArrayList<pendingBean> arr=new ArrayList<>();
        
        //String to, String from, String time, String previous_hash, int amount
        try
        {
            connect();
            query="select * from pending_transaction";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                arr.add(new pendingBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(4)));
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return arr;
    }
    
    public ArrayList<ChainBean> getChain()
    {
        ArrayList<ChainBean> arr=new ArrayList<>();
        
        //(String to, String previoushash, String hash, String time_block, String time_transaction, int amount)
        try
        {
            connect();
            query="select * from main_chain";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next())
            {
                arr.add(new ChainBean(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(6),rs.getString(4),rs.getString(3),1));
            }
            disconnect();
            query=null;
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return arr;
    }
    
    public int getBalancefromWiD(String wid)
    {
        int r=0;
        try
        {
            connect();
            query="select Wallet_Balance from wallet where Wallet_ID='"+wid+"';";
            PreparedStatement ps=c.prepareStatement(query);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                r=rs.getInt("Wallet_Balance");
            }
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
    
    
    public int removePending(String from)
    {
        int r=0;
        try
        {
            connect();
            query="delete from pending_transaction where from_w='"+from+"';";
            PreparedStatement ps=c.prepareStatement(query);
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
}