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
public class pendingBean
{
    String to,from,time,previous_hash;
    int amount;
    
    public pendingBean(String to, String from, String time, String previous_hash, int amount) {
        this.to = to;
        this.from = from;
        this.time = time;
        this.previous_hash = previous_hash;
        this.amount = amount;
    }
    
    public pendingBean(){};
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
