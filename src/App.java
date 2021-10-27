interface Burung
{
    // birds implement Bird interface that allows
    // them to fly and make sounds adaptee interface
    public void terbang();
    public void makeSound();
}
  
class Gagak implements Burung
{
    // a concrete implementation of bird
    public void terbang()
    {
        System.out.println("Terbang");
    }
    public void makeSound()
    {
        System.out.println("Chirp Chirp");
    }
}
  
interface BebekMainan
{
    // target interface
    // toyducks dont fly they just make
    // squeaking sound
    public void squeak();
}
  
class PlasticBebekMainan implements BebekMainan
{
    public void squeak()
    {
        System.out.println("Squeak");
    }
}
  
class BurungAdapter implements BebekMainan
{
    // You need to implement the interface your
    // client expects to use.
    Burung burung;
    public BurungAdapter(Burung burung)
    {
        // we need reference to the object we
        // are adapting
        this.burung = burung;
    }
  
    public void squeak()
    {
        // translate the methods appropriately
        burung.makeSound();
    }
}

public class App {
    public static void main(String args[])
    {
        Gagak gagak = new Gagak();
        BebekMainan bebekMainan = new PlasticBebekMainan();
  
        // Wrap a bird in a birdAdapter so that it 
        // behaves like toy duck
        BebekMainan burungAdapter = new BurungAdapter(gagak);
  
        System.out.println("Gagak...");
        gagak.terbang();
        gagak.makeSound();
  
        System.out.println("BebekMainan...");
        bebekMainan.squeak();
  
        // toy duck behaving like a bird 
        System.out.println("BurungAdapter...");
        burungAdapter.squeak();
    }
}
