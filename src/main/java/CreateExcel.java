import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CreateExcel {
    public static void generateTemplate(ArrayList<Integer> numList, //Список для заполнение ячеек шаблона
                                        String templateName, //Наименование выходного файла
                                        int numsRange, //Диапазон генерируемых значений в списке. сколько разных чисел там будет
                                        int N //Проверяемое число вхождений
    ) {
        try {
            //Создание книги Excel
            XSSFWorkbook book = new XSSFWorkbook();
            FileOutputStream fileout = new FileOutputStream(templateName);
            //Создание страницы
            XSSFSheet sheet = book.createSheet("Sheet 1");
            int totalRowsCount = numList.size(); //Число заполненных значениями ячеек. Равно размеру входного списка
            int rowsCount;
            //Создаем строки и заполняем их значениями из массива
            for (rowsCount=0; rowsCount<totalRowsCount; rowsCount++) {
                XSSFRow row = sheet.createRow((short)rowsCount);
                XSSFCell cell = row.createCell(0); //Создали ячейку
                cell.setCellType(Cell.CELL_TYPE_NUMERIC); //Указали тип - числовой
                cell.setCellValue(numList.get(rowsCount)); //Занесли значение в ячейку
            }
            String strFormula;
            //Проставить формулы подсчета количества вхождений в массив
            for (int i=1; i<=numsRange; i++) {
                //Задаем ячейки с формулами подсчета значений
                XSSFRow row = sheet.createRow((short)rowsCount+i-1);
                XSSFCell cell = row.createCell(0); //Создали ячейку
                strFormula = "COUNTIF($A$1:$A$100," + i + ")"; //Задали формулу
                cell.setCellType(Cell.CELL_TYPE_FORMULA); //Указали тип - формула
                cell.setCellFormula(strFormula); //Занесли формулу в ячейку

                //Проставили во второй столбец значения из диапазона
                XSSFCell cell2 = row.createCell(1); //создали ячейку во втором столбце
                cell2.setCellType(Cell.CELL_TYPE_NUMERIC); //указали тип - числовой
                cell2.setCellValue(i);

                //Проставили следующую партию формул - расчет числа вхождений чисел относительно параметра N
                XSSFCell cell3 = row.createCell(2); //Создали ячейку в 3-ем столбце
                strFormula = "IF(A" + (totalRowsCount+i) + ">=" + N + ",TRUE())*1"; //Задали формулу
                cell3.setCellType(Cell.CELL_TYPE_FORMULA); //Указали тип - формула
                cell3.setCellFormula(strFormula); //Занесли формулу в ячейку

                //Проставляем партию формул, где получаем числа, соответствующие числу вхождений >= N
                XSSFCell cell4 = row.createCell(3); //Создали ячейку в 4-ом столбце
                strFormula = "IF(C" + (totalRowsCount+i) + "=1" + ",B"
                        + (totalRowsCount+i) + ")*1"; //Задали формулу
                cell4.setCellType(Cell.CELL_TYPE_FORMULA); //Указали тип - формула
                cell4.setCellFormula(strFormula); //Занесли формулу в ячейку
            }
            //закрытие книги Excel
            book.write(fileout);
            fileout.close();
        } catch (Exception ex) {
            System.err.println("Error during creating Excel template file - " + ex);
        }
    }
}
