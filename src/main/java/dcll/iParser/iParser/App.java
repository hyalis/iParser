package dcll.iParser.iParser;

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
    	
    	String str2 = "{Sélectionnez les langages dynamiques\n" +
    			"|type=\"[]\"}\n" +
    			"+ Clojure.\n" +
    			"- Java.\n" +
    			"+ Groovy.\n" +
    			"- Scala.\n";
    	Question q2 = p.doIt(str2);
    	System.out.println(q2.toString());
    	
    }
}
