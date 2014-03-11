package dcll.iParser.iParser;

import java.util.ArrayList;

public class Question {

	private String texte;
	private ArrayList<Reponse> listReponses;
	private TypeQuestion type;
	
	public Question(String text,TypeQuestion type){
		texte=text;
		this.type=type;
	}
}
