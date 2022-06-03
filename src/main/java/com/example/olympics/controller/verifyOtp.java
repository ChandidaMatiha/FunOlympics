package com.example.olympics.controller;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.VerificationCheck;

public class verifyOtp {

    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID =("AC7642f0ed92096235fbbfda4a80db5187");
    public static final String AUTH_TOKEN = ("23b6a043427992fab6caf09da944a236");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try{
            VerificationCheck verificationCheck = VerificationCheck.creator(
                            "VA13f1547383d3f786b596f27096152e05",
                            "705522")
                    .setTo("nshathisismile@gmail.com").create();

            System.out.println(verificationCheck.getSid());
        }catch (Exception e){
            String testing= String.valueOf(e);
            System.out.println(testing.contains("was not found"));
        }

    }

    public static String sentVerifyEmail(String code,String email){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String msg=null;
        try{
            VerificationCheck verificationCheck = VerificationCheck.creator(
                            "VA13f1547383d3f786b596f27096152e05",
                            code)
                    .setTo(email).create();
            msg="Correct code";
            System.out.println(verificationCheck.getSid());
        }catch (Exception e){
            String testing= String.valueOf(e);
            System.out.println(testing.contains("was not found"));
            if(testing.contains("was not found")){
                msg="Incorrect code";
            }else{
                msg="error unknown code";
            }
        }
        return msg;
    }
}
