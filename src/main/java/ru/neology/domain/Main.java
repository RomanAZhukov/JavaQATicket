package ru.neology.domain;


public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket(
                1,
                2000,
                "VKO",
                "KZN",
                150
        );


        Ticket ticket2 = new Ticket(
                2,
                1000,
                "SVO",
                "KZN",
                90
        );
        System.out.println(ticket1.compareTo(ticket2));
        System.out.println(ticket2.compareTo(ticket1));
    }
}
