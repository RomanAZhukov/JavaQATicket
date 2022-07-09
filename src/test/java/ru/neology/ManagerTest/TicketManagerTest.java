package ru.neology.ManagerTest;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import ru.neology.repository.TicketRepository;
import ru.neology.ticketmanager.TicketManager;
import ru.neology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 200, "SVO", "KZN", 130);
    Ticket ticket2 = new Ticket(2, 800, "VKO", "LED", 480);
    Ticket ticket3 = new Ticket(3, 300, "VOZ", "DME", 45);
    Ticket ticket4 = new Ticket(4, 400, "KUF", "GOJ", 90);
    Ticket ticket5 = new Ticket(5, 550, "IST", "AER", 180);
    Ticket ticket6 = new Ticket(6, 800, "VKO", "LED", 480);
    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldSearchOneTicket() {
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("SVO", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralTickets() {
        Ticket[] expected = {ticket2, ticket6};
        Ticket[] actual = manager.findAll("VKO", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("VKO", "KZN");

        assertArrayEquals(expected, actual);
    }
}