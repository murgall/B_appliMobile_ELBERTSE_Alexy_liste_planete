package com.example.murga.b_appmob_elbertse_alexy_liste_planete;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView MaListe ;


    private void initList(ArrayList<AndroidVersion> androidList){
        AndroidVersion version= new AndroidVersion();
        version.setVersionName("jupiter");
        version.setVersionNumber("1.5");
        androidList.add(version);

        AndroidVersion version2= new AndroidVersion();
        version2.setVersionName("mars");
        version2.setVersionNumber("3");
        androidList.add(version2);

        AndroidVersion version3= new AndroidVersion();
        version3.setVersionName("mercure");
        version3.setVersionNumber("4.5");
        androidList.add(version3);

        AndroidVersion version4= new AndroidVersion();
        version4.setVersionName("neptune");
        version4.setVersionNumber("6");
        androidList.add(version4);

        AndroidVersion version5= new AndroidVersion();
        version5.setVersionName("saturne");
        version5.setVersionNumber("7.5");
        androidList.add(version5);

        AndroidVersion version6= new AndroidVersion();
        version6.setVersionName("uranus");
        version6.setVersionNumber("9");
        androidList.add(version6);

        AndroidVersion version7= new AndroidVersion();
        version7.setVersionName("venus");
        version7.setVersionNumber("11");
        androidList.add(version7);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<AndroidVersion> androidList = new ArrayList<AndroidVersion>();
        initList(androidList);
        AndroidAdapter adapter = new AndroidAdapter(this,R.layout.relative,androidList);
        final ListView list = (ListView) findViewById(R.id.maliste);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                AndroidVersion selectedItem = (AndroidVersion)adapter.getItemAtPosition(position);
                Log.v("ListPersonnalisée", "Element selectionné : " + selectedItem.getVersionName());
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
