package tec;

abstract public class TestPassagerAbstrait {
   
    abstract protected PassagerAbstrait creerPassager(String nom, int destination);
 
    /* Etat apres instanciation
     * Un seul cas 
     */
    public void testInstanciation() {
	PassagerAbstrait p = creerPassager("xxx", 3);
	
	assert false == p.estAssis();
	assert false == p.estDebout();
	assert true == p.estDehors();
    }
    
    /* Gestion des changement d'état.
     * 
     * Changer Debout puis Dehors puis assis. 
     */
    public void testGestionEtat() {
	PassagerAbstrait p = creerPassager("yyy", 3);
	
	p.changerEnDebout();
	assert false == p.estAssis();
	assert true == p.estDebout();
	assert false == p.estDehors();
	
	p.changerEnDehors();
	assert false == p.estAssis();
	assert false == p.estDebout();
	assert true == p.estDehors();
	
	p.changerEnAssis();
	assert true == p.estAssis();
	assert false == p.estDebout();
	assert false == p.estDehors();
    }  
    
    public abstract void testInteractionArret();

    public abstract void testInteractionMontee();
}
