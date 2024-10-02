package launch;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        Menu menu = new Menu();
        menu.mostrarMenu(apiKey);
    }
}
