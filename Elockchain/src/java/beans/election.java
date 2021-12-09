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
public class election 
{
    String eid,nameE,logoE,cid,nameC,desC,photoC,vid,nameV,emailV,phoneV,passwordV,photoV,vT;
    //Date td;
    public election(){}
    public election(String eid, String nameE, String logoE, String cid, String nameC, String desC, String photoC, String vid, String nameV, String emailV, String phoneV, String passwordV, String photoV, String vT) {
        this.eid = eid;
        this.nameE = nameE;
        this.logoE = logoE;
        this.cid = cid;
        this.nameC = nameC;
        this.desC = desC;
        this.photoC = photoC;
        this.vid = vid;
        this.nameV = nameV;
        this.emailV = emailV;
        this.phoneV = phoneV;
        this.passwordV = passwordV;
        this.photoV = photoV;
        this.vT = vT;
    }
    
    public election(String nameC, String desC)
    {
        this.nameC = nameC;
        this.desC = desC;
    }
    
    public election(String nameV, String vid, String emailV)
    {
        this.nameV = nameV;
        this.vid = vid;
        this.emailV=emailV;
    }
    
    public String getvT() {
        return vT;
    }

    public void setvT(String vT) {
        this.vT = vT;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getLogoE() {
        return logoE;
    }

    public void setLogoE(String logoE) {
        this.logoE = logoE;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getDesC() {
        return desC;
    }

    public void setDesC(String desC) {
        this.desC = desC;
    }

    public String getPhotoC() {
        return photoC;
    }

    public void setPhotoC(String photoC) {
        this.photoC = photoC;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getNameV() {
        return nameV;
    }

    public void setNameV(String nameV) {
        this.nameV = nameV;
    }

    public String getEmailV() {
        return emailV;
    }

    public void setEmailV(String emailV) {
        this.emailV = emailV;
    }

    public String getPhoneV() {
        return phoneV;
    }

    public void setPhoneV(String phoneV) {
        this.phoneV = phoneV;
    }

    public String getPasswordV() {
        return passwordV;
    }

    public void setPasswordV(String passwordV) {
        this.passwordV = passwordV;
    }

    public String getPhotoV() {
        return photoV;
    }

    public void setPhotoV(String photoV) {
        this.photoV = photoV;
    }

//    public Date getTd() {
//        return td;
//    }
//
//    public void setTd(Date td) {
//        this.td = td;
//    }
//    
    
}
