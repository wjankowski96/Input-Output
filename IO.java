import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;


public class IO 
{

	public static void main(String[] args) 
	{
		String input = null;
		try {
		input = Files.readString(Paths.get("data.txt")); 
		}
		catch (IOException exception) {
		exception.printStackTrace();
		}
		
	   int linenumber = 0;
	   
       try{
    		File file =new File("data.txt");
			if(file.exists())
			{
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
				while (lnr.readLine() != null)
				{
    	        	linenumber++;
    	        }
    	        lnr.close();
    	        
    		     
			}
			else
			{
    			 System.out.println("File does not exists!");
    		}
		}
		catch(IOException e)
		{
    		e.printStackTrace();
    	}

		Pattern NEWLINE = Pattern.compile("\\,|\\R"); 
		String lines[] = NEWLINE.split(input);
		double[] x = new double [linenumber];
		double[] y = new double [linenumber];

		for( int i=0 ; i<( linenumber*2); i++ )
		{
			if( i%2==0)
			{
				x[i/2]= Double.parseDouble(lines[i]);
			}
			else
			{
				y[i/2]= Double.parseDouble(lines[i]);
			}
		}
	
		
	    double xav = averageValue(x, linenumber);
	    double yav = averageValue(y, linenumber);
	    
	    String header1 = "Liczba wierszy = " + linenumber + "\n"; 
	    String header2 = "Wartość średnia kolumny x = " + xav + "\n";
	    String header3 = "Wartość średnia kolumny y = " + yav + "\n"; 
	    String header4 = "„x | y” \n";

	    String output=null;
	    
	    StringBuffer strBuffer = new StringBuffer();
	    strBuffer.append(header1);
	    strBuffer.append(header2);
	    strBuffer.append(header3);
	    strBuffer.append(header4);
	    strBuffer.append(input);
	    output=strBuffer.toString();
	    
		try 
		{ 
			Files.writeString(Paths.get("newData.txt"), output, StandardOpenOption.CREATE); 
		} 
		catch (IOException exception) 
		{
	    		    exception.printStackTrace();
	    }
	}
	
	public static double averageValue(double[] daneWejsciowe, int linenumber) 
	{
	    double suma=0, srednia=0;
		for( int i=0; i<linenumber ; i++ )
		{
			suma=suma + daneWejsciowe[i];
		}
		srednia=suma/linenumber;
		return srednia;
    }
}