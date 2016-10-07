package tec;

public class Autobus {
  private int numero_arret;
  private PassagerStandard[] passagers;
  private Jauge my_debout;
  private Jauge my_assis;
  private int nb_debout;
  private int nb_assis;
  private int index;


  final Messages messages = new Messages();

  public Autobus(int assis, int debout)
  {
	  nb_debout = debout;
	  nb_assis = assis;
	  passagers = new PassagerStandard[nb_debout+nb_assis];
	  numero_arret = 0;
	  index = 0;

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

  // Enregistrements des appels effectues par PassagerStandard.
  public void monteeDemanderAssis(PassagerStandard p)
  {
	  if(aPlaceAssise())
	  {
		  p.changerEnAssis();
		  ajouterPassager(p);
		  my_assis.incrementer();
	  }
  }

  public void monteeDemanderDebout(PassagerStandard p)
  {
	  if(aPlaceDebout())
	  {
		  p.changerEnDebout();
		  ajouterPassager(p);
		  my_debout.incrementer();
	  }
  }

  public void arretDemanderDebout(PassagerStandard p)
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
  
  public void arretDemanderAssis(PassagerStandard p)
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

  public void arretDemanderSortie(PassagerStandard p)
  {
	  if(!p.estDehors())
	  {
		if(p.estAssis())
			my_assis.decrementer();
		else
			my_debout.decrementer();
	  	p.changerEnDehors();
		enleverPassager(p);
	  }
  }


  private void ajouterPassager(PassagerStandard p)
  {
	passagers[index] = p;
	index++;
  }

  private void enleverPassager(PassagerStandard p)
  {
	  int decal = 0;

	  for(int i=0;i<index;i++)
	  {
		  if(decal == 1)
			  passagers[i-1] = passagers[i];

		  if(passagers[i] == p)
			  decal = 1;

	  }
	  passagers[index-1] = null;
	  index--;
  }

  // PassagerStandard n'utilise pas cette méthode.
  public void allerArretSuivant()
  { 
	  for(int i=0;i<index;i++)
	  {
		passagers[i].nouvelArret(this,numero_arret);
	  }
	  numero_arret++;
  }

  @overide
  public String toString()
  {
	return "[arret "+numero_arret+"] assis<"+nb_assis+"> debout<"+nb_debout+">";
  }
}
