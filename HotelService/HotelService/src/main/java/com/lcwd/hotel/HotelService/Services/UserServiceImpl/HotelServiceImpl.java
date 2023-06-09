@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private respository HotelRepository;

	@Override
	public Hotel createHotel(hotel Hotel){
		String randomHotelId = UUID.randomUUID.toString();
		hotel.setHotelId(randomHotelId);
		return respository.create(Hotel);
	}

	@Override
	public List<Hotel> getAllHotel(){
		return repository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId){
		return repository.findBy(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel Not Found with"+HotelID));
	}
}