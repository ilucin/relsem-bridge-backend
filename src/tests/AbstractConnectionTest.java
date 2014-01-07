package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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

	private static Socket socket;
	private static ServerSocket serverSocket;
	protected static DataOutputStream dataOutputStream;
	protected static DataInputStream dataInputStream;

	@BeforeClass
	public static void setUpAbstractBeforeClass() throws Exception {
		serverSocket = new ServerSocket(0);		
		socket = new Socket("localhost", serverSocket.getLocalPort());
		Socket acceptedSocket = serverSocket.accept();
		
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
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
	public void testConnectionEstablishment() {
		assertNotNull(dataInputStream);
		assertNotNull(dataOutputStream);
		assertEquals(socket.isClosed(), false);
		assertEquals(serverSocket.isClosed(), false);
		
		final byte byteToRead = 2;
		final boolean booleanToRead = true;
		final int intToRead = 10;
		final short shortToRead = 3;
		final long longToRead = 50;
		try {
			dataOutputStream.writeByte(byteToRead);
			dataOutputStream.flush();
			assertEquals(dataInputStream.readByte(), byteToRead);
			
			dataOutputStream.writeBoolean(booleanToRead);
			dataOutputStream.flush();
			assertEquals(dataInputStream.readBoolean(), booleanToRead);
			
			dataOutputStream.writeInt(intToRead);
			dataOutputStream.flush();
			assertEquals(dataInputStream.readInt(), intToRead);
			
			
			dataOutputStream.writeShort(shortToRead);
			dataOutputStream.flush();
			assertEquals(dataInputStream.readShort(), shortToRead);
			
			dataOutputStream.writeLong(longToRead);
			dataOutputStream.flush();
			assertEquals(dataInputStream.readLong(), longToRead);
			
			socket.close();
			serverSocket.close();
			assertEquals(socket.isClosed(), true);
			assertEquals(serverSocket.isClosed(), true);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
