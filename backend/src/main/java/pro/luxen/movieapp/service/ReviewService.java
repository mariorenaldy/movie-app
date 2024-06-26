package pro.luxen.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.luxen.movieapp.model.Review;
import pro.luxen.movieapp.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}

