package dcll.iParser.iParser;

import java.util.ArrayList;

/**
 * <b>Question est la classe représentant une question (simple ou multiple) avec
 * ses réponses</b>
 * <p>
 * Une question du Parser Wikiversity est caractérisé par :
 * <ul>
 * <li>String : pour l'intitulé de la question.</li>
 * <li>ArrayList : Liste des réponses proposées.</li>
 * <li>TypeQuestion : Enumération pour spécifier le type de la question
 * (multiple/simple).</li>
 * </ul>
 * </p>
 * @see Reponse
 */
public class Question 
{
    /**
     * L'intitulé de la question.
     * @see Question#getQuestionText()
     */
    private String texte;
    /**
     * . La liste des réponses proposées pour la question
     * @see Question#nbReponseCorrecte()
     * @see Question#addReponse()
     * @see Question#nbReponse()
     * @see Qestion#getIemeReponse()
     * @see Question#resultOf(String)
     */
    private ArrayList<Reponse> listReponses = new ArrayList<Reponse>();
    /**
     * Le type de la question.
     * @see TypeQuestion
     */
    private TypeQuestion type;

    /**
     * Constructeur Question.
     * <p>
     * La liste des réponses est initialement vide
     * </p>
     * @param text
     *            L'intitulé de cette question.
     * @param typeQuestion
     *            Le type de cette question.
     * @see Question#texte
     * @see Question#type
     */
    public Question( String text, TypeQuestion typeQuestion ) 
    {
        this.texte = text;
        this.type = typeQuestion;
    }

    /**
     * Ajoute une réponse à la liste des questions.
     * @param reponse
     *            La nouvelle reponse ajoutée de type Reponse.
     * @see Question#listReponses
     * @see Reponse
     */
    public void addReponse( Reponse reponse ) 
    {
        this.listReponses.add( reponse );
    }

    /**
     * . Précise si la liste de réponses passées en paramètres sont des réponses
     * juste ou pas
     * @param liste
     *            La liste de réponses ( String ) à vérifier
     * @return True : si la liste des réponses est vrai false : si la liste des
     *         réponses est fausse
     * @see Question#listReponses
     * @see Reponse#getReponseValue()
     */
    public boolean resultOf( ArrayList<String> liste ) 
    {
        if ( liste.size() == 0 ) 
        {
            return false;
        }
        boolean result = true;
        for ( String str : liste ) 
        {
            result = result
                    && this.listReponses.get( this.getIndiceOf( str ) )
                            .getReponseValue();
        }
        return result;
    }

    /**
     * . Retourne l'indice de la réponse passée en paramètre.
     * @param str
     *            La réponse à chercher dans la liste
     * @return l'indice de la réponse cherchée ( retourne -1 si réponse non
     *         trouvée)
     * @see Question#listReponses
     */
    public int getIndiceOf( String str ) 
    {
        for ( int i = 0; i < this.listReponses.size(); i++ )
        {
            if ( this.listReponses.get( i ).getReponseText().equals( str ) ) 
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * . Précise si la réponse passée en paramètre est une réponse juste ou pas
     * @param reponse
     *            La réponse ( String ) à vérifier
     * @return True : si la réponse est vrai false : si la réponse est fausse
     * @see Question#listReponses
     * @see Reponse#getReponseValue()
     * @see Reponse#getReponseText()
     */
    public boolean resultOf( String reponse ) 
    {
        for ( int i = 0; i < listReponses.size(); i++ ) 
        {
            if ( reponse.equals( listReponses.get( i ).getReponseText() ) ) 
            {
                if ( listReponses.get( i ).getReponseValue() ) 
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * . Retourne le nombre de réponses relative à cette question
     * @return le nombre de réponses
     * @see Question#listReponses
     */
    public int nbReponse() 
    {
        return listReponses.size();
    }

    /**
     * . Retourne le nombre de réponses justes relative à cette question
     * @return le nombre de réponses justes
     * @see Question#listReponses
     * @see Reponse#getReponseValue()
     */
    public int nbReponseCorrecte() 
    {
        int nbrReponseCorrect = 0;
        for ( int i = 0; i < listReponses.size(); i++ ) 
        {
            if ( listReponses.get( i ).getReponseValue() ) 
            {
                nbrReponseCorrect++;
            }
        }
        return nbrReponseCorrect;
    }

    /**
     * . toString() Spécifie la forme d'écriture de la question
     * @return la forme d'écriture de la question
     * @see Question#listReponses
     * @see Reponse#getReponseValue()
     * @see Reponse#getReponseText()
     */
    public String toString() 
    {
        StringBuffer buf = new StringBuffer();
        buf.append( this.texte + " (Reponse " + this.type + ")\n" );
        for ( Reponse rep : this.listReponses ) 
        {
            buf.append( "-> " + rep.getReponseText() + " ("
                    + rep.getReponseValue() + ")\n" );
        }
        return buf.toString();
    }

    /**
     * . Retourne la ième réponse spécifié en paramètre.
     * @param i
     *            l'indice de la réponse à retourner.
     * @return la ième réponse
     * @see Question#listReponses
     */
    public Reponse getIemeReponse( int i ) 
    {
        return listReponses.get( i );
    }

    /**
     * . Retourne l'intitulé de cette question
     * @return l'intitulé de la question
     * @see Question#texte
     */
    public String getQuestionText() 
    {
        return texte;
    }
}
