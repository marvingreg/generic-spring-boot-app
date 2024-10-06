package generic.model.generics;

public interface GenericModel <T> {
	
	void update(T model);
	
	Long getId();
	
	T generateInstance();
	
	
}
