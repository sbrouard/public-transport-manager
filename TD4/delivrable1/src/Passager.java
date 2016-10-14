package tec;

public interface Passager {
  public String nom();
  public boolean estDehors();
  
  void monterDans(Vehicule b);

  void nouvelArret(Vehicule b, int numeroArret);

  public boolean estAssis();
  public boolean estDebout();

  public void changerEnDehors();
  public void changerEnAssis();
  public void changererEnDebout();
}
