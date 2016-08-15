package ie.daniel.codechallege.model;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Integer> {
	
	
}
