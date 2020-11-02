package telran.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.movies.entities.Watch;

public interface WatchRepository extends JpaRepository<Watch, Long> {

}
