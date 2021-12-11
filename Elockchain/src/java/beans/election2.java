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
public class election2 
{
    String type,path,id,name,descC,emailV,vtype,phone_voter,password_voter,date_time;

    public election2() {}
    
    public election2(String type, String path, String id, String name, String descC, String emailV, String vtype, String phone_voter, String password_voter, String date_time) {
        this.type = type;
        this.path = path;
        this.id = id;
        this.name = name;
        this.descC = descC;
        this.emailV = emailV;
        this.vtype = vtype;
        this.phone_voter = phone_voter;
        this.password_voter = password_voter;
        this.date_time = date_time;
    }

    public election2(String type, String path, String id, String name, String descC) {
        this.type = type;
        this.path = path;
        this.id = id;
        this.name = name;
        this.descC = descC;
    }
    
        
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescC() {
        return descC;
    }

    public void setDescC(String descC) {
        this.descC = descC;
    }

    public String getEmailV() {
        return emailV;
    }

    public void setEmailV(String emailV) {
        this.emailV = emailV;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getPhone_voter() {
        return phone_voter;
    }

    public void setPhone_voter(String phone_voter) {
        this.phone_voter = phone_voter;
    }

    public String getPassword_voter() {
        return password_voter;
    }

    public void setPassword_voter(String password_voter) {
        this.password_voter = password_voter;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
    
}


