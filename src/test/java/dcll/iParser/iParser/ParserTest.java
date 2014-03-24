package dcll.iParser.iParser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class ParserTest extends TestCase{
	
	private Question questionSimple;
	private Question questionMultiple;
	private Parser parser;
	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	protected void setUp() throws Exception{
		super.setUp();
		this.parser = new Parser();
		
		String questionSimpleTexte = "{Qui est le président des États Unis?\n"+
								 "|type=\"()\"}\n"+
								 "+ Obama.\n"+
								 "- François Hollande.\n"+
								 "- Xi Jinping.\n";
		questionSimple = parser.doIt(questionSimpleTexte);
		
		String questionMultipleTexte = "{Quelles sont les couleurs des feux tricolores ?\n"+
				 "|type=\"[]\"}\n"+
				 "+ rouge.\n"+
				 "- bleu.\n"+
				 "+ vert.\n"+
				 "- noir.\n"; 
		questionMultiple = parser.doIt(questionMultipleTexte);
	}
	
	//Question Simple
	@Test
	public void testQuestionTexteSimple(){
		System.out.println("Qui est le président des États Unis?");
		System.out.println(questionSimple.getQuestionText());
		
		
		assertEquals("Question = Qui est le président des États Unis? ", "Qui est le président des États Unis?\n", questionSimple.getQuestionText());
	}
	
	@Test
	public void test1emeReponseTexteSimple(){
		assertEquals("première réponse = \"Obama.\"","Obama", questionSimple.getIemeReponse(0).getReponseText());
	}
	
	@Test
	public void testNature1emeReponseSimple(){
		assertEquals("Nature de première réponse =  true",true, questionSimple.getIemeReponse(0).getReponseValue());
	}
	
	@Test
	public void test2emeReponseSimple(){
		assertEquals("deuxième réponse = \"François Hollande\"","François Hollande", questionSimple.getIemeReponse(1).getReponseText());
	}
	
	@Test
	public void testNature2emeReponseSimple(){
		assertEquals("Nature de deuxième réponse =  false",false, questionSimple.getIemeReponse(1).getReponseValue());
	}
	
	@Test
	public void test3emeReponseSimple(){
		assertEquals("troisième réponse = \"Xi Jinping.\"","Xi Jinping", questionSimple.getIemeReponse(2).getReponseText());
	}
	
	@Test
	public void testNature3emeReponseSimple(){
		assertEquals("Nature de troisième réponse =  false",false, questionSimple.getIemeReponse(2).getReponseValue());
	}
	
	@Test
	public void testIsQuestionSimple(){
		assertEquals("Question a une seul réponse",1,questionSimple.nbReponseCorrecte());
	}
	
	//Question Multiple
	@Test
	public void testQuestionTexteMultiple(){
		assertEquals("Question = Quels sont les coleur de feu rouge?","Quelles sont les couleurs des feux tricolores ?\n", questionMultiple.getQuestionText());
	}
	
	@Test
	public void test1emeReponseTexteMultiple(){
		assertEquals("première réponse = \"rouge.\"","rouge", questionMultiple.getIemeReponse(0).getReponseText());
	}
	
	@Test
	public void testNature1emeReponseMultiple(){
		assertEquals("Nature de première réponse =  true",true, questionMultiple.getIemeReponse(0).getReponseValue());
	}
	
	@Test
	public void test2emeReponseMultiple(){
		assertEquals("deuxième réponse = \"bleu.\"","bleu", questionMultiple.getIemeReponse(1).getReponseText());
	}
	
	@Test
	public void testNature2emeReponseMultiple(){
		assertEquals("Nature de deuxième réponse =  false",false, questionMultiple.getIemeReponse(1).getReponseValue());
	}
	
	@Test
	public void test3emeReponseMultiple(){
		assertEquals("troisième réponse = \"vert.\"","vert", questionMultiple.getIemeReponse(2).getReponseText());
	}
	
	@Test
	public void testNature3emeReponseMultiple(){
		assertEquals("Nature de troisième réponse =  true",true, questionMultiple.getIemeReponse(2).getReponseValue());
	}
	
	@Test
	public void test4emeReponseMultiple(){
		assertEquals("troisième réponse = \"noir.\"","noir", questionMultiple.getIemeReponse(3).getReponseText());
	}
	
	@Test
	public void testNature4emeReponseMultiple(){
		assertEquals("Nature de troisième réponse =  false",false, questionMultiple.getIemeReponse(3).getReponseValue());
	}
	
	@Test
	public void testIsQuestionMultiple(){
		assertEquals("Question a 2 réponses correctes",2,questionMultiple.nbReponseCorrecte());
	}
	
	@Test
	public void testEntree1lignException(){
		String question = "hello";
		try{
			parser.doIt(question);
		} catch(Exception e){
			assertEquals("Question mal formée.","Pas d'accolade ouvrante en début de titre.",e.getMessage());
		}
	}
	
	@Test
	public void testPasAccoladeFinTitreException(){
		String question = "{Qui est le président des États Unis?\n"+
				 "|type=\"()\"\n"+
				 "+ Obama.\n"+
				 "+ François Hollande.\n"+
				 "- Xi Jinping.\n";
		try{		
			parser.doIt(question);
		} catch(Exception e){
			assertEquals("Exception car pas d'accolade fermante.", "Pas d'accolade fermante en fin de titre.", e.getMessage());
		}
	}
	
	@Test
	public void testPasAccolateException(){
		String question = "Qui est le président des États Unis?\n"+
				 "|type=\"()\"\n"+
				 "+ Obama.\n"+
				 "- François Hollande.\n"+
				 "- Xi Jinping.\n";
		try{
			parser.doIt(question);
		} catch(Exception e){
			assertEquals("Exception car pas d'accolade ouvrante.", "Pas d'accolade ouvrante en début de titre.", e.getMessage());
		}
	}
	
	@Test
	public void testPasTypeException(){
		String question = "{Qui est le président des États Unis?\n"+
				 "|}\n"+
				 "+ Obama.\n"+
				 "- François Hollande.\n"+
				 "- Xi Jinping.\n";
		try{
			parser.doIt(question);
		} catch(Exception e){
			assertEquals("Exception car pas de type.", "Pas de type à cette question.", e.getMessage());
		}
	}
	
	@Test
	public void testRepMultipleQuestionSimpleException(){
		String question = "{Qui est le président des États Unis?\n"+
				 "|type=\"()\"}\n"+
				 "+ Obama.\n"+
				 "+ François Hollande.\n"+
				 "- Xi Jinping.\n";
		try{
			parser.doIt(question);
		} catch(Exception e){
			assertEquals("Trop de bonnes réponses.", "Question simple mais réponses multiple.", e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
