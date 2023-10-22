package linguaggi;

public class MyScanner {
	
	int indice;
	String[] valori;

	public MyScanner(String txt){
		indice=0;
		valori = txt.split("(?=[\\^()+-])|(?<=[\\^()+-])");
	}
	
	
	public Token getNextToken(){
		try{
			String res = valori[indice];
			indice++;
			return new Token(res);
		}
			catch (Exception e){
			return null;
		}
	}
}
