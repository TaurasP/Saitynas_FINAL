package lt.viko.eif.tpetrauskas.saitynas_final.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Joke entity is used for joke's creation.
 */
@Entity
@Getter
@Setter
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
}
