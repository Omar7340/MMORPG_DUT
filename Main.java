import java.util.Random;


public class Main {

	public static void main(String[] args) {
		Map m = new Map(30);
		int tab[]={10,10};
		Hero joueur = new Hero();
		m.add_E(joueur);
		m.random_placement(m.last());
		joueur.deplacement(2, 2);
		m.add_E(new Item());
		m.random_placement(m.last());
		clear();
		System.out.println(m);
		m.moveHero();
		clear();
		System.out.println(m);
	}

	public static void clear(){
		for(int i=0;i<40;i++)
        System.out.println("\n" );
	}


}
