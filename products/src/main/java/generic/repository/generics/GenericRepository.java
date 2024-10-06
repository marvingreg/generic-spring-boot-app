package generic.repository.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import generic.model.generics.GenericModel;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel<T>> extends JpaRepository<T, Long> {

}
