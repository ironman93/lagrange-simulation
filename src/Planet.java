public class Planet implements GlobalConstants{

    int mass; // mass of the planet
    double px; // x position of the planet
    double py; // y position of the planet
    double v = 0;
    double vx = 0;
    double vy = 0;

    public Planet(int m, int x, int y){
        mass = m;
        px = x;
        py = y;
    }

    //returns the mass of the planet
    public int getMass(){
        return mass;
    }

    //returns x position of the planet
    public double getX(){
        return px;
    }

    //returns y position of the planet
    public double getY(){
        return py;
    }

    // return standard gravitational parameter of the planet
    public double getSGP(){
        return G*mass;
    }

    public double getV(){
        return v;
    }

    public double getVX(){
        return vx;
    }

    public double getVY(){
        return vy;
    }

    //sets the position of the planet
    public void setPosition(double x, double y){
        px = x;
        py = y;
    }

    public void updatePosition(){
        px = px + vx;
        py = py + vy;
        System.out.println("px: "+ px + "    py: "+ py);
    }

    public void setVelocities(double x, double y){
        vx = x;
        vy = y;
    }

    public void setVelocity(double velocity){
        v = velocity;
    }
}