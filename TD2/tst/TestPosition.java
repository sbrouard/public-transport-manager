package tec;

class TestPosition {
    
    public void testExterieur(){
	Position pos = new Position();
	int nbTestOK = 0;
	int nbTest = 0;
	
	System.out.println("Test exterieur a la creation d'une instance :");
	
	assert !pos.estAssis() : "ERREUR : le passager est assis au depart";
	nbTestOK++;
	nbTest++;
	
	assert !pos.estDebout() : "ERREUR : le passager est debout au depart";
	nbTestOK++;
	nbTest++;
	
	assert pos.estDehors() : "ERREUR : le passager n'est pas a l'exterieur au depart";
	nbTestOK++;
	nbTest++;
	
	assert !pos.estInterieur() : "ERREUR : le passager est a l'interieur au depart";
	nbTestOK++;
	nbTest++;
	System.out.println(nbTestOK + " tests reussis sur " + nbTest + "\n");
    }

    public void testAssis(){
	Position pos = new Position();
	int nbTestOK = 0;
	int nbTest = 0;
	pos = pos.assis();
	
	System.out.println("Test assis() : \n");

	assert pos.estAssis() : "ERREUR : le passager n'est pas assis";
	nbTestOK++;
	nbTest++;

	/* assert !pos.estDebout() : "ERREUR : le passager est debout";
	nbTestOK++;
	*/
	nbTest++;

	/*
	assert !pos.estDehors() : "ERREUR : le passager est dehors";
	nbTestOK++;
	*/
	nbTest++;

	assert pos.estInterieur() : "ERREUR : le passager est a l'interieur";
	nbTestOK++;
	nbTest++;
	System.out.println(nbTestOK + " tests reussis sur " + nbTest + "\nDeboggage : " + pos.toString() + "\n");
    }

    public void testDebout(){
	Position pos = new Position();
	int nbTestOK = 0;
	int nbTest = 0;
	pos = pos.debout();

	System.out.println("Test debout : \n");

    	assert !pos.estAssis() : "ERREUR : le passager est assis";
	nbTestOK++;
	nbTest++;

	/* assert pos.estDebout() : "ERREUR : le passager n'est pas debout";
	nbTestOK++;
	*/
	nbTest++;

	assert !pos.estDehors() : "ERREUR : le passager est dehors";
	nbTestOK++;
	nbTest++;

	assert pos.estInterieur() : "ERREUR : le passager est a l'interieur";
	nbTestOK++;
	nbTest++;
	System.out.println(nbTestOK + " tests reussis sur " + nbTest + "\nDeboggage : " + pos.toString() + "\n");	
    }

    public void testDehors(){
    	Position pos = new Position();
	int nbTestOK = 0;
	int nbTest = 0;
	pos = pos.dehors();

	System.out.println("Test dehors : \n");

    	assert !pos.estAssis() : "ERREUR : le passager est assis";
	nbTestOK++;
	nbTest++;

	assert !pos.estDebout() : "ERREUR : le passager est debout";
	nbTestOK++;
	nbTest++;

	/* assert pos.estDehors() : "ERREUR : le passager n'est pas dehors";
	nbTestOK++;
	*/
	nbTest++;

	/*assert !pos.estInterieur() : "ERREUR : le passager est a l'interieur";
	nbTestOK++;
	*/
	nbTest++;
	System.out.println(nbTestOK + " tests reussis sur " + nbTest + "\nDeboggage : " + pos.toString() + "\n");		
    }

     public static void main (String[] args) {

	 /*rappel pour ne pas oublier -ea */
	 boolean estMisAssertion = false; assert estMisAssertion = true; if (!estMisAssertion) { System.out.println("Execution impossible sans l'option -ea"); return; }

	 System.out.println(".");	
	 TestPosition testPos1 = new TestPosition();
	 testPos1.testExterieur();
	 
	 System.out.println(".");
	 TestPosition testPos2 = new TestPosition();
	 testPos2.testAssis();

	 System.out.println(".");
	 TestPosition testPos3 = new TestPosition();
	 testPos3.testDebout();

	 System.out.println(".");
	 TestPosition testPos4 = new TestPosition();
	 testPos4.testDehors();
     }
}
