package Stream.entity;

import java.util.Arrays;
import java.util.List;

public class Dish {
    private final String name;
    private final int calories;

    private Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() { return name; }

    public int getCalories() { return calories; }

    @Override
    public String toString() {
        return name;
    }

    public static List<Dish> returnMenu() {
        return Arrays.asList(
                new Dish("pork", 800),
                new Dish("beef", 700),
                new Dish("chicken", 400),
                new Dish("french fries", 530),
                new Dish("rice", 350),
                new Dish("season fruit", 120),
                new Dish("pizza", 550),
                new Dish("prawns", 300),
                new Dish("salmon", 450));
    }
}
