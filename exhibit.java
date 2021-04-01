class exhibit{
    
    private final int SIZE ;
    private int ndx;
    private animal[] animals;
    private String species;
    private String environment;

    exhibit( String e, int size){
        this.SIZE = size;
        this.environment = e;
        this.animals = new animal[SIZE];
        this.ndx = 0;
        this.species = "Animal";
    }

    public boolean addAnimal(animal a){

        if(this.isFull()) {
            System.out.println("Sorry. This exhibit is at capacity.");
            return false;
        }

        else if(!this.environment.equals(a.getEnvironment())) {
            System.out.println("A " + a.getSpecies() + " cannot be placed here. They need an " + a.getEnvironment() + " exhibit.");
            return false;
        }

        else if(this.species.equals(a.getSpecies())) {
            System.out.println("Fantastic! The new " + a.getSpecies() + " seems pleased with his new home!");
            ndx++;
            return true;
        }
        else if(this.ndx == 0){
            System.out.println("Fantastic! The new " + a.getSpecies() + " seems pleased with his new home!");
            ndx++;
            this.species = a.getSpecies();
            return true;
        }

        else return false;
    }

    public String getSpecies(){
        return this.species;
    }
    public String getEnvironment(){ return this.environment; }
    public boolean isEmpty() { return this.species == null; }
    public boolean isFull() { return this.ndx >= this.SIZE; }
    public int getNumberOfAnimals(){ return this.ndx; }
}
