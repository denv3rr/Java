import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Player implements Serializable {
    private String username;
    private String gender;
    private int health;
    private int hunger;
    private int thirst;
    private Inventory inventory;
    private static final long serialVersionUID = 1L;

    public Player(String username, String gender, int health, int hunger, int thirst) {
        this.username = username;
        this.gender = gender;
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.inventory = new Inventory(20, 5);
    }

    public String toString() {
        return String.format(
                "Username: %s, Gender: %s, Health: %d, Food: %d, Water: %d, %s",
                this.username, this.gender, this.health, this.hunger, this.thirst, this.inventory);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Player player1 = new Player("denver", "male", 100, 100, 100);
        Player player2 = new Player("the_player123", "female", 100, 100, 100);
        FileOutputStream fileOutputStream = new FileOutputStream("players.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(player1);
        objectOutputStream.writeObject(player2);

        FileInputStream fileInputStream = new FileInputStream("players.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Player player1Copy = (Player) objectInputStream.readObject();
        Player player2Copy = (Player) objectInputStream.readObject();

        System.out.println("\n\nPlayer 1:\n" + player1Copy);
        System.out.println("\n\nPlayer 2:\n" + player2Copy + "\n");

        objectOutputStream.close();
        objectInputStream.close();

    }
}
