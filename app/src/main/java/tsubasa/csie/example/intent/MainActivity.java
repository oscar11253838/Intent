package tsubasa.csie.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {

        EditText et = (EditText)findViewById(R.id.height);
        double height = Double.parseDouble(et.getText().toString());
        String sex="";
        RadioButton rb1 = (RadioButton) findViewById(R.id.sex1);

        if (rb1.isChecked()) {
            sex = "Male";
        }

        else {
            sex = "Female";
        }

        Intent intent = new Intent();
        intent.setClass(MainActivity.this,SecondActivity.class);

        Bundle bndl = new Bundle();
        bndl.putDouble("height",height);
        bndl.putString("sex",sex);

        intent.putExtras(bndl);

        startActivity(intent);

    }

}
