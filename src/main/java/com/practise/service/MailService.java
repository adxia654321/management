package com.practise.service;

public interface MailService {

    void sendVerificationCode(String toEmail, String code);

}
