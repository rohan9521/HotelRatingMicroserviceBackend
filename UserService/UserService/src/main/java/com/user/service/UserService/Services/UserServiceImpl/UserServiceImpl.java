@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRespository userRepository;

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
		return repository.getUser(user).orElseThrow(()->new ResourceNotFoundException("User Not Found with"+userID));
	}
}