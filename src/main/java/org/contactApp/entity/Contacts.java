package org.contactApp.entity;

public class Contacts {
    private int phoneNumber;
    private  String name;
    private String location;
    private String email;

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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

    public Contacts(int phoneNumber, String name, String location, String email) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.location = location;
        this.email = email;
    }

    public Contacts() {
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
