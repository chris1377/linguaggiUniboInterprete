package albero;

public class TimesExp extends OpExp {
	
	public TimesExp( Exp l, Exp r) {super(l,r);}
	
	public String myOp() { return "*" ; }
	
	public void accept( ExpVisitor v) { v.visit(this); }
}
