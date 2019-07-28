package com.testestockinfo.teste.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private int idAccount;
    private Float value;
    private char type;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_account")
    private List<Deposit> depositList;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_account")
    private List<Withdraw> withdrawList;

    public Account() {}

    public Account(char type) {
        this.value = 0.0f;
        this.type = type;
        this.depositList = new ArrayList<>();
        this.withdrawList = new ArrayList<>();
    }

    public int getIdAccount() {
        return idAccount;
    }

    public char getType() {
        return type;
    }

    public float getValue() {
        return value;
    }

    private void setValue(Float value) {
        this.value = value;
    }

    public List<Withdraw> getWithdrawList() {
        return withdrawList;
    }

    public List<Deposit> getDepositList() {
        return depositList;
    }

    public void deposit(Deposit deposit) throws Exception {
        Deposit.validateDeposit(deposit.getValue());
        this.setValue(this.getValue() + deposit.getValue());
        this.getDepositList().add(deposit);
    }

    public void withdraw(Withdraw withdraw) throws Exception {
        Withdraw.validateWithdraw(withdraw.getValue(), this);
        this.setValue(this.getValue() - withdraw.getValue());
        this.getWithdrawList().add(withdraw);
    }
}
