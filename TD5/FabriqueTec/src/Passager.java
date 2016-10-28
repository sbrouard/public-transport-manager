package tec;

interface Passager {
  public String nom();
  
  boolean estDehors();

  void nouvelArret(Vehicule b, int numeroArret);

  boolean estAssis();
  boolean estDebout();
  
  void changerEnDehors();
  void changerEnAssis();
  void changerEnDebout();
}
