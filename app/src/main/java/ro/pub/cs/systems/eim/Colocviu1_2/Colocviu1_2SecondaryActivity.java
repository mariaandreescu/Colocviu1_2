package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_2_secondary);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.SUMA_ARR)) {
            int[] sumaArr = intent.getIntArrayExtra(Constants.SUMA_ARR);
            int nr = intent.getIntExtra(Constants.N_SUMA, 0);

            int suma = 0;
            for (int i = 0; i < nr; i++) {
                suma += sumaArr[i];
            }
            Intent intentRes = new Intent();
            intentRes.putExtra(Constants.RETURN_KEY, suma);
            setResult(RESULT_OK, intentRes);
            finish();
        }
    }

}