package com.capgemini.bookstore.services.library.rest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.capgemini.bookstore.common.bo.BookBo;

import ma.glasnost.orika.MapperFacade;

@RunWith(SpringRunner.class)
@RestClientTest(LibraryBookAdapter.class)
@SpringBootTest
public class BookDeletionTest {

	@Value("${library.url}")
	private String libraryUrl;

	@MockBean
	private MapperFacade mapperFacade;

	@Autowired
	private LibraryBookAdapter service;

	private MockRestServiceServer server;

	@Before
	public void setUp() {
		server = MockRestServiceServer.createServer(service.getRestTemplate());
	}

	@Test
	public void shouldRequestBookDeletion() throws Exception {
		// given
		this.server.expect(requestTo(libraryUrl)).andExpect(method(HttpMethod.POST))
				.andRespond(withStatus(HttpStatus.OK));

		// when
		this.service.sendBookDeletionRequest(new BookBo());

		// then
		server.verify();
	}

}
