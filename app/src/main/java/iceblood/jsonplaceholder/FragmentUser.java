package iceblood.jsonplaceholder;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentUser extends FragmentPost {

    ArrayList<String> names;
    private TextView textView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.card_user, null);

        textView = (TextView) v.findViewById(R.id.textViewPostBody);

        names = new ArrayList<>();

        for(int i = 1;i<=5;i++){
            Send(Url+"users"+"/"+Integer.toString(i));
            Log.e("LOL","запрос отправлен");
        }

        return v;
    }

    protected void ShowResultPost(String content) {
        try {
            JSONObject jsonObject = new JSONObject(content);
            textView.setText(textView.getText()+"\n"+jsonObject.getString("name"));

        } catch (JSONException e) {
            ShowNoInternetToast();
        }
    }
}
