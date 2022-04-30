package com.hackathon.missionindradhanush;

import java.io.Serializable;

/**
 * Created by Yashkirat Singh on 27-Mar-18.
 */

public class SignUpGetterSetter implements Serializable
{
    String url;
    String signupName;
    String signupAge;
    String signupemail,signuppassword;
    String signupContact;
    String signupAdhaarNumber;
    String signupGender;
    String signupSpouseName;
    String signupSpouseAge;
    String signupSpouseEmail;
    String signupSpouseAdhaarNumber;
    String signupSpouseGender;



    public SignUpGetterSetter() {
    }

    public SignUpGetterSetter( String signupName, String signupAge, String signupContact, String signupAdhaarNumber, String signupGender, String signupSpouseName, String signupSpouseAge, String signupSpouseEmail,   String signupSpouseAdhaarNumber, String signupSpouseGender,String signupemail,String signuppassword) {
        this.signupName = signupName;
        this.signupAge = signupAge;
        this.signupContact = signupContact;
        this.signupAdhaarNumber = signupAdhaarNumber;
        this.signupGender = signupGender;
        this.signupSpouseName = signupSpouseName;
        this.signupSpouseAge = signupSpouseAge;
        this.signupSpouseEmail = signupSpouseEmail;


        this.signupSpouseAdhaarNumber = signupSpouseAdhaarNumber;
        this.signupSpouseGender = signupSpouseGender;
        this.signupemail=signupemail;
        this.signuppassword=signuppassword;
    }

    public String getSignupContact() {
        return signupContact;
    }

    public void setSignupContact(String signupContact) {
        this.signupContact = signupContact;
    }

    public String getSignupAdhaarNumber() {
        return signupAdhaarNumber;
    }

    public void setSignupAdhaarNumber(String signupAdhaarNumber) {
        this.signupAdhaarNumber = signupAdhaarNumber;
    }



    public String getSignupSpouseAdhaarNumber() {
        return signupSpouseAdhaarNumber;
    }

    public void setSignupSpouseAdhaarNumber(String signupSpouseAdhaarNumber) {
        this.signupSpouseAdhaarNumber = signupSpouseAdhaarNumber;
    }



    public String getSignupName() {
        return signupName;
    }

    public void setSignupName(String signupName) {
        this.signupName = signupName;
    }

    public String getSignupAge() {
        return signupAge;
    }

    public void setSignupAge(String signupAge) {
        this.signupAge = signupAge;
    }



    public String getSignupGender() {
        return signupGender;
    }

    public void setSignupGender(String signupGender) {
        this.signupGender = signupGender;
    }

    public String getSignupSpouseName() {
        return signupSpouseName;
    }

    public void setSignupSpouseName(String signupSpouseName) {
        this.signupSpouseName = signupSpouseName;
    }

    public String getSignupSpouseAge() {
        return signupSpouseAge;
    }

    public void setSignupSpouseAge(String signupSpouseAge) {
        this.signupSpouseAge = signupSpouseAge;
    }

    public String getSignupSpouseEmail() {
        return signupSpouseEmail;
    }

    public void setSignupSpouseEmail(String signupSpouseEmail) {
        this.signupSpouseEmail = signupSpouseEmail;
    }





    public String getSignupSpouseGender() {
        return signupSpouseGender;
    }

    public void setSignupSpouseGender(String signupSpouseGender) {
        this.signupSpouseGender = signupSpouseGender;
    }

    public String getSignupemail() {
        return signupemail;
    }

    public void setSignupemail(String signupemail) {
        this.signupemail = signupemail;
    }

    public String getSignuppassword() {
        return signuppassword;
    }

    public void setSignuppassword(String signuppassword) {
        this.signuppassword = signuppassword;
    }
}
