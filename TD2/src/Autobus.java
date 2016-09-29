package tec;

/**
 * Classe faussaire pour le test unitaire fonctionnel
 * de PassagerStandard
 *
 * Ce faussaire ne declenche pas d'appel aux methodes
 * de PassagerStandard.
 *
 * Il ne change pas son etat (la variable d'instance status). 
 * C'est le test qui change directement la valeur de cette variable. 
 *
 * Il enregistre l'appel aux méthodes qui
 * doivent modifier son etat.
 */
class Autobus {
  static final byte VIDE   = 0;
  static final byte DEBOUT = 1;
  static final byte ASSIS  = 2;
  static final byte PLEIN  = 4;
  byte status;

  final Messages messages = new Messages();

  Autobus() {
    status = VIDE;
  }

  Autobus(byte init) {
    status = init;
  }

  public boolean aPlaceAssise() {
    return status == ASSIS 
      || status == VIDE;
  }

  public boolean aPlaceDebout() {
    return status == DEBOUT 
      || status == VIDE;
  }

  // Enregistrements des appels effectues par PassagerStandard.
  public void monteeDemanderAssis(PassagerStandard p) {
    messages.add("monteeDemanderAssis");
  }

  public void monteeDemanderDebout(PassagerStandard p) {
    messages.add("monteeDemanderDebout");
  }

  public void arretDemanderDebout(PassagerStandard p) {
    messages.add("arretDemanderDebout");
  }
  
  public void arretDemanderAssis(PassagerStandard p) {
    messages.add("arretDemanderAssis");
  }

  public void arretDemanderSortie(PassagerStandard p) {
    messages.add("arretDemanderSortie");    
  }

  // PassagerStandard n'utilise pas cette méthode.
  public void allerArretSuivant() { 
  }
}
