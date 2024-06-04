package com.rtemi;
import com.rtemi.Ticket;

import java.math.BigDecimal;
import java.sql.SQLOutput;

public class TicketService {
    public static void main(String[] args) {
        BigDecimal weight = new BigDecimal(3.14);
        BigDecimal price = new BigDecimal(3.143111);
        Ticket newEmptyTicket = new Ticket();
        Ticket nonEmptyTicket = new Ticket("123","Plaza",123,true,'C',weight,price);
        Ticket limitedTicket = new Ticket("concertHall1",123);
        //System.out.println(newEmptyTicket);
        System.out.println(nonEmptyTicket);
        //System.out.println(limitedTicket);

    }

}
