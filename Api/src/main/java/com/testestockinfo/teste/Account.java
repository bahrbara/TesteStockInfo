package com.testestockinfo.teste;

public class Account {

    private int idAccount;
    private Float value;
    private char type;

    public Account(char type) {
        this.value = 0.0f;
        this.type = type;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
