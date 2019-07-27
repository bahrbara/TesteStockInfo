package com.testestockinfo.teste;

import java.util.Date;

public class Deposit {

    private int idDeposit;
    private Float value;
    private Date data;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "idDeposit=" + idDeposit +
                ", value=" + value +
                ", data=" + data +
                '}';
    }
}
