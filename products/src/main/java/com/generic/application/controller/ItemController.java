package com.generic.application.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generic.application.model.Items;
import com.generic.application.services.GenericService;
import com.generic.application.services.ItemService;

@RestController
@RequestMapping("api/items")
public class ItemController extends GenericController<Items>{

	public ItemController(GenericService<Items> service) {
		super(service);
	}

}
