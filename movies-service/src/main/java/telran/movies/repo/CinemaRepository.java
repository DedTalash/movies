package telran.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.movies.entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, String>{

//	@Query(value="select * from  cinemas where name in (select cinema_name from "
//			+ " watches  group by cinema_name  having"
//			+ " avg(ticket_cost*tickets) >"
//			+ " (select avg(ticket_cost*tickets) from watches)) ", nativeQuery = true)
//	List<Cinema> findProfitableCinemas();

	@Query(value = "SELECT * FROM cinemas WHERE name in " +
		"(SELECT cinemas_name FROM watches GROUP BY cinemas_name " +
		"ORDER BY SUM(ticket_cost*tickets) DESC LIMIT (SELECT COUNT(*)/3 FROM cinemas))", nativeQuery = true)
	List<Cinema> findProfitableCinemas();

}
