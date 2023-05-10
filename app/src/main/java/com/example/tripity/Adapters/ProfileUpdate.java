package com.example.tripity.Adapters;

public class ProfileUpdate {
    String name, email, Age, idtype, idnum, nationlity , phone;

    public ProfileUpdate() {
    }

    public ProfileUpdate(String Name, String Email, String Age, String Idtype, String Idnum, String Nationlity, String Phone) {
        this.name = Name;
        this.email = Email;
        this.Age = Age;
        this.idtype = Idtype;
        this.idnum = Idnum;
        this.nationlity = Nationlity;
        this.phone = Phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public void setNationlity(String nationlity) {
        this.nationlity = nationlity;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
