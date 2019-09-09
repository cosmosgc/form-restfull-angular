package com.raposa.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private String id;
    private String name;
    private String email;
    private String comment;
    private String cnpj;

    public Customer() {
    }

    public Customer(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return email;
    }

    public String getComment() {
        return comment;
    }
    
    public String getCnpj() {
        return cnpj;
    }
}