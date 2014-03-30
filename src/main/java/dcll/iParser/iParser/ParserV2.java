package dcll.iParser.iParser;

/**
 * . <b>Parser est la classe qui permet d'analyser la question (Sous forme de
 * String)</b>
 */
public class ParserV2 {
    /**
     * . La fonction doIt() est la fonction principal qui permet d'analyser la
     * chaine de caractère passé en paramètre et la retourne sous forme de
     * "Question"
     * @param str
     *            La chaine de caractère qui représente la question avec ses
     *            réponses
     * @return Question Objet Question qui contient l'intitulé de la question et
     *         ses réponses
     * @see Question
     * @see Reponse
     * @throws Exception
     */
    public Question doIt(String str) throws Exception {
        int pos = 0;
        String titre = "";
        Etat etat = Etat.DEB;
        Question quizz = null;
        TypeQuestion type;
        Reponse reponse;
        if (str.charAt(0) != '{') {
            throw new Exception("Premier caract hs");
        }
        while (pos < str.length()) {
            switch (etat) {
            case DEB:
                etat = Etat.TITRE;
                break;
            case TITRE:
                while (str.charAt(pos) != '|') {
                    titre += str.charAt(pos);
                    pos++;
                }
                etat = Etat.TYPE;
                break;
            case TYPE:
                if (str.substring(pos, pos + 9).equals("type=\"()\"")) {
                    type = TypeQuestion.SIMPLE;
                } else if (str.substring(pos, pos + 9).equals("type=\"[]\"")) {
                    type = TypeQuestion.MULTIPLE;
                } else {
                    throw new Exception("Erreur de type");
                }
                if (str.charAt(pos + 9) != '}') {
                    throw new Exception("Fin titre HS");
                }
                pos += 9;
                etat = Etat.REP;
                quizz = new Question(titre, type);
                break;
            case REP:
                boolean valeur;
                String rep = "";
                if (str.charAt(pos) == '+' || str.charAt(pos) == '-') {
                    // System.out.println(pos + " " + str.charAt(pos));
                    if (str.charAt(pos) == '+') {
                        valeur = true;
                    } else {
                        valeur = false;
                    }
                    pos += 2;
                    while (str.charAt(pos) != '.') {
                        rep += str.charAt(pos);
                        pos++;
                    }
                    reponse = new Reponse(rep, valeur);
                    quizz.addReponse(reponse);
                    etat = Etat.REP;
                }
                break;
            default:
                break;
            }
            pos++;
        }
        System.out.println(quizz.toString());
        return quizz;
    }
}
