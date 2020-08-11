class Animal {
	private boolean vegetarian;
	private String eats;
	private int noOfLegs;
	private String name;
	private String species;
	
	public Animal(boolean veg, String food, int legs, String name) {
		this.vegetarian = veg;
		this.eats = food;
		this.noOfLegs = legs;
		this.name = name;
		species = "Mixed";
	}
	
	public Animal(boolean veg, String food, int legs, String name, String species) {
		this.vegetarian = veg;
		this.eats = food;
		this.noOfLegs = legs;
		this.name = name;
		this.species = species;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public String getEats() {
		return eats;
	}

	public void setEats(String eats) {
		this.eats = eats;
	}

	public int getNoOfLegs() {
		return noOfLegs;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
}

class Cat extends Animal {
	
	private String color;

	public Cat(boolean veg, String food, int legs, String name) {
		super(veg, food, legs, name);
		this.color = "White";
	}
	
	public Cat(boolean veg, String food, int legs, String name, String color) {
		super(veg, food, legs, name);
		this.color = color;
	}

	public Cat(boolean veg, String food, int legs, String name, String species, String color) {
		super(veg, food, legs, name, species);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

class Persian extends Cat {
	
	private String eyeColor = "yellow";
	
	public Persian(boolean veg, String food, int legs, String name) {
		super(veg, food, legs, name);
		// TODO Auto-generated constructor stub
	}

	public Persian(boolean veg, String food, int legs, String name, String species, String color) {
		super(veg, food, legs, name, species, color);
		// TODO Auto-generated constructor stub
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
}

public class InheritancePrac {

	public static void main(String[] args) {

		Cat cat = new Cat(false, "milk", 3, "Nabi", "black");
		Persian miri = new Persian(false, "feed", 4, "miri", "persian", "white");
		
		miri.setEyeColor("blue");
		
		System.out.println("What is his name? : " + cat.getName());
		System.out.println("He eats " + cat.getEats());
		System.out.println("He has " + cat.getNoOfLegs() + " legs. He is injured...");
		System.out.println("He has " + cat.getColor() + " hair.");
		System.out.println("What his species? : " + cat.getSpecies());
		System.out.println();
		System.out.println("What is his name? : " + miri.getName());
		System.out.println("He eats " + miri.getEats());
		System.out.println("He has " + miri.getNoOfLegs() + " legs.");
		System.out.println("He has " + miri.getColor() + " hair.");
		System.out.println("What his species? : " + miri.getSpecies());
		System.out.println("He has " + miri.getEyeColor() + " eyes.");
	}
}
