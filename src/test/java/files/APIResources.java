package files;

public enum APIResources {
	
	GetTokenAPI("/api/auth/login"),
	AuthenticationAPI("/api/auth/me"),
	CreateEventAPI("/api/events");
	private String resource;
	
	APIResources (String resource){
		this.resource=resource;
	}

	public String getResource()
	{
		return resource;
	}
}
