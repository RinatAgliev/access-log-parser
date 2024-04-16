import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            System.out.println("Введите путь к файлу и нажмите <Enter>:");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (isDirectory == true) {
                System.out.println("Это папка");
                continue;
            }
            if (fileExists == false) {
                System.out.println("Файл не существует");
                continue;
            }
            if (fileExists == true) {
                System.out.println("Путь указан верно");
                i++;
                System.out.println("Это файл номер: " + i);
            }
        }
    }
}