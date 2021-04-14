package com.wy.domain;

public class MyStudent {

    private int myId;
    private int myAge;
    private String myName;
    private String myEmail;

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "myId=" + myId +
                ", myAge=" + myAge +
                ", myName='" + myName + '\'' +
                ", myEmail='" + myEmail + '\'' +
                '}';
    }
}
