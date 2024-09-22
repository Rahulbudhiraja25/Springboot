package com.learn.smsSenderLearn;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    public SmsService() {
        // Initialize Twilio with account SID and Auth Token
        Twilio.init(accountSid, authToken);
    }

    public String sendSms(String toPhoneNumber, String messageBody) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(toPhoneNumber),   // To phone number
                    new PhoneNumber(fromPhoneNumber), // From Twilio phone number
                    messageBody                      // Message content
            ).create();

            return message.getSid(); // Returns the message SID (useful for tracking)
        } catch (Exception e) {
            return "Error sending SMS: " + e.getMessage();
        }
    }
}
