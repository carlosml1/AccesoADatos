package prZooDAO;

public class Main {

	public static void main(String[] args) {
		
		Animal a = new Animal("Ardilla","Bosque",0.1);
		
		AnimalDAO.insertAnimal(a);
	}

}
