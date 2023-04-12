
public interface RatingService{
	Rating createRating(Rating rating)
	
	List<Rating> getAllRatings();

	Rating getRatingByHotelId(String hotelId)
	
	List<Rating> getRatingByUserId(String userId)
	
	Rating updateRating(String ratingId,Rating rating);

	Rating deleteRating(String ratingId);
}