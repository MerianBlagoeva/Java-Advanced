
public class Exercise {
    public static void main(String[] args) {
        System.out.println(areYouPlayingBanjo("Rene"));

    }

    public static String areYouPlayingBanjo(String name) {
        if (name.toLowerCase().startsWith("r"))
            return name + " plays banjo";
        else
            return name + " does not play banjo";
    }
}
