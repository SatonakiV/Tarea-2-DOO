import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Informe {

    public void generarTxt(Reunion reunion){

        String texto = reunion.toString();
        ArrayList<Nota> contenido = reunion.getNotas();


        try(FileWriter Informe_Reunion = new FileWriter("Informe_reunion.txt")){
            Informe_Reunion.write(texto);

            Informe_Reunion.write("\n Notas de la reunion: ");
            contenido.sort((n1, n2) -> n1.getHoraAnotacion().compareTo(n2.getHoraAnotacion()));
            for(Nota n: contenido){
                Informe_Reunion.write("\n - " + n.toString());
            }

            System.out.println("El archivo fue creado con exito");
        }

        catch(FileNotFoundException e){
            System.err.println("Error: Ubicacion del archivo no encontrada");
        }

        catch(IOException e){
            System.err.println("Error al escribir el informe");
        }

        catch(Exception e){
            System.err.println("Sucedio algo inesperado, intentalo denuevo...");
        }



    }



}
