package com.rtemi;
import com.rtemi.Ticket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketService {
    public ArrayList<Ticket> storage; // should be an interface
    public static void main(String[] args) {
        BigDecimal weight = new BigDecimal(4.200);
        BigDecimal price = new BigDecimal(99.99);

        //Ticket Generator (no-nulls)
        for (int i = 0; i <= 10; i++) {
            Random random = new Random();
            char[] sectors = {'A','B','C'};
            Ticket newTicket = new Ticket();
            newTicket.setId(String.valueOf(100 + random.nextInt(900)));
            newTicket.setConcertHall("Abu-Dhabi Concert Hall");
            newTicket.setEventCode(100 + random.nextInt(900));
            newTicket.setPromo(random.nextBoolean());
            newTicket.setSector(sectors[random.nextInt(sectors.length)]);
            newTicket.setMaxWeight(weight);
            newTicket.setMaxWeight(price);
        }
    }
    public Ticket getTicketById(String id){
        for (Ticket ticket: storage) {
            if(ticket.getId().equals(id)){
                return ticket;
            }
        }
        return null;
    }
}
