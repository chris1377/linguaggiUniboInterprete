package valutatori;

import albero.*;
import linguaggi.*;

public class EvalExpVisitor implements ExpVisitor{

	int value;
	public int getResult() { return value; }
	public void visit(PlusExp e) {
	e.left().accept(this); int arg1 = getResult();
	e.right().accept(this); int arg2 = getResult();
	value = arg1 + arg2;
	}
	
	public void visit(NumExp e) { value = e.getValue(); }
	
	@Override
	public void visit(MinusExp e) {
		e.left().accept(this); int arg1 = getResult();
		e.right().accept(this); int arg2 = getResult();
		value = arg1 - arg2;
		
	}
	@Override
	public void visit(TimesExp e) {
		e.left().accept(this); int arg1 = getResult();
		e.right().accept(this); int arg2 = getResult();
		value = arg1 * arg2;
		
	}
	@Override
	public void visit(DivExp e) {
		e.left().accept(this); int arg1 = getResult();
		e.right().accept(this); int arg2 = getResult();
		value = arg1 / arg2;
		
	}
	@Override
	public void visit(PotExp e) {
		e.left().accept(this); int arg1 = getResult();
		e.right().accept(this); int arg2 = getResult();
		value = 1;
		for(value = 1; arg2>0; arg2--) {
			value = value * arg1;
		}
		
	}
	
	
}
