package resources;

public class FormulasForCalculatingCalories {
    public static int formulaByMifflinForMan(int weight, int growth, int age) {
        return (int) Math.round((10 * weight + 6.25 * growth - 5 * age + 5) * 1.375);
    }
}