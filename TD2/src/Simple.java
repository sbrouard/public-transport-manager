import tec.PassagerStandard;
import tec.Autobus;

class Simple {
    
    public void testIntegration() {
	Autobus serenity = new tec.Autobus(1, 2);
	
	PassagerStandard kaylee = new PassagerStandard("Kaylee", 4);
	PassagerStandard jayne = new PassagerStandard("Jayne", 4);
	PassagerStandard inara = new PassagerStandard("Inara", 5);
    
	//0
	serenity.toString();
	
	//1
	serenity.allerArretSuivant();
	kaylee.monterDans(serenity);
	
	serenity.toString();
	kaylee.toString();
	
	//2
	serenity.allerArretSuivant();
	jayne.monterDans(serenity);
	
	serenity.toString();
	kaylee.toString();
	jayne.toString();
	
	//3
	serenity.allerArretSuivant();
	inara.monterDans(serenity);
	
	serenity.toString();
	kaylee.toString();
	jayne.toString();
	inara.toString();

	//4
	serenity.allerArretSuivant();
	
	serenity.toString();
	kaylee.toString();
	jayne.toString();
	inara.toString();

	//5
	serenity.allerArretSuivant();
	
	serenity.toString();
	kaylee.toString();
	jayne.toString();
	inara.toString();
	
	/* Resulat de l'execution.
	   [arret 0] assis<1> debout<2>
	   [arret 1] assis<0> debout<2>
	   Kaylee <assis>
	   [arret 2] assis<0> debout<1>
	   Kaylee <assis>
	   Jayne <debout>
	   [arret 3] assis<0> debout<0>
	   Kaylee <assis>
	   Jayne <debout>
	   Inara <debout>
	   [arret 4] assis<1> debout<1>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <debout>
	   [arret 5] assis<1> debout<2>
	   Kaylee <endehors>
	   Jayne <endehors>
	   Inara <endehors>
	*/
    }
    
    public static void main (String[] args) {
  
	/*rappel pour ne pas oublier -ea */
	 boolean estMisAssertion = false;
	 assert estMisAssertion = true; 
	 if (!estMisAssertion) { 
	     System.out.println("Execution impossible sans l'option -ea");
	     return; 
	 }
	
	 Simple test1 = new Simple();
	 test1.testIntegration();
    }
}
