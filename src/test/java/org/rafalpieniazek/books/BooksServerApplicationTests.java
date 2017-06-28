package org.rafalpieniazek.books;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rafalpieniazek.books.BooksServerApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BooksServerApplication.class)
@WebAppConfiguration
public class BooksServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
