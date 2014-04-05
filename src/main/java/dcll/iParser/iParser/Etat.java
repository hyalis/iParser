package dcll.iParser.iParser;

/**.
 * Etat est l'énumération des état de parser 
 */
public enum Etat 
{
    /**.
     * Etat Début
     */
    DEB, 
    
    /**.
     * Etat titre de question
     */
    TITRE, 
    
    /**.
     * Etat type de quesiton
     */
    TYPE, 
    
    /**.
     * Etat réponses de question
     */
    REP
}
