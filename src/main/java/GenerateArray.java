import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateArray {
    public static void main(String[] main) throws Exception {

        for (int j=1; j<=10; j++) {
            File fileArray = new File("array" + j + ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileArray));

            ArrayList<Integer> nums = new ArrayList<>();
            int num;
            for (int i=0; i<100; i++) {
                num = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                nums.add(num);
                bw.write(String.valueOf(num));
                bw.newLine();
            }
            bw.write(String.valueOf(nums));
            bw.newLine();
            bw.close();
        }
    }
}
