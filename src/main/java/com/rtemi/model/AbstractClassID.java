package com.rtemi.model;

public abstract class AbstractClassID {
    private int classId;
    protected AbstractClassID(){
    }
    protected AbstractClassID(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
