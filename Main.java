package LESSON1.Lesson2_4;

import LESSON1.Lesson2_4.Laptop;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Laptop laptop1 = new Laptop();
        laptop1.model = "HP Pavilion";
        laptop1.ram = 8;
        laptop1.hdd = 512;
        laptop1.os = "Windows 10";
        laptop1.color = "Silver";

        Laptop laptop2 = new Laptop();
        laptop2.model = "Dell XP5";
        laptop2.ram = 16;
        laptop2.hdd = 256;
        laptop2.os = "Windows 11";
        laptop2.color = "Black";

        Laptop laptop3 = new Laptop();
        laptop3.model = "MacBook Pro";
        laptop3.ram = 16;
        laptop3.hdd = 512;
        laptop3.os = "macOS";
        laptop3.color = "Silver";

        Laptop laptop4 = new Laptop();
        laptop4.model = "Lenovo ThinkPad";
        laptop4.ram = 8;
        laptop4.hdd = 256;
        laptop4.os = "Windows 10";
        laptop4.color = "Black";

        Laptop laptop5 = new Laptop();
        laptop5.model = "Asus ZenBook";
        laptop5.ram = 16;
        laptop5.hdd = 512;
        laptop5.os = "Windows 11";
        laptop5.color = "Silver";

        System.out.println(laptop1);

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);


        Map<String, Object> filter = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Объем памяти ОЗУ");
        System.out.println("2 - Объем жесткого диска");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Выход из меню");
        System.out.println("Введите номер критерия фильтрации: ");

        while (true) {
            int filterNumber = Integer.parseInt(scanner.nextLine());
            if (filterNumber == 5) {
                break;
            }
            String filterName;
            switch (filterNumber) {
                case 1:
                    filterName = "ram";
                    System.out.println("Введите минимальный параметр оперативной памяти:");
                    int ramLaptop = Integer.parseInt(scanner.nextLine());
                    filter.put(filterName, ramLaptop);
                    System.out.println("Введите номер критерия фильтрации: ");
                    break;
                case 2:
                    filterName = "hdd";
                    System.out.println("Введите минимальный параметр жесткого диска:");
                    int hddLaptop = Integer.parseInt(scanner.nextLine());
                    filter.put(filterName, hddLaptop);
                    System.out.println("Введите номер критерия фильтрации: ");
                    break;
                case 3:
                    filterName = "os";
                    System.out.println("Введите тип операционной системы (возможные варианты: Windows 10, Windows 11 или MacOs):");
                    String osLaptop = scanner.nextLine();
                    if (!osLaptop.equals("Windows 10") && !osLaptop.equals("Windows 11") && !osLaptop.equals("MacOs")) {
                        System.out.println("Вы ввели неверный параметр");
                        System.out.println("Введите номер критерия фильтрации: ");
                        break;
                    } else {
                        filter.put(filterName, osLaptop);
                    }
                    System.out.println("Введите номер критерия фильтрации: ");
                    break;
                case 4:
                    filterName = "color";
                    System.out.println("Введите желаемый цвет (возможные варианты: Silver или Black): ");
                    String colorLaptop = scanner.nextLine();
                    if (!colorLaptop.equals("Silver") && !colorLaptop.equals("Black")) {
                        System.out.println("Вы ввели неверный параметр");
                        System.out.println("Введите номер критерия фильтрации: ");
                        break;
                    } else {
                        filter.put(filterName, colorLaptop);
                    }
                    System.out.println("Введите номер критерия фильтрации: ");
                    break;
                default:
                    System.out.println("Несуществующий номер меню.");
                    System.out.println("Введите номер критерия фильтрации: ");
                    continue;
            }
        }

        // Фильтруем ноутбуки и выводим результаты
        printMySet(filterNotebooks(laptops, filter));
    }

    public static Set<Laptop> filterNotebooks(Set<Laptop> laptops, Map<String, Object> filter) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean passFilter = true;

            // Проверяем, соответствует ли ноутбук всем критериям фильтрации
            for (Map.Entry<String, Object> entry : filter.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                switch (key) {
                    case "ram":
                        if (laptop.ram < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "hdd":
                        if (laptop.hdd < (int) value) {
                            passFilter = false;
                        }
                        break;
                    case "os":
                        if (!laptop.os.equalsIgnoreCase((String) value)) {
                            passFilter = false;
                        }
                        break;
                    case "color":
                        if (!laptop.color.equalsIgnoreCase((String) value)) {
                            passFilter = false;
                        }
                        break;
                    default:
                        break;
                }
            }

            if (passFilter) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

    private static void printMySet(Set<Laptop> laptops) {
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
    }
}
