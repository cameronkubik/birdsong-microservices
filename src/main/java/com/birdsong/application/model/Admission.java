package com.birdsong.application.model;

public class Admission {

    private int adultTicketPrice;
    private int childTicketPrice;
    private int infantTicketPrice;

    public Admission(int _adultPrice, int _childPrice, int _infantPrice) {
        this.adultTicketPrice = _adultPrice;
        this.childTicketPrice = _childPrice;
        this.infantTicketPrice = _infantPrice;
    }

    public String getAdultTicketPrice() {
        String adultPrice = convertDollarString(this.adultTicketPrice);
        return adultPrice;
    }

    public String getChildTicketPrice() {
        String childPrice = convertDollarString(this.childTicketPrice);
        return childPrice;
    }

    public String getInfantTicketPrice() {
        String infantPrice = convertDollarString(this.infantTicketPrice);
        return infantPrice;
    }

    private String convertDollarString(int dollars) {
        StringBuilder sb = new StringBuilder();

        if (dollars == 0) {
            return "Free!";
        }

        sb.append("$");
        sb.append(String.valueOf(dollars));
        sb.append(".00");

        String dollarStr = sb.toString();
        return dollarStr;
    }
}