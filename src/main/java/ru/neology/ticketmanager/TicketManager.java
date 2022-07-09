package ru.neology.ticketmanager;
import ru.neology.domain.Ticket;
import ru.neology.repository.TicketRepository;

public class TicketManager {

    private final TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket newTicket) {
        repository.add(newTicket);
    }




    public Ticket [] findAll(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getSaveTickets()) {
            if (matches(ticket, departureAirport, arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }


        return result;

    }


    public boolean matches(Ticket ticket, String departureAirport, String arrivalAirport) {

        if (ticket.getDepartureAirport().contains(departureAirport)) {
            return ticket.getArrivalAirport().contains(arrivalAirport);
        }

        return false;
    }

}
