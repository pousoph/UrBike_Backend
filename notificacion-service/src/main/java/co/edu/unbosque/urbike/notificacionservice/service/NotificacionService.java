package co.edu.unbosque.urbike.notificacionservice.service;

import co.edu.unbosque.urbike.notificacionservice.model.request.CorreoDTO;
import co.edu.unbosque.urbike.notificacionservice.repository.NotificacionRepository;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class NotificacionService {
    private final NotificacionRepository notificacionRepository;
    @Value("${mail.email}")
    private String emailFrom;
    @Value("${mail.password}")
    private String passwordFrom;

    private Session session;

    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public Boolean enviarEmail(CorreoDTO correo) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.user", emailFrom);
        prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.setProperty("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(prop);

        try {

            MimeMessage email = new MimeMessage(session);
            email.setFrom(new InternetAddress(emailFrom));
            email.setRecipient(Message.RecipientType.TO, new InternetAddress(correo.correo()));
            BodyPart text = new MimeBodyPart();
            text.setContent(correo.mensaje(), "text/html");
            MimeMultipart part = new MimeMultipart();
            part.addBodyPart(text);
            email.setSubject(correo.asunto());
            email.setContent(part);
            Transport t = session.getTransport("smtp");
            t.connect(emailFrom, passwordFrom);
            t.sendMessage(email, email.getRecipients(Message.RecipientType.TO));
            t.close();
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
