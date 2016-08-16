package ie.daniel.codechallege.model;


import org.springframework.data.jpa.repository.JpaRepository;
//BeerRepository used to perform CRUD operations on the database
public interface BeerRepository extends JpaRepository<Beer, Integer> {
	
	
}
