// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии)
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
// фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HardwareStore {
    public static void main(String[] args) {

        Set<Laptop> laptopSet = getLaptops();

        System.out.println("Список ноутбуков: ");
        for (Laptop laptop : laptopSet) {
            System.out.println(laptop);
        }
        System.out.println("--------------------------------------------------");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Map<String, Object> filters = new HashMap<>();
            System.out.println("Введите параметры фильтра. Значения указаны в круглых скобках!");

            System.out.print("Производитель (ASUS, Acer, GIGABYTE, Dell, HP, Huawei, Samsung) : ");
            String manufacturerInput = scanner.nextLine();
            if (!manufacturerInput.isEmpty()) {
                filters.put("manufacturer", manufacturerInput);
            }

            System.out.print("ОЗУ (4, 8, 16, 32): ");
            String ramInput = scanner.nextLine();
            if (!ramInput.isEmpty()) {
                filters.put("ram", Integer.parseInt(ramInput));
            }

            System.out.print("Объем жесткого диска (120, 240, 500, 1000, 2000): ");
            String hdSizeInput = scanner.nextLine();
            if (!hdSizeInput.isEmpty()) {
                filters.put("hdSize", Integer.parseInt(hdSizeInput));
            }

            System.out.print("Операционная система (Linux, Windows): ");
            String operatingSystemInput = scanner.nextLine();
            if (!operatingSystemInput.isEmpty()) {
                filters.put("computerOs", operatingSystemInput);
            }

            System.out.print("Цвет (белый, серый, черный): ");
            String colorInput = scanner.nextLine();
            if (!colorInput.isEmpty()) {
                filters.put("color", colorInput);
            }

            System.out.println("--------------------------------------------------");
            System.out.println("Параметры выборки (весь список если их нет!)>> " + filters);
            System.out.println("--------------------------------------------------");
            // Фильтрация и вывод результатов
            filterLaptops(filters, laptopSet);

            System.out.print("Желаете продолжить выборку (n - нет, y - да)?: ");
            String yesNo = scanner.nextLine();
            if (yesNo.equals("n")) {
                System.out.println("GoodBye!");
                break;
            }
            System.out.println();
        }
    }

    private static Set<Laptop> getLaptops() {
        Laptop laptop1 = new Laptop("ASUS", 4, 120, "Linux", "черный");
        Laptop laptop2 = new Laptop("Acer", 32, 2000, "Windows", "белый");
        Laptop laptop3 = new Laptop("GIGABYTE", 4, 240, "Linux", "черный");
        Laptop laptop4 = new Laptop("HP", 32, 1000, "Windows", "серый");
        Laptop laptop5 = new Laptop("Samsung", 16, 500, "Windows", "серый");
        Laptop laptop6 = new Laptop("Huawei", 8, 240, "Windows", "черный");
        Laptop laptop7 = new Laptop("Dell", 16, 1000, "Windows", "черный");
        Laptop laptop8 = new Laptop("Acer", 8, 500, "Windows", "серый");
        Laptop laptop9 = new Laptop("HP", 4, 120, "Linux", "белый");
        Laptop laptop10 = new Laptop("Acer", 8, 500, "Windows", "черный");

        Set<Laptop> laptopSet = Set.of(laptop1, laptop2, laptop3, laptop4, laptop5,
                                    laptop6, laptop7, laptop8, laptop9, laptop10);
        return laptopSet;
    }

    private static void filterLaptops(Map<String, Object> filters, Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            boolean passFilter = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                switch (entry.getKey()) {
                    case "manufacturer":
                        if (!laptop.getManufacturer().equals(entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case "ram":
                        if (laptop.getRam() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "hdSize":
                        if (laptop.getHdSize() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "operatingSystem":
                        if (!laptop.getOs().equalsIgnoreCase((String) entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase((String) entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                }
            }

            if (passFilter) {
                System.out.println(laptop);
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }
}
