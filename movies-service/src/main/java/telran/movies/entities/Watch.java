package telran.movies.entities;
import java.time.LocalDateTime;

import javax.persistence.*;
@Entity
@Table(name="watches")
public class Watch {
	@Id
	@GeneratedValue
	long watchId;
LocalDateTime dateTime;
int ticketCost;
int tickets;
@ManyToOne
Cinema cinema;
@ManyToOne
Movie movie;
public Watch() {
}
public Watch(LocalDateTime dateTime, int ticketCost, int tickets, Cinema cinema, Movie movie) {
	super();
	this.dateTime = dateTime;
	this.ticketCost = ticketCost;
	this.tickets = tickets;
	this.cinema = cinema;
	this.movie = movie;
}
public long getWatchId() {
	return watchId;
}
public LocalDateTime getDateTime() {
	return dateTime;
}
public int getTicketCost() {
	return ticketCost;
}
public int getTickets() {
	return tickets;
}
public Cinema getCinema() {
	return cinema;
}
public Movie getMovie() {
	return movie;
}
@Override
public String toString() {
	return "Watch [watchId=" + watchId + ", dateTime=" + dateTime + ", ticketCost=" + ticketCost + ", tickets="
			+ tickets + ", cinema=" + cinema + ", movie=" + movie + "]";
}

}
