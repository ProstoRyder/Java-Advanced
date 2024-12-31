import model.Car;
import model.Person;
import model.Smartphone;
import serializer.ReflectionSerializer;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        // Create instances of Car, Person, and Smartphone
        Car car = new Car("Tesla Model S", 2022);
        Person person = new Person("John Doe", 30);
        Smartphone smartphone = new Smartphone("iPhone 15", 999.99);

        // Variables to measure time taken for reflection serialization
        long startReflection, endReflection;

        System.out.println("[**** Using Reflection Serializer ****]");

        // Start measuring the time
        startReflection = System.nanoTime();

        // Serialize objects to JSON and XML using ReflectionSerializer
        System.out.println(ReflectionSerializer.toJson(car));
        System.out.println(ReflectionSerializer.toJson(person));
        System.out.println(ReflectionSerializer.toJson(smartphone));
        System.out.println(ReflectionSerializer.toXml(car));
        System.out.println(ReflectionSerializer.toXml(person));
        System.out.println(ReflectionSerializer.toXml(smartphone));

        // End time measurement
        endReflection = System.nanoTime();

        // Print the time taken for reflection serialization
        System.out.println("Reflection Time: " + (endReflection - startReflection) + " ns");
    }
}
