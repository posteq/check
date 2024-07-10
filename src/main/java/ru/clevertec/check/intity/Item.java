package ru.clevertec.check.intity;

public class Item {
    int id;
    int count;


    public Item(int id, int count) {
        this.id = id;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
