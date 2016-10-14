package tec;

abstract class Passager {
  public boolean estDehors();

  void nouvelArret(Vehicule b, int numeroArret);

  public boolean estAssis();
  public boolean estDebout();

  public void changerEnDehors();
  public void changerEnAssis();
  public void changerEnDebout();
}
