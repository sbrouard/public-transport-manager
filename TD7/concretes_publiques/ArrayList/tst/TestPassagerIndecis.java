package tec;

public class TestPassagerIndecis extends TestPassagerAbstrait {

    public static void main (String[] args) throws TecInvalidException{ 
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}

	int nbTest = 0;
	
	//************ Verifier l'instanciation *************
	System.out.print('.'); nbTest++;
	new TestPassagerIndecis().testInstanciation();
	
	//********* Verifier changement d'etat **************
	System.out.print('.'); nbTest++;
	new TestPassagerIndecis().testGestionEtat();
	
	//********* Verifier les interactions  *************
	System.out.print('.'); nbTest++;
	new TestPassagerIndecis().testInteractionMontee();
	
	System.out.print('.'); nbTest++;
	new TestPassagerIndecis().testInteractionArret();
	
	System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStandard"); 
    }

    protected PassagerAbstrait creerPassager(String nom, int destination) {
	return new PassagerIndecis(nom, destination);
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

    /* Interaction a la montee
     * Trois cas
     *  - des places assises et debout
     *  - pas de place assise
     *  - aucune place. 
     */
    public void testInteractionMontee() throws TecInvalidException{
	PassagerAbstrait p = creerPassager("yyy", 5);
	
	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
	p.monterDans(faux);
	
	assert "monteeDemanderDebout" == faux.messages.getLast() : "debout";    
	
	faux = new FauxVehicule(FauxVehicule.DEBOUT);
	p.monterDans(faux);
	
	assert "monteeDemanderDebout" == faux.messages.getLast() : "debout";    
	
	faux = new FauxVehicule(FauxVehicule.PLEIN);
	p.monterDans(faux);
	
	assert 0 == faux.messages.size() : "pas de place";        
    }
}
