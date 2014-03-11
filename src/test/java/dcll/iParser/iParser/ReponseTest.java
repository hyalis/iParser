package dcll.iParser.iParser;
import org.junit.Test;

import junit.framework.TestCase;


public class ReponseTest extends TestCase
{
	
	private Reponse reponse;
	

	protected void setUp() throws Exception {
		super.setUp();
        this.reponse = new Reponse("Paris", true);
    }

	@Test
	public void testReponseGetReponseText() {
		assertEquals("Paris", reponse.getReponseText());
	} 
	
	@Test
	public void testReponseGetReponseValue() {
		assertEquals(true, reponse.getReponseValue());
	} 
}
