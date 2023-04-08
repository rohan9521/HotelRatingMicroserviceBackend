
public interface UserService{
	User saveUser(User user);
	
	List<User> getAllUser();

	User getUser(String userId);
	
	//TODO
	//userupdate
	//userdelete
}