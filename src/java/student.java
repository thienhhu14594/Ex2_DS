public class student {
    private static String name;
    private static String id;
    private static int year;

    public student(){}

    public student(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public static String getName() {
        return name;
    }

    public static String getId() {
        return id;
    }

    public static int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) { this.id = id; }

    public void setYear(int year) {
        this.year = year;
    }
}
