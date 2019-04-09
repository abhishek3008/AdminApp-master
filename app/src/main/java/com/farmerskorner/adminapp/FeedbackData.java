package com.farmerskorner.adminapp;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
public class FeedbackData extends AsyncTask<String,Void,String> {
    Context context;
    RecyclerView recyclerView;
    List<Suggestion> suggestionList;
    public FeedbackData(Context context, RecyclerView recyclerView){
        this.context = context;
        this.recyclerView = recyclerView;
    }
    @Override
    protected String doInBackground(String... strings) {
        try{
            String link="http://avrutti.com/election/responseFeedback.php";
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result){
        Log.d("Result Activity",result);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        suggestionList= new ArrayList<>();
        String[] splitArray = result.split("\\|");
        int length = (splitArray.length);
        for (int i=0; i<length; i=i+3){
            String name=splitArray[i];
            String imageText=name.substring(0,1);
            String rating=splitArray[i+1];
            float numberRating=Float.parseFloat(rating);
            String comment=splitArray[i+2];
            suggestionList.add(new Suggestion(imageText,name,numberRating,comment));
        }
        SuggestionAdapter adapter = new SuggestionAdapter(context, suggestionList);
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
