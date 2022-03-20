 package com.home.serviceManagement.backend;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
//@EnableJpaRepositories("com.izeye.throwaway.data")
//@EnableElasticsearchRepositories("com.izeye.throwaway.indexing")
public class BackendApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		 logger.info("Application launch");
		SpringApplication.run(BackendApplication.class, args);
	}

}
