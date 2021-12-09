/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClasses;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class MailDetails 
{
    static String user="elockchainproject@gmail.com"; //username here
    static String port="587";
    static String host="smtp.gmail.com";
    public static String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public static String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public static  String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public MailDetails(String user, String port, String host) {
        this.user = user;
        this.port = port;
        this.host = host;
    }

    public MailDetails() {}
}
