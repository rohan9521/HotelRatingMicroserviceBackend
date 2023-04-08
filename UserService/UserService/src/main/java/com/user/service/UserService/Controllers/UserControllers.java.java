@RestController
@RequestMapping("/users")
public class UserController{
	@AutoWired
	private UserService userService;
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User userNew = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATEDy).body(userNew);
}	
 
	
	//get single user
@GetMapping("/{userId}")
public ResponseEntity<User> getSingleUser(@PathVariable String UserId){
	User retireivedUser = userService.getUser(userId);
	return ResponseEntity.ok(retireivedUser);
}
@GetMapping
public ResponseEntity<User> getSingleUser(@PathVariable String Userid){
	List<User> allUser = userService.getAllUser();
	return ResponseEntity.ok(allUser);
}
}