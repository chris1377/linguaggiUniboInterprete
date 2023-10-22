package albero;

public interface ExpVisitor {

	void visit( PlusExp e );
	void visit( MinusExp e );
	void visit( TimesExp e );
	void visit( DivExp e );
	void visit( NumExp e );
	void visit( PotExp e );
	
}
