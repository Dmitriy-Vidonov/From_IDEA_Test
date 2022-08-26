import java.lang.reflect.Array;
import java.util.*;

public class TestMapEntry {
    public static void main(String[] args) {
        Map<String, String> students = new HashMap<>();
        students.put("Max", "Pyatochkin");
        students.put("Ivan", "Zagoruyko");
        students.put("Sasha", "Baron Koehn");

        System.out.println(students.entrySet());
        System.out.println(students);

        // 1 способ получения значения по ключу
        // for (String s: students.keySet()) {
        //     String lastname = students.get(s);
        // }

        // 2 cпособ получения значения по ключу - более употребим
        //Map.Entry<K, V> - это интерфейс, который позволяет получить доступ к записям в словаре
        //мы создаем переменную student типа Map.Entry
        for (Map.Entry<String, String> student: students.entrySet()) {
            System.out.println(
                    "Student name is = " + student.getKey() + " and student last name is = " + student.getValue()
            );
        }

        Integer[] arrKey = {3, 5, 2, 5, 8, 10, 3, 8, 8, 6, 6, 2, 1, 1, 2, 5, 4, 9, 2, 9, 7, 4, 8, 3, 5, 6, 2, 9, 4, 5, 7, 5, 8, 7, 8, 3, 10, 2, 9, 8, 3, 4, 7, 6, 6, 10, 5, 10, 4, 7, 3, 6, 8, 1, 2, 8, 10, 1, 1, 4, 2, 5, 5, 2, 5, 7, 3, 5, 3, 4, 7, 1, 4, 8, 5, 10, 1, 6, 8, 5, 1, 4, 6, 2, 3, 9, 6, 3, 5, 8, 8, 7, 2, 1, 6, 2, 5, 3, 9, 10};
        Integer[] arrValue = {2, 3, 5, 6, 8};
        ArrayList<Integer> keyList = new ArrayList<>(Arrays.asList(arrKey));
        ArrayList<Integer> valueList = new ArrayList<>(Arrays.asList(arrValue));
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
        arrList.add(keyList); //index(0)
        arrList.add(valueList); //index(1)

        ArrayList<Integer> finList = new ArrayList<Integer>(hashN.hashN(arrList.get(0), 10));
        ArrayList<Integer> numList = new ArrayList<Integer>((arrList.get(1)));
        Collections.sort(finList);
        Collections.sort(numList);

        if (finList.equals(numList)) {
            System.out.println("Заебись!");
        } else System.out.println("Не очень заебись...");
    }
}