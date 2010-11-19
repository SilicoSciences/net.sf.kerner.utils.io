/**
 * 
 *
 */
package net.sf.kerner.utils.io.buffered.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-10-25
 *
 */
public class TestCharIterator {
	
	private CharIterator it;

	StringReader input;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		input = null;
		it = null;
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.BufferedReader)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorBufferedReader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.File)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorFile() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.InputStream)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorInputStream() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.Reader, boolean)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorReaderBoolean() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.BufferedReader, boolean)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorBufferedReaderBoolean() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.File, boolean)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorFileBoolean() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.InputStream, boolean)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorInputStreamBoolean() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#CharIterator(java.io.Reader)}.
	 */
	@Test
	@Ignore
	public final void testCharIteratorReader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#hasNext()}.
	 * @throws IOException 
	 */
	@Test
	public final void testHasNext() throws IOException {
		input = new StringReader("test");
		it = new CharIterator(input);
		assertTrue(it.hasNext());
	}
	
	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#hasNext()}.
	 * @throws IOException 
	 */
	@Test
	public final void testHasNext01() throws IOException {
		input = new StringReader("");
		it = new CharIterator(input);
		assertFalse(it.hasNext());
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#nextIndex()}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextIndex() throws IOException {
		input = new StringReader("");
		it = new CharIterator(input);
		assertEquals(1, it.nextIndex());
	}
	
	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#nextIndex()}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextIndex01() throws IOException {
		input = new StringReader("test");
		it = new CharIterator(input);
		assertEquals(1, it.nextIndex());
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#nextChar()}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextOne() throws IOException {
		input = new StringReader("test");
		it = new CharIterator(input);
		assertTrue(it.hasNext());
		assertEquals('t', it.nextChar());
		assertEquals('e', it.nextChar());
		assertEquals('s', it.nextChar());
		assertEquals('t', it.nextChar());
		assertFalse(it.hasNext());
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#nextChars()}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextBunch() throws IOException {
		input = new StringReader("test");
		it = new CharIterator(input);
		assertTrue(it.hasNext());
		assertArrayEquals(new char[]{'t','e','s','t'}, it.nextChars());
		assertFalse(it.hasNext());
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#nextChars(int)}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextBunchInt() throws IOException {
		input = new StringReader("test");
		it = new CharIterator(input);
		assertTrue(it.hasNext());
		assertArrayEquals(new char[]{'t','e','s','t'}, it.nextChars(4));
		assertFalse(it.hasNext());
	}
	
	/**
	 * Test method for {@link net.sf.kerner.commons.io.buffered.CharIterator#nextChars(int)}.
	 * @throws IOException 
	 */
	@Test
	public final void testNextBunchInt01() throws IOException {
		input = new StringReader("test");
		it = new CharIterator(input);
		assertTrue(it.hasNext());
//		System.err.println(it.nextBunch(3));
		assertArrayEquals(new char[]{'t','e','s'}, it.nextChars(3));
		assertTrue(it.hasNext());
	}

}