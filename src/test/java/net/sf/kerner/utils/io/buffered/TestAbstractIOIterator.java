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
import java.util.NoSuchElementException;

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
		
		protected final BufferedStringReader reader2;
		
		public My(Reader reader) throws IOException {
			super(reader);
			reader2 = new BufferedStringReader(super.reader);
		}

		@Override
		protected String doRead() throws IOException {
			String s = reader2.nextString();
			return s;
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
		in = "input001";
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
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#hasNext()}.
	 * @throws IOException 
	 */
	@Test
	public final void testHasNext02() throws IOException {
		in = "";
		it = new My(new StringReader(in));
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
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#next()}.
	 * @throws IOException 
	 */
	@Test(expected=NoSuchElementException.class)
	public final void testNext01() throws IOException {
		it.next();
		it.next();
	}

}
