import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
//import org.apache.solr.common.SolrInputDocument;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

public class PatentsIndexer extends Configured implements Tool {

   public static void main( String[] args) throws  Exception {
      int res  = ToolRunner.run( new PatentsIndexer(), args);
      System.exit(res);
   }

   public int run( String[] args) throws  Exception {
      Job job  = Job.getInstance(getConf(), "patentindexer");
      job.setJarByClass(this.getClass());

      FileInputFormat.addInputPaths(job, args[0]);
      FileOutputFormat.setOutputPath(job, new Path(args[1]));
      job.setMapperClass(PatentParserMap.class);
      job.setReducerClass(PatentParserReduce.class);
      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(Text.class);

      return job.waitForCompletion(true)  ? 0 : 1;
   }
   
   public static class PatentParserMap extends Mapper<LongWritable ,  Text ,  Text ,  Text > {
      public void map(LongWritable offset,  Text lineText,  Context context)
        throws  IOException,  InterruptedException {
         
         // each line represents a patent in the USPTO xml format
         String patentxml  = lineText.toString();

         // parse the xml according to its DTD version and extract values of target index fields from it
         Patent patent = PatentTransformer.transform(patentxml);
         if(patent.getId().compareTo("")!=0) { // parsed successfully
        	 // emit id and single format xml
        	 context.write(new Text(patent.getId()), new Text(patent.toXMLLine(true)));
        	 /*try{
        		   DefaultHttpClient httpClient = new DefaultHttpClient();
        		    HttpPost post = new HttpPost("http://10.18.203.79:9090/solr/updatecommitWithin=10000 -H \"Content-Type: text/xml\" --data-binary '<add><doc><field name=\"id\">2</field></doc></add>'");
        		    httpClient.execute(post);        		    
        		} catch (UnsupportedEncodingException e) {
        		    e.printStackTrace();
        		} catch (IOException e) {
        		    e.printStackTrace();
        		} catch (Exception e) {
        		    e.printStackTrace();
        		}
        		*/
        	 /*HttpSolrServer server = new HttpSolrServer("http://10.18.203.79:9090/solr");     	    
     	      SolrInputDocument doc = patent.getSolrDocument();     	      
     	      try {
     	    	  server.add(doc);
     	    	  context.write(new Text(patent.getId()), new Text(patent.toXML()));
     	      } catch(SolrServerException e) {
     	    	 e.printStackTrace();
     	      }
     	      //server.commit();
     	       */
         }         
      }
   }

   public static class PatentParserReduce extends Reducer<Text ,  Text ,  Text ,  Text> {
      @Override 
      public void reduce( Text id,  Iterable<Text> parsed,  Context context)
         throws IOException,  InterruptedException {
    	  // each id is unique and will be associated with only one xml
         for ( Text parsedpatent : parsed) {
        	 context.write(id,  parsedpatent);        	 
         }
      }
   }
}