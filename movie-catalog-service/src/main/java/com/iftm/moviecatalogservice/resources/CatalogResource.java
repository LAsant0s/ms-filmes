package com.iftm.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.moviecatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	
	@GetMapping("/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable String userID) {
		return Collections.singletonList(
			new CatalogItem("Transformes", "Filme de Robô", 3)
		);
	}
	
	
}
