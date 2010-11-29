/**
 * 
 */
package net.sf.kerner.utils.io.buffered;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

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
	
	private String in = "input";
	private AbstractIOIterator<String> it;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		it = new AbstractIOIterator<String>(new StringReader(in)){

			@Override
			protected String doRead() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected String doRead(int bufferSize) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

	@After
	public void tearDown() throws Exception {
		it = null;
	}

	/**
	 * Test method for {@link net.sf.kerner.utils.io.buffered.AbstractIOIterator#hasNext()}.
	 */
	@Test
	public final void testHasNext() {
		fail("Not yet implemented"); // TODO
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
