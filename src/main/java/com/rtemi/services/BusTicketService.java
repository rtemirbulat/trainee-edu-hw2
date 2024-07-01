package com.rtemi.services;

import com.rtemi.interfaces.Printable;
import com.rtemi.model.BusTicket;
import com.rtemi.model.TicketUID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Service class to manage bus tickets.
 * Provides functionalities to create, store, remove, and search bus tickets.
 */
public class BusTicketService extends TicketUID implements Printable {
    private static List<BusTicket> ticketList = new ArrayList<>();
    private static AtomicInteger idCounter = new AtomicInteger();
    /**
     * Creates a new bus ticket and stores it in memory.
     * @param ticketClass The class of the ticket (e.g., Standard, VIP, Super).
     * @param ticketType The type of the ticket (e.g., Month, Year, Daily).
     * @param startDate The start date of the ticket.
     * @param price The price of the ticket.
     * @return The created BusTicket.
     */
    public BusTicket createBusTicket(String ticketClass, String ticketType, String startDate, BigDecimal price) {
        BusTicket ticket = new BusTicket(startDate, ticketType, ticketClass, price);
        ticket.setTicketUid(idCounter.incrementAndGet());
        ticketList.add(ticket);
        return ticket;
    }

    public boolean removeBusTicketById(int ticketUID) {
        return ticketList.removeIf(ticket -> ticket.getTicketUid() == ticketUID);
    }

    public BusTicket getTicketById(int ticketUID) {
        Optional<BusTicket> ticket = ticketList.stream()
                .filter(t -> t.getTicketUid() == ticketUID)
                .findFirst();
        return ticket.orElse(null);
    }
    /**
     * Searches for bus tickets by type and price range.
     * @param ticketType The type of the ticket.
     * @param minPrice The minimum price.
     * @param maxPrice The maximum price.
     * @return A list of matching BusTickets.
     */
    public static List<BusTicket> searchTicketsByTypeAndPrice(String ticketType, BigDecimal minPrice, BigDecimal maxPrice) {
        return ticketList.stream()
                .filter(ticket -> ticket.getTicketType().equalsIgnoreCase(ticketType)
                        && ticket.getPrice().compareTo(minPrice) >= 0
                        && ticket.getPrice().compareTo(maxPrice) <= 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        BusTicketService service = new BusTicketService();

        System.out.println(service.createBusTicket("STD", "MONTH", "2024-06-27", BigDecimal.valueOf(100)));
        System.out.println(service.createBusTicket("SUP", "YEAR", "2024-06-28", BigDecimal.valueOf(500)));
        System.out.println(service.createBusTicket("VIP", "DAY", "2024-06-29", BigDecimal.valueOf(1000)));

        for (int i = 0; i < ticketList.size(); i++) {
            System.out.println(ticketList.get(i).getTicketUid() +" "+  ticketList.get(i) );
        }

        // Get and print a ticket by ID
        BusTicket ticket = service.getTicketById(1);
        if (ticket != null) {
            ticket.toString();
        }

        // Search and print tickets by type and price range
        List<BusTicket> searchedTickets = service.searchTicketsByTypeAndPrice("Economy", new BigDecimal("10.00"), new BigDecimal("16.00"));
        searchedTickets.forEach(ticket1 -> System.out.println(ticket1));

        // Remove a ticket by ID
        boolean removed = service.removeBusTicketById(1);
        System.out.println("Ticket with ID 1 removed: " + removed);

        for (int i = 0; i < ticketList.size(); i++) {
            System.out.println(ticketList.get(i).getTicketUid() +" "+  ticketList.get(i) );
        }
    }

}
