package com.example.Semicolon.Back;

/*import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    private static Session session = Session.getInstance(setProps(), new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("semicolonFHmbd@gmail.com", "******");
        }
    });

    public static Properties setProps(){
        Properties prop = System.getProperties();
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        return prop;
    }

    public static void send(String email){
        session.setDebug(true);
        try{
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("semicolonFHmbd@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("ignis.hd@gmx.at")
            );
            message.setSubject("Thanks!");
            message.setText("Thank you for using Semicolons FHmdb!\nYour Semicolon Team!");

            System.out.println("sending");
            Transport.send(message);
            System.out.print("succsesfull");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        send("ignis.hd@gmx.at");
    }
}
*/