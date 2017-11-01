package iceblood.jsonplaceholder;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class FragmentComm extends FragmentPost {

    private EditText editTextComm;
    private TextView textViewCommName, textViewCommEmail, textViewCommBody;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.card_comments, null);

        textViewCommName = (TextView) v.findViewById(R.id.textViewCommName);
        textViewCommEmail = (TextView) v.findViewById(R.id.textViewCommEmail);
        textViewCommBody = (TextView) v.findViewById(R.id.textViewCommBody);
        editTextComm = (EditText) v.findViewById(R.id.editTextComm);

        Send(Url+"comments/1");


        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = editTextComm.getText().toString();
                try {
                    if (Integer.parseInt(str) >= 1 && Integer.parseInt(str) <= 500) {
                        Send(Url+"comments/"+str);
                    }
                } catch (Exception ex) {

                    Toast toast = Toast.makeText(getActivity(),
                            "введите число от 1 до 500", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        return v;
    }
    protected void ShowResultPost(String content) {
        try {
            JSONObject jsonObject = new JSONObject(content);
            textViewCommName.setText(jsonObject.getString("name"));
            textViewCommBody.setText(jsonObject.getString("body"));
            textViewCommEmail.setText(jsonObject.getString("email"));
        } catch (JSONException e) {
            ShowNoInternetToast();
        }
    }
}
