package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import com.etk.network.server.ByteTokenizer;
import com.etk.network.server.MsgParser;

public class ByteTokenizerTest {

	ByteTokenizer tokenizer;
	byte[] bytes;
	MsgParser parser;
	byte delims;

	@Before
	public void setUp() throws Exception {
		this.parser = new MsgParser();
		this.delims = 0;
		this.bytes = new byte[] { 0, 0, 'I', ',', 0, 'l', 'i', 'k', 'e', 0,
				't', 'o', 0, 0, 't', 'o', 'k', 'e', 'n', 'i', 'z', 'e', '!', 0,
				':', ')', 0, 0 };
		this.tokenizer = new ByteTokenizer(bytes, delims);
	}

	@Test
	public void testCorrectExecution() {
		assertEquals(5, this.tokenizer.countTokens());
		try {
			assertEquals("I,", this.parser.parseMsg(this.tokenizer.nexToken()));
			assertEquals("like",
					this.parser.parseMsg(this.tokenizer.nexToken()));
			assertEquals("to", this.parser.parseMsg(this.tokenizer.nexToken()));
			assertEquals("tokenize!",
					this.parser.parseMsg(this.tokenizer.nexToken()));
			assertEquals(":)", this.parser.parseMsg(this.tokenizer.nexToken()));
		} catch (UnsupportedEncodingException e) {
			fail();
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testNoSuchElementExceptionException() {
		this.tokenizer.nexToken();
		this.tokenizer.nexToken();
		this.tokenizer.nexToken();
		this.tokenizer.nexToken();
		this.tokenizer.nexToken();
		this.tokenizer.nexToken();
	}
}
