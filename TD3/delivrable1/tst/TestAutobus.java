package tec;

class TestAutobus {

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
    new TestAutobus().testInstanciation();

    //********* Verifier la gestion des places **********
    System.out.print('.'); nbTest++;
    new TestAutobus().testGestionDemander();

    System.out.print('.'); nbTest++;
    new TestAutobus().testGestionChanger();

    System.out.print('.'); nbTest++;
    new TestAutobus().testGestionSortie();

    //******** Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestAutobus().testInteractionDemander();

    System.out.print('.'); nbTest++;
    new TestAutobus().testInteractionChanger();

    System.out.print('.'); nbTest++;
    new TestAutobus().testInteractionSortie();

    //********* Gestion des passagers ***************
    System.out.print('.'); nbTest++;
    new TestAutobus().testArretSuivant();

    System.out.println("(" + nbTest + "):OK: " + "tec.TestAutobus"); 
  }

  //********************************************************

  /* Etat apres instanciation
   * Deux cas d'autobus:
   *   - uniquement des places assises.
   *   - uniquement des places debout.
   */
  void testInstanciation() {
    //*********** Assis ****************************
    Autobus assis = new Autobus(66, 0);

    assert true == assis.aPlaceAssise();
    assert false == assis.aPlaceDebout();

    //************ Debout ***************************
    Autobus debout = new Autobus(0, 99);

    assert false == debout.aPlaceAssise();
    assert true == debout.aPlaceDebout();
  }


  /* Gestion des places a la montee.
   *
   * Remplir toutes les places assises d'un autobus.
   * Remplir toutes les places debout d'un autobus.
   */
  void testGestionDemander() {
    PassagerStandard[] faux = {new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard()}; //10

    Autobus bus = new Autobus(5, 3);

    //********* Assis *******************************
    for (int i = 1; i < 5; i++) { //4
      bus.monteeDemanderAssis(faux[i]);
      assert true == bus.aPlaceAssise() : "demande " + i;	
    }

    bus.monteeDemanderAssis(faux[5]);
    assert false == bus.aPlaceAssise() : "demande 5: fin assis";


    //*********** Debout ******************************
    bus.monteeDemanderDebout(faux[6]);
    assert true == bus.aPlaceDebout() : "demande 1";	

    bus.monteeDemanderDebout(faux[7]);
    assert true == bus.aPlaceDebout() : "demande 2";	

    bus.monteeDemanderDebout(faux[8]);
    assert false == bus.aPlaceDebout() : "demande 3: fin debout";
  }

  /* Gestion des places à la sortie d'un passager a un arret. 
   *
   * Remplir toutes les places assises et toutes les places debout.
   * Faire sortir un assis et un debout.
   */
  void testGestionSortie() {
    PassagerStandard[] faux = {new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard()}; // 9

    Autobus bus = new Autobus(3, 4);

    //*************** Remplir **********************
    for (int i = 1; i < 4; i++) { //3
      bus.monteeDemanderAssis(faux[i]);
      faux[i].status = PassagerStandard.ASSIS;
    }

    for (int i = 4; i <= 7; i++) { //4
      bus.monteeDemanderDebout(faux[i]);
      faux[i].status = PassagerStandard.DEBOUT;
    }

    //***************** Sortir *************************
    bus.arretDemanderSortie(faux[6]);
    assert true == bus.aPlaceDebout() : "sortie debout";

    bus.arretDemanderSortie(faux[2]);
    assert true == bus.aPlaceAssise() : "sortie assis";
  }

  /* Gestion du changement de places a un arret.
   *
   * Remplir Autobus max assise et max debout - 1.
   * 
   * Changer un assis en debout
   * et un debout en assis.
   */
  void testGestionChanger() {
    PassagerStandard[] faux = {new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard()}; // 9

    Autobus bus = new Autobus(3, 5);

    //*************** Remplir **********************
    for (int i = 1; i < 4; i++) { //3
      bus.monteeDemanderAssis(faux[i]);
      faux[i].status = PassagerStandard.ASSIS;
    }

    for (int i = 4; i <= 7; i++) { //4
      bus.monteeDemanderDebout(faux[i]);
      faux[i].status = PassagerStandard.DEBOUT;
    }

    //************** Changer *************************
    bus.arretDemanderDebout(faux[2]);
    assert true == bus.aPlaceAssise() : "assis";
    assert false == bus.aPlaceDebout() : "debout";


    bus.arretDemanderAssis(faux[5]);
    assert false == bus.aPlaceAssise() : "assis";
    assert true == bus.aPlaceDebout() : "debout";
  }


  /* Interaction a la montee.
   *
   * Remplir un autobus debout puis assis.
   */
  void testInteractionDemander() {
    PassagerStandard[] faux = {new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard()}; //10

    Autobus bus = new Autobus(3, 5);

    //*********** Debout ******************************
    for (int i = 1; i < 6; i++) { //5
      bus.monteeDemanderDebout(faux[i]);
      assert 1 == faux[i].messages.size() 
	: "erreur nombre d'appels pour " + i;
      assert "changerEnDebout" == faux[i].messages.getLast() 
	: "mauvais appel pour " + i;
    }

    //********* Assis *******************************
    for (int i = 6; i < 9; i++) { //3
      bus.monteeDemanderAssis(faux[i]);
      assert 1 == faux[i].messages.size() 
	: "erreur nombre d'appels pour " + i;
      assert "changerEnAssis" == faux[i].messages.getLast() 
	: "mauvais appel pour " + i;
    }
  }


  /* Interaction pour un changement de places.
   * 
   * Changer un debout en assis puis d'assis à debout.
   */
  void testInteractionChanger() {
    PassagerStandard faux = new PassagerStandard();

    Autobus bus = new Autobus(1, 1);

    bus.monteeDemanderDebout(faux);
    faux.status = PassagerStandard.DEBOUT;

    bus.arretDemanderAssis(faux);
    assert 2 == faux.messages.size() : "erreur nombre d'appels";
    assert "changerEnAssis" == faux.messages.getLast() : "mauvais appel";

    bus.arretDemanderDebout(faux);
    assert 3 == faux.messages.size() : "erreur nombre d'appels";
    assert "changerEnDebout" == faux.messages.getLast() : "mauvais appel";
  }

  /* Interaction la sortie d'un passager.
   *
   * demander des places assises et debout.
   * et faire sortir un assis et un debout.
   */
  void testInteractionSortie() {
    PassagerStandard[] faux = {new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard()}; // 9

    Autobus bus = new Autobus(10, 20);

    //*************** Ajouter **********************
    bus.monteeDemanderAssis(faux[1]);
    faux[1].status = PassagerStandard.ASSIS;

    bus.monteeDemanderDebout(faux[2]);
    faux[2].status = PassagerStandard.DEBOUT;

    bus.monteeDemanderDebout(faux[3]);
    faux[3].status = PassagerStandard.DEBOUT;

    bus.monteeDemanderAssis(faux[4]);
    faux[4].status = PassagerStandard.ASSIS;

    bus.monteeDemanderDebout(faux[5]);
    faux[5].status = PassagerStandard.DEBOUT;

    bus.monteeDemanderAssis(faux[6]);
    faux[6].status = PassagerStandard.ASSIS;

    bus.monteeDemanderAssis(faux[7]);
    faux[7].status = PassagerStandard.ASSIS;

    //***************** Sortir *************************
    bus.arretDemanderSortie(faux[6]);
    assert 2 == faux[6].messages.size() : "erreur nombre d'appels";
    assert "changerEnDehors" == faux[6].messages.getLast() : "mauvais appel";

    bus.arretDemanderSortie(faux[2]);
    assert 2 == faux[2].messages.size() : "erreur nombre d'appels";
    assert "changerEnDehors" == faux[2].messages.getLast() : "mauvais appel";
  }


  //********* Gestion des passagers ***************
  /* Interaction pour indiquer un arret au passager
   * L'autobus declenche la methode nouvelArret
   * sur tous les passagers stockes. 
   * 
   * Ajouter quelques passager assise et debout.
   * Faire sortie des passagers assis et debout.
   */
  void testArretSuivant() {
    PassagerStandard[] faux = {new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard()}; // 9

    Autobus bus = new Autobus(99, 66);

    //********* Ajout des passagers **********
    for (int i = 1; i < 5; i++) {
      bus.monteeDemanderAssis(faux[i]);
      faux[i].status = PassagerStandard.ASSIS;
    }

    for (int i = 5; i < 9; i++) {
      bus.monteeDemanderDebout(faux[i]);
      faux[i].status = PassagerStandard.DEBOUT;
    }

    /*******************************************/
    bus.allerArretSuivant();
    
    for (int i = 1; i < 9; i++) {
      assert 2 == faux[i].messages.size() 
	: "erreur nombre d'appels pour " + i;
      assert "nouvelArret" == faux[i].messages.getLast() 
	: "mauvais appel pour " + i;
    }

    //******** Suppression de passagers ******************
    bus.arretDemanderSortie(faux[3]);
    bus.arretDemanderSortie(faux[6]);
    bus.arretDemanderSortie(faux[8]);

    bus.monteeDemanderDebout(faux[0]);
    faux[0].status = PassagerStandard.DEBOUT;

    bus.allerArretSuivant();

    assert "nouvelArret" != faux[3].messages.getLast() 
      : "plus d'appel a nouvelArret:3";
    assert "nouvelArret" != faux[6].messages.getLast() 
      : "plus d'appel a nouvelArret:6";
    assert "nouvelArret" != faux[8].messages.getLast() 
      : "plus d'appel a nouvelArret:8";

    assert "nouvelArret" == faux[0].messages.getLast() 
      : "plus d'appel a nouvelArret:0";

    for (int i = 1; i < 8; i++) {
      if (3 == i || 6 == i)
	continue;
      
      assert 3 == faux[i].messages.size() 
	: "erreur nombre d'appels pour " + i;
      assert "nouvelArret" == faux[i].messages.getLast() 
	: "mauvais appel pour " + i;
    }
  }
}
