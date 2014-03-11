package dcll.iParser.iParser;
import org.junit.Test;
import junit.framework.TestCase;

public class QuestionTest extends TestCase {

	private Question quizzSimple;
	private Question quizzMultiple;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.quizzSimple = new Question("Quelle est la capitale de la France ?", TypeQuestion.SIMPLE);
		this.quizzSimple.addReponse(new Reponse("Paris", true));
		this.quizzSimple.addReponse(new Reponse("Madrid", false));
		
		this.quizzMultiple = new Question("Qu'est ce qui est bleu ?", TypeQuestion.MULTIPLE);
		this.quizzMultiple.addReponse(new Reponse("Voiture de La Poste", false));
		this.quizzMultiple.addReponse(new Reponse("Le ciel", true));
		this.quizzMultiple.addReponse(new Reponse("La mer", true));
		this.quizzMultiple.addReponse(new Reponse("De l'herbe", false));
	}
	
	@Test
	public void testReponseCorrecteSIMPLE() {
		assertEquals("Paris est une réponse correcte.", true, quizzSimple.resultOf("Paris"));
	} 
	
	@Test
	public void testReponseFausseSIMPLE() {
		assertEquals("Madrid est une réponse fausse.", false, quizzSimple.resultOf("Madrid"));
	}
	
	@Test
	public void testReponseCorrecteMULTIPLE() {
		assertEquals("Le ciel est une réponse correcte.", true, quizzSimple.resultOf("Le ciel"));
	} 
	
	@Test
	public void testReponseFausseMULTIPLE() {
		assertEquals("De l'herbe est une réponse fausse.", false, quizzSimple.resultOf("De l'herbe"));
	}
	
	@Test
	public void testAjoutReponse(){
		this.quizzSimple.addReponse(new Reponse("Londres", false));
		assertEquals("Il doit y avoir 3 réponses maintenant.", 3, quizzSimple.nbReponse());
	}

	@Test
	public void testNbReponsesCorrecteSIMPLE(){
		assertEquals("Paris est la seule bonne réponse. Donc une seule réponse correcte.", 1, quizzSimple.nbReponseCorrecte());
	}
	
	@Test
	public void testNbReponsesCorrecteMultiple(){
		this.quizzSimple.addReponse(new Reponse("Toulouse", true));
		assertEquals("Paris et Toulouse sont des bonne réponses. Donc deux réponses correctes", 2, quizzSimple.nbReponseCorrecte());
	}
	
	@Test
	public void testGetReponse(){
		/*for(String rep : quizzSimple.getReponseCorrecte()){
			assertEquals("La bonne réponse est Paris ou Toulouse", "Paris", quizzSimple.getReponseCorrecte());
		}*/
	}
	
	
}
