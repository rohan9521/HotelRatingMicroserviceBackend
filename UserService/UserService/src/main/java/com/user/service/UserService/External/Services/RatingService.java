
@FeignClient(name="RATING-Service")
public interface RatingService{
    @GetMapping("ratings/{ratingId}")
    Rating getRating(@PathVariable("ratingId") String ratingId); 
    //@PathVariable("hotelId") is because if hotelId name from getmapping 
    //doesnt match with variable name then else no need to right;

    @PostMapping("/ratings")
    public Rating createRating(Rating value);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable ratingId,Rating rating);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable ratingId,Rating rating);


}