package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import twitter4j.*;
import twitter4j.conf.*;
//import javax.swing.*;

public class Main {
	
	/**
	 * @param args
	 * @throws TwitterException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws TwitterException, FileNotFoundException {
		File csvFile = new File("tweets.csv");
		if (!csvFile.exists())
			throw new FileNotFoundException("file doesn't exist");
		PrintStream l_out = new PrintStream(new FileOutputStream("tweets.csv",true));
		
		Configuration conf = (new ConfigurationBuilder()).setDebugEnabled(true)
				  .setOAuthConsumerKey("5WHrltMd3j4YTA1YTZoUET8DT")
				  .setOAuthConsumerSecret("kjnJ03shic0YKmtMA5tkA09gaw8cQLbPaLzbSCEevUBl2HDtA5")
				  .setOAuthAccessToken("68107269-fWxJ2V3HlQNmVRVaSZoEXzU2KiC8an6h4o1WxR0tN")
				  .setOAuthAccessTokenSecret("RO2Rg58MtSxzRTPd4hsPaEWQdhPnOvWicvBqkzDIZqOOu")
				  .setHttpProxyHost("cache.univ-lille1.fr")
				  .setHttpProxyPort(3128).build();
		TwitterFactory tf = new TwitterFactory(conf);
		Twitter twitter = tf.getInstance();
		
		Query query 		= new Query("source: whispyy");
		QueryResult result 	= twitter.search(query);
		for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	        l_out.print("@" + status.getUser().getScreenName() + ":" + status.getText()+",");
	    }
		l_out.flush();
		l_out.close();
		l_out = null; 
	}


}