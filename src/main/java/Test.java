import java.util.HashMap; //импорт класса HashMap

public class Test {
    public static void main(String[] args) {
        //Создаем HashMap с именем capitalCities с ключами типа String и значениями типа String
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        /*Добавление новых элментов*/
        //для добавления используйте метод put()
        //добавляем ключи и значения (страна, город)
        capitalCities.put("Russia", "Moscow");
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);

        /*Доступ к элементам*/
        //Для получения значения в HashMap - используйте метод get() с указанием ключа. Пары у нас ключ-значение.
        //значение получаем по ключу. Ключ - страна. Значение - столица
        System.out.println(capitalCities.get("Russia"));

        HashMap<Integer, String> testMap = new HashMap<Integer, String>();
        testMap.put(1, "Адынычка");
        testMap.put(2, "Двоешка");
        testMap.put(3, "Троешка");
        for(int j=1; j<=testMap.size(); j++) {
            System.out.println(testMap.get(j));
        }

        /*Удаление элемента*/
        capitalCities.remove("England");
        testMap.remove(3);

        System.out.println(capitalCities);
        System.out.println(testMap);

        //Удаление всех элементов
        testMap.clear();

        System.out.println(testMap);

        /*Измерение размера карты - как много в ней элементов?*/
        System.out.println("размер мапы - " + capitalCities.size() + " пары");

        /*Циклы по мапе*/
        //Цикл по ключам - метод keyset() по циклу for-each
        for (String i : capitalCities.keySet()) { //вывод ключей на печать
            System.out.println(i);
        }

        System.out.println("***************");

        //Цикл по значениям - метод values() по циклу for-each
        for (String i : capitalCities.values()) { //вывод значений на печать
            System.out.println(i);
        }

        //Печать и ключей и значений в цикле - по сути выводим ключи, а от них получаем значения
        for (String i : capitalCities.keySet()) {
            System.out.println("Ключ:" + i + " Значение:" + capitalCities.get(i));
        }

        /*ИСПОЛЬЗОВАНИЕ РАЗНЫХ ТИПОВ*/
        //В Java тип String это объект. Это не примитивный тип.
        //Если мы хотим использовать примитивные типы, например int - их надо объявлять через эквивалентный класс-оболочку
        //Wrapper class - https://www.w3schools.com/java/java_wrapper_classes.asp
        //Например при работе с коллекциями используются только объекты. Как и здесь с мапами - нужны именно объекты
        //поэтому если нужно использовать int в HashMap, то юзаем Integer
        //объявление идет так же через оболочку. Например Integer myInt = 5;

        //Создадим HashMap, в котором хранятся ключи типа String и значения типа Integer
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        //Добавим ключи и значения
        people.put("Vanya", 1);
        people.put("Дермидонт Валерьяныч", 35);
        people.put("Катюша", 5);

        for (String i : people.keySet()) {
            System.out.println("ключ: " + i + " | значение: " + people.get(i));
        }

        //Проверка на наличие в словаре значения
        System.out.println(people.containsValue(35)); //true

        //Проверка на наличрие в словаре ключа
        System.out.println(people.containsKey("Vanya")); //true

        //Удаление элемента из словаря
        people.remove("Дермидонт Валерьяныч");
        System.out.println(people);
    }
}
