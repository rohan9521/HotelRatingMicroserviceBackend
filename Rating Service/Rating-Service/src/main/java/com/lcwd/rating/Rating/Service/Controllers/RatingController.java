@RestController
@RequestMapping("/ratings")
public class RatingController{
	@AutoWired
	private ratingService RatingService;
	//create
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating ratingNew = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingNew);
	}	

 	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		List<Rating> ratingList = ratingService.getRatings();
		return ResponseEntity.ok(ratingList);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<Rating> getRatingByHotelId(@PathVariable String hotelid){
		Rating ratingByHotel = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingByHotel);
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<Rating> getRatingByUserId(@PathVariable String userId){
		Rating ratingByUser = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingByUser);
	}
}