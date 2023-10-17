import java.util.*;

public class City {
	private String name, country;
	private int population;
	public City(String name, int population, String country) {
		this.name = name;
		this.population = population;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}
	public String getCountry() {
		return country;
	}
}

public class CityProgram {
	public static void main(String[] args) {
		System.out.println("=== Enter cities ===");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter city name: ");
		String name = input.nextLine();
		System.out.print("Enter population: ");
		int population = Integer.parseInt(input.nextLine());
		System.out.print("Enter country: ");
		String country = input.nextLine();
		ArrayList<City> cities = new ArrayList<City>();
		City cityObject = new City(name, population, country);
		cities.add(cityObject);
		while (true) {
			System.out.print("\nEnter city name: ");
			name = input.nextLine();
			if (name.isEmpty()) {
				break;
			}
			System.out.print("Enter population: ");
			population = Integer.parseInt(input.nextLine());
			System.out.print("Enter country: ");
			country = input.nextLine();
			cityObject = new City(name, population, country);
			cities.add(cityObject);
		}
		System.out.println("\n=== Show cities ===");
		System.out.print("Enter country: ");
		country = input.nextLine();
		System.out.println();
		input.close();
		int max = 0;
		String mostPopulated = "";
		for (City object : cities) {
			if (object.getCountry().equals(country)) {
				System.out.println(object.getName() + ", " + object.getPopulation() + " inhabitants");
				if (object.getPopulation() > max) {
					max = object.getPopulation();
					mostPopulated = object.getName();
				}
			}
		}

		System.out.println("\nThe most populated city in " + country + " is " + mostPopulated);

	}

}
