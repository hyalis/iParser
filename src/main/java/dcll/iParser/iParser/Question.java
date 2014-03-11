package dcll.iParser.iParser;

import java.util.ArrayList;

public class Question {

	private String texte;
	private ArrayList<Reponse> listReponses;
	private TypeQuestion type;
	
	public Question(String text,TypeQuestion type){
		texte=text;
		this.type=type;
		listReponses=new ArrayList<Reponse>();
	}
	
	public void addReponse(Reponse reponse){
		listReponses.add(reponse);
	}
	
	public boolean resultOf(ArrayList<String> liste){
		return listReponses.containsAll(liste);
	}
	
	public boolean resultOf(String reponse){
		return listReponses.contains(reponse);
	}
	
	public int nbReponse(){
		return listReponses.size();
	}

	public int nbReponseCorrecte(){
		int nbrReponseCorrect=0;
		for(int i=0;i<listReponses.size();i++){
			if(listReponses.get(i).getReponseValue()==true)
				nbrReponseCorrect++;
		}
		return nbrReponseCorrect;
	}
}
