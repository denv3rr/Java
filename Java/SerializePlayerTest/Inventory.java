import java.io.Serializable;

public class Inventory implements Serializable {
    private int slots;
    private int usedSlots;

    public Inventory(int slots, int usedSlots) {
        this.slots = slots;
        this.usedSlots = usedSlots;
    }

    public String toString() {
        return String.format("\nTotal Inventory Slots: %d\nInventory Slots Available: %d\n", this.slots,
                this.slots - this.usedSlots);
    }
}
