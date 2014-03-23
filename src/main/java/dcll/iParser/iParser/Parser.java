package dcll.iParser.iParser;

/**.
 * <b>Parser est la classe qui permet
 * d'analyser la question (Sous forme de String)</b>
 */
public class Parser {

	/**.
	 * Constructeur Parser()
	 */
	public Parser() {
	}

	/**.
     * La fonction doIt() est la fonction principal
     * qui permet d'analyser la chaine de caractère passé
     * en paramètre et la retourne sous forme de "Question"
     *
     * @param str
     *       La chaine de caractère qui représente la question avec ses réponses
     *
     * @return Question
     * 	   Objet Question qui contient l'intitulé de la question et ses réponses
     *
     * @see Question
     * @see Reponse
     * @throws Exception
     */
	public Question doIt(final String str) throws Exception {
		int nbReponsesTrue = 0;

		String[] lignes = str.split("\n"); // Decoupage des lignes

		// Recuperation de la question (on ommet le premier "{" )
		String intituleQuestion = lignes[0].substring(1);
		String typeQuestion = lignes[1]; // Recuperation du type

		TypeQuestion type = null;

		// On récupère le type de la question
		if (typeQuestion.contains("type=\"()\"")) {
			type = TypeQuestion.SIMPLE;
		} else if (typeQuestion.contains("type=\"[]\"")) {
			type = TypeQuestion.MULTIPLE;
		} else {
			throw new Exception("ExpressionMalFormuleeException");
		}

		Question quiz = new Question(intituleQuestion, type);

		// Bouclage sur les réponses
		for (int i = 2; i < lignes.length; i++) {
			String reponse = lignes[i]; // On recup la reponse i
			String textReponse = reponse.substring(reponse.indexOf(" "));
			// On enlève l'espace du debut
			textReponse = textReponse.trim();

			if (reponse.startsWith("+")) {
				if (type == TypeQuestion.SIMPLE
						&& nbReponsesTrue >= 1) {
				throw new Exception("QuestionSimpleMaisMultipleReponseException");
				} else {
					quiz.addReponse(new Reponse(textReponse, true));
					nbReponsesTrue++;
				}

			} else if (reponse.startsWith("-")) {
				quiz.addReponse(new Reponse(textReponse, false));
			} else {
				throw new Exception("ExpressionMalFormuleeException");
			}
		}
		return quiz;
	}

}
