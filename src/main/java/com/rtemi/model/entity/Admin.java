package com.rtemi.model.entity;

import com.rtemi.interfaces.Printable;
import com.rtemi.model.AbstractClassID;
import com.rtemi.model.Ticket;

public class Admin extends AbstractClassID implements Printable {
    final Role role;
    private boolean ticketApproved = false;
    public Admin(){
        this.role = Role.ADMIN;
    }
    public void printRole(){
        System.out.println("Role described :" + role);
    }

    public void checkTicket(Ticket ticket){
        ticketApproved = true;
        System.out.println("Checked ticket : " + ticket.getTicketId());
    }
    @Override
    public void printContent() {
        System.out.println("Role :" + role + " Ticket checked :" + ticketApproved );
    }


}
