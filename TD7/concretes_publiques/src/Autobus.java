package tec;

public class Autobus extends Vehicule implements Transport{
  private int numero_arret;
  private Passager[] passagers;
  private Jauge my_debout;
  private Jauge my_assis;
  private int nb_debout;
  private int nb_assis;


  final Messages messages = new Messages();

  public Autobus(int assis, int debout)
  {
	  nb_debout = debout;
	  nb_assis = assis;
	  passagers = new Passager[nb_debout+nb_assis+1];//+1 pour le passager tétu
	  numero_arret = 0;

	  if(assis < 0 || debout < 0)
	  {
	      throw new java.lang.IllegalArgumentException("assis or debout must be >0");
	  }

	  for(int i=0;i<nb_debout+nb_assis;i++)
		passagers[i] = null;

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
	  boolean in = false;

	  for(int i=0;i<nb_assis+nb_debout && !in;i++)
	  {
		if(passagers[i].equals(p))
			 in = true;
	  }
	  
	  return in;
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
	  //if(aPlaceDebout())
	  //{
		  p.changerEnDebout();
		  ajouterPassager(p);
		  my_debout.incrementer();
	  //}
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
	int i;

	for(i=0;passagers[i]!=null;i++);

	passagers[i] = p;
  }

  private void enleverPassager(Passager p)
  {
	  int decal = 0;
	  int i;

	  for(i=0;passagers[i]!=p;i++);
		

	  passagers[i] = null;
  }

  // Passager n'utilise pas cette méthode.
  public void allerArretSuivant()
  { 
	  numero_arret++;
	  for(int i=0;i<nb_assis+nb_debout;i++)
	  {
		if(passagers[i] != null)
			 passagers[i].nouvelArret(this,numero_arret);
	  }
  }

  @Override
  public String toString()
  {
	return "[arret "+numero_arret+"] assis"+my_assis.toString()+" debout"+my_debout.toString()+"";
  }
}
