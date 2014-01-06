package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * General test class that can be inherited by every class who needs to fake a
 * remote connection. All tests which inherit this class don't have to call the @BeforeClass
 * method "setUpAbstractBeforeClass" and @AfterClass method
 * "tearDownAbstractAfterClass" otherwise the inheritance will break.
 * 
 * @author Michele
 * 
 */
public class AbstractConnectionTest {

	private static final int port = 5000;
	private static Socket socket;
	private static ServerSocket serverSocket;
	protected static DataOutputStream dataOutputStream;
	protected static DataInputStream dataInputStream;

	@BeforeClass
	public static void setUpAbstractBeforeClass() throws Exception {
		serverSocket = new ServerSocket(port);
		socket = new Socket("localhost", port);

		Socket acceptedSocket = serverSocket.accept();
		dataOutputStream = new DataOutputStream(
				acceptedSocket.getOutputStream());
		dataInputStream = new DataInputStream(acceptedSocket.getInputStream());
	}

	@AfterClass
	public static void tearDownAbstractAfterClass() throws Exception {
		if (!socket.isClosed())
			socket.close();
		if (!serverSocket.isClosed())
			serverSocket.close();
	}

	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNotNull() {
		assertNotNull(dataInputStream);
		assertNotNull(dataOutputStream);
		assertEquals(socket.isClosed(), false);
		assertEquals(socket.isConnected(), true);
		assertEquals(serverSocket.isClosed(), false);
	}
}
