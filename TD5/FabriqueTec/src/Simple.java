import tec.Usager;
import tec.Transport;
import tec.FabriqueTec;

class Simple {
    
    public void testIntegration() {
	Transport serenity = FabriqueTec.faireBus(1, 2);
	
	Usager kaylee = FabriqueTec.fairePassagerStd("Kaylee", 4);
	Usager jayne = FabriqueTec.fairePassagerStd("Jayne", 4);
	Usager inara = FabriqueTec.fairePassagerStd("Inara", 5);
    
	//0
	System.out.println(serenity.toString());
	
	//1
	serenity.allerArretSuivant();
	kaylee.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	
	//2
	serenity.allerArretSuivant();
	jayne.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	
	//3
	serenity.allerArretSuivant();
	inara.monterDans(serenity);
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());

	//4
	serenity.allerArretSuivant();
	
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());


	//5
	serenity.allerArretSuivant();
	
	System.out.println(serenity.toString());
	System.out.println(kaylee.toString());
	System.out.println(jayne.toString());
	System.out.println(inara.toString());
	
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
