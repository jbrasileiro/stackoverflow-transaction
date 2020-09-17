package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXAMPLE")
public class Example {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column
	private Long id;
	@Column
	private String value;
	
	
}
