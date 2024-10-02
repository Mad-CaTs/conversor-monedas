package launch;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        Menu menu = new Menu();
        menu.mostrarMenu(apiKey);

        while (!salir){
            try{
                salir = menu.mostrarMenu(apiKey);
            } catch (Exception e){
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}
