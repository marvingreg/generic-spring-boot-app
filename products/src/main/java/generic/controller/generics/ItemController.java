package generic.controller.generics;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generic.model.generics.Items;
import generic.services.generics.GenericService;

@RestController
@RequestMapping("/api/items")
public class ItemController extends GenericController<Items> {

	public ItemController(GenericService<Items> service) {
		super(service);
	}

}
