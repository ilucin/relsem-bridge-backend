package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

import com.etk.network.server.MsgParser;

public class MsgParserTest {

	MsgParser parser;
	byte[] string;
	// short integers
	byte[] simpleShortInt_;
	byte[] complexShortInt_;
	// integers
	byte[] simpleInteger;
	byte[] complexInteger;

	@Before
	public void setUp() throws Exception {
		this.parser = new MsgParser();
		this.string = new byte[] { 'I', ',', ' ', 'l', 'i', 'k', 'e', ' ', 't',
				'o', ' ', 'p', 'a', 'r', 's', 'e', '!', ' ', ':', ')' };
		// short integers
		this.simpleShortInt_ = new byte[] { 0, 4 };
		this.complexShortInt_ = new byte[] { 23, 112 };
		// integers
		this.simpleInteger = new byte[] { 0, 0, 0, 7 };
		this.complexInteger = new byte[] { 59, (byte) 154, (byte) 202, 0 };
	}

	@Test
	public void testCorrectExecution() {
		try {
			assertEquals(7, this.parser.parseInt(simpleInteger));
			assertEquals(1000000000, this.parser.parseInt(complexInteger));
		} catch (IllegalArgumentException e) {
			fail();
		}
		String temp = "";
		try {
			temp = this.parser.parseMsg(string);
		} catch (UnsupportedEncodingException e) {
			fail();
		}
		assertEquals("I, like to parse! :)", temp);

		try {
			assertEquals(4, this.parser.parseShort(this.simpleShortInt_));
			assertEquals(6000, this.parser.parseShort(this.complexShortInt_));
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooShortInt() {
		this.parser.parseInt(simpleShortInt_);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooLongInt() {
		byte[] tooLong = { 0, 0, 0, 7, 6 };
		this.parser.parseInt(tooLong);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooLongShort() {
		this.parser.parseShort(this.complexInteger);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTooShortShort() {
		byte[] tooShort = { 0 };
		this.parser.parseShort(tooShort);
	}
}
