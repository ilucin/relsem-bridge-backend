package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.lang.model.type.NullType;

import org.junit.Before;
import org.junit.Test;

import com.etk.network.server.Receiver;
import com.etk.network.server.Sender;

public class ReceiverTest extends AbstractConnectionTest {

	Receiver receiver;
	Sender sender;

	@Before
	public void setUp() throws Exception {

		this.receiver = new Receiver(dataInputStream);

	}

	

	@Test
	public void testGetPassword() throws IOException {
		dataOutputStream.writeInt(10);
		dataOutputStream
				.writeBytes(new String(nullTerminateString("postgres")));
		dataOutputStream.flush();
		this.receiver.getPassword();
	}

	@Test
	public void testReceiveAuthMessage() throws IOException {

		String string = "postgres";
		int size = nullTerminateString(string).length;
		dataOutputStream.writeInt(4 + 2 + 2 + 2 * size);
		dataOutputStream.writeShort(9);
		dataOutputStream.writeShort(2);
		dataOutputStream
				.writeBytes(new String(nullTerminateString("postgres")));
		dataOutputStream
				.writeBytes(new String(nullTerminateString("postgres")));
		dataOutputStream.flush();
		this.receiver.receiveAuthMessage();
	}

	@Test
	public void testGetUsername() {
		this.receiver.getUsername();
	}

	@Test
	public void testGetDBName() {
		this.receiver.getDBName();
	}
	
	@Test
	public void testGetMessageType() throws IOException {

		dataOutputStream.writeByte('E');
		dataOutputStream.flush();
		this.receiver.getMessageType();

	}

	@Test
	public void testReadQueryMessage() throws IOException {
		dataOutputStream.writeInt(10);
		dataOutputStream.writeBytes(new String(nullTerminateString("SELECT host FROM festival;")));
		dataOutputStream.flush();
		this.receiver.readQueryMessage();
		
	}

	private byte[] nullTerminateString(String string) {
		byte[] in = string.getBytes();
		byte[] out = new byte[in.length + 1];
		for (int i = 0; i < in.length; i++) {
			out[i] = in[i];
		}
		out[in.length] = '\0';
		return out;
	}

}
