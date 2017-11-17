package com.capgemini.bookstore.core.books.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.bookstore.common.bo.BookBo;
import com.capgemini.bookstore.core.books.BookMaintenance;
import com.capgemini.bookstore.persistence.entity.BookEntity;
import com.capgemini.bookstore.persistence.repository.BookRepository;
import com.capgemini.bookstore.services.library.rest.LibraryBookAdapter;

import ma.glasnost.orika.MapperFacade;

@Transactional
@Service
public class BookMaintenanceImpl implements BookMaintenance {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MapperFacade mapper;

	@Autowired
	private LibraryBookAdapter lBAdapter;

	@Override
	public BookBo addBook(BookBo bo) {
		return saveBook(bo);
	}

	@Override
	public BookBo readBook(long id) {
		BookEntity book = this.bookRepository.findOne(id);
		return this.mapper.map(book, BookBo.class);
	}

	@Override
	public List<BookBo> readBooks() {
		List<BookEntity> books = this.bookRepository.findAll();

		List<BookBo> bookBos = books.stream()//
				.map(bookEntity -> this.mapper.map(bookEntity, BookBo.class))//
				.collect(Collectors.toList());

		return bookBos;
	}

	@Override
	public boolean deleteBook(long id) {

		BookEntity book = this.bookRepository.findOne(id);
		if (book != null) {
			lBAdapter.sendBookDeletionRequest(this.mapper.map(book, BookBo.class));

			this.bookRepository.delete(book);
			return true;
		}
		return false;
	}

	@Override
	public BookBo updateBook(BookBo bookTo) {
		return saveBook(bookTo);
	}

	private BookBo saveBook(BookBo bo) {

		System.out.println("Saving book");
		BookEntity book = this.mapper.map(bo, BookEntity.class);
		BookEntity savedBook = this.bookRepository.saveAndFlush(book);
		return this.mapper.map(savedBook, BookBo.class);
	}

}
