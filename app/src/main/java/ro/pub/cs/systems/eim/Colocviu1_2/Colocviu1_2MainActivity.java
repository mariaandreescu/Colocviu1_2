package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Colocviu1_2MainActivity extends AppCompatActivity {

    private EditText nextTermText;
    private TextView allTermsText;
    private Button addButton;
    private Button computeButton;
    int suma[];
    int i = 0;
    int sumaTotala = 0;
    int old_value = 0;

    PressButtonListener buttonListener = new PressButtonListener();

    private IntentFilter intentFilter = new IntentFilter();

    private class PressButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.add_button) {
                if (!nextTermText.getText().toString().equals("")) {
                    if (allTermsText.getText().toString().equals("")) {
                        allTermsText.setText(allTermsText.getText().toString() + nextTermText.getText().toString());
                    } else {
                        allTermsText.setText(allTermsText.getText().toString() + " + " + nextTermText.getText().toString());
                    }
                }
                suma[i++] = Integer.valueOf(nextTermText.getText().toString());

            }
            if (view.getId() == R.id.compute_button) {
                Intent intent = new Intent(getApplicationContext(), Colocviu1_2SecondaryActivity.class);

                intent.putExtra(Constants.SUMA_ARR, suma);
                intent.putExtra(Constants.N_SUMA, i);
                startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);
        suma = new int[20];

        nextTermText = (EditText) findViewById(R.id.next_term);
        allTermsText = (TextView) findViewById(R.id.all_terms);
        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(buttonListener);
        computeButton = (Button) findViewById(R.id.compute_button);
        computeButton.setOnClickListener(buttonListener);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            if (intent != null) {
                sumaTotala = intent.getIntExtra(Constants.RETURN_KEY, -1);
                Toast.makeText(this, "The sum is: " + sumaTotala, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.RETURN_KEY, String.valueOf(sumaTotala));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.RETURN_KEY)) {
            sumaTotala = savedInstanceState.getInt(Constants.RETURN_KEY, -1);
            Toast.makeText(this, "The sum is: " + sumaTotala, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "The sum is: " + sumaTotala, Toast.LENGTH_LONG).show();
        }
    }
}
