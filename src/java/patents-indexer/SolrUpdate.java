import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.bzip2.CBZip2InputStream;

class SolrUpdateThread implements Runnable{
	String solr;
	String[] docs;
	int count;
	boolean flymode = false;
	SolrUpdateThread(String solr, String[] docs, int count, boolean flymode) {
		this.solr = solr;
		this.docs = docs;
		this.count = count;
		this.flymode = flymode;
	}
	
	@Override
	public void run() {
		String allxml = "";
		for(int i=0; i<count; i++) {
			String id, xml;
			int indx = docs[i].indexOf("\t");		
			if(indx>0) {
				// extract id
				id = docs[i].substring(0,docs[i].indexOf("\t"));
				System.out.println(String.format("Adding (%s)...", id));
				
				// extract document xml
				xml = docs[i].substring(docs[i].indexOf("\t")+1);
				xml = xml.replace("\\n", "\n");
			}
			else {
				// extract id
				id = "unknown";
				System.out.println(String.format("Adding (%s)...", id));
				
				// extract document xml
				xml = docs[i];
				xml = xml.replace("\\n", "\n");
			}
			if(xml.substring(0,5).compareTo("<add>")==0)
				xml = xml.substring(5);
			if(xml.substring(xml.length()-6,xml.length()).compareTo("</add>")==0)
				xml = xml.substring(0,xml.length()-6);
			allxml += xml;
		}
		try {
			allxml = "<add>" + allxml + "</add>";
			String tempfilename = "";
			File tempfile = null;
			if(flymode==false) {
				// store to temporary file
				tempfilename = "./__temporary__patent__xml__"+this.toString();
				tempfile = new File(tempfilename);
				FileWriter xmlfile;
				xmlfile = new FileWriter(tempfile);
				xmlfile.write(allxml);
				xmlfile.close();
			}
	
			// invoke solr update on temporary file content
			ProcessBuilder cmd;
			if(System.getProperty("os.name").contains("Windows")) {
				if(flymode==true)
					cmd = new ProcessBuilder("curl", "-H","\"Content-Type: text/xml\"","\"Accept-Charset: UTF-8\"","\""+solr+"\"", "\"--data-binary\"","\""+allxml+"\"");
				else
					cmd = new ProcessBuilder("curl", "-H","\"Content-Type: text/xml\"","\"Accept-Charset: UTF-8\"","\""+solr+"\"", "\"--data-binary\"","\"@"+tempfilename+"\"");
			}
			else {
				if(flymode==true)
					cmd = new ProcessBuilder("curl","-H","Content-Type: text/xml","Accept-Charset: UTF-8",solr, "--data-binary",allxml);
				else
					cmd = new ProcessBuilder("curl","-H","Content-Type: text/xml","Accept-Charset: UTF-8",solr, "--data-binary","@"+tempfilename);
			}
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
			//System.out.println(output);
			

			// commit changes
			if(System.getProperty("os.name").contains("Windows"))
				cmd = new ProcessBuilder("curl", "\""+solr+"?commit=true\"");
			else
				cmd = new ProcessBuilder("curl", solr+"?commit=true");
			cmd.redirectErrorStream(true);
			p = cmd.start();
			
			// delete temporary file
			if(flymode==false)
				tempfile.delete();					
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class SolrUpdate {
	protected static void printUsage() {
		System.out.println("Usage: java SolrUpdate --input input-dir --solr url-of-solr-update [--threads n] [--compressed y/n] [--thread-docs 100] [--flymode y/n]");
		System.out.println("E.g.,: java SolrUpdate --input /home/wshalaby/solr-update --solr http://localhost:8983/solr/update --threads 10 --thread-docs 100 --flymode n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * For each file in passed arguments
		 * 1. open the file
		 * 2. read next line (each line corresponds to as id+tab+document in xml)
		 * 4. call solr update to add it to the index
		 */
		String inpath = "";
		String solr = "";
		int numThreads = 1;
		int threads_docs = 100;
		boolean compressed = false;
		boolean flymode = false;
		ExecutorService executor;
		if(args.length>=4) {
			for(int i=0; i<args.length; i++) {
				if(args[i].equalsIgnoreCase("--input")) {
					inpath = args[i+1];
				}
				else if(args[i].equalsIgnoreCase("--solr")) {
					solr = args[i+1];
				}
				else if(args[i].equalsIgnoreCase("--threads")) {
					numThreads = Integer.parseInt(args[i+1]);
				}
				else if(args[i].equalsIgnoreCase("--compressed")) {
					compressed = args[i+1].equalsIgnoreCase("y");
				}
				else if(args[i].equalsIgnoreCase("--flymode")) {
					flymode = args[i+1].equalsIgnoreCase("y");
				}
				else if(args[i].equalsIgnoreCase("--thread-docs")) {
					threads_docs = Integer.parseInt(args[i+1]);
				}
			}
			if(inpath.length()>0 && solr.length()>0) {
				String[] docs = new String[threads_docs];
				executor = Executors.newFixedThreadPool(numThreads);
				File[] dir = new File(inpath).listFiles();
				for(File input : dir) {
					try {
						BufferedReader reader;
						if(compressed) {
							FileInputStream fis = new FileInputStream(input);
							fis.read();
							fis.read();
							CBZip2InputStream bz = new CBZip2InputStream(fis);
							reader = new BufferedReader(new InputStreamReader(bz));							
						}
						else {
							reader = new BufferedReader(new FileReader(input));
						}
						String line;
						int count = 0;
						while((line=reader.readLine())!=null) {
							docs[count] = line;
							count++;
							if(count==threads_docs) {
								executor.execute(new SolrUpdateThread(solr, docs, count, flymode));
								docs = new String[threads_docs];
								count = 0;
							}
						}
						if(count>0) {
							executor.execute(new SolrUpdateThread(solr, docs, count, flymode));
						}
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//while(true);
				executor.shutdown();
				/*try {
					executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				while(!executor.isTerminated()) {							
				}
			}
			else printUsage();
		}
		else 
			printUsage();
	}

}
