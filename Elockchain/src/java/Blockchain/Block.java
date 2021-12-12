/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author A 04 Nishant Badlani
 */
public class Block 
{
    String index,timestamp,vw,cw,previousHash,hash;
    int amount=1;
    int nounce=0;

    public Block(String index, String timestamp, String vw, String cw, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.vw = vw;
        this.cw = cw;
        this.previousHash = previousHash;
        this.hash = calculateHash();
        this.nounce=0;
    }
    
    String calculateHash()
    {
        String op="abc";
        try
        {
            String data=this.index+this.previousHash+this.timestamp+this.vw+this.cw+this.amount+this.nounce;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(data.getBytes(StandardCharsets.UTF_8));
            op= DatatypeConverter.printHexBinary(digest).toLowerCase();
        }
        catch(Exception e) {e.printStackTrace();}
        return op;
    }
    
    void mineBlck(int diff){
        String value="";
        for(int i=0;i<diff;i++) {  value=value+"0"; }
        while(!hash.substring(0, diff).equals(value))
        {
            this.nounce++;
            this.hash=calculateHash();
        }
    }
    
    public static void main(String p[])
    {
        Block b=new Block("1","12-12-2021","rjRJJRjrr","egvsg","yhbee");
        b.mineBlck(4);
        System.out.println(b.hash);
        System.out.println(b.nounce);
    }
    
    
}

