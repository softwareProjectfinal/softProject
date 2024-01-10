package orders;

import org.slf4j.LoggerFactory;
import parts.Product;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


public class Request {

    private Product product;
    private String customerName;
    private String carMake;
    private String carModel;
    private String preferredDate;
    private boolean confirmed;
    private Session session;
    private Authenticator auther;
    private MimeMessage message;

    //public Request()


    public Request(Product p, String cName, String carMak, String carModl, String preferDate, boolean b) {

        product = p;
        customerName = cName;
        carMake = carMak;
        carModel = carModl;
        preferredDate = preferDate;
        confirmed = b;

    }


    public void email() {

        Logger Logger =  LoggerFactory.getLogger(getClass().getName());

        try {

            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

                 session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("s12029362@stu.najah.edu", "bwov xqav ekes qmfb");
                }
            });
            //session.setDebug(true);
            message = new MimeMessage(session);
            String from = "s12029362@stu.najah.edu";
            message.setFrom(new InternetAddress(from));
            String to = "omar.omar5750@gmail.com";
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
            message.setSubject("This is your code to reset new password");
            message.setText("your mesg");
            Transport.send(message);
        } catch (MessagingException m) {
            Logger.error("",m) ;


        }

    }



}
