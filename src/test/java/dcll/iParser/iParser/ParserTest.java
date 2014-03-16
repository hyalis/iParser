package dcll.iParser.iParser;

import junit.framework.TestCase;

public class ParserTest extends TestCase{
	
	private Question questionSimple;
	private Question questionMultiple;
	
	protected void setUp() throws Exception{
		super.setUp();
		Parser parser = new Parser();
		
		String questionSimpleTexte = "{Qui est le président des États Unis?\n"+
								 "|type=\"()\"}\n"+
								 "+ Obama.\n"+
								 "- François Hollande.\n"+
								 "- Xi Jinping.\n";
		questionSimple = parser.doIt(questionSimpleTexte);
		
		String questionMultipleTexte = "{Quels sont les coleur de feu rouge?\n"+
				 "|type=\"[]\"}\n"+
				 "+ rouge.\n"+
				 "- bleu.\n"+
				 "+ vert.\n"+
				 "- noir.\n"; 
		questionMultiple = parser.doIt(questionMultipleTexte);
	}
	
	//Question Simple
	public void testQuestionTexteSimple(){
		assertEquals("Question = Qui est le président des États Unis? ","Qui est le président des États Unis?", questionSimple.getQuestionText());
	}
	
	public void test1emeReponseTexteSimple(){
		assertEquals("première réponse = \"Obama.\"","Obama.", questionSimple.getIemeReponse(0).getReponseText());
	}
	
	public void testNature1emeReponseSimple(){
		assertEquals("Nature de première réponse =  true",true, questionSimple.getIemeReponse(0).getReponseValue());
	}
	
	public void test2emeReponseSimple(){
		assertEquals("deuxième réponse = \"François Hollande.\"","François Hollande.", questionSimple.getIemeReponse(1).getReponseText());
	}
	
	public void testNature2emeReponseSimple(){
		assertEquals("Nature de deuxième réponse =  false",false, questionSimple.getIemeReponse(1).getReponseValue());
	}
	
	public void test3emeReponseSimple(){
		assertEquals("troisième réponse = \"Xi Jinping.\"","Xi Jinping.", questionSimple.getIemeReponse(2).getReponseText());
	}
	
	public void testNature3emeReponseSimple(){
		assertEquals("Nature de troisième réponse =  false",false, questionSimple.getIemeReponse(2).getReponseValue());
	}
	
	public void testIsQuestionSimple(){
		assertEquals("Question a une seul réponse",1,questionSimple.nbReponseCorrecte());
	}
	
	//Question Multiple
	public void testQuestionTexteMultiple(){
		assertEquals("Question = Quels sont les coleur de feu rouge?","Quels sont les coleur de feu rouge?", questionMultiple.getQuestionText());
	}
	
	public void test1emeReponseTexteMultiple(){
		assertEquals("première réponse = \"rouge.\"","rouge.", questionMultiple.getIemeReponse(0).getReponseText());
	}
	
	public void testNature1emeReponseMultiple(){
		assertEquals("Nature de première réponse =  true",true, questionMultiple.getIemeReponse(0).getReponseValue());
	}
	
	public void test2emeReponseMultiple(){
		assertEquals("deuxième réponse = \"bleu.\"","bleu.", questionMultiple.getIemeReponse(1).getReponseText());
	}
	
	public void testNature2emeReponseMultiple(){
		assertEquals("Nature de deuxième réponse =  false",false, questionMultiple.getIemeReponse(1).getReponseValue());
	}
	
	public void test3emeReponseMultiple(){
		assertEquals("troisième réponse = \"vert.\"","vert.", questionMultiple.getIemeReponse(2).getReponseText());
	}
	
	public void testNature3emeReponseMultiple(){
		assertEquals("Nature de troisième réponse =  true",true, questionMultiple.getIemeReponse(2).getReponseValue());
	}
	
	public void test4emeReponseMultiple(){
		assertEquals("troisième réponse = \"noir.\"","noir.", questionMultiple.getIemeReponse(3).getReponseText());
	}
	
	public void testNature4emeReponseMultiple(){
		assertEquals("Nature de troisième réponse =  false",false, questionMultiple.getIemeReponse(3).getReponseValue());
	}
	
	public void testIsQuestionMultiple(){
		assertEquals("Question a 2 réponses correctes",2,questionMultiple.nbReponseCorrecte());
	}
	
}
