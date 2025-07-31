import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaApiYConversion {
public String consultaYConversionDivisa(String base, String destino, double cantidad){

    URI direccion= URI.create("https://v6.exchangerate-api.com/v6/ff80da4ff154fda99229ac09/pair/"+base+"/"+destino+"/"+cantidad);
    System.out.println(direccion);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion)
            .build();
    try {
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
       // System.out.println(response.body());
        String bodyJson=response.body();
       // System.out.println("Resultado de la consulta en formato Json feo==>>"+bodyJson);
        return  bodyJson;
    } catch (IOException e) {
        System.out.println("Error de conexión: no se pudo contactar con el servidor.");
        System.out.println("Detalles técnicos: " + e.getMessage());
    } catch (InterruptedException e) {
        System.out.println("La operación fue interrumpida antes de completarse.");
        System.out.println("Detalles técnicos: " + e.getMessage());
    }

    return null;

}
}
