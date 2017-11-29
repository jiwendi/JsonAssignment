package joyiwendi.com.jsonassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    EditText text = (EditText) findViewById(R.id.text);
    String listColor = " ";

    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        content = "{\n"+
                "     \"colors\": [\n"+
                "       {\n"+
                "         \"color\": \"black\",\n"+
                "         \"category\": \"hue\",\n"+
                "         \"type\": \"primary\",\n"+
                "         \"code\": {\n"+
                "           \"rgba\": [255,255,255,1],\n"+
                "           \"hex\": \"#000\"\n"+
                "         }\n"+
                "       },\n"+
                "       {\n"+
                "         \"color\": \"white\",\n"+
                "         \"category\": \"value\",\n"+
                "         \"code\": {\n"+
                "           \"rgba\": [0,0,0,1],\n"+
                "           \"hex\": \"#FFF\"\n"+
                "         }\n"+
                "       },\n"+
                "       {\n"+
                "         \"color\": \"red\",\n"+
                "         \"category\": \"hue\",\n"+
                "         \"type\": \"primary\",\n"+
                "         \"code\": {\n"+
                "           \"rgba\": [255,0,0,1],\n"+
                "           \"hex\": \"#FF0\"\n"+
                "         }\n"+
                "       },\n"+
                "       {\n"+
                "         \"color\": \"blue\",\n"+
                "         \"category\": \"hue\",\n"+
                "         \"type\": \"primary\",\n"+
                "         \"code\": {\n"+
                "           \"rgba\": [0,0,255,1],\n"+
                "           \"hex\": \"#00F\"\n"+
                "         }\n"+
                "       },\n"+
                "       {\n"+
                "         \"color\": \"yellow\",\n"+
                "         \"category\": \"hue\",\n"+
                "         \"type\": \"primary\",\n"+
                "         \"code\": {\n"+
                "           \"rgba\": [255,255,0,1],\n"+
                "           \"hex\": \"#FF0\"\n"+
                "         }\n"+
                "       },\n"+
                "       {\n"+
                "         \"color\": \"green\",\n"+
                "         \"category\": \"hue\",\n"+
                "         \"type\": \"secondary\",\n"+
                "         \"code\": {\n"+
                "           \"rgba\": [0,255,0,1],\n"+
                "           \"hex\": \"#0F0\"\n"+
                "         }\n"+
                "       }\n"+
                "     ]\n"+
                "   }";

                read();

        }




    public void read(){

        try {
            JSONObject colours = (JSONObject) new JSONTokener(content).nextValue();
            JSONArray colourArray = colours.getJSONArray("colors");


            for (int i = 0; i < colourArray.length(); i++) {

                JSONObject arrayNum = (JSONObject) colourArray.get(i);


                JSONObject code = (JSONObject) arrayNum.get("code");
                JSONArray rgba = (JSONArray) code.get("rgba");
                if (rgba.getInt(1) == 255) {
                    counter += 1;
                    }
                listColor += arrayNum.get("color") + " - ";
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void count(View view) {

        text.setText (counter);
    }

    public void list(View view) {

        text.setText(listColor);
    }

    public void modify(View view) {

        try {
            JSONObject colours = (JSONObject) new JSONTokener(content).nextValue();
            JSONArray colourArray = colours.getJSONArray("colors");

            JSONObject newjson = new JSONObject();

            newjson.put("color","orange");
            newjson.put("category","hue");

            JSONObject rgba = new JSONObject();
            JSONArray arrayNew = new JSONArray();
            arrayNew.put(255);
            arrayNew.put(165);
            arrayNew.put(0);
            arrayNew.put(1);
            rgba.put("rgba",arrayNew);
            rgba.put("hex","#FA0");

            newjson.put("code",rgba);

            colourArray.put(newjson);

            JSONObject colours2 = new JSONObject();
            colours2.put("colors",colourArray);

            String result = colours2.toString(2);

            text.setText(result);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


