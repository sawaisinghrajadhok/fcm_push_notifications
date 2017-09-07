/**
 * 
 */

/**
 * @author Sawai Singh Charan
 *
 */
 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class Push {

	public static void main(String[] args) throws Exception {

		String url = "https://fcm.googleapis.com/fcm/send";
		String API_ACCESS_KEY = "AAAA5U66wZU:APA91bHoeCQn7C67-yihLHhbQXm-NOJZ2Qdi5jpiI0KFtlPloLMxSI77_SgbMx_iIHb1IduJtCD9VuNGhrK9J0qQKPkKUEaRT8gohVx5GbF_nf9eEJ_q0RXW3QTaEpO3WqnXAWCyArk-";
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		con.setUseCaches(false);
		con.setDoInput(true);
		con.setDoOutput(true);
		
		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Authorization", "key=" + API_ACCESS_KEY);
		con.setRequestProperty("Content-Type", "application/json");
		
		// Put receivers token ids.
		JSONArray jsonArray = new JSONArray();
		jsonArray.put("dXQ-QwIAZDg:APA91bHqKQgjW9IusTzGXlHRrrOgozbk3tYzXn5RY4P5vZDnrci2O_huVaCbcuEreCDqNZFLFCW_WYwgHe5EsWZS1cQzvg8dbeQhzUdSJpbD47eU-De5VBAurEAMt6c3ri0G-BM83lZJ");  
		//jsonArray.put("d5p3EPzFOAY:APA91bFR0gdB20ZqJ9J6YHDIUxYHHZl4HZj2atyZXAeDHM-AFoZAlaEs_V7T226laZdwaSUcNYKK7wzjUQnvTXF65ur85Ngc2GLR9DkCOUwfqZSuxpXlt0UYYA7dnJESEakkWMNulG4_");
		
		// Create json for notification.
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("registration_ids", jsonArray);
		JSONObject info = new JSONObject();
		info.put("title", "Testing");
		info.put("body", new Date());
		jsonObject.put("notification", info);
		System.out.println(jsonObject);
		
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
		outputStreamWriter.write(jsonObject.toString());
		outputStreamWriter.flush();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());
	}
}