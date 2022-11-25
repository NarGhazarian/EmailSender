import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public static void main(String[] args) throws IOException, MessagingException {




        final Properties properties = new Properties();
        properties.load(EmailSender.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("spotifya359@gmail.com"));
        message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress("beastblissmusic@gmail.com")));
        message.setSubject("hello");
        message.setText("Hi this is my text");

        Transport tr = mailSession.getTransport();
        tr.connect(null,"pwashonuwhzzqtfs");
        tr.sendMessage(message,message.getAllRecipients());
        tr.close();



    }
}