import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PatentIndexerMain implements Runnable {

	private String[] samples;
	private String outpath;

	public PatentIndexerMain(String[] samples, String outpath) {
		// TODO Auto-generated constructor stub
		this.samples = samples;
		this.outpath = outpath;
		
	}
	
	@Override
	public void run() {
		// open output file
		for(int s=0; s<samples.length && samples[s]!=null; s++)
		{
			System.out.println("Sample "+String.valueOf(s));
			String sample = samples[s];
			Patent patent = PatentTransformer.transform(sample);
			if(patent.getId().compareTo("")!=0) {
				try {
					File f = new File(outpath+"/"+patent.getId());
					FileWriter out = new FileWriter(f);
					if(f.exists()) {
						out.write(patent.toXMLLine(true));
						out.close();					
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block				
					e.printStackTrace();
				}					
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("enter input path: ");
			String inpath = sc.nextLine();
			System.out.print("enter output path: ");
			String outpath = sc.nextLine();
			if(inpath.length()>0 && outpath.length()>0) {
				System.out.print("enter number of threads: ");
				int numThreads = sc.nextInt();
				
				try {
					// open source file
					BufferedReader in = new BufferedReader(new FileReader(inpath));
					if(in!=null)
					{
						ExecutorService executor = Executors.newFixedThreadPool(numThreads);
						
						String[] samples = new String[1000];
						String[] labels = new String[1000];
						HashSet<String> labelsDic = new HashSet<String>();
						
						// loop on input records
						int lineNo = 0;
						String line = in.readLine();
						while(line!=null)
						{
							// extract sample string
							// each sample is label\tid\tstring
							samples[lineNo] = line;
							
							if(++lineNo%1000==0) {
								executor.execute(new PatentIndexerMain(samples, outpath));
								samples =  new String[1000];
								lineNo = 0;
							}
							line = in.readLine();
						}
						if(lineNo>0) {
							executor.execute(new PatentIndexerMain(samples, outpath));
						}
						
						in.close();
						
						// wait for all threads to complete.
						executor.shutdown();
						while(!executor.isTerminated()) {
							
						}
					}
					System.out.println("Done generating information :)");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
			else
				break;
		}
	}

}
