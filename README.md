# Tarea-2-DOO

Estudiantes: Gerhec Ain Parra Gavilan, Diego Felipe Fuentes Conejeros(Satonakiv) y Martin Alonso Labarca Rojas

Grupo 16


Explicación de las clases y/o metodos adicionales al UML:


Clase Informe:

generarTxt: metodo que genera un archivo .txt con las estadisticas de la reunion y las notas de esta mediante el uso de
file writer y pasando con toString las estadisticas previamente obtenidas en la clase reunion. Analogamente se añade un
try-catch bloque para evitar que se cree mal el .txt ya sea por no encontrar la ubicacion, error al escribirlo, etc.


Clase Reunion:

getRetrasos: metodo que devuelve mediante un for de objetos y un if con instaceof Retraso si alguien llego tarde y lo añade al arraylist de atrasados.

toString: metodo que devuelve las estadisticas de la reunion usando Stringbuilder para evitar errores en los test junit
y mejorar la rapidez.


Clase Nota:
añadidura de un atributo para guardar la hora exacta del instante en el que se realiza una anotacion.



