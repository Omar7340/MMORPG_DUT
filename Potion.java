
public class Potion extends Item{
	private int degats; // <0 si potion de soin

	public Potion(){
		super();
		super.setNom("Potion");
		this.degats = 0;
	}
	public String toString(){
		return "P";
	}
}
