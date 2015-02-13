/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        //System.out.println("Hr: Count");
        //for(int hour = 0; hour < hourCounts.length; hour++) {
        //    System.out.println(hour + ": " + hourCounts[hour]);
        //}

        int horas = 0;
        while(horas < hourCounts.length)
        {
            System.out.println(horas + ": " + hourCounts[horas]);
            horas = horas + 1;
        }
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }

    /**
     * a�ade a la clase `LogAnalyzer`  un nuevo constructor. Este constructor tendr� un par�metro consistente en el nombre del archivo de log a analizar. 
     * Usa la clase `LogFileCreator` para crear tu propio archivo de log y comprueba que puedes analizarlo con la clase `LogAnalyzer`.
     */
    public LogAnalyzer(String nombre)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(nombre);
    }

    /**
     * Crea un m�todo llamado `numberOfAccesses` que se pueda ejecutar despu�s del m�todo `analyzeHourlyData` y que devuelva el n�mero 
     * total de accesos al servidor web registrados en el archivo de log.
     */
    public int  numberOfAccesses()
    {
        int cont = 0;
        for (int horas : hourCounts){
            cont = cont + horas;
        }
        return cont;

    }

    /**
     * A�ade un m�todo denominado `busiestHour` a la clase `LogAnalyzer` que se pueda ejecutar despu�s del m�todo `analyzeHourlyData` y que 
     * devuelva en qu� hora el servidor tuvo que responder a m�s peticiones. 
     */
    public int busiestHour()
    {
        int cont = 0;
        for (int indice = 0; indice < hourCounts.length; indice = indice + 1){
            if( hourCounts[indice] > hourCounts[cont]);
            cont = indice;
        }
        return cont;
    }

    /**
     * A�ade un m�todo denominado `quietestHour` a la clase `LogAnalyzer` que se pueda ejecutar despu�s del m�todo `analyzeHourlyData` y que 
     * devuelva la hora a la que el servidor estuvo menos sobrecargado. Para testear este m�todo aseg�rate de que lo pruebas con un archivo 
     * de log en el que ha habido accesos a todas las horas.
     */
    public int quietestHour()
    {
        int cont = 0;
        for (int indice = 0; indice < hourCounts.length; indice = indice + 1){
            if( hourCounts[indice] < hourCounts[cont]);
            cont = indice;
        }
        return cont;
    }
    
    /**
     *  A�ade un m�todo que se pueda ejecutar despu�s del m�todo `analyzeHourlyData` y que calcule el per�odo de dos horas consecutivas con 
     *  m�s carga del d�a y devuelva un entero con la primera hora de dicho periodo.
     */
    
    public int dosHoras()
    {
        int cont = 0;
        for (int indice = 0; indice < hourCounts.length - 1; indice = indice + 1){
            if( (hourCounts[indice] + hourCounts[cont + 1]) > ( hourCounts[indice] + hourCounts[cont + 1]));
            cont = indice;
        }
        return cont;
    }
}
