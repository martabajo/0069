/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael KÃ¶lling.
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
     * añade a la clase `LogAnalyzer`  un nuevo constructor. Este constructor tendrá un parámetro consistente en el nombre del archivo de log a analizar. 
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
     * Crea un método llamado `numberOfAccesses` que se pueda ejecutar después del método `analyzeHourlyData` y que devuelva el número 
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
}
