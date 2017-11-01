package iceblood.jsonplaceholder;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class FragmentPhoto extends FragmentPost {

    ImageView imageView;
    private DownloadImageAsync downloadImageAsync;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.card_photo, null);

        imageView = (ImageView) v.findViewById(R.id.imageView2);


        Send(Url + "photos" + "/" + 5);

        return v;
    }
    protected void ShowResultPost(String content) {

        try {
            JSONObject jsonObject = new JSONObject(content);
            SendBitmap(jsonObject.getString("url"));
        } catch (JSONException e) {
            ShowNoInternetToast();
        }
    }
    protected void SendBitmap(String str) {

        downloadImageAsync = new DownloadImageAsync();
        Log.e("LOL","картинка запрошена");
        downloadImageAsync.setDownloadListener(new DownloadAsyncListener.DownloadListener() {
            @Override
            public void onFinish(Object object) {
                Log.e("LOL","картинка пришла");
                imageView.setImageBitmap((Bitmap) object);
                Log.e("LOL","запрос пришел");
            }
        });
        Log.e("LOL","картинка запрошена 2");
        downloadImageAsync.execute(str);
        Log.e("LOL","картинка запрошена 3");

    }
}
