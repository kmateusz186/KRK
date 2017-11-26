package com.capgemini.bookstore.services.library.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.bookstore.common.bo.BookBo;
import com.capgemini.bookstore.services.library.to.LibraryBookTo;

import ma.glasnost.orika.MapperFacade;

@Service
public class LibraryBookAdapter {

	@Value("${library.url}")
	private String libraryUrl;

	@Autowired
	private MapperFacade mapper;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	private RestTemplate restTemplate;

	@PostConstruct
	public void buildRestTemplate() {
		this.restTemplate = restTemplateBuilder.build();
	}

	public void sendBookDeletionRequest(BookBo book) {

		restTemplate.postForObject(libraryUrl, mapper.map(book, LibraryBookTo.class), LibraryBookTo.class);
	}

	RestTemplate getRestTemplate() {
		return restTemplate;
	}

}
