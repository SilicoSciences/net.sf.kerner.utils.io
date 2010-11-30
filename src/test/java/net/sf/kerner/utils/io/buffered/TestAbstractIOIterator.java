/**
 * 
 */
package net.sf.kerner.utils.io.buffered;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import net.sf.kerner.utils.io.buffered.impl.BufferedStringReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	 * @throws IOException 
	 */
	@Test
	public final void testHasNext01() throws IOException {
		it.next();
		assertFalse(it.hasNext());
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#next()}.
	 * @throws IOException 
	 */
	@Test
	public final void testNext() throws IOException {
		String s = it.next();
		assertEquals(in, s);
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#next(int)}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextInt() throws IOException {
		String s = it.next(2);
		assertEquals(in.substring(0,2), s);
	}
	
	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#next(int)}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextInt01() throws IOException {
		String s = it.next(2);
		s = it.next();
		assertEquals("pu", s);
	}
	
	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#next(int)}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextInt02() throws IOException {
		String s = it.next(2);
		s = it.next(10000);
		assertEquals(in.substring(2), s);
	}

}
