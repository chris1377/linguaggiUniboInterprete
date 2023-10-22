package linguaggi;
import albero.*;
import valutatori.*;

public class Main {
	public static void main (String[] args) {
		
		String expression = "(52^2)^2";
		MyScanner scanner = new MyScanner(expression);
		MyInterpreter parser = new MyInterpreter(scanner);
		Exp ast = parser.parseExp(); //Crea albero dal parser
		System.out.println(ast);
		
		ParExpVisitor v = new ParExpVisitor(); //Valuti l'albero
		ast.accept(v);
		System.out.println(ast + " \t " + v.getResult());
		
		EvalExpVisitor vEval = new EvalExpVisitor();
		ast.accept(vEval);
		System.out.println(ast + " = " + vEval.getResult());
		
		PostExpVisitor vPost = new PostExpVisitor();
		ast.accept(vPost);
		System.out.println(ast + " = " + vPost.getResult());
		
		LettereExpVisitor vLet = new LettereExpVisitor();
		ast.accept(vLet);
		System.out.println(ast + " = " + vLet.getResult());
		
	}
}
