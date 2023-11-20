// Класс ноутбук
// Поля:
//     Производитель (manufacturer);
//     ОЗУ (ram);
//     Объем ЖД (hdSize);
//     Операционная система (operatingSystem);
//     Цвет корпуса (color);
// Методы:
//     Получить бренд (getManufacturer);
//     Получить ОЗУ (getRam);
//     Получить объем ЖД (getHdSize);
//     Получить ОС (getOS);
//     Получить цвет корпуса (getColor);

public class Laptop {

    private String manufacturer;
    private int ram;
    private int hdSize;
    private String operatingSystem;
    private String color;

    public Laptop(String manufacturer, int ram, int hdSize, String operatingSystem, String color) {
        this.manufacturer = manufacturer;
        this.ram = ram;
        this.hdSize = hdSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRam() {
        return ram;
    }

    public int getHdSize() {
        return hdSize;
    }

    public String getOs() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        String result = "Производитель -> " + manufacturer + " | "
                + "ОЗУ ГБ -> " + ram + " | "
                + "Объем диска ГБ -> " + hdSize + " | "
                + "OS -> " + operatingSystem + " | "
                + "Цвет корпуса -> " + color;
        return result;
    }
}