/**
 * 
 */
package net.sf.kerner.utils.io.buffered;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import net.sf.kerner.utils.io.buffered.impl.BufferedStringReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-29
 *
 */
public class TestAbstractIOIterator {
	
	private static class My extends AbstractIOIterator<String> {
		
		protected final BufferedStringReader reader2 = new BufferedStringReader(super.reader);

		public My(Reader reader) throws IOException {
			super(reader);
		}

		@Override
		protected String doRead() throws IOException {
			return doRead(2);
		}

		@Override
		protected String doRead(int bufferSize) throws IOException {
			System.err.println(reader2);
			return reader2.nextString(bufferSize);
		}
	}
	
	private String in;
	private AbstractIOIterator<String> it;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		in = "input";
		it = new My(new StringReader(in));
	}

	@After
	public void tearDown() throws Exception {
		it = null;
		in = null;
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#hasNext()}.
	 */
	@Test
	public final void testHasNext() {
		assertTrue(it.hasNext());
	}
	
	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#hasNext()}.
	 */
	@Test
	public final void testHasNext01() {
		it.close();
		assertFalse(it.hasNext());
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#nextIndex()}.
	 */
	@Test
	public final void testNextIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#next()}.
	 */
	@Test
	public final void testNext() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#next(int)}.
	 */
	@Test
	public final void testNextInt() {
		fail("Not yet implemented"); // TODO
	}

}
