package com.a1st.invoicepro.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import static com.twilio.rest.api.v2010.account.Message.creator;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public class SmsUtils {
    public static final String FROM_NUMBER = "+447883285927";
    public static final String SID_KEY = "AC0827014313f3054c5b8b736e5fa84332";
    public static final String TOKEN_KEY = "77325a89f3d47b4fa11aaed4caee68ef";

    public static void sendSMS(String to, String messageBody) {
        Twilio.init(SID_KEY, TOKEN_KEY);
        Message message = creator(new PhoneNumber("+" + to), new PhoneNumber(FROM_NUMBER), messageBody).create();
        System.out.println(message);
    }
}
