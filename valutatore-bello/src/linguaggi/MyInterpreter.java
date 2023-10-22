package linguaggi;

import albero.DivExp;
import albero.Exp;
import albero.MinusExp;
import albero.NumExp;
import albero.PlusExp;
import albero.PotExp;
import albero.TimesExp;

public class MyInterpreter {
	
	private MyScanner scanner;
	private Token currentToken;
	
	public MyInterpreter(MyScanner scanner) {
		this.scanner=scanner;
		currentToken=scanner.getNextToken();
	}

	public Exp parseExp() {
		Exp termSeq = parseTerm();
		while(currentToken != null) {
			if(currentToken.equals("+")) {
				currentToken = scanner.getNextToken();
				Exp nextTerm = parseTerm();
				if (nextTerm != null)
					termSeq = new PlusExp(termSeq, nextTerm); //Creato elemento dell'albero
				else return null;
			}
			else if(currentToken.equals("-")) {
				currentToken = scanner.getNextToken();
				Exp nextTerm = parseTerm();
				if (nextTerm != null)
					termSeq = new MinusExp(termSeq, nextTerm);
				else return null;
			}
			else return termSeq;
		}
		return termSeq;
	}
	
	
	public Exp parseTerm(){
		Exp factorSeq = parsePot();
		while (currentToken != null){
			if (currentToken.equals("*")) {
				currentToken = scanner.getNextToken();
				Exp nextFactor = parsePot();
				if (nextFactor != null)
					factorSeq = new TimesExp(factorSeq, nextFactor);
				else return null;
			}
			else if (currentToken.equals(":")) {
				currentToken = scanner.getNextToken();
				Exp nextFactor = parsePot();
				if (nextFactor != null)
					factorSeq = new DivExp(factorSeq, nextFactor);
				else return null;
			}
			else return factorSeq; // next token non fa parte di L(Term)
		} // end while
		return factorSeq; // next token nullo -> end input
	}
	
	public Exp parsePot(){
		Exp factorSeq = parseFactor();
		while (currentToken != null && !currentToken.equals("")){
			if (currentToken.equals("^") ) {
				currentToken = scanner.getNextToken();
				Exp nextFactor = parseFactor();
				if (nextFactor != null)
					factorSeq = new PotExp(factorSeq, nextFactor);
				else return null;
				
			}
			else return factorSeq; // next token non fa parte di L(Term)
		} // end while
		return factorSeq; // next token nullo -> end input
	}
	
	
	public Exp parseFactor() {
		if (currentToken.equals("(")) {
			currentToken = scanner.getNextToken();
			Exp innerExp = parseExp();
			if (currentToken.equals(")")) {
				currentToken = scanner.getNextToken();
				return innerExp; // parentesi irrilevanti
			} else throw new IllegalArgumentException("missing )"); // manca la parentesi chiusa
		}
		else // dev’essere un numero
		if (currentToken.isNumber()) {
			int value = currentToken.getAsInt();
			currentToken = scanner.getNextToken();
			return new NumExp(value);
		}
		else // non è un fattore, quindi
		 throw new IllegalArgumentException("non a number"); // non è qualcosa di riconosciuto
		}
	
}
