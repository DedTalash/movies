package telran.movies.entities;
import javax.persistence.*;
@Entity
@Table(name="movies")
public class Movie {
@Id
	String name;
String producer;
int year;
public Movie() {
	
}
public Movie(String name, String producer, int year) {
	super();
	this.name = name;
	this.producer = producer;
	this.year = year;
}
@Override
public String toString() {
	return "Movie [name=" + name + ", producer=" + producer + ", year=" + year + "]";
}
public String getName() {
	return name;
}
public String getProducer() {
	return producer;
}
public int getYear() {
	return year;
}


}
