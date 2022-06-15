package lt.viko.eif.tpetrauskas.saitynas_final.repository;

import lt.viko.eif.tpetrauskas.saitynas_final.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JokeRepository extends functionality from JpaRepository for DB CRUD operations.
 */
@Repository
public interface JokeRepository extends JpaRepository<Joke, Integer> {
}
