package com.example.meganwechter.homework4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.action_menu_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Context context = getApplicationContext();
        MediaPlayer mediaPlayer;
        switch (pos) {
            case 0:
                //nothing to do, user has selected the default
                break;
            case 1:
                //launch welcome video activity
                Intent i = new Intent(this, VideoActivity.class);
                startActivity(i);
                break;
            case 2:
                //launch fight song audio
                mediaPlayer = MediaPlayer.create(context,R.raw.fightsong);
                mediaPlayer.start();
                break;
            case 3:
                //yall may need to launch a new activity for the maps work
                showMessage("The Tower","The Tower is a great place to meet chicks.  Because it is so tall, " +
                        "mama birds feel safe building their nests there.  In their natural habitat, they are" +
                        "more trusting than at local watering holes like the Bling Pig Pub.  Visit the Life Sciences" +
                        " Library in the Tower to learn all about it");
                break;
            case 4:

                showMessage("The SAC","The New University of Texas Student Activity Center, the NUTSAC for middle, or the SAC" +
                        " for short is awesome.");
                break;
            case 5:

                showMessage("The PCL","Fill in the blank Herbert and Allison");
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView parent) {

    }

    public void showMessage (String title, String Message){
        // create a new alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Sets whether the dialog is cancelable or not.
        builder.setCancelable(true);

        // Set the title displayed in the dialog
        builder.setTitle(title);

        // set the message to display
        builder.setMessage(Message);

        // creates an AlertDialog with the arguments supplied to this builder and immediately displays the dialog.
        builder.show();
    }
}
