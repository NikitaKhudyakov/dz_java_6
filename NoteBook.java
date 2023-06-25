public class NoteBook {
    private String name;
    private Integer access_memory;
    private Integer hard_drive;
    private Integer os;
    private String color;

    public NoteBook(String name, Integer access_memory, Integer hard_drive, Integer os, String color) {
        this.name = name;
        this.access_memory = access_memory;
        this.hard_drive = hard_drive;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return name + " - Название, " + access_memory + " - ОЗУ, " + hard_drive + " - Объем ЖД, " + os
                + " - Операционная система, " + color + " - Цвет. ";

    }

    public String toName() {
        return name + " - Название. ";
    }

    public String toAccess() {
        return access_memory + " - ОЗУ. ";
    }

    public String toHard_drive() {
        return hard_drive + " - Объем ЖД.";
    }

    public String toOS() {
        return os + " - Операционная система.";
    }

    public String toColor() {
        return color + " - Цвет.";
    }

    public void vibor() {
        System.out.println("Выбери по каким параметрам будем делать фильтрацию!");
        System.out.println("1 - Название, 2 - ОЗУ, 3 - Объем ЖД, 4 - Операционная система, 5 - Цвет. ");
        int numb1 = io.nextInt();
    }

}
