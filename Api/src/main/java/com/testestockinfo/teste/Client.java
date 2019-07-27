package com.testestockinfo.teste;

import java.util.ArrayList;
import java.util.Date;

public class Client {
    private int idClient;
    private String name;
    private String cpf;
    private char gender;
    private int age;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private String address;
    private ArrayList<Account> accountList;

    public Client(int idClient, String name, String cpf, char gender, int age, Date birthDate,
                  String email, String phoneNumber, String address) {

        this.accountList = new ArrayList<>();
        Account accountNormal = new Account('N');
        Account accountEventual = new Account('E');

        this.idClient = idClient;
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.accountList.add(accountNormal);
        this.accountList.add(accountEventual);
    }


    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public int getAge() {
         return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
