import java.io.*;
import java.util.*;


public class Map {
	private boolean[][] map ;
	private ArrayList<Entite> entites;

	public Map(int taille) {
		this.map = new boolean[taille][taille];
		this.entites = new ArrayList<Entite>();
		this.generate();

	}

	public void moveHero(){
		Scanner sc = new Scanner(System.in);
		int choix=0 , compteur = 0;
		Hero j = (Hero) this.entites.get(0);
		//String[] deplacement_possible = {;

/*
		if(!this.isNotGround(j.getX(), j.getY()-1)) {
			deplacement_possible[compteur] = "OUEST";
			compteur ++;
		}
		if(!this.isNotGround(j.getX()+1, j.getY())) {
		deplacement_possible[compteur] = "SUD";
		compteur ++;
		}
		if(!this.isNotGround(j.getX(), j.getY()+1)) {
		deplacement_possible[compteur] = "EST";
		compteur ++;
		}
		if(!this.isNotGround(j.getX()-1, j.getY())) {
		deplacement_possible[compteur] = "NORTH";
		compteur ++;
		}
	
*/
		do{
			System.out.println("Où voulez vous allez:");
			System.out.println("1: OUEST\n2: SUD\n3: EST\n5: NORD");
			System.out.print("==> ");
			try{
				choix = sc.nextInt();
			}catch(Exception e){
				choix = 0;
			}
		}while(choix < 0 || choix > 5 || choix == 4);
		int dx=0,dy=0;
		switch(choix){
			case 1:
				dy--;
				break;
			case 3:
				dy++;
				break;
			case 5:
				dx--;
				break;
			case 2:
				dx++;
				break;
			default :
				//erreur a gerer meme si normalement pas de probleme
		}
		if(!this.isNotGround(j.getX()+dx,j.getY()+dy))
			j.deplacement(j.getX()+dx, j.getY()+dy);

	}

	public Entite last(){
		return this.entites.get(this.entites.size()-1);
	}
	public int getT(){
		return this.map.length;
	}
	public boolean isNotGround(int x, int y){
		return this.map[x][y];
	}
	public void add_E(Entite e){
		this.entites.add(e);
	}

	public void random_placement(Entite entite){
		int x,y;
		Random r = new Random();

		do{
			x = r.nextInt(this.getT());
			y = r.nextInt(this.getT());
		}while(this.isNotGround(x, y));
		entite.setX(x);
		entite.setY(y);
	}
	//////////////////////////////////
   //// fonction de construction ////
  //////////////////////////////////

	public void generate() {
		for(int i=0; i < this.map.length; i++){
			for(int j=0; j < this.map.length; j++){
				this.map[i][j] = false;
			}
		}
		this.contour();
	}

	public void contour() {
		for(int i = 0; i < this.map.length; i++) {
			this.map[0][i] = true;
			this.map[i][0] = this.map[i][this.map.length -1] = true; // mur des cotes de la map
			this.map[this.map.length - 1][i] = true;  // mur bas de la map
		}
	}

	//------------------------------------------------------------------------------------
	public void random_entite(){
		Random r = new Random();
		if (r.nextInt(1)==0)
			this.generateItem();
		else
			this.generateMonstre();
	}

	public void generateItem(){

	}

	public void generateMonstre(){

	}

	public String toString(){
		String retour="";
		boolean trouve;
		for(int i=0; i<this.map.length; i++){
			for(int j=0; j<this.map.length; j++){
				if (map[i][j]){
					retour+="#";
				}else{
					trouve = false;
					for (int e=0;e<entites.size();e++){
						if (this.entites.get(e).getX()==i && this.entites.get(e).getY()==j){
							retour+=this.entites.get(e).toString();
							trouve = true;
							break;
						}
					}
				if(!trouve)
					retour+=" ";
				}
			}
			retour += "\n";
		}
		return retour;
	/*	for (int i=0;i<map.length;i++){
			for (int j=0;j<map.length;j++){
				retour += map[i][j];
			}
		}
		return retour;
	*/
	}
/*
	public boolean save(String nom) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File(nom))));
			dos.writeInt(this.getTailleMap());
			for(int i = 0; i < this.getTailleMap(); i++) {
				for(int j = 0; j < this.getTailleMap(); j++) {
					dos.writeChar(this.map[i][j]);
				}
			}
			return true;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(dos != null)
					dos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}


	}
	public boolean load(String nom) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File(nom))));
			if(this.taille_map !=  dis.readInt()) {
				System.out.println("Les cartes n'ont pas la meme taille");;
			}
			else {
				for(int i = 0; i < this.getTailleMap(); i++) {
					for(int j = 0; j < this.getTailleMap(); j++) {
						this.map[i][j] = dis.readChar();
					}
				}
				return true;
			}
			return false;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(dis != null)
					dis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
 */
}
