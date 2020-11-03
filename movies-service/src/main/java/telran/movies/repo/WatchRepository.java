package telran.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.movies.dto.CinemaProfit;
import telran.movies.dto.MovieCinemaTickets;
import telran.movies.entities.Watch;

public interface WatchRepository extends JpaRepository<Watch, Long> {

	List<Watch> findByMovieName(String name);
@Query(value="select name as cinema, coalesce(sum(ticket_cost * tickets),0)"
		+ " as profit from cinemas left join watches on name=cinema_name group by name order by"
		+ " coalesce(sum(ticket_cost * tickets),0)", nativeQuery = true)
	List<CinemaProfit> findCinemasProfits();
/************************************************************************/
List<MovieCinemaTickets> findMoviesCinemasTickets();


}
