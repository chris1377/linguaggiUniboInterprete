package valutatori;

import albero.*;
import linguaggi.*;

public class PostExpVisitor implements ExpVisitor{

	String curs = "";
	public String getResult() { return curs; } // accessor
	protected void visitOpExp(OpExp e){
	e.left().accept(this); String sleft = getResult();
	e.right().accept(this); String sright = getResult();
	curs = "(" + sleft + " " + sright + " " +  e.myOp() + " " + ")";
	}
	public void visit( PlusExp e ) { visitOpExp(e); }
	public void visit( MinusExp e ) { visitOpExp(e); }
	public void visit( TimesExp e ) { visitOpExp(e); }
	public void visit( DivExp e ) { visitOpExp(e); }
	public void visit( PotExp e ) { visitOpExp(e); }
	public void visit( NumExp e ) { curs = "" + e.getValue(); }
	
}
