 class Planet {
    String shape;
    double Density ;
    String name;
    public Planet(double density, String shape, String name){
            this.shape = shape;
            this.name = name;
            this.Density = density;
    }

    public void rotation(){};

    @Override
    public boolean equals(Object obj) {
        Planet objPlanet = (Planet) obj;
        if((this.Density==objPlanet.Density)&&(this.shape.equals(objPlanet.shape))&&(this.name.equals(objPlanet.name))) return true;
        else return false;
    }
}
