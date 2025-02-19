package com.bridgelabz.datastructures.linkedlist;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket last;
    private int count;

    public TicketReservationSystem() {
        this.last = null;
        this.count = 0;
    }

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        count++;
    }

    public void removeTicket(int ticketId) {
        if (last == null) return;
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) last = prev;
                }
                count--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }

    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Name: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    public void searchTicket(String query) {
        if (last == null) return;
        Ticket current = last.next;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Name: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            }
            current = current.next;
        } while (current != last.next);
    }

    public int totalTickets() {
        return count;
    }
}

class TicketReservationMain {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "Vibhor", "Inception", "A12", "10:30 AM");
        system.addTicket(2, "Shreyas", "Interstellar", "B5", "12:00 PM");
        system.addTicket(3, "Jean", "DDLJ", "C8", "02:00 PM");

        system.displayTickets();
        System.out.println("Total Tickets: " + system.totalTickets());

        system.searchTicket("Inception");

        system.removeTicket(2);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.totalTickets());
    }
}

