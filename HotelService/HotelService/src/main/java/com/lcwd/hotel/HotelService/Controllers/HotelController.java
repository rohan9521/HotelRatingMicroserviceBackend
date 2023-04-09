@RestController
@RequestMapping("/hotels")
public class HotelController{
	@AutoWired
	private HotelService HotelService;
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody hotel Hotel){
		Hotel hotelNew = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelNew);
	}	
 
	
	//get single Hotel
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
		List<Hotel> allHotel = HotelService.getHotel(hotelId);
		return ResponseEntity.ok(allHotel);
	}
		//get single Hotel
	@GetMapping
	public ResponseEntity<Hotel> getSingleHotel(){
		List<Hotel> allHotel = HotelService.getAllHotel();
		return ResponseEntity.ok(allHotel);
	}
}