package dcll.iParser.iParser;

/**
 * <b>Reponse est la classe représentant une reponse en vue d'être liée à une question</b>
 * <p>
 * Une reponse est caractérisé par :
 * <ul>
 * <li>String : pour l'intitulé de la réponse.</li>
 * <li>boolean : Si la réponse est juste ou pas.</li>
 * </ul>
 * </p> 
 */
public class Reponse 
{
	/**
     * L'intitulé de la réponse
     * 
     * @see Reponse#Reponse()
     * @see Reponse#getReponseText()
     */
	private String texte;
	
	/**
     * Si la réponse est juste ou pas
     * 
     * @see Reponse#Reponse()
     * @see Reponse#getReponseValue()
     */
	private boolean juste;
	
	
	/**
     * Constructeur Reponse.
     * 
     * @param txt
     *            L'intitulé de cette réponse.
     * @param value
     *            réponse juste ou fausse
     * 
     * @see Reponse#texte
     * @see Reponse#juste
     */
	public Reponse( String txt, boolean value ) 
	{
		this.texte = txt;
		this.juste = value;
	}

	/**
     * Retourne l'intitulé de la réponse.
     * 
     * @return l'intitulé de la réponse.
     * 
     * @see Reponse#texte
     */
	public String getReponseText() 
	{
		return this.texte;
	}

	/**
     * Retourne la valeur de la réponse.
     * 
     * @return la valeur de la réponse (true / false) 
     * 
     * @see Reponse#juste
     */
	public boolean getReponseValue() 
	{
		return this.juste;
	}
}
