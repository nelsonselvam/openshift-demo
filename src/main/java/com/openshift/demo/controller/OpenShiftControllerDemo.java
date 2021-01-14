package com.openshift.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenShiftControllerDemo {
	
	@RequestMapping("/")
    public String index() {
        return "App Deployed successfully!";
    }
	
	@GetMapping("/book")
	public ResponseEntity<Response> getBookSuggestion() {

		String name = "Reader";
		
		Optional<Book> bookSuggestion = getBooks().stream().filter(predicate -> predicate.getBookId() == getRandom())
				.findFirst();
		ServiceMessage serviceMessage = new ServiceMessage();
		HttpStatus httpStatus = HttpStatus.OK;
		Response response = new Response();

		if (!StringUtils.isEmpty(name)) {
			if (bookSuggestion.isPresent()) {
				bookSuggestion.get()
						.setBookLabel("Hello " + name + ". Here is the book suggestion for the day. Read well!");
				response.setSuggestedBook(bookSuggestion.get());
			} else {
				Book book = new Book();
				book.setBookLabel("Oops! Sorry " + name + ". I've just ran out of book suggestions!");
				response.setSuggestedBook(book);
			}
			serviceMessage.setCode("200");
			serviceMessage.setType("Success");
			serviceMessage.setDescription("Information Retrieved Successfully");
		} else {
			serviceMessage.setCode("400");
			serviceMessage.setType("Bad Request");
			serviceMessage.setDescription("Please check the request");
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		response.setServiceMessage(serviceMessage);

		return new ResponseEntity<>(response, httpStatus);

	}

	private List<Book> getBooks() {

		List<Book> books = new ArrayList<>();

		Map<String, String> book1 = new HashMap<>();
		book1.put("Alchemist, The", "Coelho, Paulo");
		book1.put("Nudge", "Thaler, Richard; Sunstein, Cass R.");
		book1.put("Residence on Earth", "Neruda, Pablo");
		book1.put("The 7 Habits of Highly Effective People", "Cover, Stephen R");
		book1.put("Atomic Habits", "Clear, James");

		for (Entry<String, String> book : book1.entrySet()) {
			int idx = 1;
			Book bookIterator = new Book();
			bookIterator.setBookId(idx);
			bookIterator.setAuthors(book.getValue());
			bookIterator.setBookName(book.getKey());
			idx = idx + 1;
			books.add(bookIterator);
		}

		return books;
	}

	private int getRandom() {

		Random random = new Random();

		int rand = 1;

		while (true) {
			rand = random.nextInt(6);
			if (rand != 0)
				break;
		}
		return rand;
	}
}
