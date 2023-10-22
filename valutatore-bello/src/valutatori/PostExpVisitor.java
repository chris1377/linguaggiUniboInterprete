package valutatori;

import albero.*;
import linguaggi.*;
import pl.allegro.finance.tradukisto.ValueConverters;

public class PostExpVisitor implements ExpVisitor{
	

	String curs = "";
	public String getResult() { return curs; } // accessor
	
	protected void visitOpExp(OpExp e){
	e.left().accept(this); String sleft = getResult();
	e.right().accept(this); String sright = getResult();
	String op="";
	switch( e.myOp()) {
		case "+" :
			op = "più";
			break;
		case "-" :
			op = "meno";
			break;
		case "*" :
			op = "per";
			break;
		case "/" :
			op = "diviso";
			break;
		case "^" :
			op = "alla";
			break;
		default:
			op="OPERATORE NON RICONOSCIUTO";
	}
	curs = "(" + sleft + " "  +  op + " " + sright + " "+ ")";
	}
	
	
	public void visit( PlusExp e ) { visitOpExp(e); }
	public void visit( MinusExp e ) { visitOpExp(e); }
	public void visit( TimesExp e ) { visitOpExp(e); }
	public void visit( DivExp e ) { visitOpExp(e); }
	public void visit( PotExp e ) { visitOpExp(e); }
	
	public void visit( NumExp e ) { 
		ValueConverters intConverter = ValueConverters.ITALIAN_INTEGER;
		String num = intConverter.asWords(e.getValue());
		curs = "" + num; 
	
	}
	
}
