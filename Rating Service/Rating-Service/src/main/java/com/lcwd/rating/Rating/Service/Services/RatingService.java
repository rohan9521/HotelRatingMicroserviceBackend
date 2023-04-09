
public interface RatingService{
	Rating createRating(Rating rating)
	
	List<Rating> getAllRatings();

	Rating getRatingByHotelId(String hotelId)
	
	Rating getRatingByUserId(String userId)
	
	//TODO
	//userupdate
	//userdelete
}