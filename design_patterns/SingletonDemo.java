package design_patterns;

public class SingletonDemo {
    public static void main(String[] args) {
        // Get the single instance of Singleton using the public static method
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        // Both references should point to the same object
        // Demonstrates that only one instance is created
        System.out.println("Singleton instance: " + s1);
        System.out.println("Singleton instance: " + s2);
    }
}

// =========================
// Bill Pugh Singleton Class
// =========================
class Singleton {

    // 1️⃣ Private constructor prevents instantiation from other classes.
    //    This ensures that the class cannot be instantiated directly using 'new'.
    private Singleton() {}

    // 2️⃣ Static inner helper class holds the single instance of Singleton.
    //    This class is not loaded into memory until it is actually referenced,
    //    which makes this implementation lazy-loaded.
    private static class SingletonHelper {
        // The single instance is created when the SingletonHelper class is loaded.
        // The JVM guarantees thread-safety for class loading, so no explicit synchronization is needed.
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3️⃣ Public static method to provide global access to the single instance.
    //    When this method is called for the first time, the SingletonHelper class is loaded,
    //    creating the Singleton instance in a thread-safe, lazy manner.
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
