import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ReadExcelTemplate {
    /*static ArrayList<Integer> readTemplate(String templateName, //имя Excel шаблона для обработки
                                           int totalRowsCount,  //кол-во ячеек в столбце, заполненное числовыми значениями
                                           int rangeOfFormulaCells, //какое число ячеек с формулами считываем
                                           int columnNumber //в каком столбце считываем ячейки с формулами (счет с 0)
    ) {*/
    static HashSet<Integer> readTemplate(String templateName, //имя Excel шаблона для обработки
                                         int totalRowsCount,  //кол-во ячеек в столбце, заполненное числовыми значениями
                                         int rangeOfFormulaCells, //какое число ячеек с формулами считываем
                                         int columnNumber //в каком столбце считываем ячейки с формулами (счет с 0)
    ) {
        //откроем файл из заданного местоположения
        //ArrayList<Integer> numsFromSheet = new ArrayList<>(); //создание списка для хранения итоговых значений
        HashSet<Integer> numsFromSheet = new HashSet<Integer>();
        try{
            FileInputStream file = new FileInputStream(new File(templateName)); //открытие потока на чтение
            Workbook workbook = new XSSFWorkbook(file); //создание рабочей книги

            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator(); //интерфейс для формул
            formulaEvaluator.evaluateAll(); //проход по всем ячейкам книги

            //извлечем первый лист файла и пройдемся по каждой строке
            Sheet sheet = workbook.getSheetAt(0); //в sheet помещаем текущую книгу нашего ексель файла

            for (int i=totalRowsCount; i<totalRowsCount+rangeOfFormulaCells; i++) { //цикл по столбцу с формулами
                Cell cellNums = sheet.getRow(i).getCell(columnNumber); //создание ячейки для инициализации значений
                if((int)formulaEvaluator.evaluate(cellNums).getNumberValue()!=0) //в итог заносим ненулевые значения
                    numsFromSheet.add((int)formulaEvaluator.evaluate(cellNums).getNumberValue()); //только результат формул
            }
            //Collections.sort(numsFromSheet); //сортировка итогового списка

        } catch (Exception ex) {
            System.err.println("Error during reading the Excel file - " + ex);
        }
        return numsFromSheet;
    }
}
