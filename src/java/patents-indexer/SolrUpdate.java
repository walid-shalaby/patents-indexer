import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolrUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * args[0] --> input directory
		 * args[1] --> solr instance ip:port (e.g., 10.18.203.79:9090)
		 * For each file in passed arguments
		 * 1. open the file
		 * 2. read next line (each line corresponds to as id+tab+document in xml)
		 * 4. call solr update to add it to the index
		 */
		String temp = args[0]+"/__temporary__patent__xml";
		File[] dir = new File(args[0]).listFiles();
		for(File input : dir) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(input));
				String line; 
				while((line=reader.readLine())!=null) {
					int indx = line.indexOf("\t");
					 {
						String id, xml;
						if(indx>0) {
							// extract id
							id = line.substring(0,line.indexOf("\t"));
							System.out.println(String.format("Adding (%s)...", id));
							
							// extract document xml
							xml = line.substring(line.indexOf("\t")+1);
							xml = xml.replace("\\n", "\n");
						}
						else {
							// extract id
							id = "unknown";
							System.out.println(String.format("Adding (%s)...", id));
							
							// extract document xml
							xml = line;
							xml = xml.replace("\\n", "\n");
						}
						
						// store to temporary file
						File tempfile = new File(temp);
						FileWriter xmlfile = new FileWriter(tempfile);
						xmlfile.write(xml);
						xmlfile.close();
	
						// invoke solr update on temporary file content
						ProcessBuilder cmd = new ProcessBuilder("curl","-H","Content-Type: text/xml","http://"+args[1]+"/solr/update?commitWithin=10000", "--data-binary","@"+tempfile);
						cmd.redirectErrorStream(true);
						Process p = cmd.start();

						BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String out, output="";
						while((out=br.readLine())!=null) {
							output += out + System.lineSeparator();
						}
						br.close();
						
						// print invocation result
						System.out.println("exit value: ("+String.valueOf(p.waitFor())+")");
						System.out.println(output);
						
						// delete temporary file
						tempfile.delete();					
					}
				}
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
