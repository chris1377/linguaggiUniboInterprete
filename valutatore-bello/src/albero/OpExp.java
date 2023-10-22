package albero;

public abstract class OpExp extends Exp {
	
	Exp left, right;
	public Exp left() { return left; }
	public Exp right() { return right; }
	protected OpExp( Exp l, Exp r){ left=l; right=r;}
	public abstract String myOp();
	public String toString(){
	return left.toString() + myOp() + right.toString();
	}
}
