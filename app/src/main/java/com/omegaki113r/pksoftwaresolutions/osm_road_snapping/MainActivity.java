package com.omegaki113r.pksoftwaresolutions.osm_road_snapping;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<GPS_Coordinates> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File dbFile = Environment.getExternalStorageDirectory();
        dbFile = new File(dbFile,"Databases/MapTrackData.db");

        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(dbFile,null);
        Cursor c = database.rawQuery("SELECT * FROM tbl_distance",null);

        int tripLatIndex = c.getColumnIndex("trip_lat");
        int tripLngIndex = c.getColumnIndex("trip_lng");

        c.moveToFirst();
        /*
        while(c!=null){
            Log.i("DB DATA", String.valueOf(c.getDouble(tripLatIndex)));
            c.moveToNext();
        }
        */
        do{

            GPS_Coordinates coordinates = new GPS_Coordinates(c.getDouble(tripLatIndex),c.getDouble(tripLngIndex));
            list.add(coordinates);
            Log.i("DB DATA", coordinates.toString());
        }while(c.moveToNext());

    }
}
