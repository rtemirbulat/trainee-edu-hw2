package com.rtemi.model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class TicketUID {
    private int ticketUid;
    protected TicketUID(){
    }
    protected TicketUID(int ticketUid) {
        this.ticketUid = this.ticketUid;
    }

    public int getTicketUid() {
        return ticketUid;
    }

    public void setTicketUid(int ticketUid) {
        this.ticketUid = ticketUid;
    }
}
