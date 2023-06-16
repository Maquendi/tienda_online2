package service.user;

import java.util.Optional;

public class UserSessionService {
	
	private UserSession user;
	
	private UserSessionService(){}
	
	private static class SingletonHelper {
		
		private static final UserSessionService INSTANCE = new UserSessionService();
	}
	
	public static UserSessionService getInstace() {
		return SingletonHelper.INSTANCE;
	}

	public void setUser(UserSession user) {
		this.user = user;
	}
	
	public Optional<UserSession> getUserSession(){
		return Optional.ofNullable(user);	
	}
}
