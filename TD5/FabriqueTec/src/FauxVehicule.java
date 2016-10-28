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
class FauxVehicule implements Vehicule, Transport{
  static final byte VIDE   = 0;
  static final byte DEBOUT = 1;
  static final byte ASSIS  = 2;
  static final byte PLEIN  = 4;
  byte status;


  /**private:

  int max_assis;
  int max_debout;


  public :**/

  final Messages messages = new Messages();
  FauxVehicule() {
    status = VIDE;
  }

  FauxVehicule(byte init) {
    status = init;
  }

  FauxVehicule(int assis, int debout)
  {
    
  }

  public boolean aPlaceAssise() {
	return status == ASSIS 
      || status == VIDE;
  }

  public boolean aPlaceDebout() {
    return status == DEBOUT 
      || status == VIDE;
  }

  // Enregistrements des appels effectues par Passager.
  public void monteeDemanderAssis(Passager p) {
    messages.add("monteeDemanderAssis");
  }

  public void monteeDemanderDebout(Passager p) {
    messages.add("monteeDemanderDebout");
  }

  public void arretDemanderDebout(Passager p) {
    messages.add("arretDemanderDebout");
  }
  
  public void arretDemanderAssis(Passager p) {
    messages.add("arretDemanderAssis");
  }

  public void arretDemanderSortie(Passager p) {
    messages.add("arretDemanderSortie");    
  }

  // PassagerStandard n'utilise pas cette méthode.
  public void allerArretSuivant() { 
  }
}
