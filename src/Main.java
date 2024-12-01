import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення композицій
        MusicComposition track1 = new MusicComposition("Song 1", "Artist A", 3.5, "Pop") {};
        MusicComposition track2 = new MusicComposition("Song 2", "Artist B", 4.0, "Rock") {};
        MusicComposition track3 = new MusicComposition("Song 3", "Artist C", 5.0, "Jazz") {};

        // Використання різних конструкторів
        DoublyLinkedSet<MusicComposition> set1 = new DoublyLinkedSet<>();
        DoublyLinkedSet<MusicComposition> set2 = new DoublyLinkedSet<>(track1);
        DoublyLinkedSet<MusicComposition> set3 = new DoublyLinkedSet<>(List.of(track1, track2, track3));

        // Додавання та робота з колекцією
        set1.add(track1);
        set1.add(track2);
        System.out.println(set1.contains(track1)); // true
        set1.remove(track1);
        System.out.println(set1.contains(track1)); // false
    }
}