package com.example.dipali.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab = (Button) findViewById(R.id.submit1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (android.widget.EditText) findViewById(R.id.sr2);
                EditText email = (android.widget.EditText) findViewById(R.id.sr3);
                EditText pwd = (android.widget.EditText) findViewById(R.id.sr4);
                boolean filled = false;
                int count=0;
                if (name.getText().toString().trim().equals("")) {
                    name.setError("Name is required.");
                    count++;
                }else filled = true;
                if (email.getText().toString().trim().equals("")) {
                    email.setError("Email  is required.");
                    count++;
                }else filled = true;
                if (pwd.getText().toString().trim().equals("")) {
                    pwd.setError("Password is required.");
                    count++;
                }else filled = true;
                if (filled && count==0) {
                    android.content.Intent i = new android.content.Intent(Intent.ACTION_VIEW, android.net.Uri.parse("http://homeguru.brijendrasharma.in/studentregister.php?s_name="+name.getText().toString()+"&s_email="+email.getText().toString()+"&s_pwd="+pwd.getText().toString()+"&submit=Submit"));
                    startActivity(i);

                } else {
                    Toast.makeText(getApplicationContext(), "This form has errors.", Toast.LENGTH_SHORT).show();
                }

               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        Button fab1 = (Button) findViewById(R.id.goback2);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                android.content.Intent i = new android.content.Intent(StudentRegister.this,RegisterMenu.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
