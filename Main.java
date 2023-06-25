
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String> map;
        System.out.println();
        NoteBook Samsung = new NoteBook("Samsung", 8, 1024, "Windows 11", "серебристый");
        NoteBook Xiaomi = new NoteBook("Xiaomi ", 8, 512, "Linux", "синий");
        NoteBook Asus = new NoteBook("Asus ", 16, 256, "DOS", "серебристый");
        NoteBook Huawei = new NoteBook(" Huawei", 8, 512, "Linux", "синий");
        NoteBook Lenovo = new NoteBook("Lenovo ", 4, 1024, "Windows 11", "черный");

        ArrayList array_nout = new ArrayList<>();
        array_nout.add(Samsung);
        array_nout.add(Xiaomi);
        array_nout.add(Asus);
        array_nout.add(Huawei);
        array_nout.add(Lenovo);

        for (var nout : array_nout) {
            System.out.println(nout);
        }
        System.out.println();

        map = FindPar();

        Filtr(map, array_nout);

    }

    static void Filtr(Map<String, String> crete_map, ArrayList<NoteBook> list) {
        ArrayList<NoteBook> filtr = new ArrayList<>();
        System.out.println();

        for (var nout : list) {
            if ((crete_map.containsKey("ram")) &&
                    (nout.getRam() < Integer.parseInt(crete_map.get("ram")))) {
                nout.setName("");
            }
            if ((crete_map.containsKey("hd")) &&
                    (nout.getHd() < Integer.parseInt(crete_map.get("hd")))) {
                nout.setName("");
            }

            if ((crete_map.containsKey("os")) &&
                    (!nout.getOs().equals(crete_map.get("os")))) {
                nout.setName("");
            }
            if ((crete_map.containsKey("color")) &&
                    (!nout.getColor().equals(crete_map.get("color")))) {
                nout.setName("");
            }

        }

        for (var i : list) {
            if (!i.getName().equals("")) {
                filtr.add(i);
            }
            System.out.println();
        }
        if (filtr.size() > 0) {
            System.out.println();

            for (var item : filtr) {
                System.out.println(item);
            }
            System.out.println();
        } else {
            System.out.println("Соответствий не найдено");
        }

    }

    static Map<String, String> FindPar() {
        String color = "";
        String choice = "";
        String os = "";

        Boolean getOut = false;

        Map<String, String> str = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        while (!getOut) {
            System.out.println();
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("Enter - вывод полученных результатов");

            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Введите минимальный объем ОЗУ в мегабайтах: ");
                    str.put("ram", scan.nextLine());
                    break;
                }
                case "2": {
                    System.out.println("Введите минимальный объем диска в гигабайтах: ");
                    str.put("hd", scan.nextLine());
                    break;
                }
                case "3": {
                    System.out.println("Доступны следующие ОС:");
                    System.out.println("1 - Windows 11");
                    System.out.println("2 - Linux");
                    System.out.println("3 - DOS");
                    System.out.println("Выберите цвету цифру: ");
                    choice = scan.nextLine();
                    switch (choice) {
                        case "1": {
                            os = "Windows 11";
                            break;
                        }
                        case "2": {
                            os = "Linux";
                            break;
                        }
                        case "3": {
                            os = "DOS";
                            break;
                        }

                        default:
                            break;
                    }
                    str.put("os", os);
                    System.out.println("Выбрано: " + str.get("os"));
                    break;
                }
                case "4": {
                    System.out.println("1 - белый");
                    System.out.println("2 - серый");
                    System.out.println("3 - серебристый");
                    System.out.println("4 - черный");
                    System.out.println("5 - синий");
                    System.out.println("Выберите  цифру: ");
                    String colorNum = scan.nextLine();
                    switch (colorNum) {
                        case "1": {
                            color = "белый";
                            break;
                        }
                        case "2": {
                            color = "серый";
                            break;
                        }
                        case "3": {
                            color = "серебристый";
                            break;
                        }
                        case "4": {
                            color = "черный";
                            break;
                        }
                        case "5": {
                            color = "синий";
                            break;
                        }
                        default:
                            break;
                    }
                    str.put("color", color);
                    System.out.println("Выбрано: " + str.get("color"));
                    break;
                }
                case "": {
                    getOut = true;

                    System.out.println(str);
                    break;
                }
                default: {

                }
            }
        }

        return str;
    }
}