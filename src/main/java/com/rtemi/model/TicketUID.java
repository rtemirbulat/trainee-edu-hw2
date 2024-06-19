package com.rtemi.model;

public abstract class TicketUID {
    private int classId;
    protected TicketUID(){
    }
    protected TicketUID(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
