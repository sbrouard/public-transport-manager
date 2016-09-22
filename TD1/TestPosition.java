class TestPosition {
    
    public void testExterieur(){
	Position pos = new Position();
	assert !pos.estAssis() : "ERREUR : le passager est assis au depart";
	assert !pos.estDebout() : "ERREUR : le passager est debout au depart";
	assert pos.estDehors() : "ERREUR : le passager n'est pas a l'exterieur au depart";
	assert !pos.estInterieur() : "ERREUR : le passager est a l'interieur au depart";

    }

     public static void main (String[] args) {

	 /*rappel pour ne pas oublier -ea */
	 boolean estMisAssertion = false; assert estMisAssertion = true; if (!estMisAssertion) { System.out.println("Execution impossible sans l'option -ea"); return; }


	 TestPosition testPos = new TestPosition();
	 testPos.testExterieur();

	 
     }

}
