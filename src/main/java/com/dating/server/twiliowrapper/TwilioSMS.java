package com.dating.server.twiliowrapper;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "TwilioSMS")
public class TwilioSMS {
    private static final String ACCOUNT_SID = "ACd72466690c7276bd71640701ff966a75";
    private static final String AUTH_TOKEN = "c1bff111632e143999ddd79a835ab519";

    public TwilioSMS(){
        log.info("Init TwilioSMS");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public static void main(String[] args) {
//        Message message = Message.creator(new PhoneNumber("+16478065791"),
//                new PhoneNumber("+12054489561"),
//                "This is the ship that made the Kessel Run in fourteen parsecs?").create();
//
//        System.out.println(message.getSid());
    }

    public void sendSMS(String to, String body) {

        Message message = Message.creator(new PhoneNumber(to),
                new PhoneNumber("+12054489561"),
                body).create();

        System.out.println(message.getSid());
    }
}
