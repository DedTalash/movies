package telran.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.movies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

	@Query(value = "select * from movies where producer=:producer", nativeQuery = true)
	List<Movie> findByProducer(@Param("producer") String producer);

	@Query(value = "select * from movies", nativeQuery = true)
	List<Movie> findAllMovies();

	@Query(value = "SELECT * FROM movies WHERE year >= :yearFrom AND year <= :yearTo", nativeQuery = true)
	List<Movie> findByYearsFromTo(@Param("yearFrom") int yearFrom, @Param("yearTo") int yearTo);

	@Query(value = "select * from movies where name=:name limit 1", nativeQuery = true)
	Movie findByName(@Param("name") String name);

//	@Query(value = "SELECT name_movies FROM watches WHERE tickets>=:count ", nativeQuery = true)
//	List<Movie> findMoviesWatchesGreaterThan(@Param("name") int count);


}
