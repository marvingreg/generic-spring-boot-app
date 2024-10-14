package com.generic.application.services;

import org.springframework.stereotype.Service;

import com.generic.application.model.Items;
import com.generic.application.repository.GenericRepository;

@Service
public class ItemService extends GenericService<Items>{

	public ItemService(GenericRepository<Items> repository) {
		super(repository);
	}

}
