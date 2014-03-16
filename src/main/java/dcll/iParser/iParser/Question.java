package dcll.iParser.iParser;

import java.util.ArrayList;

public class Question {

	private String texte;
	private ArrayList<Reponse> listReponses=new ArrayList<Reponse>();
	private TypeQuestion type;
	
	public Question(String text,TypeQuestion type){
		texte = text;
		this.type = type;
	}
	
	public void addReponse(Reponse reponse){
		listReponses.add(reponse);
	}
	
	public boolean resultOf(ArrayList<String> liste){
		int tab[] = null;
		tab=new int[liste.size()];
		
		//initialisation du tableau en O 
		for(int i=0;i<liste.size();i++){
			tab[i]=0;
		}
		//recherche des composants de "liste" dans "listReponses"
		for(int i=0;i<liste.size();i++)
		{
			for(int j=0;j<listReponses.size();j++){
				if(liste.get(i).equals(listReponses.get(j).getReponseText()) && 
						listReponses.get(j).getReponseValue()){
						tab[i]=1;
				    }
				
			}
		}
		//vérification des composants
		for(int i=0;i<liste.size();i++){
			if(tab[i]==0)
			return false;
		}
		return true;
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
