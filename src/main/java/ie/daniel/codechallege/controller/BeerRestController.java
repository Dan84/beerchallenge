package ie.daniel.codechallege.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.daniel.codechallege.model.Beer;
import ie.daniel.codechallege.model.BeerRepository;


@RestController
@RequestMapping("/beers")
public class BeerRestController {
@Autowired	
BeerRepository beerRepository;
	
	@RequestMapping("")
	public List<Beer> listBeers(){
		return  (List<Beer>) beerRepository.findAll();
	}
	
	@RequestMapping("/{id}")
	public Beer showBeer(@PathVariable Integer id){
		return beerRepository.findOne(id);
	}
	
	@RequestMapping("/random")
	public Beer randomBeer(){
		
		Random random = new Random();		
		Beer beer = beerRepository.findOne(random.nextInt(beerRepository.findAll().size())+1);		
		return beer;		
	}
	
	

}
