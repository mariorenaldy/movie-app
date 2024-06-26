package pro.luxen.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.luxen.movieapp.model.Review;
import pro.luxen.movieapp.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }
}
