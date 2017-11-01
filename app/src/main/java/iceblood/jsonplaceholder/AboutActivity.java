package iceblood.jsonplaceholder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Titan'ik on 01.11.2017.
 */

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        final EditText editTextCall = (EditText) findViewById(R.id.editTextCall);

        Button buttonCall = (Button) findViewById(R.id.button_call);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + editTextCall.getText()));
                startActivity(dialIntent);
            }
        });
    }
}
