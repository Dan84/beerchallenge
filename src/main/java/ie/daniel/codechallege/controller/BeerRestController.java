package ie.daniel.codechallege.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ie.daniel.codechallege.model.Beer;
import ie.daniel.codechallege.model.BeerRepository;


@RestController
@RequestMapping("/beers")
public class BeerRestController {
@Autowired	
BeerRepository beerRepository;
	
	//FIND ALL 
	@RequestMapping(method = RequestMethod.GET)
	public List<Beer> listBeers(){
		return  beerRepository.findAll();
	}
	
	
	//FIND ONE
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Beer showBeer(@PathVariable Integer id){
		return beerRepository.findOne(id);
	}	
	
	
	//ADD BEER
	@RequestMapping(method = RequestMethod.POST)
	public String createBeer(@RequestBody Beer beer) {
        
        try {
        	beerRepository.save(beer);
        } catch (Exception e) {
            
            return e.getMessage();
        }
        return "creation successful: " + String.valueOf(beer.getId());
    }
	
	
	//UPDATE BEER
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Beer update(@PathVariable Integer id, @RequestBody Beer beerIn) {
	    Beer beer = beerRepository.findOne(id);
	    beer.setName(beerIn.getName());
	    beer.setDescription(beerIn.getDescription());
	    beer.setPercentage(beerIn.getPercentage());
	    beer.setLocation(beerIn.getLocation());
	   
	    return beerRepository.save(beer);
	  }
	
	
	//DELETE BEER
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBeer(@PathVariable Integer id) {
        try {
            beerRepository.delete(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "deletion successful";
    }
	
	
	//FIND RANDOM BEER
	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public Beer randomBeer(){
		
		Random random = new Random();		
		Beer beer = beerRepository.findOne(random.nextInt(beerRepository.findAll().size())+1);		
		return beer;		
	}
	
	

}
