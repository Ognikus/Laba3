import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void zad1(String str) {
        char lastChar = str.charAt(str.length() - 1);
        System.out.println("Последний символ строки: " + lastChar);

        boolean endsWithExclamation = str.endsWith("!!!");
        System.out.println("Строка заканчивается на '!!!': " + endsWithExclamation);

        boolean startsWithILike = str.startsWith("I like");
        System.out.println("Строка начинается с 'I like': " + startsWithILike);

        boolean containsJava = str.contains("Java");
        System.out.println("Строка содержит 'Java': " + containsJava);

        int position = str.indexOf("Java");
        System.out.println("Позиция подстроки 'Java' в строке: " + position);

        String replacedString = str.replace('a', 'o');
        System.out.println("Строка после замены символов: " + replacedString);

        String upperCaseString = str.toUpperCase();
        System.out.println("Строка в верхнем регистре: " + upperCaseString);

        String lowerCaseString = str.toLowerCase();
        System.out.println("Строка в нижнем регистре: " + lowerCaseString);

        String javaString = "java";
        int javaIndex = str.indexOf(javaString);
        if (javaIndex != -1) {
            String result = str.substring(javaIndex, javaIndex + javaString.length());
            System.out.println("Вырезанная подстрока: " + result);
        } else {
            System.out.println("Подстрока не найдена");
        }

//        String substring = str.substring(str.indexOf("Java"), str.indexOf("Java") + "Java".length());
//        System.out.println("Вырезанная подстрока: " + substring);

    }

    public static void zad2() {
        int a = 3;
        int b = 56;

        StringBuilder sb = new StringBuilder();

        sb.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n");
        sb.append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n");
        sb.append(a).append(" * ").append(b).append(" = ").append(a * b).append("\n");

        System.out.println(sb.toString());

        sb.insert(sb.indexOf("="), "равно ");
        sb.deleteCharAt(sb.indexOf("=") );
        System.out.println(sb.toString());

        sb.replace(sb.indexOf("="), sb.indexOf("=") + 1, "равно ");
        sb.replace(sb.indexOf("="), sb.indexOf("=") + 1, "равно ");
        System.out.println(sb.toString());
    }

    public static String zad3(String input) {
        String searchFor = "object-oriented programming";
        String replaceWith = "OOP";

        // Разбиваем строку на подстроки, используя регулярное выражение
        String[] parts = input.split("(?i)" + searchFor);

        // Если в строке только одно вхождение "object-oriented programming", возвращаем исходную строку
        if (parts.length <= 1) {
            return input;
        }

        // Создаем StringBuilder для построения новой строки
        StringBuilder sb = new StringBuilder();

        // Проходим по оставшимся подстрокам и заменяем каждое второе вхождение на "OOP"
        for (int i = 1; i < parts.length; i++) {
            if (i % 2 == 0) {
                sb.append(replaceWith).append(parts[i]);
            } else {
                sb.append(searchFor).append(parts[i]);
            }
        }

        // Выводим измененный текст в консоль
        String output = sb.toString();
        System.out.println(output);

        return output;
    }

    public static String getMiddleChars(String str) {
        // Проверяем, что длина строки четная
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("String length should be even");
        }

        // Находим индекс первого символа из двух средних
        int startIndex = (str.length() / 2) - 1;

        // Получаем подстроку с двумя средними символами
        String middleChars = str.substring(startIndex, startIndex + 2);


        return middleChars;
    }
    public static void zad4(){
        String str = "string";
        String middleChars = getMiddleChars(str);
        System.out.println(middleChars);
    }

    public static void zad5(String lastName, int grade, String subject) {
        String template = "Студент %-15s получил %3d по %-10s.";
        String formattedString = String.format(template, lastName, grade, subject);
        System.out.println(formattedString);
    }

    public static void zad6() {
        String str = "Versions: Java 5, Java 6, Java 7, Java 8, Java 12.";
        String pattern = "Java \\d+"; // регулярное выражение для поиска подстроки "Java X"

        // Создаем объект Pattern для заданного регулярного выражения
        Pattern p = Pattern.compile(pattern);

        // Создаем объект Matcher для данной строки
        Matcher m = p.matcher(str);

        // Находим все совпадения и распечатываем их
        while (m.find()) {
            System.out.println(m.group());
        }
    }

    private static int countDistinctChars(String word) {
        HashSet<Character> set = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                set.add(c);
            }
        }
        return set.size();
    }

    public static void zad7(){
        String str = "fffff ab f 1234 jkjk";
        String[] words = str.split(" "); // разделяем строку на слова по пробелам
        String minWord = ""; // переменная для хранения слова с минимальным числом различных символов
        int minDistinctChars = Integer.MAX_VALUE; // переменная для хранения минимального числа различных символов

        for (String word : words) {
            int distinctChars = countDistinctChars(word);
            if (distinctChars < minDistinctChars) {
                minDistinctChars = distinctChars;
                minWord = word;
            }
        }

        System.out.println("Слово с минимальным числом различных символов: " + minWord);
    }

    public static void zad8(){
        String sentence = "One two three раз два три one1 two2 123";
        String[] words = sentence.split(" "); // разделяем предложение на слова по пробелам
        int latinWordsCount = 0; // переменная для хранения количества слов, содержащих только символы латинского алфавита

        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) { // если слово содержит только символы латинского алфавита
                latinWordsCount++;
            }
        }

        System.out.println("Количество слов, содержащих только символы латинского алфавита: " + latinWordsCount);
    }

    public static String findPalindrome(String sentence) {
        String[] words = sentence.split("\\s+"); // разбиваем предложение на слова
        for (String word : words) {
            if (word.matches("\\d+")) { // проверяем, состоит ли слово только из цифр
                StringBuilder sb = new StringBuilder(word);
                String reverseWord = sb.reverse().toString(); // переворачиваем слово
                if (word.equals(reverseWord)) { // сравниваем исходное и перевернутое слово
                    return word; // если слово является палиндромом, возвращаем его
                }
            }
        }
        return null; // если палиндром не найден, возвращаем null
    }
    public static void zad9(){
        String sentence = "Если есть хвосты по дз, начните с первого не сданного 222 задания 123 324 111 4554";
        String palindrome = findPalindrome(sentence);
        if (palindrome != null) {
            System.out.println("Найден палиндром: " + palindrome);
        } else {
            System.out.println("Палиндром не найден");
        }
    }
    public static void zad10(){
        Pattern pattern = Pattern.compile("c+a+b");
        Matcher matcher1 = pattern.matcher("cab");
        Matcher matcher2 = pattern.matcher("ccab");
        Matcher matcher3 = pattern.matcher("cccab");
        boolean b1 = matcher1.matches();
        boolean b2 = matcher2.matches();
        boolean b3 = matcher3.matches();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

    }

    public static void main(String[] args) {
        boolean f = true;
        while (f) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите задание из списка ниже:");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("""
                    1.Задание 1
                    2.Задание 2
                    3.Задание 3
                    4.Задание 4
                    5.Задание 5
                    6.Задание 6
                    7.Задание 7
                    8.Задание 8
                    9.Задание 9
                    10.Задание 10
                    Введите 0 чтобы выйти из программы""");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.print("Введите Номер задания: ");
            int n = scanner.nextInt();
            switch (n) {
                case 0 -> f = false;
                case 1 -> zad1("I like java!!1");
                case 2 -> zad2();
                case 3 -> zad3("Object-oriented programming is a programming language model organized around objects rather than and data rather than logic. Object-oriented programming blabla. Object-oriented programming bla.");
                case 4 -> zad4();
                case 5 -> zad5("Иванов", 5, "Математика");
                case 6 -> zad6();
                case 7 -> zad7();
                case 8 -> zad8();
                case 9 -> zad9();
                case 10 -> zad10();
                default -> System.out.println("Введите указанные номера заданий!");

            }
        }
    }
}
