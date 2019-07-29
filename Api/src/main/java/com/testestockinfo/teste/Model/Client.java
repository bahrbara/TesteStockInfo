package com.testestockinfo.teste.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private int idClient;

    private String name;
    private String cpf;
    private char gender;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private String address;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private List<Account> accountList;

    public Client() {}

    public Client(String name, String cpf, char gender, Date birthDate, String email, String phoneNumber, String address) {
        this.accountList = new ArrayList<>();
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
