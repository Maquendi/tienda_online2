package service.user;

public class DefaultUserServiceImpl implements UserService{

	
	@Override
	public void doLogin() {
		System.out.println("You selected Login");
	}

	@Override
	public void doRegistration() {
		System.out.println("You selected Register");
	}

}
