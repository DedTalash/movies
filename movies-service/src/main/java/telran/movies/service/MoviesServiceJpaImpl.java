package telran.movies.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import telran.movies.repo.*;
import telran.movies.dto.*;

import telran.movies.entities.*;
import telran.movies.service.api.MoviesService;
@Service
public class MoviesServiceJpaImpl implements MoviesService {
@Autowired 
CinemaRepository cinemaRepo;
@Autowired 
MovieRepository movieRepo;
@Autowired 
WatchRepository watchRepo;
	@Override
	public void addMovie(MovieDto movieDto) {
	
		if (movieRepo.existsById(movieDto.name)) {
			throw new RuntimeException("Movie already exists " + movieDto.name); 
		}
		Movie movie = toMovie(movieDto);
		movieRepo.save(movie);

	}

	private Movie toMovie(MovieDto movieDto) {
		
		return new Movie(movieDto.name, movieDto.producer, movieDto.year);
	}

	@Override
	public MovieDto getMovie(String name) {
		return toMovieDto(movieRepo.findByName(name));
	}

	@Override
	public List<MovieDto> getMoviesProducer(String producer) {
		
		return toListMovieDto(movieRepo.findByProducer(producer));
	}

	private List<MovieDto> toListMovieDto(List<Movie> movies) {
		
		return movies.stream().map(this::toMovieDto).collect(Collectors.toList());
	}
	private MovieDto toMovieDto(Movie movie) {
		MovieDto res = new MovieDto();
		res.name = movie.getName();
		res.producer = movie.getProducer();
		res.year = movie.getYear();
		return res;
	}

	@Override
	public List<MovieDto> getMoviesYears(int yearFrom, int yearTo) {
		return toListMovieDto(movieRepo.findByYearsFromTo(yearFrom, yearTo));
	}

	@Override
	public void deleteMovie(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MovieDto> getMovies() {
		return toListMovieDto(movieRepo.findAllMovies());
	}

	@Override
	public void addCinema(CinemaDto cinemaDto) {
		if(cinemaRepo.existsById(cinemaDto.name)) {
			throw new RuntimeException("Cinema already exists " + cinemaDto.name);
		}
		Cinema cinema = toCinema(cinemaDto);
		cinemaRepo.save(cinema);

	}

	private Cinema toCinema(CinemaDto cinemaDto) {
		
		return new Cinema(cinemaDto.name, cinemaDto.city, cinemaDto.places);
	}

	@Override
	public void addWatch(WatchDto watchDto) {
	Cinema cinema = cinemaRepo.findById(watchDto.cinemaName).orElse(null);
	if (cinema == null) {
		throw new RuntimeException("no cinema " + watchDto.cinemaName);
	}
	Movie movie = movieRepo.findById(watchDto.movieName).orElse(null);
	if (movie == null) {
		throw new RuntimeException("no movie " + watchDto.movieName);
	}
	LocalDateTime dateTime = LocalDateTime.parse(watchDto.dateTime);
	
	Watch watch = new Watch(dateTime, watchDto.ticketCost, watchDto.tickets, cinema, movie);
	watchRepo.save(watch);

	}

	@Override
	public List<MovieDto> moviesWatchesGreaterThan(int nWatches) {
		return null;
	}

	@Override
	public List<MovieDto> mostPopularMovies(int amount) {
		// TODO get <amount> movies with biggest number of the tickets in watches
		return null;
	}

	@Override
	public List<CinemaDto> profitableCinemas() {
		
		return toListCinemaDto(cinemaRepo.findProfitableCinemas());
	}

	private List<CinemaDto> toListCinemaDto(List<Cinema> cinemas) {
		
		return cinemas.stream().map(this::toCinemaDto).collect(Collectors.toList());
	}
private CinemaDto toCinemaDto(Cinema cinema) {
	CinemaDto res = new CinemaDto();
	res.city = cinema.getCity();
	res.name = cinema.getName();
	res.places = cinema.getPlaces();
	return res;
}
	@Override
	public List<MovieDto> profitableMoviesCity(String city) {
		// TODO get all movies with profit greater than average profit for all movies in the given city
		return null;
	}

	@Override
	public List<CinemaDto> cinemasLeastMovieWatchesProducer(int nCinemas, String producer) {
		// TODO get the given number of cinemas of the given producer with least number of watches
		return null;
	}

	@Override
	public void updateProducer(String movieName, String producer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MovieCinemaTickets> getMoviesCinemasTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CinemaProfit> getCinemasProfits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCinemasLessProfit(long profit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePlaces(String cinemaName, int places) {
		// TODO Auto-generated method stub

	}

	@Override
	public CinemaDto getCinema(String cinemaName) {
		// TODO get info about cinema with the given name
		return null;
	}

	@Override
	public List<CinemaDto> getCinemas() {
		// TODO get data about all cinemas
		return null;
	}

}
