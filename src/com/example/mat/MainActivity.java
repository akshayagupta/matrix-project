package com.example.mat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView txtView ; 
	EditText edtText ;
	Button btn ;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	//GridLayout grid ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtText = (EditText) findViewById(R.id.editText1) ;
		btn = (Button) findViewById(R.id.btn1) ;
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				// TODO Auto-generated method stub
				String s = edtText.getText().toString();
				 Intent myintent = new Intent(getApplicationContext(), SecondActivity.class) ;
				 myintent.putExtra(EXTRA_MESSAGE,s) ;
				 startActivity(myintent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
