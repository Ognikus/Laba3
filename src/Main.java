import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void Task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strings = new String[n];
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
            if (strings[i].length() > maxLength) {
                maxLength = strings[i].length();
            }
            if (strings[i].length() < minLength) {
                minLength = strings[i].length();
            }
        }

        System.out.println("Самая длинная строка: " + getMaxString(strings, maxLength) + ", длина: " + maxLength);
        System.out.println("Самая короткая строка: " + getMinString(strings, minLength) + ", длина: " + minLength);
    }

    public static String getMaxString(String[] strings, int maxLength) {
        for (String str : strings) {
            if (str.length() == maxLength) {
                return str;
            }
        }
        return "";
    }

    public static String getMinString(String[] strings, int minLength) {
        for (String str : strings) {
            if (str.length() == minLength) {
                return str;
            }
        }
        return "";
    }

    public static void Task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        // Сортировка в порядке возрастания длины строки
        Arrays.sort(strings, Comparator.comparingInt(String::length));

        System.out.println("Строки в порядке возрастания длины:");
        for (String str : strings) {
            System.out.println(str);
        }

        // Сортировка в порядке убывания длины строки
        Arrays.sort(strings, Comparator.comparingInt(String::length).reversed());

        System.out.println("Строки в порядке убывания длины:");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void Task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strings = new String[n];

        // Ввод строк
        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку #" + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        // Вычисление средней длины строк
        double avgLength = 0;
        for (String str : strings) {
            avgLength += str.length();
        }
        avgLength /= n;

        // Вывод строк, длина которых меньше/больше средней
        System.out.println("Строки, длина которых меньше средней (" + avgLength + "):");
        for (String str : strings) {
            if (str.length() < avgLength) {
                System.out.println(str + " (длина: " + str.length() + ")");
            }
        }

        System.out.println("Строки, длина которых больше средней (" + avgLength + "):");
        for (String str : strings) {
            if (str.length() > avgLength) {
                System.out.println(str + " (длина: " + str.length() + ")");
            }
        }
    }

    public static void Task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество слов: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Считываем лишний перенос строки

        String firstWord = null;
        int minUniqueChars = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите слово: ");
            String word = scanner.nextLine();
            int uniqueChars = countUniqueChars(word);
            if (uniqueChars < minUniqueChars) {
                firstWord = word;
                minUniqueChars = uniqueChars;
            }
        }

        if (firstWord == null) {
            System.out.println("Нет введенных слов");
        } else {
            System.out.println("Первое слово с минимальным числом уникальных символов: " + firstWord);
        }
    }

    // Метод, который считает число уникальных символов в слове
    public static int countUniqueChars(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        return set.size();
    }


    public static void Task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество слов: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Считываем лишний перенос строки

        int latinWordsCount = 0;
        int equalVowelConsonantWordsCount = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите слово: ");
            String word = scanner.nextLine();

            if (containsOnlyLatinChars(word)) {
                latinWordsCount++;

                if (hasEqualVowelConsonantCount(word)) {
                    equalVowelConsonantWordsCount++;
                }
            }
        }

        System.out.println("Количество слов, содержащих только символы латинского алфавита: " + latinWordsCount);
        System.out.println("Количество слов с равным числом гласных и согласных букв: " + equalVowelConsonantWordsCount);
    }

    // Метод, который проверяет, состоит ли слово только из символов латинского алфавита
    public static boolean containsOnlyLatinChars(String word) {
        return word.chars().allMatch(Character::isLetter) && word.chars().allMatch(c -> c < 128);
    }

    // Метод, который проверяет, имеет ли слово равное число гласных и согласных букв
    public static boolean hasEqualVowelConsonantCount(String word) {
        int vowelsCount = 0;
        int consonantsCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelsCount++;
            } else {
                consonantsCount++;
            }
        }
        return vowelsCount == consonantsCount;
    }

    public static void Task6() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество слов: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Считываем лишний перенос строки

        String wordWithIncreasingChars = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите слово: ");
            String word = scanner.nextLine();

            if (isCharsIncreasing(word) && wordWithIncreasingChars == null) {
                wordWithIncreasingChars = word;
            }
        }

        if (wordWithIncreasingChars == null) {
            System.out.println("Нет слов со строгим порядком возрастания кодов символов");
        } else {
            System.out.println("Первое слово со строгим порядком возрастания кодов символов: " + wordWithIncreasingChars);
        }
    }

    // Метод, который проверяет, идут ли символы в слове в строгом порядке возрастания их кодов
    public static boolean isCharsIncreasing(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) >= word.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }


    public static void Task7() {
        Scanner scan;

        String text;
        String[] textArray;

        System.out.println("Введите текст:");

        scan = new Scanner(System.in);
        text = scan.nextLine();

        textArray = text.split(" ");

        for(int i = 0; i < textArray.length; i++) {
            textArray[i] = textArray[i].replaceAll("[“:”,\"'`;()?_-]", "");
            if(uniqueSymbolsChecker(textArray[i])) {
                System.out.print("Cлово, состоящее только из различных символов: " + textArray[i] + "\n");
                break;
            }
        }
    }

    private static boolean uniqueSymbolsChecker(String word) {
        boolean result = false;

        ArrayList<Character> list = new ArrayList<>();
        char[] chars = word.toCharArray();

        for(char c : chars) {
            if (list.contains(c)) {
                result = false;
                return result;
            }
            else {
                list.add(c);
                result = true;
            }
        }

        return result;
    }

    public static void Task8() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        String palindrome = null;
        int palindromeCount = 0;

        for (String word : words) {
            if (isNumeric(word) && isPalindrome(word)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    palindrome = word;
                    break;
                }
                if (palindromeCount == 1) {
                    palindrome = word;
                }
            }
        }

        if (palindrome != null) {
            System.out.println("Палиндром слово: " + palindrome);
        } else {
            System.out.println("Палиндром не найден.");
        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9]+");
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean f = true;
        while (f) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите задание из списка ниже:");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("""
                    1.Ввести n строк с консоли, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.
                    2.Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания) значений их длины.
                    3.Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше (больше) средней, а также длину.
                    4.Ввести n слов с консоли. Найти слово, в котором число различных символов минимально. Если таких слов несколько, найти первое из них.
                    5.Ввести n слов с консоли. Найти количество слов, содержащих только символы латинского алфавита,\s
                    а среди них – количество слов с равным числом гласных и согласных букв.
                    6.Ввести n слов с консоли. Найти слово, символы в котором идут в строгом порядке возрастания их кодов.\s
                    Если таких слов несколько, найти первое из них.
                    7.Ввести n слов с консоли. Найти слово, состоящее только из различных символов. Если таких слов несколько, найти первое из них.
                    8.Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти слово-палиндром. Если таких слов больше одного, найти второе из них.
                    Введите 0 чтобы выйти из программы""");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.print("Введите Номер задания: ");
            int n = scanner.nextInt();
            switch (n) {
                case 0 -> f = false;
                case 1 -> Task1();
                case 2 -> Task2();
                case 3 -> Task3();
                case 4 -> Task4();
                case 5 -> Task5();
                case 6 -> Task6();
                case 7 -> Task7();
                case 8 -> Task8();
                default -> System.out.println("Введите указанные номера заданий!");

            }
        }
    }
}