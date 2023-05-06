package dev.samirbutron.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate; //Otra forma de comunicarse con la DB y simplifica funciones dificiles de ejecutar

    public Review createReview(String reviewBody, String imdbId){
        Review review = new Review(reviewBody);
        reviewRepository.insert(review);
        mongoTemplate.update(Movie.class) //Clase que queremos actualizar
                .matching(Criteria.where("imdbId").is(imdbId)) //Encontramos los datos de la pelicula a actualizar
                .apply(new Update().push("reviewIds").value(review)) //actualizamos dentro del campo de la pelicula
                .first();
        return review;
    }
}
