package com.app.ProspectaEval;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.appRepository.AppRepository;
import com.app.modal.Entities;
import com.app.modal.Entry;
import com.app.modal.RequestDTO;
import com.app.modal.ResponseDTO;

@RestController
public class AppController {

	
	private static String baseUrl = "https://api.publicapis.org";
	
	@Autowired
	RestTemplate restTemplate;
	
//	@Autowired
//	AppRepository appRepository;
	
	
	//For testing only
	@GetMapping(value = "/hi")
	public String sayHello() {
		return "Hello World";
	}
	
	
	//to get all Entries
	@GetMapping(value = "/resources")
	public ResponseEntity<ResponseDTO> getAllEntries(){
		
//		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<ResponseDTO> responseEntity = restTemplate
				.getForEntity(baseUrl+"/entries", ResponseDTO.class);
		
		return responseEntity;
	}
	
	
	
	//Create an API that lists the title, description
   //based on the category passed as an input parameter.
	
	@GetMapping(value = "/resources/{category}")
	public ResponseEntity<List<RequestDTO>> getEntriesByCategory(
			@PathVariable("category")String category
			){
//		RestTemplate restTemplate = new RestTemplate();
		
		List<RequestDTO> list = new ArrayList<>();
		ResponseEntity<ResponseDTO> responseEntity = restTemplate
				.getForEntity(baseUrl+"/entries", ResponseDTO.class);
		
		
		ResponseDTO body = responseEntity.getBody();
		 List<Entry> entries = body.getEntries();
		for(Entry ent : entries) {
			if(ent.getCategory().equalsIgnoreCase(category))
				list.add(new RequestDTO(ent.getAPI(), ent.getDescription()));
			
		}
		
		return new ResponseEntity<List<RequestDTO>>(list, HttpStatus.ACCEPTED);
	}
	
	
	
	//Create an API that would save a new entry with all
//	the relevant properties which retrieves values from 
//	the endpoint GET /entries.
	
	@PostMapping(value = "/saveEntry")
	public ResponseEntity<Entities> saveEntries(){
		
		ResponseEntity<ResponseDTO> responseEntity = restTemplate
				.getForEntity(baseUrl+"/random", ResponseDTO.class);
		
		Entry body = responseEntity
				.getBody()
				.getEntries()
				.get(0);
		
		Entities entity = new Entities(body.getAPI() ,
				body.getDescription() ,
				body.getCategory() );
//		appRepository.save(entity);
		return new ResponseEntity<Entities>( entity,HttpStatus.ACCEPTED);
	}

	
	//Question: what are the key things you would consider when 
    //creating/consuming 
	//an API to ensure that it is secure and reliable?
	
	//-> While consuming an API firstly we need to take care of the structure 
	//of the api data and create DTO classes respective to the field of that APIs
	//field and map all field to the DTO class
	//after we can filter only fields we need by creating another DTO class
	// all these things can be done using RestTemplate 
	//  so we can configure RestTemplate in @SpringBootAnnotation class
	
}
