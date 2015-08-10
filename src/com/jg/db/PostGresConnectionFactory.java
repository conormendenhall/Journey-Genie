package com.jg.db;

public class PostGresConnectionFactory {
	//Google Singleton Pattern
	private PostGresConnectionFactory() {
		
	}

	private static final PostGresConnectionFactory INSTANCE = new PostGresConnectionFactory();
	
	public static PostGresConnectionFactory getSingleton(){
        return INSTANCE;
    }
	
	
}
