package dcll.iParser.iParser;

public class Reponse 
{
	private String texte;
	private boolean juste;
	
	public Reponse( String txt, boolean value ) 
	{
		this.texte = txt;
		this.juste = value;
	}

	public String getReponseText() 
	{
		return this.texte;
	}

	public boolean getReponseValue() 
	{
		return this.juste;
	}
}
