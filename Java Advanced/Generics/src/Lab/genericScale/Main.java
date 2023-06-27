package Lab.genericScale;

public class Main {
    public static void main(String[] args) {

        String left = "Meri";
        String right = "Lili";

        Scale<String> stringScale = new Scale<>(left, right);

        System.out.println(stringScale.getHeavier());
    }
}
