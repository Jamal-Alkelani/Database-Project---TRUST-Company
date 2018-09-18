package Email;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


public class EmailMessage 
{
    
private static final String senderEmailID = "janazcompany@gmail.com";
private static final String senderPassword = "janazcompany123456789janazcompany";
private static final String emailSMTPserver = "smtp.gmail.com";
private static final String emailServerPort = "587";
private static String receiverEmailID = null;
private static String emailSubject = "Test Mail";
private static String emailBody = ":)";


public static class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(senderEmailID, senderPassword);
}
}

public static void SendMessage(String receiverEmailID1, String emailSubject1, String emailBody1) 
{
    try
    {
receiverEmailID=receiverEmailID1;
emailSubject=emailSubject1;
emailBody=emailBody1;
Properties props = new Properties();
props.put("mail.smtp.user",senderEmailID);
props.put("mail.smtp.host", emailSMTPserver);
props.put("mail.smtp.port", emailServerPort);
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.auth", "true");

props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
SecurityManager security = System.getSecurityManager();
try
{
Authenticator auth = new SMTPAuthenticator();
Session session = Session.getInstance(props, auth);
MimeMessage msg = new MimeMessage(session);
msg.setText(emailBody);
msg.setSubject(emailSubject);
msg.setFrom(new InternetAddress(senderEmailID));
msg.addRecipient(Message.RecipientType.TO,
new InternetAddress(receiverEmailID));
Transport.send(msg);
//System.out.println("Message send Successfully:)");
}
catch (Exception mex)
{

}
    
}
catch(Exception mhyhy)
{
    
}

}

}