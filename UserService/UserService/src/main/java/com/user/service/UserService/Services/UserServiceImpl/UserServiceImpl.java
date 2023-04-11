@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private RestTemplate restTemplate; 
	
	@Autowired
	private UserRespository userRepository;

	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user){
		String randomUserId = UUID.randomUUID.toString();
		user.setUserId(randomUserId);
		return repository.save(user);
	}

	@Override
	public List<User> getAllUser(){
		return repository.findAll();
	}

	@Override
	public User getUser(String userId){
		User user = repository.getUser(user).orElseThrow(()->new ResourceNotFoundException("User Not Found with"+userID));
		//Earlier \|/
		//ArrayList<Ratings> ratings = restTemplate.getForObject("https://localhost:8081/users/"+user.getUserId(),ArrayList.class);
		//But this has some problem .. it converts to arraylist of linkedhashmap and not arrayList of ratings so 
		//below implementation is correct.
		Rating[] ratings[] = restTemplate.getForObject("https://RATING-Service/users/"+user.getUserId(),Rating[].class);

		ArrayList<Rating> ratingList  = Arrays.stream(ratings).toList();

		List<Rating> ratingListWithHotel = ratingList.stream().map{rating->
	//		Hotel hotel = restTemplate.getForObject("https://HOTEL_SERVICE/users/"+rating.getHotelId(),Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}.collect(Collections.toList());
		
		user.setRatings(ratingListWithHotel);
		return user;
	}
}