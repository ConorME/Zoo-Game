import java.util.Scanner;
import java.util.Random;

class zoo{
    
    public exhibit[] exhibits;
    private final int SIZE;
    private int ndx;

    public zoo(int size){
        this.SIZE = size;
        this.exhibits = new exhibit[SIZE];
    }

    public static void main(String[] args){

        String[] animals = { "Elephant", "Lion", "Polar Bear", "Penguin", "Whale", "Dolphin" };
        String[] environments = { "Savannah", "Arctic", "Ocean"};
        String welcomePrompt = "Welcome to the Zoo Management System!";

        //Each is the number of each exhibit we want to instantiate.
        int each = 2, position;
        int zooSize = 6, exhibitSize = 4, animalValue;
        String c, randomAnimalSpecies, randomAnimalEnvironment, in;
        animal randomAnimal;

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        zoo exampleZoo = new zoo(zooSize);

        //Build exhibit array.
        int j = 0;
        for(String e : environments){
            for(int i = 0; i < each; i ++) {
                    exampleZoo.exhibits[i + j] = new exhibit(e, exhibitSize);
                }
                j += each;
        }

        System.out.println(welcomePrompt);

        while (true) {

            animalValue = rand.nextInt(animals.length);
            randomAnimalSpecies = animals[animalValue];

            //Get the preferred environment
            if (randomAnimalSpecies.equals("Elephant") || randomAnimalSpecies.equals("Lion")) {
                randomAnimalEnvironment = "Savannah";
            } else if (randomAnimalSpecies.equals("Polar Bear") || randomAnimalSpecies.equals("Penguin")) {
                randomAnimalEnvironment = "Arctic";
            } else if (randomAnimalSpecies.equals("Whale") || randomAnimalSpecies.equals("Dolphin")) {
                randomAnimalEnvironment = "Ocean";
            } else throw new RuntimeException("No matching environment.");

            //Instantiate random animal.
            randomAnimal = new animal(randomAnimalSpecies, randomAnimalEnvironment);

            System.out.println("A new " + randomAnimalSpecies + " is ready to be placed. Please select an exhibit:");

            //Output exhibit information.
            for (int i = 0; i < zooSize; i++) {
                position = (i % each) + 1;
                c = String.valueOf((char) (i + 65));
                System.out.println(exampleZoo.exhibits[i].getEnvironment() + " " + position + " (" + c + ") - " + exampleZoo.exhibits[i].getNumberOfAnimals() + " " + exampleZoo.exhibits[i].getSpecies() + "(s)");
            }

            int inputValue;
            try {
                in = input.next("[a-zA-Z]");
                inputValue = Character.getNumericValue(Character.toLowerCase(in.charAt(0)));
                inputValue -= 10;
                if (inputValue < zooSize) exampleZoo.exhibits[inputValue].addAnimal(randomAnimal);
                else throw new Exception("Input out of range.");

            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }
}
