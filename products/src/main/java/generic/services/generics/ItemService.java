package generic.services.generics;

import org.springframework.stereotype.Service;

import generic.model.generics.Items;
import generic.repository.generics.GenericRepository;

@Service
public class ItemService extends GenericService<Items>{

	public ItemService(GenericRepository<Items> repository) {
		super(repository);
	}

}
