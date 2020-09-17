package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/example")
public class ExampleController {

	@Autowired
    private ExampleService service;

    @GetMapping
    public ResponseEntity<Example> execute(){
		Example entity = service.save();
		Long id = entity.getId();
		LocalDateTime envio = LocalDateTime.now();
		LocalDateTime timeout = envio.plusSeconds(30);
		do {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
				throw new IllegalStateException(e);
			}
			System.err.println(service.get(id));
		}
		while (LocalDateTime.now().isBefore(timeout));
		return ResponseEntity.ok(service.get(id));
    }
    

    @GetMapping("{id}")
    public ResponseEntity<Example> update(@PathVariable(value = "id") final Long id){
    	return ResponseEntity.ok(service.update(id));
    }
}
