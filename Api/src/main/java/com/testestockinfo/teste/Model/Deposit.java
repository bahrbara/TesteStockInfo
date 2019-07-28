package com.testestockinfo.teste.Model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deposit")
public class Deposit extends Operation {

    @Id
    @GeneratedValue
    private int idDeposit;

    private Float value;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Deposit() {
        this.setType("DEPOSIT");
    }

    public int getIdDeposit() {
        return idDeposit;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float depositValue) {
        this.value = depositValue;
    }

    public Date getDate() {
        return this.date;
    }

    public static void validateDeposit(Float depositValue) throws Exception {
        if (depositValue < 0) {
            throw new Exception("Valor de depósito negativo");
        }
    }
}
