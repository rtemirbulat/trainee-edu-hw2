package com.rtemi;
import com.rtemi.Ticket;

import java.math.BigDecimal;

public class TicketService {
    public static void main(String[] args) {
        BigDecimal weight = new BigDecimal(4.200);
        BigDecimal price = new BigDecimal(99.99);
        Ticket newEmptyTicket = new Ticket();
        Ticket nonEmptyTicket = new Ticket("123","Plaza",123,true,'C',weight,price);
        Ticket limitedTicket = new Ticket("concertHall1",123);
        System.out.println(newEmptyTicket);
        System.out.println(nonEmptyTicket);
        System.out.println(limitedTicket);

    }

}
