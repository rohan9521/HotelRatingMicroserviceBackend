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
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> ratingByUserList = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingByUser);
	}

	@PutMapping("/{ratingId}")
	public ResponseEntity<Rating> updateRating(@PathVariable Rating ratingId,Rating rating){
		Rating rating = ratingService.updateRating(ratingid,rating);
		return ResponseEntity.ok(rating);
	}

	@DeleteMapping("/{ratingId}")
	public ResponseEntity<boolean> deleteRating(@PathVariable Rating ratingId){
		try{
			ratingService.deleteRating(ratingid);
			return ResponseEntity.ok(true);
		}catch(Exception e){
			return ResponseEntity.badRequest(false).body(e.message);
		}
	
	}
}