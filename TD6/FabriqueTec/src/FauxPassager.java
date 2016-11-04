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
class FauxPassager implements Passager, Usager{
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

  public boolean estDehors() {
    return status == DEHORS;
  }
  
  public boolean estAssis() {
    return status == ASSIS;
  }
  
  public boolean estDebout() {
    return status == DEBOUT;
  }

  // Enregistrements des appels effectues par Autobus.
  public void changerEnDehors() {
    status = DEHORS;
    messages.add("changerEnDehors");
  }


  public void changerEnAssis() {
    status = ASSIS;
    messages.add("changerEnAssis");
  }

  public void changerEnDebout() {
    status = DEBOUT;
    messages.add("changerEnDebout");
  }

  public void nouvelArret(Vehicule bus, int numeroArret) {
    messages.add("nouvelArret");
  }

  // Autobus n'utilise pas cette méthode.
    public void monterDans(Transport t) { 
  }
}
