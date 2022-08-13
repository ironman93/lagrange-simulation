import javax.swing.*;
import java.awt.Graphics;

public class PlanetarySystem extends JFrame implements GlobalConstants{

    // final double G = 0.0000000000667430; //gravitational constant
    int a; // semi-major axis of the orbit
    double dx;
    double dy;
    Planet inner;
    Planet outer;
    //static int T = (int)(2 * Math.PI * Math.sqrt((d*d*d)/(G*m1)));

    public PlanetarySystem(int mInner, int mOuter, int xInner, int yInner, int xOuter, int yOuter){
        super("Lagrange Points Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);
        setResizable(false);


        inner = new Planet(mInner, xInner, yInner);
        outer = new Planet(mOuter, xOuter, yOuter);
        setDeltas();
        setA();
        setVelocity();
        setVelocities();
        update();
    }

    public static void main(String[] args) throws Exception {
        
        /* JFrame window = new JFrame("Lagrange Points Simulation");
        window.setSize(1000, 1000);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
        PlanetarySystem system = new PlanetarySystem(200000, 60, 500, 500, 800, 400);
    }
    
    public void update(){
        System.out.println("v: " + outer.getV());
        System.out.println("vx: " + outer.getVX());
        System.out.println("vy: " + outer.getVY());
        System.out.println("a: " + a);
        System.out.println("dx: " + dx + ",  dy: "+dy);
        setDeltas();
        setA();
        setVelocities();
        outer.updatePosition();
        try{Thread.sleep(3);}
        catch(InterruptedException ex){Thread.currentThread().interrupt();}
        this.repaint();
        update();
    }

    public void setDeltas(){
        dx = outer.getX()-inner.getX(); //delta x between the planets
        dy = outer.getY()-inner.getY();
    }

    // calculates and returns the distance betweeen the planets based on their position
    public void setA(){
        a =  (int)Math.sqrt((dx*dx)+(dy*dy)); //pythagoras theorem (a: dx, b: dy, c: return value)
    }

    // calculates and returns the orbital period based on the semi-major axis and mass of the more massive planet
    public int calculateT(){
        return (int)(2 * Math.PI * Math.sqrt((a*a*a)/(inner.getSGP())));
    }

    //calculates and returns the velocity based on the orbital period and semi-major axis
    public void setVelocity(){
        double distance = (int)(2 * Math.PI * a);
        System.out.println("distance: " + distance);
        double v = distance/((double)calculateT());
        System.out.println("T: " + calculateT());
        System.out.println("v2: " + v);
        outer.setVelocity(v*5000);
    }

    public void setVelocities(){
        double vx = 2;
        double vy = (((dx*vx)/dy)*-1);
        double y = Math.sqrt(vx*vx+vy*vy);
        double factor = outer.getV()/y;
        vx = factor*vx;
        vy = factor*vy;
        outer.setVelocities(vx, vy);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawOval((int)outer.getX(), (int)outer.getY(), 20, 20);
        g.drawOval((int)inner.getX(), (int)inner.getX(), 30, 30);

    }

}
