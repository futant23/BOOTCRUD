package one.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findByName(String name);
	
	List<Person> findByAge(int age);
	
	Person findById(String id);
	
	List<Person> findAll();
}
