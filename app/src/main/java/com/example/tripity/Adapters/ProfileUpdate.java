package com.example.tripity.Adapters;

public class ProfileUpdate {
    String name, email, Age, idtype, idnum, nationlity , phone;

    public ProfileUpdate(String Name, String Email, String Age, String Idtype, String Idnum, String Nationlity, String Phone) {
        this.name = Name;
        this.email = Email;
        this.Age = Age;
        this.idtype = Idtype;
        this.idnum = Idnum;
        this.nationlity = Nationlity;
        this.phone = Phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return Age;
    }

    public String getIdtype() {
        return idtype;
    }

    public String getIdnum() {
        return idnum;
    }

    public String getNationality() {
        return nationlity;
    }
}
