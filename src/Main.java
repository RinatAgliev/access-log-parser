import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        int lineCount, minLength, maxLength;
        lineCount = 0;
        minLength = Integer.MAX_VALUE;
        maxLength = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите путь к файлу и нажмите <Enter>:");
            String path = scanner.nextLine();
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
                break;
            }
        }

        try {
            System.out.println("------------------");
            System.out.println("Введите путь к файлу который хотите просканировать и нажмите <Enter>:");
            String path = scanner.nextLine();
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                int length = line.length();

                if (length > 1024) {
                    throw new LineTooLongException("Длина строки больше 1024");
                }

                if (length < minLength) {
                    minLength = length;
                }
                if (length > maxLength) {
                    maxLength = length;
                }

            }

        } catch (LineTooLongException | IOException ex) {
            System.out.println(ex.getMessage());

        }

        finally {
            System.out.println("Общее количество строк в файле: "+lineCount);
            System.out.println("Длина самой длинной строки в файле: "+maxLength);
            System.out.println("Длина самой короткой строки в файле: "+minLength);
        }

    }
}