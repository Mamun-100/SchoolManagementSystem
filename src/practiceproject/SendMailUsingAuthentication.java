/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproject;
import javax.mail.*;                                                                                                                
import javax.mail.internet.*;                                                                                                    
import java.util.*;   
/**
 *
 * @author Os-10
 */
public class SendMailUsingAuthentication{                                                                                                                                            
    static final String SMTP_HOST_NAME = "smtp.gmail.com";  // for gmail                
    static final String SMTP_AUTH_USER = "mrhudaisoftware@gmail.com";    // Username                        
    private static final String SMTP_AUTH_PWD  = "mrhudaisoftware12";  // Password                     
                                                                                                                                                                                        
public void postMail( String recipients[], String subject,String message, String from) throws MessagingException{                                                                                                                                         
     boolean debug = false;                                                                                                       
                                                                                               
     Properties props = new Properties();                                                                                
     props.put("mail.smtp.starttls.enable","true");                                                                     
     props.put("mail.smtp.host", SMTP_HOST_NAME);   
     props.put("mail.smtp.port", "587");
     props.put("mail.smtp.auth", "true");                                                                                    

     Authenticator auth = new SMTPAuthenticator();                                                                
     Session session = Session.getDefaultInstance(props, auth);                                                 
     session.setDebug(debug);                                                                                                  

                                                                                                          
    Message msg = new MimeMessage(session);   
    
    InternetAddress addressFrom = new InternetAddress(from);                                             
    msg.setFrom(addressFrom);                                                                                             

    InternetAddress[] addressTo = new InternetAddress[recipients.length];                             
    for (int i = 0; i < recipients.length; i++){                                                                                                                                      
        addressTo[i] = new InternetAddress(recipients[i]);                                                        
    }                                                                                                                                      
    msg.setRecipients(Message.RecipientType.TO, addressTo);                                                                                                                         
    msg.setSubject(subject);                                                                                                  
    msg.setContent(message, "text/plain");                                                                              
    Transport.send(msg);                                                                                                       
 }                                                                                                                                        
                                                                                                                                   
private class SMTPAuthenticator extends javax.mail.Authenticator {                                                                                                                                          
        @Override                                                                                                                   
    public PasswordAuthentication getPasswordAuthentication(){                                                                                                                                      
        String username = SMTP_AUTH_USER;                                                                    
        String password = SMTP_AUTH_PWD;                                                                     
        return new PasswordAuthentication(username, password);                                             
         }                                                                                                                                       
    } 
}
