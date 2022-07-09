package ru.neology.ticketmanager;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}