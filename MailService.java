/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author manikanta.m
 */
public class MailService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String host = "ew2smtp.aws-imidomain.com";
        String port = "25";
        String from = "noreply@iminmx.io";
        String to = "manikantamaddukuri12@gmail.com";
        boolean authEnable = false;

        final String user = "test@imimobile.io";
        final String password = "xxxxx";

        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "false");

        Session session;

        if (authEnable) {
            session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });
        } else {
            session = session = Session.getInstance(props);
        }

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("mail from manikanta");
            message.setText("This is just a sample email sent by manikanta");

            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
