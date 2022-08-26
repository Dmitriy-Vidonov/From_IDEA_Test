/*import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class hashN {
    public static ArrayList<Integer> hashN(ArrayList<Integer> arrList, int N){
        //задаем итоговый список для вывода результата работы метода
        ArrayList<Integer> finList = new ArrayList<>();
        try{
            //задаем словарь для хранения числа вхождений элементов в список
            HashMap<Integer, Integer> hashM = new HashMap<>();
            int value = 1;
            //заполнение словаря, где ключ - элемент списка, значение - число вхождения элемента в список
            for(Integer counter : arrList) {
                if (!hashM.containsKey(counter)) {
                    hashM.put(counter, 1);
                }
                else {
                    value = hashM.get(counter) + 1;
                    hashM.put(counter, value);
                    //проверка значений пар на соответствие условию >= N
                    if (value >= N && !finList.contains(counter)) { //СДЕЛАТЬ 1 ПРОВЕРКУ ВМЕСТО 2
                        finList.add(counter);
                    }
                }
            }
            Collections.sort(finList);
        } catch (Exception ex) {
            System.out.println("Exception during work with hashmap - " + ex);
        }
        return finList;
    }
}
 */
/******************************************************************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class hashN {
    public static HashSet<Integer> hashN(ArrayList<Integer> arrList, int N){
        //задаем итоговый список для вывода результата работы метода
        HashSet<Integer> finList = new HashSet<Integer>();
        try{
            //задаем словарь для хранения числа вхождений элементов в список
            HashMap<Integer, Integer> hashM = new HashMap<>();
            int value = 1;
            //заполнение словаря, где ключ - элемент списка, значение - число вхождения     элемента в список
            for(Integer counter : arrList) {
                if (!hashM.containsKey(counter)) {
                    hashM.put(counter, 1);
                }
                else {
                    value = hashM.get(counter) + 1;
                    hashM.put(counter, value);
                    //проверка значений пар на соответствие условию >= N
                    if (value >= N) finList.add(counter);
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception during work with hashmap - " + ex);
        }
        return finList;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(hashN(ListGen.generateList(1, 10, 100), 10));
    }
}