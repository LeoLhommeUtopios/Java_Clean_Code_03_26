package org.example.dip;

public class EmailSenderImpl implements EmailSender {
    @Override
    public void send(Email email) {
        System.out.print("To:"+email.getTo()+", Subject: "+email.getSubject()+", Message: "+email.getMessage());
    }
}
