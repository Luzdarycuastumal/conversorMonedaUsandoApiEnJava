import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class GeneracionDeArchivo {
    public void generacionDeArchivo(List<Divisa> historial) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escritura = new FileWriter("historial.json")) {
            gson.toJson(historial, escritura);
            System.out.println("Todas tus conversiones han sido guardadas en el archivo Json historial.json");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }

    }
}
