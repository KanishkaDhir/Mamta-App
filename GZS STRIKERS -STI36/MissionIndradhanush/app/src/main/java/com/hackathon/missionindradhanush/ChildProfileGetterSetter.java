package com.hackathon.missionindradhanush;;

import java.io.Serializable;

/**
 * Created by Yashkirat Singh on 27-Mar-18.
 */

public class ChildProfileGetterSetter implements Serializable
{

    String childProfileName,childProfileGender,childProfileDOB,childProfileHospitalName,childProfilePlaceOfBirth,url;
    int vacc1,vacc2,vacc3,vacc4,vacc5,vacc6,vacc7,status;

    public ChildProfileGetterSetter(String childProfileName, String childProfileGender, String childProfileDOB, String childProfileHospitalName, String childProfilePlaceOfBirth,String url,int vacc1,int vacc2,int vacc3,int vacc4,int vacc5,int vacc6,int vacc7,int status) {
        this.childProfileName = childProfileName;
        this.childProfileGender = childProfileGender;
        this.childProfileDOB = childProfileDOB;
        this.childProfileHospitalName = childProfileHospitalName;
        this.childProfilePlaceOfBirth = childProfilePlaceOfBirth;
        this.url=url;
        this.vacc1=vacc1;
        this.vacc2=vacc2;
        this.vacc3=vacc3;
        this.vacc4=vacc4;
        this.vacc5=vacc5;
        this.vacc6=vacc6;
        this.vacc7=vacc7;
        this.status=status;
    }

    public String getChildProfileName() {
        return childProfileName;
    }

    public void setChildProfileName(String childProfileName) {
        this.childProfileName = childProfileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChildProfileGender() {
        return childProfileGender;
    }

    public void setChildProfileGender(String childProfileGender) {
        this.childProfileGender = childProfileGender;
    }

    public String getChildProfileDOB() {
        return childProfileDOB;
    }

    public void setChildProfileDOB(String childProfileDOB) {
        this.childProfileDOB = childProfileDOB;
    }

    public String getChildProfileHospitalName() {
        return childProfileHospitalName;
    }

    public void setChildProfileHospitalName(String childProfileHospitalName) {
        this.childProfileHospitalName = childProfileHospitalName;
    }

    public String getChildProfilePlaceOfBirth() {
        return childProfilePlaceOfBirth;
    }

    public void setChildProfilePlaceOfBirth(String childProfilePlaceOfBirth) {
        this.childProfilePlaceOfBirth = childProfilePlaceOfBirth;
    }

    public int getVacc1() {
        return vacc1;
    }

    public void setVacc1(int vacc1) {
        this.vacc1 = vacc1;
    }

    public int getVacc2() {
        return vacc2;
    }

    public void setVacc2(int vacc2) {
        this.vacc2 = vacc2;
    }

    public int getVacc3() {
        return vacc3;
    }

    public void setVacc3(int vacc3) {
        this.vacc3 = vacc3;
    }

    public int getVacc4() {
        return vacc4;
    }

    public void setVacc4(int vacc4) {
        this.vacc4 = vacc4;
    }

    public int getVacc5() {
        return vacc5;
    }

    public void setVacc5(int vacc5) {
        this.vacc5 = vacc5;
    }

    public int getVacc6() {
        return vacc6;
    }

    public void setVacc6(int vacc6) {
        this.vacc6 = vacc6;
    }

    public int getVacc7() {
        return vacc7;
    }

    public void setVacc7(int vacc7) {
        this.vacc7 = vacc7;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
