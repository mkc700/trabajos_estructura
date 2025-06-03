public class PalindromoRecursivo {

    /**
     * Comprueba si una palabra es un palíndromo de forma recursiva.
     * Considera la palabra tal cual, distinguiendo mayúsculas/minúsculas.
     *
     * @param palabra La cadena de texto a comprobar.
     * @return true si la palabra es un palíndromo, false en caso contrario.
     */
    public static boolean esPalindromo(String palabra) {
        // Validación inicial: Si la palabra es nula, no es un palíndromo.
        if (palabra == null) {
            return false;
        }

        // Caso base 1: Si la palabra tiene 0 o 1 carácter, es un palíndromo.
        if (palabra.length() <= 1) {
            return true;
        }

        // Obtener el primer y último carácter.
        char primerCaracter = palabra.charAt(0);
        char ultimoCaracter = palabra.charAt(palabra.length() - 1);

        // Caso base 2: Si el primer y último carácter no coinciden, no es un palíndromo.
        if (primerCaracter != ultimoCaracter) {
            return false;
        }

        // Paso recursivo:
        // Si el primer y último carácter coinciden, comprobamos recursivamente
        // la sub-palabra (la palabra sin el primer y último carácter).
        // `substring(1, palabra.length() - 1)` obtiene la sub-cadena desde el índice 1
        // hasta el penúltimo carácter (excluyendo el último).
        String subPalabra = palabra.substring(1, palabra.length() - 1);
        return esPalindromo(subPalabra);
    }

    // --- Versión más robusta que ignora mayúsculas/minúsculas y caracteres no alfabéticos ---
    /**
     * Comprueba si una palabra (o frase) es un palíndromo de forma recursiva,
     * ignorando mayúsculas/minúsculas y caracteres no alfabéticos.
     *
     * @param texto El texto a comprobar.
     * @return true si el texto es un palíndromo, false en caso contrario.
     */
    public static boolean esPalindromoRobusto(String texto) {
        if (texto == null) {
            return false;
        }

        // Preprocesar el texto: eliminar caracteres no alfabéticos y convertir a minúsculas.
        // Utiliza una expresión regular para mantener solo letras y números.
        String textoLimpio = texto.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        return esPalindromoRec(textoLimpio, 0, textoLimpio.length() - 1);
    }

    /**
     * Método auxiliar recursivo para la comprobación robusta del palíndromo.
     * Trabaja con índices para evitar crear nuevas cadenas (más eficiente).
     *
     * @param texto El texto limpio (solo alfanumérico y minúsculas).
     * @param inicio El índice de inicio de la subcadena a comprobar.
     * @param fin El índice de fin de la subcadena a comprobar.
     * @return true si la subcadena es un palíndromo, false en caso contrario.
     */
    private static boolean esPalindromoRec(String texto, int inicio, int fin) {
        // Caso base 1: Si el índice de inicio es mayor o igual al de fin,
        // significa que hemos revisado todos los caracteres o que solo queda uno.
        // En ambos casos, es un palíndromo.
        if (inicio >= fin) {
            return true;
        }

        // Caso base 2: Si los caracteres en los extremos no coinciden, no es un palíndromo.
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }

        // Paso recursivo: Si los caracteres coinciden, avanzamos los índices hacia el centro.
        return esPalindromoRec(texto, inicio + 1, fin - 1);
    }


    public static void main(String[] args) {
        // Pruebas para la versión simple:
        System.out.println("--- Versión Simple (sensible a mayúsculas/minúsculas y espacios) ---");
        System.out.println("radar es un palíndromo: " + esPalindromo("radar"));       // true
        System.out.println("oso es un palíndromo: " + esPalindromo("oso"));           // true
        System.out.println("reconocer es un palíndromo: " + esPalindromo("reconocer")); // true
        System.out.println("ana es un palíndromo: " + esPalindromo("ana"));           // true
        System.out.println("hola es un palíndromo: " + esPalindromo("hola"));         // false
        System.out.println("abccba es un palíndromo: " + esPalindromo("abccba"));     // true
        System.out.println("a es un palíndromo: " + esPalindromo("a"));               // true
        System.out.println(" (cadena vacía) es un palíndromo: " + esPalindromo("")); // true
        System.out.println("Radar es un palíndromo: " + esPalindromo("Radar"));       // false (por 'R' y 'r')
        System.out.println("A mama panama es un palíndromo: " + esPalindromo("A mama panama")); // false (por espacios y mayúsculas)


        // Pruebas para la versión robusta:
        System.out.println("\n--- Versión Robusta (ignora mayúsculas/minúsculas y no alfabéticos) ---");
        System.out.println("radar es un palíndromo: " + esPalindromoRobusto("radar"));         // true
        System.out.println("Radar es un palíndromo: " + esPalindromoRobusto("Radar"));         // true
        System.out.println("Amo la paloma es un palíndromo: " + esPalindromoRobusto("Amo la paloma")); // true
        System.out.println("La ruta nos aporto otro paso natural es un palíndromo: " + esPalindromoRobusto("La ruta nos aporto otro paso natural")); // true
        System.out.println("Anita lava la tina es un palíndromo: " + esPalindromoRobusto("Anita lava la tina")); // true
        System.out.println("Sé verlas al revés es un palíndromo: " + esPalindromoRobusto("Sé verlas al revés")); // true
        System.out.println("Hola es un palíndromo: " + esPalindromoRobusto("Hola"));           // false
        System.out.println("A man, a plan, a canal: Panama es un palíndromo: " + esPalindromoRobusto("A man, a plan, a canal: Panama")); // true
        System.out.println(" (cadena vacía) es un palíndromo: " + esPalindromoRobusto("")); // true
        System.out.println("!@#$a$#@! es un palíndromo: " + esPalindromoRobusto("!@#$a$#@!")); // true
    }
}
