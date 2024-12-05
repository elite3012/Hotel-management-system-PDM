package com.code.hms.dao;

import java.util.List;

import com.code.hms.entities.Billing;

public interface BillingDAO {
    //Save to database
    public void saveBilling(Billing billing);

    //Delete the bill
    public void deleteBilling(int billingId);

    // Find bill by id
    public Billing getBillingByID(int billingId);

    // Find bill by reservation id
    public Billing getBillingByReservationID(int reservationId);

    // Find bill by room number
    public Billing getBillingByRoomNumber(int roomId);

    // Find the last bill
    public Billing getLastBilling();

    // Find all billings
    public List<Object[]> getAllBillings();
}