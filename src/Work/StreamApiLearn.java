package Work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiLearn {


    public static void main(String[] args) {

        // this type of list will be immutable
        List<String> list1 = List.of("Ayush", "Atul", "Anish", "Harshit", "Animesh", "Dhano", "Pranjal");
        System.out.println("list1 "+list1);

        // create another list which will contain strings of length 5 only

        // M1-> older method or legacy method
        List<String> resultedList1 = new ArrayList<>();
        for (String temp: list1) {
            if (temp.length() == 5) {
                resultedList1.add(temp);
            }
        }
        System.out.println("resulted List " + resultedList1);

        // M2-> new Method with Stream API
        // Stream API requires an boolean valued function or predicate function which will passed to it as an lambda
        // or may be something else
        Stream<String> stream = list1.stream();     // first we need to grab the stream on our data
        List<String> filteredList = stream.filter(temp -> temp.length() == 5).collect(Collectors.toList());
        System.out.println("filtered List " + filteredList);

        // print the names which ends with 'h' character
        System.out.println("String ends with 'h' character");
        list1.stream().filter(temp -> temp.endsWith("h")).forEach(e -> System.out.println(e));

        // replace the first chracter of the string starts with "H" by "h" so for this we need to use map()
        // function in stream api bcz now we need to perform operations on our every data
        System.out.println("------------------ modified data -------------------");
        list1.stream().map(temp -> {
            if (temp.startsWith("H")) {
                temp = temp.replaceFirst("H", "h");
            }
            return temp;
        }).forEach(e -> System.out.println(e));
        System.out.println("original list " + list1);

        // if you want todo some sorting then use sorted() method of stream API
        System.out.println("-------------------- sorted data --------------------");
        list1.stream().sorted().forEach(temp -> System.out.println(temp));


        // map() vs flatMap()
        // map() -- it works on stream of data i.e. does only transformation
        // flatMap() -- it works on stream of stream data and does flattening along with transformation
        System.out.println("-------------------------- Map vs FlatMap ----------------------------");
        List<AnimeCharacters> animeList = new ArrayList<>();
        animeList.add(new AnimeCharacters("Naruto", "Uzumaki", Arrays.asList("Rasengan", "RasenShuriken")));
        animeList.add(new AnimeCharacters("Sasuke","Uchiha",Arrays.asList("Saringan", "Rinnegan")));
        animeList.add(new AnimeCharacters("Goku","Saiyan",Arrays.asList("KameHameHa")));


        // map function on animeList
        // let's try to fetch all attacks of anime characters
        List<List<String>> attackListMap = animeList.stream().map(temp -> temp.getAttacks()).collect(Collectors.toList());
        System.out.println("attacks using map() " + attackListMap);

        // flatMap function on animeList
        // let's try to fetch all attacks of anime characters
        // bcz flatMap() works on stream of stream so it'll retirn an stream so we need to get that stream first
        // and see the return type as well bcz here we will get List<String> not List<List<String>>
        List<String> attackListFlatMap = animeList.stream().flatMap(temp -> temp.getAttacks().stream()).collect(Collectors.toList());
        System.out.println("attacks using flatMap() " + attackListFlatMap);

        // fetch the list of attacks which contain two attacks using map() and flatMap() and add one more word
        // "More Powerfull"
        // using map()
//        List<List<String>> modifiedAttackListMap = animeList.stream().map(temp -> {
//            if (temp.getAttacks().size() == 2) {
//                temp.getAttacks().add("More powerfull");
//            }
//            return temp.getAttacks();
//        }).collect(Collectors.toList());
//        System.out.println("modifiedAttackListMap "+ modifiedAttackListMap);

        // using flatMap()
//        List<String> modifiedAttackListFlatMap = animeList.stream().flatMap(temp->temp.getAttacks().stream()).collect(Collectors.toList());
//        System.out.println("modifiedAttackListFlatMap "+ modifiedAttackListFlatMap);
    }
}
