package br.assessment.sorting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.assessment.sorting.SortingService;
import br.assessment.sorting.SortingService.OrderingException;
import br.assessment.sorting.entities.ComparatorParameters;
import br.assessment.sorting.entities.Configuration;
import br.assessment.sorting.entities.Configuration.ComparatorDirection;

public class SortingServiceTest {

	@Test
	public void titleAscOrderTest() {
		List<Book> expected = Arrays.asList(new Book(
				"Head First Design Patterns", "Elisabeth Freeman", 2004),
				new Book("Internet & World Wide Web: How to Program",
						"Deitel & Deitel", 2007), new Book(
						"Java How to Program", "Deitel & Deitel", 2007),
				new Book("Patterns of Enterprise Application Architecture",
						"Martin Fowler", 2002));

		List<ComparatorParameters> params = Arrays
				.asList(new ComparatorParameters("title",
						ComparatorDirection.ASC));
		List<Book> bookList = createBookList();
		
		SortingService service = new SortingService(new Configuration(params));
		service.sortList(bookList);

		assertArrayEquals(expected.toArray(), bookList.toArray());
	}

	@Test
	public void authorAscTitleDescOrderTest() {
		List<Book> expected = Arrays.asList(new Book("Java How to Program",
				"Deitel & Deitel", 2007), new Book(
				"Internet & World Wide Web: How to Program", "Deitel & Deitel",
				2007), new Book("Head First Design Patterns",
				"Elisabeth Freeman", 2004), new Book(
				"Patterns of Enterprise Application Architecture",
				"Martin Fowler", 2002));

		List<ComparatorParameters> params = Arrays.asList(
				new ComparatorParameters("author", ComparatorDirection.ASC),
				new ComparatorParameters("title", ComparatorDirection.DESC));
		List<Book> bookList = createBookList();
		
		SortingService service = new SortingService(new Configuration(params));
		service.sortList(bookList);

		assertArrayEquals(expected.toArray(), bookList.toArray());
	}

	@Test
	public void editionDescAuthorDescTitleAscOrderTest() {
		List<Book> expected = Arrays.asList(new Book(
				"Internet & World Wide Web: How to Program", "Deitel & Deitel",
				2007),
				new Book("Java How to Program", "Deitel & Deitel", 2007),
				new Book("Head First Design Patterns", "Elisabeth Freeman",
						2004), new Book(
						"Patterns of Enterprise Application Architecture",
						"Martin Fowler", 2002));

		List<ComparatorParameters> params = Arrays.asList(
				new ComparatorParameters("edition", ComparatorDirection.DESC),
				new ComparatorParameters("author", ComparatorDirection.DESC),
				new ComparatorParameters("title", ComparatorDirection.ASC));
		List<Book> bookList = createBookList();
		SortingService service = new SortingService(new Configuration(params));
		service.sortList(bookList);
		
		assertArrayEquals(expected.toArray(), bookList.toArray());
	}

	@Test(expected = OrderingException.class)
	public void nullListParamShouldThrowExceptionTest() {
		List<ComparatorParameters> params = Arrays
				.asList(new ComparatorParameters("title",
						ComparatorDirection.ASC));

		SortingService service = new SortingService(new Configuration(params));
		service.sortList(null);
	}

	@Test
	public void emptyListTest() {
		List<Book> bookList = new ArrayList<Book>();
		List<ComparatorParameters> params = Arrays
				.asList(new ComparatorParameters("title",
						ComparatorDirection.ASC));
		SortingService service = new SortingService(new Configuration(params));
		service.sortList(bookList);
		assertTrue(bookList.isEmpty());
	}

	public static List<Book> createBookList() {
		return Arrays.asList(new Book("Java How to Program", "Deitel & Deitel",
				2007), new Book(
				"Patterns of Enterprise Application Architecture",
				"Martin Fowler", 2002), new Book("Head First Design Patterns",
				"Elisabeth Freeman", 2004), new Book(
				"Internet & World Wide Web: How to Program", "Deitel & Deitel",
				2007));
	}
}
