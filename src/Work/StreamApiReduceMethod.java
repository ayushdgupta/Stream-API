package Work;

import java.util.ArrayList;
import java.util.List;

public class StreamApiReduceMethod {

    public static void main(String[] args) {
        List<String> names = List.of("Ayush", "Dhano", "Jaini", "Teliya", "Chakku", "Anish", "Atul");

        // Now suppose we want to concat all names with a delimeter '-'

        // M1-> old method using forEach loop
        String concatString = "";
        for (String name : names) {
            concatString = concatString + " - " + name;
        }
        concatString = concatString.substring(2);
        System.out.println("concatenated value with legacy methods " + concatString);

        // M2-> let's see the same functionality with reduce method and suppose i want to concat only those
        // names whose length is >=5
        String concatenatedNames = names.stream()
                .filter(name -> name.length() >= 5)
                .reduce((name1, name2) -> name1 + " - " + name2).get();
        System.out.println("concatenated value with Reduce methods " + concatenatedNames);

        // let's see some basic arithmetic operations +, - , *, max(), min()
        // M1-> basic approaches
        List<Integer> data = List.of(1, 3, 2, 3, 12, 25);
        int dataSum = 0;
        int dataProduct = 1;
        int dataMinus = 0;
        int dataMax = Integer.MIN_VALUE;
        int dataMin = Integer.MAX_VALUE;
        for (int no : data) {
            dataSum = dataSum + no;
            dataProduct = dataProduct * no;
            dataMinus = no - dataMinus;
            if (no > dataMax) {
                dataMax = no;
            }
            if (no < dataMin) {
                dataMin = no;
            }
        }
        System.out.println("+ result is " + dataSum);
        System.out.println("- result is " + dataMinus);
        System.out.println("* result is " + dataProduct);
        System.out.println("max() result is " + dataMax);
        System.out.println("min() result is " + dataMin);

        //M2-> Using reduce method
        Integer sum1 = data.stream().reduce((a, b) -> a + b).get();
        Integer sum2 = data.stream().reduce(0, (a, b) -> a + b);
        Integer sum3 = data.stream().reduce(Integer::sum).get();
        Integer minus = data.stream().reduce((a, b) -> b - a).get();
        Integer product = data.stream().reduce((a, b) -> a * b).get();
        Integer max = data.stream().reduce((a, b) -> {
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }).get();
        Integer min = data.stream().reduce((a, b) -> {
            if (a < b) {
                return a;
            } else {
                return b;
            }
        }).get();
        System.out.println("+ result using Reduce "+ sum1);
        System.out.println("+ result using Reduce W/O Identity " + sum2);
        System.out.println("+ result using Reduce using method reference " + sum3);
        System.out.println("- result using Reduce " + minus);
        System.out.println("* result using Reduce " + product);
        System.out.println("max() result using Reduce " + max);
        System.out.println("min() result using Reduce " + min);

        // now suppose if i want to find the sum of no. where no>=5 then add 1 in it and then sum
        Integer sumGreaterThanFive = data.stream()
                .filter(no -> no >= 5)
                .map(a -> a + 1)
                .reduce(Integer::sum).get();
        System.out.println("sum greater than 5 " + sumGreaterThanFive);
    }
}
