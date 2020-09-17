package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExampleService {

	@Autowired
	private ExampleRepository repository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
	public Example get(final Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
	public Example save() {
		return repository.save(Example.builder()
				.value("NOT OK")
				.build());
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
	public Example update(final Long id) {
		Example entity = repository.getOne(id);
		entity.setValue("OK");
		Example save = repository.save(entity);
		System.err.println(save);
		return save;
	}
}
