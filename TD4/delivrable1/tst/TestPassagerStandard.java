package tec;

public class TestPassagerStandard {

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
    PassagerStandard p = new PassagerStandard("xxx", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  /* Gestion des changement d'état.
   * 
   * Changer Debout puis Dehors puis assis. 
   */
  public void testGestionEtat() {
    PassagerStandard p = new PassagerStandard("yyy", 3);

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
 
  /* Interaction a la montee
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */
  public void testInteractionMontee() {
    PassagerStandard p = new PassagerStandard("yyy", 5);
    
    Autobus faux = new Autobus(Autobus.VIDE);
    p.monterDans(faux);
    
    assert "monteeDemanderAssis" == faux.messages.getLast() : "assis";    
    
    faux = new Autobus(Autobus.DEBOUT);
    p.monterDans(faux);
    
    assert "monteeDemanderDebout" == faux.messages.getLast() : "debout";    

    faux = new Autobus(Autobus.PLEIN);
    p.monterDans(faux);
    
    assert 0 == faux.messages.size() : "pas de place";        
  }

  /* Interaction a un arret
   * Deux cas
   *  - numero d'arret < a la destination
   *  - numero d'arret >= a la destination 
   */
  public void testInteractionArret() {
    PassagerStandard p = new PassagerStandard("yyy", 5);
    
    Autobus faux = new Autobus(Autobus.VIDE);

    p.nouvelArret(faux, 1);
    assert 0 == faux.messages.size() : "pas a destination";

    p.nouvelArret(faux, 5);
    assert "arretDemanderSortie" == faux.messages.getLast() : "destination";    
    }
}
