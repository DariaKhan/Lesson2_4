package LESSON1.Lesson2_4;

public class Laptop {
public String model;
public int ram;
public int hdd;
public String os;
public String color;

@Override
public String toString() {
    return "Искомая модель ноутбука: " +
            "модель: " + model +
            ", объем оперативной памяти ГБ: " + ram +
            ", объем жесткого дика ГБ: " + hdd +
            ", ОС:" + os +
            ", цвет: " + color;
    }

}
