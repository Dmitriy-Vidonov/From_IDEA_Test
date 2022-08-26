public class StringGen {

    public static String generator(int len) {

        String pw = "";
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++)
        {
            if (i % 3 == 0) { //генерация чисел от 0 до 9
                char c=Character.forDigit((int) (Math.random() * 10),10);
                str.append(c);
            }
            else { //генерация ASCII символов - англоязычные буквы
                char c = (char) (int) (Math.random() * 26 + 97);
                str.append(c);
            }
        }
        return str.toString();
    }
}
