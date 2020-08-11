package Stream.Exercitii;

import Stream.entity.Dish;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;


// TODO: return the names of dishes that are low in calories (<400), sorted by number of calories.
public class BeforeAfterJava8 {

    public static void main(String[] args) {
        List<String> answer = Arrays.asList("season fruit", "prawns", "rice");
        List<Dish> menu = Dish.returnMenu();

        out.println(answer.equals(beforeJava8(menu)) ? "Before solution is correct! :)" : "Before solution is wrong! :(");
        out.println(answer.equals(afterJava8(menu)) ? "After solution is correct! :)" : "After solution is wrong! :(");
    }


    //hint: Collections.sort(collection, comparator);
    static List<String> beforeJava8(List<Dish> menu) {
        return Collections.emptyList();
    }

    static List<String> afterJava8(List<Dish> menu) {
        return Collections.emptyList();
    }
}
