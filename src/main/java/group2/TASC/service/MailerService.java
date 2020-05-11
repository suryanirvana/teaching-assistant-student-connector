package group2.TASC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailerService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String content) {
        MimeMessagePreparator mailMessage = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, true, "UTF-8");
            message.setFrom("tasc.group2@gmail.com", "TASC Group 2");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
        };
        mailSender.send(mailMessage);
    }
}
