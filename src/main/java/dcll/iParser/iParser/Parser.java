package dcll.iParser.iParser;

/**
 * @author leo
 * TODO: 
 * - créer les exceptions
 * - les declencher
 */
public class Parser {

	public Parser()
	{
	}
	
	public Question doIt(String str)
	{
		int nbReponsesTrue = 0;
    	
    	String[] lignes = str.split("\n"); // Decoupage des lignes
    	
    	String intituleQuestion = lignes[0].substring(1); // Recuperation de la question (on ommet le premier "{" )
    	String typeQuestion = lignes[1]; // Recuperation du type
    	
    	TypeQuestion type = null;
    	
    	// On récupère le type de la question
    	if (typeQuestion.contains("type=\"()\"")) {
    		type = TypeQuestion.SIMPLE;
    	} else if (typeQuestion.contains("type=\"[]\"")){
    		type = TypeQuestion.MULTIPLE;
    	} else 
    	{
    		// throw ExpressionMalFormuleeException
    	}
    	
    	Question quiz = new Question(intituleQuestion, type);
    	
    	// Bouclage sur les réponses
    	for (int i = 2; i < lignes.length; i++ )
    	{
    		String reponse = lignes[i]; // On recup la reponse i
    		String textReponse = reponse.substring(reponse.indexOf(" "));
    		
    		if(reponse.startsWith("+"))
    		{
    			if (type == TypeQuestion.SIMPLE && nbReponsesTrue >= 1 )
    			{
    				// throw QuestionSimpleMaisMultipleReponseException
    			} else {
        			quiz.addReponse(new Reponse(textReponse, true));   //Ajout reponse true
        			nbReponsesTrue++;    				
    			}
    			
    		} else if (reponse.startsWith("-"))
    		{
    			quiz.addReponse(new Reponse(textReponse, false));    // Ajout reponse false
    		} else {
    			// throw ExpressionMalFormuleeException
    		}
    	}
    	return quiz;
	}

}
