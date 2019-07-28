package com.testestockinfo.teste;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id @GeneratedValue
    private int idAccount;
    private Float value;
    private char type;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.LAZY, mappedBy="account", cascade=CascadeType.PERSIST)
    private List<Withdraw> withdrawList;

    @JsonManagedReference
    @OneToMany(fetch=FetchType.LAZY, mappedBy="account", cascade=CascadeType.PERSIST)
    private List<Deposit> depositList;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    public Account(char type) {
        this.value = 0.0f;
        this.type = type;
        this.depositList = new ArrayList<>();
        this.withdrawList = new ArrayList<>();
    }

    public int getIdAccount() {
        return idAccount;
    }

    void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public float getValue() {
        return value;
    }

    private void setValue(Float value) {
        this.value = value;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public List<Withdraw> getWithdrawList() {
        return withdrawList;
    }

    public void setWithdrawList(ArrayList<Withdraw> withdrawList) {
        this.withdrawList = withdrawList;
    }

    public List<Deposit> getDepositList() {
        return depositList;
    }

    public void setDepositList(ArrayList<Deposit> depositList) {
        this.depositList = depositList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", value=" + value +
                ", type=" + type +
                ", withdrawList=" + withdrawList +
                ", depositList=" + depositList +
                '}';
    }

    public Float deposit(Float depositValue) throws Exception {
        Deposit.validateDeposit(depositValue);
        this.setValue(this.getValue() + depositValue);
        this.addDeposit(depositValue);
        return this.getValue();
    }

    public Float withdraw(Float withdrawValue) throws Exception {
        Withdraw.validateWithdraw(withdrawValue, this);
        this.setValue(this.getValue() - withdrawValue);
        this.addWithdraw(withdrawValue);
        return this.getValue();
    }

    public void addDeposit(Float depositValue) {
        Deposit deposit = new Deposit();
        deposit.setValue(depositValue);
        this.getDepositList().add(deposit);
    }

    public void addWithdraw(Float withdrawValue) {
        Withdraw withdraw = new Withdraw();
        withdraw.setValue(withdrawValue);
        this.getWithdrawList().add(withdraw);
    }
}
