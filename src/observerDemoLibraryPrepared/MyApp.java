package observerDemoLibraryPrepared;

public class MyApp {
    public static void main(String[] args) {
        DMV dmv = new DMV();
        dmv.addObserver(new Peasant("Elliot"));
        dmv.addObserver(new Peasant("Poe"));
        dmv.addObserver(new Peasant("Tripp"));
        new Thread(dmv).start();
    }
}