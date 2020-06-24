package com.google.firebase.referencecode.database.models;

public class Ticket {
    private String customerName;
    private long ticketNumber;
    private String ticketDetail;

    public Ticket() {}

    public Ticket(String customerName, long ticketNumber, String ticketDetail) {
        this.customerName = customerName;
        this.ticketNumber = ticketNumber;
        this.ticketDetail = ticketDetail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketDetail() {
        return ticketDetail;
    }

    public void setTicketDetail(String ticketDetail) {
        this.ticketDetail = ticketDetail;
    }
}
