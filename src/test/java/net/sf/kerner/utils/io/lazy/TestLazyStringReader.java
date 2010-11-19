/**
 * 
 */
package net.sf.kerner.utils.io.lazy;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 * @author Alexander Kerner
 * 
 */
public class TestLazyStringReader {

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
		
	}

	/**
	 * Test method for {@link net.sf.kerner.commons.io.lazy.LazyStringReader#LazyStringReader()}.
	 */
	@Test
	public final void testLazyStringReader() {
		new LazyStringReader();
	}
	
	/**
	 * Test method for {@link net.sf.kerner.commons.io.lazy.LazyStringReader#read(java.io.Reader)}
	 * @throws IOException 
	 */
	@Test
	public final void testReadReader() throws IOException {
		final java.io.StringReader sr = new java.io.StringReader("test");
		final String s2 = new LazyStringReader().read(sr);
		assertEquals("test", s2);
	}
	
	/**
	 * Test method for {@link net.sf.kerner.commons.io.lazy.LazyStringReader#read(java.io.File)}
	 * @throws IOException 
	 */
	@Test(expected=IOException.class)
	public final void testReadFile() throws IOException {
		new LazyStringReader().read(new File("/dieses/file/kann/hoffentlich/nicht/angelegt/werden"));
	}
	
	/**
	 * Test method for {@link net.sf.kerner.commons.io.lazy.LazyStringReader#read(java.io.InputStream)}.
	 * @throws IOException 
	 */
	@Test(expected=IOException.class)
	public final void testReadInputStream() throws IOException {
		new LazyStringReader().read(new FileInputStream(new File("/dieses/file/kann/hoffentlich/nicht/angelegt/werden")));
	}
	
	
	
	/**
	 * Test method for {@link net.sf.kerner.commons.io.lazy.LazyStringReader#read(java.io.Reader)}
	 * @throws IOException 
	 */
	@Test
	public final void example() throws IOException {
		final LazyStringReader reader = new LazyStringReader();
		final java.io.StringReader sr = new java.io.StringReader("Hallo Welt!");
		assertEquals("Hallo Welt!", reader.read(sr));
	}

}
