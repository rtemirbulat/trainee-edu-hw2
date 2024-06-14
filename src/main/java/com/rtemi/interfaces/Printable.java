package com.rtemi.interfaces;

public interface Printable {
    default void printContent(){
        System.out.println("print content in console");
    }
}
