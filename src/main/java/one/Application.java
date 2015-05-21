package one;

import one.controller.PersonController;
import one.domain.Person;
import one.domain.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private static final Logger log =LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonController personController;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}

	@Override public void run(String... args) throws Exception {
		log.info("run()");
		
		log.info("clearing repository ...");
		personRepository.deleteAll();
                
                log.info("seeding db ...");
                   
                for(int i =0; i<5000; i++){
                    Person person =new Person();
                    person.setName("Brian "+i);
                    person.setAge(i);
                    personRepository.save(person);
                }
                
                log.info("done seeding db ...");
	}
}
