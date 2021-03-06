package tec;

/**
 * Classe faussaire pour le test unitaire fonctionnel
 * d'Autobus. 
 *
 * Ce faussaire ne declenche pas d'appel aux methodes
 * d'Autobus.
 *
 * Il ne change pas son etat (la variable d'instance status). 
 * C'est le test qui change directement la valeur de cette variable. 
 *
 * Il enregistre l'appel aux méthodes qui doivent modifier son etat.
 */
class FauxPassager extends Passager implements Usager {
  static final byte DEHORS = 0;
  static final byte ASSIS  = 1;
  static final byte DEBOUT = 2;
  byte status;

  final Messages messages = new Messages();

  FauxPassager() {
    status = DEHORS;
  }

  FauxPassager(byte init) {
    status = init;
  }

  public String nom() {
    return null;
  }

  boolean estDehors() {
    return status == DEHORS;
  }
  
  boolean estAssis() {
    return status == ASSIS;
  }
  
  boolean estDebout() {
    return status == DEBOUT;
  }

  // Enregistrements des appels effectues par Autobus.
  void changerEnDehors() {
    status = DEHORS;
    messages.add("changerEnDehors");
  }


  void changerEnAssis() {
    status = ASSIS;
    messages.add("changerEnAssis");
  }

  void changerEnDebout() {
    status = DEBOUT;
    messages.add("changerEnDebout");
  }

  void nouvelArret(Vehicule bus, int numeroArret) {
    messages.add("nouvelArret");
  }

  // Autobus n'utilise pas cette méthode.
    public void monterDans(Transport t) { 
  }
}
