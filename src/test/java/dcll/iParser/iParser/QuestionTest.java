package dcll.iParser.iParser;
import org.junit.Test;
import junit.framework.TestCase;

public class QuestionTest extends TestCase {

	private Question quizzOne;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.quizzOne = new Question("Quelle est la capitale de la France ?");
		this.quizzOne.addReponse(new Reponse("Paris", true));
		this.quizzOne.addReponse(new Reponse("Madrid", false));
	}
	
	@Test
	public void testReponseCorrecte() {
		assertEquals("Paris est une réponse correcte.", true, quizzOne.resultOf("Paris"));
	} 
	
	@Test
	public void testReponseFausse() {
		assertEquals("Madrid est une réponse fausse.", false, quizzOne.resultOf("Madrid"));
	}
	
	@Test
	public void testAjoutReponse(){
		this.quizzOne.addReponse(new Reponse("Londres", false));
		assertEquals("Il doit y avoir 3 réponses maintenant.", 3, quizzOne.nbReponse());
	}
	
	@Test
	public void testSupprimerReponse(){
		this.quizzOne.delReponse("Madrid");
		assertEquals("Il y a une réponse en moins. Plus que 2 réponses.", 2, quizzOne.nbReponse());
	}

	@Test
	public void testNbReponsesCorrecteUne(){
		assertEquals("Paris est la seule bonne réponse. Donc une seule réponse correcte.", 1, quizzOne.nbReponseCorrecte());
	}
	
	@Test
	public void testNbReponsesCorrecteMultiple(){
		this.quizzOne.addReponse("Toulouse", true);
		assertEquals("Paris et Toulouse sont des bonne réponses. Donc deux réponses correctes", 2, quizzOne.nbReponseCorrecte());
	}
	
	@Test
	public void testGetReponse(){
		assertEquals("La bonne réponse est Paris.", "Paris", quizzOne.getReponseCorrecte());
	}
	
	
}
