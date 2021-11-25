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
public class hostBean 
{
    String fname,lname,HiD,email,phno,password;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getHiD() {
        return HiD;
    }

    public void setHiD(String hiD) {
        HiD = hiD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public hostBean(String fname, String lname, String hiD, String email, String phno, String password) {
        this.fname = fname;
        this.lname = lname;
        HiD = hiD;
        this.email = email;
        this.phno = phno;
        this.password = password;
    }

    public hostBean() {}
}
