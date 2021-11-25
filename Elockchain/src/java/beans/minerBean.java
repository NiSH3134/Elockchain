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
public class minerBean 
{
    String fname,lname,MiD,email,phone,acc_no,acc_ifsc,password;
    
    public minerBean(){}

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

    public String getMiD() {
        return MiD;
    }

    public void setMiD(String miD) {
        MiD = miD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getAcc_ifsc() {
        return acc_ifsc;
    }

    public void setAcc_ifsc(String acc_ifsc) {
        this.acc_ifsc = acc_ifsc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public minerBean(String fname, String lname, String miD, String email, String phone, String acc_no, String acc_ifsc,
            String password) {
        this.fname = fname;
        this.lname = lname;
        MiD = miD;
        this.email = email;
        this.phone = phone;
        this.acc_no = acc_no;
        this.acc_ifsc = acc_ifsc;
        this.password = password;
    };

    
}
