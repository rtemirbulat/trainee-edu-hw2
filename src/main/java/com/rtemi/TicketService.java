package com.rtemi;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TicketService {
    static List<Ticket> tickets;

    public static void main(String[] args) {
        BigDecimal weight = new BigDecimal(4.200);
        BigDecimal price = new BigDecimal(99.99);
        Ticket newEmptyTicket = new Ticket();
        Ticket nonEmptyTicket = new Ticket("123", "Plaza", 123, true, 'C', weight, price);
        Ticket limitedTicket = new Ticket("concertHall1", 123);
        System.out.println(newEmptyTicket);
        System.out.println(nonEmptyTicket);
        System.out.println(limitedTicket);

        tickets = Arrays.asList(nonEmptyTicket, newEmptyTicket, limitedTicket);

        System.out.println("FIND TICKET BY SECTOR: " + getTicketByStadiumSector('C'));

    }

    public static Ticket getTicketByStadiumSector(char sector) {
        return tickets.stream()
                .filter(ticket -> sector == ticket.getSector())
                .findAny()
                .orElse(null);
    }
}
