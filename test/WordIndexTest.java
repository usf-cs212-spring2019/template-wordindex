import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("javadoc")
class WordIndexTest {

	Index<String> index;

	@Nested
	public class EmptyIndexTests {

		@BeforeEach
		public void createEmpty() {
			/*
			 * DO NOT CHANGE THIS! If you are getting a compile error, then you have not
			 * implemented the Index interface properly yet.
			 */
			index = new WordIndex();
		}

		@Test
		public void testNumElements() {
			Assertions.assertEquals(0, index.numElements());
		}

		@Test
		public void testNumPositions() {
			Assertions.assertEquals(0, index.numPositions("empty"));
		}

		@Test
		public void testContainsWord() {
			Assertions.assertFalse(index.contains("empty"));
		}

		@Test
		public void testContainsPosition() {
			Assertions.assertFalse(index.contains("empty", 42));
		}

		@Test
		public void testGetElements() {
			Assertions.assertTrue(index.getElements().isEmpty());
		}

		@Test
		public void testGetPositions() {
			Assertions.assertTrue(index.getPositions("empty").isEmpty());
		}

		@Nested
		public class SingleAddTests {

			@BeforeEach
			public void createEmpty() {
				index.add("answer", 42);
			}

			@Test
			public void testNumElements() {
				Assertions.assertEquals(1, index.numElements());
			}

			@Test
			public void testNumPositions() {
				Assertions.assertEquals(1, index.numPositions("answer"));
			}

			@Test
			public void testContainsWord() {
				Assertions.assertTrue(index.contains("answer"));
			}

			@Test
			public void testContainsPositionFalse() {
				Assertions.assertFalse(index.contains("answer", 0));
			}

			@Test
			public void testContainsPositionTrue() {
				Assertions.assertTrue(index.contains("answer", 42));
			}

			@Test
			public void testGetElements() {
				Assertions.assertTrue(index.getElements().contains("answer"));
			}

			@Test
			public void testGetPositions() {
				Assertions.assertTrue(index.getPositions("answer").contains(42));
			}

			@Test
			public void testGetElementsSize() {
				Assertions.assertEquals(1, index.getElements().size());
			}

			@Test
			public void testGetPositionsSize() {
				Assertions.assertEquals(1, index.getPositions("answer").size());
			}

			@Test
			public void testDoubleAdd() {
				Assertions.assertFalse(index.add("answer", 42));
			}

			@Test
			public void testAddNewPosition() {
				Assertions.assertTrue(index.add("answer", 12));
			}

			@Test
			public void testAddNewElement() {
				Assertions.assertTrue(index.add("question", 42));
			}

			@Test
			public void testAddAllFalse() {
				Assertions.assertFalse(index.addAll(new String[] {"answer"}, 42));
			}

			@Test
			public void testAddAllTrue() {
				Assertions.assertTrue(index.addAll(new String[] {"question", "answer"}, 41));
			}

			@Test
			public void testElementsModification() {
				Collection<String> elements = index.getElements();

				try {
					elements.clear();
				}
				catch (Exception e) {
					// ignored
				}

				Assertions.assertTrue(index.contains("answer"));
			}

			@Test
			public void testPositionsModification() {
				Collection<Integer> positions = index.getPositions("answer");

				try {
					positions.clear();
				}
				catch (Exception e) {
					// ignored
				}

				Assertions.assertTrue(index.contains("answer", 42));
			}
		}
	}
}
