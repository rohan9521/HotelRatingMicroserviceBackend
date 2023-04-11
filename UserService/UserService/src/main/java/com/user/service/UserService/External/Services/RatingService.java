
@FeignClient(name="RATING-Service")
public interface RatingService{
    @GetMapping("hotels/{hotelId}")
    Rating getRating(@PathVariable("ratingId") String hotelId); 
    //@PathVariable("hotelId") is because if hotelId name from getmapping 
    //doesnt match with variable name then else no need to right;
}