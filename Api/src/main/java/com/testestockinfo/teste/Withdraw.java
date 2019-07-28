package com.testestockinfo.teste;

import java.util.Date;

public class Withdraw {

    private int idWithdraw;
    private Float value;
    private Date data;

    public int getIdWithdraw() {
        return idWithdraw;
    }

    public void setIdWithdraw(int idWithdraw) {
        this.idWithdraw = idWithdraw;
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
        return "Withdraw{" +
                "idWithdraw=" + idWithdraw +
                ", value=" + value +
                ", data=" + data +
                '}';
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
