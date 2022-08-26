import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.*;

class hashNTest {

    //Repeated test
    @RepeatedTest(100)
    @DisplayName("Repeated test")
    void repeatedTest() throws Exception {
        //Указываем N - с каким числом будем сравнивать число вхождений элементов
        int N = ThreadLocalRandom.current().nextInt(7, 10 + 1);
        String templateName = "testExcel.xlsx";
        //Задаем список, по которому будет проходить проверка
        ArrayList<Integer> numsList = new ArrayList<Integer>(ListGen.generateList(1,10,100));
        //Создаем ексель файл для проверки
        CreateExcel.generateTemplate(numsList,"testExcel.xlsx", 10, N);
        //Выполняем проверку
        Assertions.assertEquals(ReadExcelTemplate.readTemplate(templateName, 100, 10, 3),
                hashN.hashN(numsList, N));
    }
}