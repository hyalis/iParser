package dcll.iParser.iParser;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
    	Parser p = new Parser();
    	
    	String str1 = "{La Suisse est membre de l'Union Européenne.\n" +
    			"|type=\"()\"}\n" +
    			"- Vrai.\n" +
    			"+ Faux.\n";
    	Question q1 = p.doIt(str1);
    	System.out.println(q1.toString());
    	
    	System.out.println("L'utilisateur répond : Vrai.");
		if(q1.resultOf("vrai"))
			System.out.println("Il a répondu correctement.");
		else
			System.out.println("Il s'est trompé.");
    	
    	
    	
    	String str2 = "{Sélectionnez les langages dynamiques\n" +
    			"|type=\"[]\"}\n" +
    			"+ Clojure.\n" +
    			"- Java.\n" +
    			"+ Groovy.\n" +
    			"- Scala.\n";
    	Question q2 = p.doIt(str2);
    	System.out.println(q2.toString());
    	
    	
    	ArrayList<String> listReponse=new ArrayList<String>();
		listReponse.add(" Clojure.");
		listReponse.add(" Groovy.");
		System.out.println("L'utilisateur répond : Clojure et Groovy.");
		if(q2.resultOf(listReponse))
			System.out.println("Il a répondu correctement.");
		else
			System.out.println("Il s'est trompé.");
    }
}
