package dcll.iParser.iParser;

public class ParserV2 {
	public Question doIt( final String str ) throws Exception 
	{
		int pos = 0;
		String titre = "";
		Etat etat = Etat.DEB;
		Question quizz = null;
		TypeQuestion type;
		Reponse reponse;
		if(str.charAt(0) != '{')
			throw new Exception("Premier caract hs");
		
		while(pos < str.length()){
			switch(etat){
				case DEB : 
					etat = Etat.TITRE;
					break;
				case TITRE :
					while(str.charAt(pos) != '|'){
						titre += str.charAt(pos);
						pos++;
					}
					etat = Etat.TYPE;
					break;
				case TYPE :
					if(str.substring(pos, pos+9).equals("type=\"()\"")){
						type = TypeQuestion.SIMPLE;
					} else if (str.substring(pos, pos+9).equals("type=\"[]\"")){
						type = TypeQuestion.MULTIPLE;
					} else {
						throw new Exception("Erreur de type");
					}
					if(str.charAt(pos+9) != '}')
						throw new Exception("Fin titre HS");
					pos += 9;
					etat = Etat.REP;
					quizz = new Question(titre, type);
					break;
				case REP :
					boolean valeur;
					String rep = "";
					if(str.charAt(pos) == '+' || str.charAt(pos) == '-'){
						System.out.println(pos + " " + str.charAt(pos));
						if(str.charAt(pos) == '+')
							valeur = true;
						else
							valeur = false;
						pos += 2;
						while(str.charAt(pos) != '.'){
							rep += str.charAt(pos);
							pos++;
						}
						reponse = new Reponse(rep, valeur);
						quizz.addReponse(reponse);
						etat = Etat.REP;
					}
					break;
			}
			pos++;
		}
		System.out.println(quizz.toString());
		return quizz;
	}
}