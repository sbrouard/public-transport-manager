package tec;

abstract public class TestPassagerAbstrait {
   
    abstract protected PassagerAbstrait creerPassager(String nom, int destination);

    public static void main (String[] args) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}

	int nbTest = 0;
	
	//************ Verifier l'instanciation *************
	System.out.print('.'); nbTest++;
	new TestPassagerStandard().testInstanciation();
	
	//********* Verifier changement d'etat **************
	System.out.print('.'); nbTest++;
	new TestPassagerStandard().testGestionEtat();
	
	//********* Verifier les interactions  *************
	System.out.print('.'); nbTest++;
	new TestPassagerStandard().testInteractionMontee();
	
	System.out.print('.'); nbTest++;
	new TestPassagerStandard().testInteractionArret();
	
	System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStandard"); 
    }
 
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

    /* Interaction a un arret
     * Deux cas
     *  - numero d'arret < a la destination
     *  - numero d'arret >= a la destination 
     */
    public void testInteractionArret() {
	PassagerAbstrait p = creerPassager("yyy", 5);
	
	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
	
	p.nouvelArret(faux, 1);
	assert 0 == faux.messages.size() : "pas a destination";
	
	p.nouvelArret(faux, 5);
	assert "arretDemanderSortie" == faux.messages.getLast() : "destination";    
    }
    
    public abstract void testInteractionMontee();
}
