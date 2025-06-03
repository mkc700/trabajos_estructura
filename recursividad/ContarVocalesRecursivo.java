public class ContarVocalesRecursivo {

    /**
     * Cuenta el número de vocales en una cadena de texto de forma recursiva.
     * La comprobación de vocales es insensible a mayúsculas/minúsculas.
     *
     * @param cadena La cadena de texto a analizar.
     * @return El número de vocales en la cadena.
     */
    public static int contarVocales(String cadena) {
        // Validación inicial: Si la cadena es nula, no hay vocales.
        if (cadena == null) {
            return 0;
        }

        // Caso base: Si la cadena está vacía (o ya no quedan caracteres por procesar),
        // no hay más vocales que contar.
        if (cadena.length() == 0) {
            return 0;
        }

        // Obtener el primer carácter y el resto de la cadena
        char primerCaracter = cadena.charAt(0);
        String restoCadena = cadena.substring(1); // La subcadena sin el primer caracter

        // Comprobar si el primer carácter es una vocal
        int esVocal = 0;
        // Convertir a minúsculas para una comparación insensible a mayúsculas/minúsculas
        char lowerChar = Character.toLowerCase(primerCaracter);

        if (lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u') {
            esVocal = 1;
        }

        // Proceso recursivo:
        // Suma 1 (si el caracter actual es vocal) o 0 (si no lo es)
        // más el resultado de contar vocales en el resto de la cadena.
        return esVocal + contarVocales(restoCadena);
    }

    public static void main(String[] args) {
        // Ejemplos de uso:
        System.out.println("Número de vocales en 'Hola Mundo': " + contarVocales("Hola Mundo")); // Esperado: 4 (o,a,o,u)
        System.out.println("Número de vocales en 'Programacion Recursiva': " + contarVocales("Programacion Recursiva")); // Esperado: 9 (o,a,a,i,o,e,u,i,a)
        System.out.println("Número de vocales en 'Java': " + contarVocales("Java"));           // Esperado: 2 (a,a)
        System.out.println("Número de vocales en 'RHYTHM': " + contarVocales("RHYTHM"));       // Esperado: 0
        System.out.println("Número de vocales en 'aeiouAEIOU': " + contarVocales("aeiouAEIOU")); // Esperado: 10
        System.out.println("Número de vocales en '': " + contarVocales(""));                 // Esperado: 0
        System.out.println("Número de vocales en null: " + contarVocales(null));             // Esperado: 0 (por la validación inicial)
    }
}