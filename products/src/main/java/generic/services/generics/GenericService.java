package generic.services.generics;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import generic.model.generics.GenericModel;
import generic.repository.generics.GenericRepository;


public abstract class GenericService <T extends GenericModel<T>>{

	private final GenericRepository<T> repository;

	public GenericService(GenericRepository<T> repository) {
		this.repository = repository;
	}
	
	public Page<T> getPage(Pageable pageable) throws NullPointerException, Exception{

		Page<T> page = Optional.ofNullable(repository.findAll(pageable))
				.orElseThrow(()-> new NullPointerException("No records Found"));
		return page;
	}

	public T get(Long id) throws NullPointerException, Exception {
		T object = repository.findById(id)
				.orElseThrow(()-> new NullPointerException("No record found"));

		return object;
	}
	
	@Transactional
	public T create(T object) throws Exception {
		T objectCreated = repository.save(object);

		return objectCreated;
	}

	@Transactional
	public T update(T object) throws NullPointerException, Exception {
		T objectToUpdate = repository.findById(object.getId())
				.orElseThrow(()-> new NullPointerException("No records found"));
		objectToUpdate.update(object);

		repository.save(objectToUpdate);

		return objectToUpdate;
	}

	@Transactional
	public T delete(Long id) throws NullPointerException, Exception {

		T objectToDelete = repository.findById(id)
				.orElseThrow(()-> new NullPointerException("No record found"));

		repository.delete(objectToDelete);

		return objectToDelete;
	}

}
