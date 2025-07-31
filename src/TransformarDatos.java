import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TransformarDatos {
    public Divisa transformarDatos(String BodyJson){
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        Divisa objDivisa=gson.fromJson(BodyJson, Divisa.class);
        System.out.println("**Datos convertidos a objeto record Divisa**");
        System.out.println("ToString del Objeto Record Divisa: "+objDivisa);
        return objDivisa;
        //System.out.println(gson.toJson(objDivisa));
    }
}
