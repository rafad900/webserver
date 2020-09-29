import javax.imageio.ImageIO;
import java.awt.Image;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ImageRequest {
    private static HttpURLConnection connection = null;
    private static InputStream is = null;
    private static DataOutputStream os = null;
    private static BufferedReader rd = null;   //This is unecessary for images
    private static Image img = null;
    private static StringBuilder content = null; 

    private static String urlParameters = "name=Jack&occupation=programmer";
    private static byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

    private static void connect() {
        try {
            URL url = new URL("http://localhost:8000/blog/post/");
            connection = (HttpURLConnection) url.openConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createResponse() {
        try  { 
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Java Client");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            os = new DataOutputStream( connection.getOutputStream() );
            os.write( postData );

        
            rd = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
            String line;
            content = new StringBuilder();
            
            while ( (line = rd.readLine() ) != null ) {
                content.append( line );
                content.append( System.lineSeparator() );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println( content.toString() );

        connection.disconnect();
    }


            
        
    public static void main( String [] args) {
        System.out.println("This is the test for the functions");
        connect();
        System.out.println("Got past the connection");
        createResponse();
        System.out.println("Created the window");


    }
}
