package iceblood.jsonplaceholder;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class FragmentTodos extends FragmentPost {

    private TextView textViewTodosCompleted, textViewTodosTitle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.card_todos, null);

        textViewTodosCompleted = (TextView) v.findViewById(R.id.textViewTodosCompleted);
        textViewTodosTitle = (TextView) v.findViewById(R.id.textViewTodosTitle);

        Send(Url+"todos/1");

        return v;
    }
    protected void ShowResultPost(String content) {
        try {
            JSONObject jsonObject = new JSONObject(content);
            Log.e("LOL","запрос обработался");
            textViewTodosCompleted.setText(jsonObject.getBoolean("completed")?
                    getString(R.string.completed):getString(R.string.not_completed));

            textViewTodosTitle.setText(jsonObject.getString("title"));
        } catch (JSONException e) {
            ShowNoInternetToast();
        }
    }
}
