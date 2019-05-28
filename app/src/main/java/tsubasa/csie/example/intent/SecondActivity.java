package tsubasa.csie.example.intent;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstaceState) {

        super.onCreate(savedInstaceState);
        setContentView(R.layout.secondlayout);

        Bundle bnde = this.getIntent().getExtras();

        String sex = bnde.getString("sex");
        double height = bnde.getDouble("height");

        String setText="";

        if (sex.equals("Male")) {
            setText="Male";
        }
        else {
            setText="Female";
        }

        String weight = this.getWeight(sex,height);

        TextView tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("你是一位"+setText+"\n你的身高是"+height+"cm\n你的標準體重是"+weight+"公斤");

    }

    private String format (double num) {
        NumberFormat formatter = new DecimalFormat("0.00");
        String s = formatter.format(num);
        return s;
    }

    private String getWeight(String sex,double height) {
        String weight = "";
        if (sex.equals("M")) {
            weight = format((height-80)*0.7);
        }
        else {
            weight = format((height-70)*0.6);
        }
        return weight;
    }

}
