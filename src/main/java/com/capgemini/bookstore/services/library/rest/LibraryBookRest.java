package com.capgemini.bookstore.services.library.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookstore.common.bo.BookBo;
import com.capgemini.bookstore.core.books.BookMaintenance;
import com.capgemini.bookstore.services.library.to.LibraryBookTo;
import com.capgemini.bookstore.services.library.to.builder.LibraryBookToBuilder;

import ma.glasnost.orika.MapperFacade;

@RestController
@RequestMapping(value = "/services/rest")
public class LibraryBookRest {

	@Autowired
	private BookMaintenance service;

	@Autowired
	private MapperFacade mapper;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<LibraryBookTo> getBooks() {
		return mapper.mapAsList(service.readBooks(), LibraryBookTo.class);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public void addBook(@RequestBody LibraryBookTo book) {
		service.addBook(mapper.map(book, BookBo.class));
	}

}
