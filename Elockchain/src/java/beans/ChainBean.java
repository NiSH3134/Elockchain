/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class ChainBean 
{
    String to,previoushash,hash,time_block,time_transaction;
    int amount;

    public ChainBean(String to, String previoushash, String hash, String time_block, String time_transaction, int amount) {
        this.to = to;
        this.previoushash = previoushash;
        this.hash = hash;
        this.time_block = time_block;
        this.time_transaction = time_transaction;
        this.amount = amount;
    }

    public String getTime_block() {
        return time_block;
    }

    public void setTime_block(String time_block) {
        this.time_block = time_block;
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
