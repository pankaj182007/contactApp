package org.contactApp.entity;

public class Contacts {
    private String phoneNumber;
    private  String name;
    private String location;
    private String email;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacts(String phoneNumber, String name, String location, String email) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.location = location;
        this.email = email;
    }

    public Contacts() {
    }

    @Override
    public String toString() {
        return "Contacts :----------" +
                "\nphoneNumber=" + phoneNumber +
                "\nname= " + name +
                "\nlocation= " + location +
                "\nemail= " + email ;
    }
}
