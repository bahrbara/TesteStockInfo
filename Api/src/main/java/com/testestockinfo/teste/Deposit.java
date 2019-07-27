package com.testestockinfo.teste;

import java.util.Date;

public class Deposit {

    private int idDeposit;
    private Float value;
    private Date date;

    public int getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(int idDeposit) {
        this.idDeposit = idDeposit;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "idDeposit=" + idDeposit +
                ", value=" + value +
                ", data=" + date +
                '}';
    }

    public static void validateDeposit(Float depositValue) throws Exception {
        if (depositValue < 0) {
            throw new Exception("Valor inválido");
        }
    }
}
