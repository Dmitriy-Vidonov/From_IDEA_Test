import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Test2 {
    public static void main(String[] args) {
        //создали список
        ArrayList<Integer> arrInt = new ArrayList<>();
        //заполнили список рандомными значениями от 1 до 10
        for (int i=0; i<100; i++) {
            arrInt.add(ThreadLocalRandom.current().nextInt(1, 10 + 1));
        }
        System.out.println(Arrays.asList(arrInt)); //вывели содержимое списка на экран
        int N = 10;

        HashMap<Integer, Integer> hashM = new HashMap<>(); //создали словарь для хранения карты значений
        /*смотрим - есть ли уже такой ключ, какой мы хотим добавить. если нет - добавляем со значением 1
         если есть - получаем значение и добавляем заново со значнием +1 */
        int value = 1;
        ArrayList<Integer> finList = new ArrayList<>();

        for(Integer counter : arrInt) {
            if (!hashM.containsKey(counter) /*&& N >= 1*/) {
                hashM.put(counter, 1);
            }
           /* if (!hashM.containsKey(counter) && N == 1) {
                hashM.put(counter, 1);
                //finList.add(counter);
            }*/
            else {
                value = hashM.get(counter) + 1;
                hashM.put(counter, value);
                if (value >= N && !finList.contains(counter)) {
                    finList.add(counter);
                }
            }
        }

        System.out.println(hashM);

        /*Пройтись по всему словарю и вывести в список только те ключи, значения которых равны или больше N*/

        /*for (Map.Entry<Integer, Integer> searchKeys: hashM.entrySet()) {
            if (searchKeys.getValue() >= N) {
                //System.out.println(searchKeys.getKey());
                finList.add(searchKeys.getKey());
            }
        } */
        System.out.println(Arrays.asList(finList));
    }
}