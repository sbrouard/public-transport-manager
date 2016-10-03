package tec;

public class Autobus {
  static final byte VIDE   = 0;
  static final byte DEBOUT = 1;
  static final byte ASSIS  = 2;
  static final byte PLEIN  = 4;
  private byte status;
  private int nb_debout;
  private int nb_debout_left;
  private int nb_assis;
  private int nb_assis_left;
  private int numero_arret;
  private PassagerStandard[] passagers;



  final Messages messages = new Messages();
  Autobus() {
    status = VIDE;
  }

  Autobus(byte init) {
    status = init;
  }

  Autobus(int assis, int debout)
  {
	  nb_debout = debout;
	  nb_assis = assis;
	  passagers = new PassagerStandard[nb_debout+nb_assis];
	  numero_arret = 0;

	  nb_debout_left = debout;
	  nb_assis_left = assis;
	  
	  if(nb_debout+nb_assis > 0)
	  {
		  status = VIDE;
	  }
	  else
	  {
		  status = PLEIN;
	  }
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
  public void monteeDemanderAssis(PassagerStandard p)
  {
	  if(p.estDehors())
	  {
		  if(aPlaceAssise())
		  {
			  p.changerEnAssis();
			  nb_assis_left--;
			  statusChanged();
			  ajouterPassager(p);
		  }
	  }
  }

  public void monteeDemanderDebout(PassagerStandard p)
  {
	  if(p.estDehors())
	  {
		  if(aPlaceDebout())
		  {
			  p.changerEnDebout();
			  nb_debout_left--;
			  statusChanged();
			  ajouterPassager(p);
		  }
	  }
  }

  public void arretDemanderDebout(PassagerStandard p)
  {
	  if(aPlaceAssise())
	  {
		  if(p.estAssis())
		  {
			p.changerEnDebout();
			nb_assis_left++;
			nb_debout_left--;
			statusChanged();
		  }
	  }
  }
  
  public void arretDemanderAssis(PassagerStandard p)
  {
	  if(aPlaceDebout())
	  {
		  if(p.estDebout())
		  {
			p.changerEnAssis();
			nb_assis_left--;
			nb_debout_left++;
			statusChanged();
		  }
	  }
  }

  public void arretDemanderSortie(PassagerStandard p)
  {
	  if(!p.estDehors())
	  {
	  	p.changerEnDehors();
		enleverPassager(p);
	  }
  }

  private void statusChanged()
  {
	  if(nb_debout_left == 0)
		  status &= DEBOUT^0xff;
	  else
	  {
		  status &= PLEIN^0xff;
		  status |= DEBOUT;
	  }

	  if(nb_assis_left == 0)
		  status &= ASSIS^0xff;
	  else
	  {
		  status &= PLEIN^0xff;
		  status |= ASSIS;
	  }

	  if(nb_assis_left == nb_assis && nb_debout_left == nb_debout)
		  status = VIDE;
	  if(status == 0)
		  status = PLEIN;
  }

  private void ajouterPassager(PassagerStandard p)
  {
	passagers[nb_assis_left+nb_debout_left-1] = p;
  }

  private void enleverPassager(PassagerStandard p)
  {
	  int decal = 0;

	  for(int i=nb_assis+nb_debout-1;i>0;i--)
	  {
		  if(passagers[i] == p)
			  decal = 1;

		  if(decal == 1)
			  passagers[i-1] = passagers[i];
	  }
	  passagers[0] = null;
  }

  // PassagerStandard n'utilise pas cette méthode.
  public void allerArretSuivant()
  { 
	  for(int i=nb_assis+nb_debout-1;i>=0 && passagers[i] != null;i--)
	  {
		passagers[i].nouvelArret(this,numero_arret);
	  }
	  numero_arret++;
  }
}
