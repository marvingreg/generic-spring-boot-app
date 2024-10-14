package com.generic.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.generic.application.model.GenericModel;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel<T>> extends JpaRepository<T, Long> {

}
