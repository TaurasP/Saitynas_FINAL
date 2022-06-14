package lt.viko.eif.tpetrauskas.saitynas_final.repository;

import lt.viko.eif.tpetrauskas.saitynas_final.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Integer> {
}
