package tec;

public class TestPassagerStandard extends TestPassagerAbstrait {

    protected PassagerAbstrait creerPassager(String nom, int destination) {
	return new PassagerStandard(nom, destination);
    }

    /* Interaction a la montee
     * Trois cas
     *  - des places assises et debout
     *  - pas de place assise
     *  - aucune place. 
     */
    public void testInteractionMontee() {
	PassagerAbstrait p = creerPassager("yyy", 5);
	
	FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
	p.monterDans(faux);
	
	assert "monteeDemanderAssis" == faux.messages.getLast() : "assis";    
	
	faux = new FauxVehicule(FauxVehicule.DEBOUT);
	p.monterDans(faux);
	
	assert "monteeDemanderDebout" == faux.messages.getLast() : "debout";    
	
	faux = new FauxVehicule(FauxVehicule.PLEIN);
	p.monterDans(faux);
	
	assert 0 == faux.messages.size() : "pas de place";        
    }
}
