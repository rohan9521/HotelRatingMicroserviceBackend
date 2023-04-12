@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private respository RatingRepository;

	@Override
	public Rating createRating(Rating rating){
		String randomHotelId = UUID.randomUUID.toString();
		rating.setRatingId(randomHotelId);
		return respository.create(rating);
	}

	@Override
	public List<Rating> getAllRatings(){
		return repository.findAll();
	}

	@Override
	public Rating getRatingByHotelId(String hotelId){
		return repository.findBy(hotelId).orElseThrow(()->new ResourceNotFoundException("Rating Not Found with"+HotelID));
	}

	@Override
	public List<Rating> getRatingByUserId(String userId){
		return repository.findBy(userId).orElseThrow(()->new ResourceNotFoundException("Rating Not Found with"+HotelID));
	}

	@Override
	public Rating updateRating(String ratingId,Rating rating){
		return repository.updateRating(rating)
	}

	@Override
	public void deleteRating(String ratingId){
		 repository.deleteById(ratingId);
	}
}