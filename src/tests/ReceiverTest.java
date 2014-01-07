package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.etk.network.server.Receiver;

public class ReceiverTest extends AbstractConnectionTest {

	private Receiver receiver;
	// fake a jdbc authentication message
	private final String[] fakeAuthMessage = { "user", "postgres", "database",
			"dbname", "client_encoding", "UTF8", "DateStyle", "ISO",
			"extra_float_digits", "2", "TimeZone", "Europe/Berlin" };

	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.receiver = new Receiver(dataInputStream);
	}

	@BeforeClass
	public static void setUpReceiverBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownReceiverAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void getPasswordTest() {
		try {
			dataOutputStream.writeByte('p');
			final String pass = "postgres";
			byte[] password = nullTerminateString(pass);
			dataOutputStream.writeInt(password.length + 4);
			dataOutputStream.write(password);
			dataOutputStream.flush();
			assertEquals(this.receiver.getMessageType(), 'p');
			assertEquals(this.receiver.getPassword(), pass);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void receiveSSLAuthMessageTest() {
		try {
			dataOutputStream.writeInt(8);
			dataOutputStream.writeInt(80877103);
			dataOutputStream.flush();
			assertEquals(this.receiver.receiveAuthMessage(), false);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	private void fakeJDBCAuthMessage() {
		int messageLenght = 0;
		for (int i = 0; i < fakeAuthMessage.length; i++) {
			messageLenght += nullTerminateString(fakeAuthMessage[i]).length;
		}
		// all string + protocolMajorVersion + protocolMinorVersion + lenght of
		// the message
		try {
			dataOutputStream.writeInt(messageLenght + 2 + 2 + 4);
			// protocolMajorVersion
			dataOutputStream.writeShort(9);
			// protocolMinorVersion
			dataOutputStream.writeShort(2);
			for (int i = 0; i < fakeAuthMessage.length; i++) {
				dataOutputStream.write(nullTerminateString(fakeAuthMessage[i]));
			}
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void receiveCorrectAuthMessageTest() {
		fakeJDBCAuthMessage();
		try {
			assertEquals(this.receiver.receiveAuthMessage(), true);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getUsernameTest() {
		fakeJDBCAuthMessage();
		try {
			assertEquals(this.receiver.receiveAuthMessage(), true);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(this.receiver.getUsername(), fakeAuthMessage[1]);
	}

	@Test
	public void getDBNameTest() {
		fakeJDBCAuthMessage();
		try {
			assertEquals(this.receiver.receiveAuthMessage(), true);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(this.receiver.getDBName(), fakeAuthMessage[3]);
	}

	@Test
	public void getMessageTypeTest() {
		try {
			// simulate a "Terminate" message
			dataOutputStream.writeByte('X');
			dataOutputStream.writeInt(4);
			dataOutputStream.flush();
			assertEquals(this.receiver.getMessageType(), 'X');
			// The following line is only to empty the input stream
			dataInputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void readQueryMessageTest() {
		final String queryString = "SELECT host FROM festival;";
		byte[] query = nullTerminateString(queryString);
		try {
			dataOutputStream.writeByte('Q');
			dataOutputStream.writeInt(query.length + 4);
			dataOutputStream.write(query);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(this.receiver.getMessageType(), 'Q');
		// remove the final semicolon because will be deleted by the method
		assertEquals(this.receiver.readQueryMessage(),
				queryString.substring(0, queryString.length() - 1));
	}

	private byte[] nullTerminateString(String string) {
		byte[] in = string.getBytes();
		byte[] out = new byte[in.length + 1];
		for (int i = 0; i < in.length; i++) {
			out[i] = in[i];
		}
		out[in.length] = 0;
		return out;
	}
}
