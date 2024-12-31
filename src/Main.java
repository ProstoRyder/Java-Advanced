import items.Animal;
import items.Laptop;
import items.Movie;
import utils.ReflectionSerializer;
import utils.ManualSerializer;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Movie movie = new Movie("Inception", "Christopher Nolan", "2010");
        Animal animal = new Animal("Elephant", 25, "Savannah");
        Laptop laptop = new Laptop("XPS 15", "Intel i7", "1TB SSD");

        System.out.println("---- Using Reflection Serializer ----");
        long startReflection = System.nanoTime();
        System.out.println(ReflectionSerializer.toJson(movie));
        System.out.println(ReflectionSerializer.toXml(movie));
        System.out.println(ReflectionSerializer.toJson(animal));
        System.out.println(ReflectionSerializer.toXml(animal));
        System.out.println(ReflectionSerializer.toJson(laptop));
        System.out.println(ReflectionSerializer.toXml(laptop));
        long endReflection = System.nanoTime();
        System.out.println("Reflection Time: " + (endReflection - startReflection) + " ns");

        System.out.println("---- Using Manual Serializer ----");
        long startManual = System.nanoTime();
        System.out.println(ManualSerializer.toJson(movie));
        System.out.println(ManualSerializer.toXml(movie));
        System.out.println(ManualSerializer.toJson(animal));
        System.out.println(ManualSerializer.toXml(animal));
        System.out.println(ManualSerializer.toJson(laptop));
        System.out.println(ManualSerializer.toXml(laptop));
        long endManual = System.nanoTime();
        System.out.println("Manual Serialization Time: " + (endManual - startManual) + " ns");
    }
}
