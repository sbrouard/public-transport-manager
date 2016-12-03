package tec;
import java.util.ArrayList;
import java.util.Iterator;

public class Tramway extends Vehicule implements Transport{
  private int numero_arret;
  private Jauge my_debout;
  private Jauge my_assis;
  private int nb_debout;
  private int nb_assis;
  private ArrayList<Passager> passagers;

  final Messages messages = new Messages();

  public Tramway(int assis, int debout)
  {
	  nb_debout = debout;
	  nb_assis = assis;

	  passagers = new ArrayList();
	  numero_arret = 0;

	  if(assis < 0 || debout < 0)
	  {
	      throw new java.lang.IllegalArgumentException("assis or debout must be >0");
	  }


	  if(debout <= 0)
		my_debout = null;
	  else
	  	my_debout = new Jauge(debout,0);

	  if(assis <= 0)
	  	my_assis = null;
	  else
	  	my_assis = new Jauge(assis,0);
  }

  public boolean aPlaceAssise()
  {
	if(my_assis == null)
		return false;
	if(my_assis.estRouge())
		return false;
	else
		return true;
  }

  public boolean aPlaceDebout()
 {

	if(my_debout == null)
		return false;
	if(my_debout.estRouge())
		return false;
	else
		return true;
  }

  boolean isAlreadyIn(Passager p)
  {
      return this.passagers.contains(p);
  }


  // Enregistrements des appels effectues par Passager.
  void monteeDemanderAssis(Passager p)
  {
  	  if(isAlreadyIn(p))
	      throw new java.lang.IllegalStateException("Passager must not be already in");

	  if(aPlaceAssise())
	  {
		  p.changerEnAssis();
		  ajouterPassager(p);
		  my_assis.incrementer();
	  }
  }

  void monteeDemanderDebout(Passager p)
  {
  	  if(isAlreadyIn(p))
	      throw new java.lang.IllegalStateException("Passager must not be already in");
	  p.changerEnDebout();
	  ajouterPassager(p);
	  my_debout.incrementer();
  }

  void arretDemanderDebout(Passager p)
  {
	  if(aPlaceDebout())
	  {
		  if(p.estAssis())
		  {
			p.changerEnDebout();
			my_debout.incrementer();
			my_assis.decrementer();
		  }
	  }
  }
  
  void arretDemanderAssis(Passager p)
  {
	  if(aPlaceAssise())
	  {
		  if(p.estDebout())
		  {
			p.changerEnAssis();
			my_assis.incrementer();
			my_debout.decrementer();
		  }
	  }
  }

  void arretDemanderSortie(Passager p)
  {
	if(p.estAssis())
		my_assis.decrementer();
	else
		my_debout.decrementer();
	p.changerEnDehors();
	enleverPassager(p);
  }


  private void ajouterPassager(Passager p)
  {
      this.passagers.add(p);
  }

  private void enleverPassager(Passager p)
  {
      this.passagers.remove(p);
  }

  // Passager n'utilise pas cette méthode.
  public void allerArretSuivant()
  { 
	  numero_arret++;
	  System.out.println("ARRET SUIVANT, PASSEZ UNE BONNE JOURNEE !!");
	  ArrayList cl = (ArrayList) passagers.clone();
	  Iterator<Passager> i = cl.iterator();
	  Passager p;
	  while(i.hasNext()){
	      p = i.next();
	      p = passagers.get(passagers.indexOf(p));
	      p.nouvelArret(this, numero_arret);
	  }
  }

    public void allerArretSuivant(Greffon g)
    { 
	numero_arret++;
	System.out.println("ARRET SUIVANT, PASSEZ UNE BONNE JOURNEE !!");
	ArrayList cl = (ArrayList) passagers.clone();
	Iterator<Passager> i = cl.iterator();
	Passager p;
	while(i.hasNext()){
	    p = i.next();
	    p = passagers.get(passagers.indexOf(p));
	    p.nouvelArret(g, numero_arret);
	  }
    }
    
  @Override
  public String toString()
  {
	return "[arret "+numero_arret+"] assis"+my_assis.toString()+" debout"+my_debout.toString()+"";
  }
}
