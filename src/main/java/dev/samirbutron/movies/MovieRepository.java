package dev.samirbutron.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Se comunica con la base de datos
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //Use automatic queries
    Optional<Movie> findMovieByImdbId(String imdbId);
}
