package com.example.jahnvi.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class InstActivity extends AppCompatActivity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst);
        mListView = (ListView) findViewById(R.id.inst_list);

        String[] listItems = new String[4];
        listItems[0] = "You can give an input to the video player in the form of jpg image files numbered from 1 to n that would be played at 24fps ";
        listItems[1] = " The numbering decides the order in which the frames will be joined.";
        listItems[2] = "The images should be present in the default Pictures directory of your device.";
        listItems[3] = "In case you don't have the images, follow the procedure in the doc to add images.";

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/JosefinSans-Bold.ttf");
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTypeface(typeface);
                return view;
            }
        };
        mListView.setAdapter(adapter);
        Button nextBtn = (Button)findViewById(R.id.next);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

}
