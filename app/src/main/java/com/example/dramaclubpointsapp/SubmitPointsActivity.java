package com.example.dramaclubpointsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubmitPointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_points);
        EditText first = (EditText) findViewById(R.id.editText);
        EditText last = (EditText) findViewById(R.id.editText2);
    }

    public void goHomeButton(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onRadioButtonClicked(View v){
        TextView yes = (TextView) findViewById(R.id.problemSolver);

        Boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()){
            case R.id.radioButton:
                if(checked) {
                   yes.setText("freshmen");
                }
                break;
            case R.id.radioButton2:
                if(checked) {
                    yes.setText("sophomore");
                }
                break;
            case R.id.radioButton3:
                if(checked) {
                    yes.setText("junior");
                }
                break;
            case R.id.radioButton4:
                if(checked){
                    yes.setText("senior");
                }

        }

    }
    public void submitPoints(View v){
        EditText first = (EditText) findViewById(R.id.editText);
        EditText last = (EditText) findViewById(R.id.editText2);
        EditText productionName = (EditText) findViewById(R.id.editText3);
        EditText companyName = (EditText) findViewById(R.id.editText4);
        TextView getGrade = (TextView) findViewById(R.id.problemSolver);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String firstName = first.getText().toString();
        String lastName = last.getText().toString();
        String grade = getGrade.getText().toString();
        String role = spinner.getSelectedItem().toString();

        if (first.getText().toString().equals("") || last.getText().toString().equals("") || spinner.getSelectedItem().toString().equals("Role in Production:")){

        }
        else {
            first.setText("");
            last.setText("");
            productionName.setText("");
            companyName.setText("");



            String sent = firstName + " " + lastName + ", " + grade + ", " + role + ".";
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, sent);
            String chooserTitle = "Choose an app to send your message";
            Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
            startActivity(chosenIntent);
        }

        
    }
}
