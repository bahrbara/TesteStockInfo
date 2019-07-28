package com.testestockinfo.teste.Model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "withdraw")
public class Withdraw extends Operation {

    @Id
    @GeneratedValue
    private int idWithdraw;

    private Float value;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public int getIdWithdraw() {
        return idWithdraw;
    }

    public Withdraw() {
        this.setType("WITHDRAW");
    }

    public Date getDate() {
        return this.date;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float depositValue) {
        this.value = depositValue;
    }

    public static void validateWithdraw(Float withdrawValue, Account account) throws Exception {
        isNegative(withdrawValue);
        hasEnoughBalance(withdrawValue, account.getValue());
    }

    private static void isNegative(Float value) throws Exception {
        if (value < 0) {
            throw new Exception("Valor de saque negativo");
        }
    }

    private static void hasEnoughBalance(Float withdrawValue, Float accountValue) throws Exception {
        if (accountValue < withdrawValue) {
            throw new Exception("Saldo insuficiente");
        }
    }
}
