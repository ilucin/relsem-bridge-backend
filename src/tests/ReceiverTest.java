package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.etk.network.server.Receiver;

public class ReceiverTest extends AbstractConnectionTest {

	Receiver receiver;
	
	@Before
	public void setUp() throws Exception {
	
		this.receiver = new Receiver(dataInputStream);
		
	}
	
	
	
	@Test
	public void testGetUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDBName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testReceiveAuthMessage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMessageType() throws IOException {
	
		dataOutputStream.writeByte('E');
		dataOutputStream.flush();
		receiver.getMessageType();
	
	}

	@Test
	public void testReadQueryMessage() {
		fail("Not yet implemented");
	}

}
