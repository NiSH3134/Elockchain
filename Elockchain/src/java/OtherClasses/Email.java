package OtherClasses;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Date;
public class Email 
{
    public static void transferEmail(String h,String u,String p,String port,String r,String s,String m) throws AddressException,MessagingException
    {
        Properties pr=new Properties();
        pr.put("mail.smtp.host", h);
        pr.put("mail.smtp.port", port);
        pr.put("mail.smtp.auth", "true");
        pr.put("mail.smtp.starttls.enable", "true");
        Authenticator a=new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(u,p);
            }
        };
        Session session=Session.getInstance(pr,a);
        Message msg=new MimeMessage(session);
        msg.setFrom(new InternetAddress(u));
        InternetAddress [] to= { new InternetAddress(r)};
        msg.setRecipients(Message.RecipientType.TO, to);
        msg.setSubject(s);
        msg.setText(m);
        Transport.send(msg);
    } 
}


/*
public String host="smtp.gmail.com";
    public String user=""; //username here
    public String pass=ps.Pw.getPass(); 
    public String port="587";
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        PrintWriter pw=res.getWriter();
        String r=req.getParameter("rem");
        String s=req.getParameter("sub");
        String m=req.getParameter("message"); 
        
        try
        {
            p1.SendMail.transferEmail(host, user, pass, port, r, s, m);
            pw.println("Sent!!");
        }
        catch(Exception e) {e.printStackTrace();  pw.println(e);}
    }
*/

/*
public class Pw 
{
    public static String password=""; //password here
    public static String getPass()
    {
        return password;
    }
}
*/