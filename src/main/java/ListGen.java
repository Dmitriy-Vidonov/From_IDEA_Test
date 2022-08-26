import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ListGen {
    public static ArrayList<Integer> generateList(int lowerLimit, int upperLimit, int count) throws Exception {
        ArrayList<Integer> workList = new ArrayList<Integer>(); //задаем рабочий список
        for (int i=0; i<count; i++) { //заполняем список в указанных рамках
            workList.add(ThreadLocalRandom.current().nextInt(lowerLimit, upperLimit + 1));
        }
        return workList;
    }
}
