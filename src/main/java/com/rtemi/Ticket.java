package com.rtemi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.Date;

/*TO-DO:
Create 2 Java classes -“Ticket” and “TicketService”
The “Ticket" class should have the following variables:
○ ID (max 4 digits and/or chars)
○ concert hall (max 10 chars)
○ event code (3 digits)
○ time (Unix timestamp)
○ is promo
○ stadium sector (from ‘A’ to ‘C’)
○ max allowed backpack weight in kg (with grams precision)
Choose the [name] [data type], [access modifier] and [variable type] carefully, depending on a [variable] purpose.
There should be the ability to create a Ticket instance with all parameters initialised and also a limited one - [concert hall], [event code] and
[time].
*/

public class Ticket {
    private static final int ID_MAX_DIGITS_ALLOWED = 4;
    private static final int HALL_NAME_MAX_CHARS = 10;
    private static final int PRICE_PRECISION = 9;
    private static final int WEIGHT_PRECISION = 3;

    private String id;
    private String concertHall;
    private int eventCode;
    private long ticketPurchaseTime;
    private boolean isPromo;
    private char sector;
    private BigDecimal maxWeight;
    private BigDecimal ticketPrice;

    public Ticket() {
    }

    public Ticket(String id, String concertHall, int eventCode, boolean isPromo, char sector, BigDecimal maxWeight, BigDecimal ticketPrice) {
        this.id = id.length() > ID_MAX_DIGITS_ALLOWED ? id.substring(0, ID_MAX_DIGITS_ALLOWED) : id;
        this.concertHall = concertHall.length() > HALL_NAME_MAX_CHARS ? concertHall.substring(0, HALL_NAME_MAX_CHARS) : concertHall;
        this.eventCode = Integer.parseInt(String.valueOf(eventCode).substring(0, 3));
        this.ticketPurchaseTime = System.currentTimeMillis() / 1000L;
        this.isPromo = isPromo;
        setSector(sector);
        setMaxWeight(maxWeight);
        setTicketPrice(ticketPrice);
    }

    public Ticket(String concertHall, int eventCode) {
        this.concertHall = concertHall.length() > HALL_NAME_MAX_CHARS ? concertHall.substring(0, HALL_NAME_MAX_CHARS) : concertHall;
        this.eventCode = Integer.parseInt(String.valueOf(eventCode).substring(0, 3));
        this.ticketPurchaseTime = System.currentTimeMillis() / 1000L;
    }
    // Assuming that we dont know exceptions YET
    public void setMaxWeight(BigDecimal maxWeight){
        if(maxWeight!=null){
            this.maxWeight = maxWeight.setScale(WEIGHT_PRECISION, RoundingMode.HALF_UP);
        }
        else{
            System.out.println("Weight is null, no rounding will be performed");
        }
    }
    // Assuming that we dont know exceptions YET
    public void setTicketPrice(BigDecimal ticketPrice) {
        if(ticketPrice!=null){
            this.ticketPrice = ticketPrice.setScale(PRICE_PRECISION,RoundingMode.HALF_UP);
        }
        else{
            System.out.println("Price is null, no rounding will be performed");
        }
    }

    public void setSector(char sector) {
        if (sector == 'A' || sector == 'B' || sector == 'C') {
            this.sector = sector;
        } else {
            System.out.println("Sector must be one of following: A, B, C");
        }
    }

    @Override
    public String toString() {
        return "Ticket " +
                "id='" + id + '\'' +
                ", concertHall - '" + concertHall + '\'' +
                ", eventCode - " + eventCode +
                ", ticketPurchaseTime - " + DateFormat.getInstance().format(ticketPurchaseTime) +
                ", isPromo - " + isPromo +
                ", sector - " + sector +
                ", maxWeight - " +  maxWeight +
                ", ticketPrice - " + ticketPrice +
                '}';
    }
}
