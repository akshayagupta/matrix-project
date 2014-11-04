package com.example.mat;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	int count =1 ; 
	static int a[][] =new int[100][100] ;
	static Intent intent ;
	static String outArray[];// = new String[111111] ;
	static int pos[] = new int[111111];
	static  GridView gridview ;
	static Context context;
	 int k ;
		static int i=0;
		static ArrayAdapter <String>aaa[];
		static int countas=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
	    intent = getIntent();
	    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
	    k = Integer.parseInt(message);
	    outArray = new String[k*k];
	    Toast.makeText(getApplicationContext(), ""+k, Toast.LENGTH_LONG).show();
	    computeStringArray(k);
	    gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setNumColumns(k);
	    Handler pauser = new Handler();
	    context=getApplicationContext();
	    for(i=0;i<k*k;i++)
	    {
	    	outArray[i]=new String("");
	    }
	    aaa=new ArrayAdapter[k*k];
	    
	    for(i=0;i<k*k;i++){
	    	pauser.postDelayed(new Runnable(){
	    		public void run(){
	    			updateHi();
	    		}
	    	}, 1000*i);
		}
	    
	}
	
	public static synchronized void updateHi(){
			outArray[pos[countas]]=""+countas ;
	    	aaa[countas]= new ArrayAdapter<String>(
	 				context,
	 				android.R.layout.simple_list_item_1, 
	 				outArray );
	 	    gridview.setAdapter(aaa[countas]);
	 	   countas++;
	 	    
	}
	


	private void computeStringArray(int n) {
		// TODO Auto-generated method stub
		int count  ;
		int up = 1 , left = 0, right = n+1 , bottom = n + 1  ;
		int flag = 1 ;
		int p = n*n ; 
		int cur_x = 1 ; 
		int cur_y = 1 ;
		for( count = 0; count < p ; count++ )
		{
			if( flag == 1 )
			{
				a[cur_x][cur_y++] =  count ;
				//outArray[count] = "" + count ;
				if( cur_y == right )
				{	
					cur_x++;
					cur_y-- ; 
					right-- ;
					flag = 2 ; 
					}
				}
			else if( flag == 2 )
			{
				a[cur_x++][cur_y] =  count ;
				//outArray[count] = "" + count ;
				if(cur_x == bottom )
				{
					cur_y-- ;
					cur_x-- ;
					bottom -- ;
					flag = 3 ;
					}
				}
			else if( flag == 3 )
			{
				a[cur_x][cur_y--] =  count ;
				//outArray[count] = "" + count ;
				if(cur_y == left)
				{
					cur_y++ ;
					cur_x-- ;
					left++ ;
					flag = 4;
					}
				}
			else if( flag == 4 )
			{
					a[cur_x--][cur_y] =  count ;
					//outArray[count] = "" + count ;
					if(cur_x == up)
					{
						cur_x++ ;
						cur_y++ ;
						up++;
						flag = 1;
						}	
				}	 
			else  ;
			}	
		int c = 0 ; 
		for(int i = 1 ; i <= n ; i++)
			for(int j  =1 ; j <= n ; j++ )
			{
					pos[a[i][j]] = c;
					outArray[c++] = "" + a[i][j] ;
		
			}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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


