package com.example.tripity.Adapters;

public class ProfileUpdate {
    String name, email, Age, idtype, idnum, nationlity;

    public ProfileUpdate(String name, String email, String age, String idtype, String idnum, String nationlity) {
        this.name = name;
        this.email = email;
        this.Age = age;
        this.idtype = idtype;
        this.idnum = idnum;
        this.nationlity = nationlity;
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
