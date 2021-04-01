class animal{
    private String species;
    private String environment;

    animal(String species, String environment){
        this.species = species;
        this.environment = environment;
    }

    public String getSpecies(){
        return this.species;
    }
    public String getEnvironment(){
        return this.environment;
    }
}
