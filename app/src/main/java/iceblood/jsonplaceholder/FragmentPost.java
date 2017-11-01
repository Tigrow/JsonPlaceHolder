package iceblood.jsonplaceholder;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class FragmentPost extends Fragment {

    protected DownloadAsync downloadAsync;
    protected String Url = "https://jsonplaceholder.typicode.com/";
    protected View v;

    private EditText editTextPost;
    private TextView textViewPostTitle, textViewPostBody;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.card_post, null);

        editTextPost = (EditText) v.findViewById(R.id.editTextPost);
        textViewPostTitle = (TextView) v.findViewById(R.id.textViewPostTitle);
        textViewPostBody = (TextView) v.findViewById(R.id.textViewPostBody);

        Send(Url+"posts/1");

        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String str = editTextPost.getText().toString();
                try {
                    if (Integer.parseInt(str) >= 1 && Integer.parseInt(str) <= 100) {
                        Send(Url+"posts/"+str);
                    }
                } catch (Exception ex) {

                    Toast toast = Toast.makeText(getActivity(),
                            "введите число от 1 до 100", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        return v;
    }

    protected void Send(String str) {

        downloadAsync = new DownloadAsync();
        downloadAsync.setDownloadListener(new DownloadAsyncListener.DownloadListener() {
            @Override
            public void onFinish(Object object) {
                ShowResultPost((String) object);
                Log.e("LOL","запрос пришел");
            }
        });
        downloadAsync.execute(str);

    }

    protected void ShowResultPost(String content) {
        try {
            JSONObject jsonObject = new JSONObject(content);
            Log.e("LOL","запрос обработался");
            textViewPostTitle.setText(jsonObject.getString("title"));
            textViewPostBody.setText(jsonObject.getString("body"));
        } catch (JSONException e) {
            ShowNoInternetToast();
        }
    }
    protected  void ShowNoInternetToast(){
        Toast toast = Toast.makeText(getActivity(),
                getString(R.string.no_internet), Toast.LENGTH_SHORT);
        toast.show();
    }


}
