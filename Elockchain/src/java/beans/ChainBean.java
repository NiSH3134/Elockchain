/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author A 04 Nishant Badlani
 */
public class ChainBean 
{
    String from,to,previoushash,hash,time_block,time_transaction;
    int amount;
    int nounce=0;

    public ChainBean(String from,String to, String previoushash, String hash, String time_block, String time_transaction, int amount) {
        this.from = from;
        this.to = to;
        this.previoushash = previoushash;
        this.hash = calculateHash();
        this.time_block = time_block;
        this.time_transaction = time_transaction;
        this.amount = amount;
    }
    
     String calculateHash()
    {
        String op="abc";
        try
        {
            String data=this.from+this.previoushash+this.time_block+this.time_transaction+this.to+this.amount+this.nounce;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(data.getBytes(StandardCharsets.UTF_8));
            op= DatatypeConverter.printHexBinary(digest).toLowerCase();
        }
        catch(Exception e) {e.printStackTrace();}
        return op;
    }
    
    public void mineBlck(int diff){
        String value="";
        for(int i=0;i<diff;i++) {  value=value+"0"; }
        while(!hash.substring(0, diff).equals(value))
        {
            this.nounce++;
            this.hash=calculateHash();
        }
    }
    
    public String getTime_block() {
        return time_block;
    }

    public void setTime_block(String time_block) {
        this.time_block = time_block;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getNounce() {
        return nounce;
    }

    public void setNounce(int nounce) {
        this.nounce = nounce;
    }

    public String getTime_transaction() {
        return time_transaction;
    }

    public void setTime_transaction(String time_transaction) {
        this.time_transaction = time_transaction;
    }

    
    
    public ChainBean() {}
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPrevioushash() {
        return previoushash;
    }

    public void setPrevioushash(String previoushash) {
        this.previoushash = previoushash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
