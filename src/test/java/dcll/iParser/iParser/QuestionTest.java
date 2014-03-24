package dcll.iParser.iParser;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class QuestionTest extends TestCase {

	private Question quizzSimple, quizzMultiple, quizz;
	
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
		
		this.quizz = new Question("Qui est le meilleur ?", TypeQuestion.SIMPLE);
		this.quizz.addReponse(new Reponse("L'autre", false));
		this.quizz.addReponse(new Reponse("Moi", true));
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
		ArrayList<String> listReponse=new ArrayList<String>();
		listReponse.add("Le ciel");
		listReponse.add("La mer");
		assertEquals("Le ciel est une réponse correcte.", true, quizzMultiple.resultOf(listReponse));
	} 
	
	@Test
	public void testReponseFausseMULTIPLE() {
		ArrayList<String> listReponse=new ArrayList<String>();
		listReponse.add("Le ciel");
		assertEquals("Le ciel est une réponse fausse.", true, quizzMultiple.resultOf(listReponse));
	}
	
	@Test
	public void testReponseFausseMULTIPLE2() {
		ArrayList<String> listReponse=new ArrayList<String>();
		listReponse.add("De l'herbe");
		assertEquals("De l'herbe est une réponse fausse.", false, quizzMultiple.resultOf(listReponse));
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
	public void testtoString(){

		String toStr = "Qui est le meilleur ? (Reponse SIMPLE)\n"
				+"-> L'autre (false)\n"
				+"-> Moi (true)\n";
		assertEquals("Je suis le meilleur", toStr, this.quizz.toString());
	}
	
	
	@Test
	public void testGetIndiceOfNormal(){
		assertEquals("Renvoie 1, l'indice de \"Moi\"", 1, quizz.getIndiceOf("Moi"));
	}
	
	@Test
	public void testGetIndiceOfInconnu(){
		assertEquals("Doit renvoyer -1 car ReponseInconnue n'existe pas", -1, quizz.getIndiceOf("ReponseInconnue"));
	}
	
	@Test
	public void testResultOfSizeZero(){
		ArrayList<String> rep = new ArrayList<String>();
		assertEquals("Je suis le meilleur", false, quizz.resultOf(rep));
	}
	
	@Test
	public void testGetIeme(){
		assertEquals("Le 2 ème de quizzMultiple est mer.", "La mer", quizzMultiple.getIemeReponse(2).getReponseText());
	}
	
	@Test
	public void testGetQuestionText(){
		assertEquals("Le titre de la question est le bon.", "Qu'est ce qui est bleu ?", quizzMultiple.getQuestionText());
	}
	

	
}
