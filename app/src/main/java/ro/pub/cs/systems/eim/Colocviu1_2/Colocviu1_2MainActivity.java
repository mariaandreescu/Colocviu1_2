package ro.pub.cs.systems.eim.Colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Colocviu1_2MainActivity extends AppCompatActivity {

    private EditText nextTermText;
    private TextView allTermsText;
    private Button addButton;

    PressButtonListener buttonListener = new PressButtonListener();


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
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        nextTermText = (EditText) findViewById(R.id.next_term);
        allTermsText = (TextView) findViewById(R.id.all_terms);
        addButton = (Button) findViewById(R.id.add_button);

        addButton.setOnClickListener(buttonListener);
    }
}