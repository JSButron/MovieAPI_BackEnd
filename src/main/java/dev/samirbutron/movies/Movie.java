package dev.samirbutron.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data //Takes care of all Getter and Setter
@AllArgsConstructor //Creates a constructor that uses all parameters
@NoArgsConstructor // Creates a constructor that uses no parameters at all
public class Movie {
    @Id
    private ObjectId id; // Todos estos identificadores son exactos a los que se encuentran en la Data Base
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //Permite guardar solamente los reviewIds pero los Reviews en otra coleccion de Mongo
    private List<Review> reviewIds;

}
