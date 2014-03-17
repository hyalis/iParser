package dcll.iParser.iParser;

import java.util.ArrayList;

public class Question {

	private String texte;
	private ArrayList<Reponse> listReponses=new ArrayList<Reponse>();
	private TypeQuestion type;
	
	public Question(String text,TypeQuestion type){
		this.texte = text;
		this.type = type;
	}
	
	public void addReponse(Reponse reponse){
		this.listReponses.add(reponse);
	}
	
	public boolean resultOf(ArrayList<String> liste){
		if(liste.size() == 0) return false;
		boolean result = true;
		for(String str : liste){
			result = result && this.listReponses.get(this.getIndiceOf(str)).getReponseValue();
		}
		return result;
	}
	
	private int getIndiceOf(String str) {
		for(int i = 0; i < this.listReponses.size(); i++){
			if(this.listReponses.get(i).getReponseText().equals(str))
				return i;
		}
		return -1;
	}

	public boolean resultOf(String reponse){
		for(int i=0;i<listReponses.size();i++)
		{
			if(reponse.equals(listReponses.get(i).getReponseText()))
				if(listReponses.get(i).getReponseValue()==true)
				return true;
		}
		return false;
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
	
	public String toString()
	{
		String str;
		str = this.texte + " (Reponse " + this.type + ")\n";
		
		for(Reponse rep : this.listReponses)
		{
			str += "\t" + rep.getReponseText() + "(" + rep.getReponseValue() + ")\n";
		}
		
		return str;
	}
	
	public Reponse getIemeReponse(int i){
		return listReponses.get(i);
	}
	
	public String getQuestionText(){
		return texte;
	}
}
