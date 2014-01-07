package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.etk.network.server.Receiver;

public class WrongParametersTest extends AbstractConnectionTest {

	private Receiver receiver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.receiver = new Receiver(dataInputStream);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void nullValuesTest() {
		assertEquals(this.receiver.getUsername(), null);
		assertEquals(this.receiver.getDBName(), null);
	}

}
