package utilities;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author goku-_000
 */
public class EmailSender {

    private String desMail, subject, content;

    public EmailSender(String desMail, String subject, String content) {
        this.desMail = desMail;
        this.subject = subject;
        this.content = content;
    }
    
    public EmailSender(){
        
    }

    public String getDesMail() {
        return desMail;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
    
    
    
    public String sendEmail() {
        
        Properties prop = new Properties();
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(prop, new MailAuth());

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gmail.com", "IT KMITL"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(desMail));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            return "Pass";
        } catch (MessagingException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
            return "Fail";
        }
    }

}
