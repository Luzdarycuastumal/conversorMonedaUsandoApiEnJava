import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static void mostrarMenu(){
        System.out.println("""
         ***Sea Bienvenido al Conversor de Monedas***
         1. Dolar(USD)==>>Peso Argentino(ARS)
         2. Peso Argentino(ARS)==>>Dolar(USD)
         3. Dolar(USD)==>>Real Brasileño(BRL)
         4. Real Brasileño(BRL)==>>Dolar(USD)
         5. Dolar(USD)==>>Peso Colombiano(COP)
         6. Peso Colombiano(COP)==>>Dolar(USD)
         7. Salir del Programa.                                  
                          """);
    }
    public static void main(String[] args) {
        String base;
        String destino;
        Double cantidad;
        String responseBody;
        Divisa nuevoObjetoDivisa;
        List<Divisa> historial=new ArrayList<>();
        Scanner lecturaTeclado=new Scanner(System.in);
        ConsultaApiYConversion consulta=new ConsultaApiYConversion();
        TransformarDatos transformarAObjeto=new TransformarDatos();
        GeneracionDeArchivo generarArchivo=new GeneracionDeArchivo();
        boolean controlDeMenu=true;
        while(controlDeMenu){
            mostrarMenu();
            System.out.println("Elija Opción...");
            int opcion=Integer.parseInt(lecturaTeclado.nextLine());
            System.out.println(opcion);
            switch (opcion){
                case 1:
                    System.out.println("***Dolar(USD) ==>> Peso Argentino(ARS)***");
                    System.out.println("Ingrese Cantidad a convertir");
                    cantidad=Double.parseDouble(lecturaTeclado.nextLine());
                    base ="USD";
                    destino="ARS";
                    responseBody=consulta.consultaYConversionDivisa(base,destino,cantidad);
                    System.out.println("Resultado de la consulta en formato Json feo==>>"+responseBody);
                    nuevoObjetoDivisa=transformarAObjeto.transformarDatos(responseBody);
                    historial.add(nuevoObjetoDivisa);
                    break;
                case 2:
                    System.out.println("Peso Argentino(ARS)==>>Dolar(USD)");
                    System.out.println("Ingrese Cantidad a convertir");
                    cantidad=Double.parseDouble(lecturaTeclado.nextLine());
                    base ="ARS";
                    destino="USD";
                    responseBody=consulta.consultaYConversionDivisa(base,destino,cantidad);
                    System.out.println("Resultado de la consulta en formato Json feo==>>"+responseBody);
                    nuevoObjetoDivisa=transformarAObjeto.transformarDatos(responseBody);
                    historial.add(nuevoObjetoDivisa);
                    break;
                case 3:
                    System.out.println("Dolar(USD)==>>Real Brasileño(BRL)");
                    System.out.println("Ingrese Cantidad a convertir");
                    cantidad=Double.parseDouble(lecturaTeclado.nextLine());
                    base ="USD";
                    destino="BRL";
                    responseBody=consulta.consultaYConversionDivisa(base,destino,cantidad);
                    System.out.println("Resultado de la consulta en formato Json feo==>>"+responseBody);
                    nuevoObjetoDivisa=transformarAObjeto.transformarDatos(responseBody);
                    historial.add(nuevoObjetoDivisa);
                    break;
                case 4:
                    System.out.println("Real Brasileño(BRL)==>>Dolar(USD)");
                    System.out.println("Ingrese Cantidad a convertir");
                    cantidad=Double.parseDouble(lecturaTeclado.nextLine());
                    base ="BRL";
                    destino="USD";
                    responseBody=consulta.consultaYConversionDivisa(base,destino,cantidad);
                    System.out.println("Resultado de la consulta en formato Json feo==>>"+responseBody);
                    nuevoObjetoDivisa=transformarAObjeto.transformarDatos(responseBody);
                    historial.add(nuevoObjetoDivisa);
                    break;
                case 5:
                    System.out.println("Dolar(USD)==>>Peso Colombiano(COP)");
                    System.out.println("Ingrese Cantidad a convertir");
                    cantidad=Double.parseDouble(lecturaTeclado.nextLine());
                    base ="USD";
                    destino="COP";
                    responseBody=consulta.consultaYConversionDivisa(base,destino,cantidad);
                    System.out.println("Resultado de la consulta en formato Json feo==>>"+responseBody);
                    nuevoObjetoDivisa=transformarAObjeto.transformarDatos(responseBody);
                    historial.add(nuevoObjetoDivisa);
                    break;
                case 6:
                    System.out.println("Peso Colombiano(COP)==>>Dolar(USD)");
                    System.out.println("Ingrese Cantidad a convertir");
                    cantidad=Double.parseDouble(lecturaTeclado.nextLine());
                    base ="COP";
                    destino="USD";
                    responseBody=consulta.consultaYConversionDivisa(base,destino,cantidad);
                    System.out.println("Resultado de la consulta en formato Json feo==>>"+responseBody);
                    nuevoObjetoDivisa=transformarAObjeto.transformarDatos(responseBody);
                    historial.add(nuevoObjetoDivisa);
                    break;
                case 7:
                    generarArchivo.generacionDeArchivo(historial);
                    System.out.println("Gracias por usar nuestro servicio");
                    controlDeMenu=false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
        lecturaTeclado.close();
    }
}
