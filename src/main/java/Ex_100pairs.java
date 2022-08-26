import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Ex_100pairs {
    public static void main(String[] args) {
        try {
            //Генерация ключей
            ArrayList<Integer> keys = new ArrayList<>();
            int i;
            while(keys.size()!=100){
                i=ThreadLocalRandom.current().nextInt(10, 900 + 1);;
                if(!keys.contains(i)){ //добавляем только те значения, которых еще не было в списке
                    keys.add(i);
                }
            }
            //В словарь кладем пары рандомное число : рандомная строка
            HashMap<Integer, String> pairs100 = new HashMap<>();
            for (int j=0; j<keys.size(); j++){
                pairs100.put(keys.get(j), StringGen.generator(10)); //StringGen - класс с генерацией строк
            }
            //Считываем по ключам все значения
            for(Integer k : pairs100.keySet()) {
                System.out.println("key:" + k + " value:" + pairs100.get(k));
            }
            pairs100.clear(); //удаляем все пары
        } catch (Exception ex) {
            System.out.println("Exception during work with HashMap - " + ex);
        }
    }
}
