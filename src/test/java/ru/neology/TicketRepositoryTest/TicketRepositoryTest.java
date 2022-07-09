package ru.neology.TicketRepositoryTest;
import org.junit.jupiter.api.Test;
import ru.neology.domain.Ticket;
import ru.neology.repository.TicketRepository;

import ru.neology.ticketmanager.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 200, "SVO", "KZN", 130);
    Ticket ticket2 = new Ticket(2, 800, "VKO", "LED", 480);
    Ticket ticket3 = new Ticket(3, 300, "VOZ", "DME", 45);
    Ticket ticket4 = new Ticket(4, 400, "KUF", "GOJ", 90);
    Ticket ticket5 = new Ticket(5, 550, "IST", "AER", 180);
    Ticket ticket6 = new Ticket(6, 650, "TLV", "HEL", 480);

    @Test
    public void emptyRepo() {
        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneTicket() {
        repo.add(ticket3);

        Ticket[] expected = {ticket3};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveSeveralTickets() {
        repo.add(ticket1);
        repo.add(ticket3);
        repo.add(ticket5);

        Ticket[] expected = {ticket1, ticket3, ticket5};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveById() {
        repo.add(ticket4);
        repo.add(ticket6);
        repo.add(ticket2);
        repo.removeTicketById(2);

        Ticket[] expected = {ticket4, ticket6};
        Ticket[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenIDNotFound() {
        repo.add(ticket2);
        repo.add(ticket5);
        repo.add(ticket3);


        assertThrows(NotFoundException.class, () -> {
            repo.removeTicketById(4);
        });
    }



}
