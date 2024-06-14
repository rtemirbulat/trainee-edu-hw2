package com.rtemi.model.entity;

import com.rtemi.interfaces.Printable;
import com.rtemi.model.AbstractClassID;
import com.rtemi.model.Ticket;

public class User extends AbstractClassID implements Printable {
    final Role role;
    boolean ticketAcquired = false;
    public User(){
        this.role = Role.CLIENT;
    }


    public void printRole(){
        System.out.println("Role described :" + role);
    }

    //
    public void getTicket(Ticket ticket){
        ticketAcquired = true;
        System.out.println("Ticket acquired: " + ticket.getTicketId());
    }
    @Override
    public void printContent() {
        System.out.println("Role :" + role + " Ticket checked :" + ticketAcquired );
    }
}
