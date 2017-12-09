package org.check.car.carcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] typesOfCheck = {"История регистрации", "Нахождение в розыске", "Участие в ДТП", "Наличие ограничений"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvTypesOfCheck = (ListView) findViewById(R.id.lvTypesOfCheck);

        //ArrayAdapter<CharSequence> adapter = new ArrayAdapter.createFromResource(this, R.array.typesOfCheck, android.R.layout.simple_list_item_1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, typesOfCheck);
        lvTypesOfCheck.setAdapter(adapter);

        lvTypesOfCheck.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, CheckHistory.class);
                //Intent intent = new Intent(MainActivity.this, CheckGibdd.class);
                switch (i){
                    case 0:
                        intent.putExtra("typeOfCheck", "history");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("typeOfCheck", "wanted");
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("typeOfCheck", "aiusdtp");
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("typeOfCheck", "restricted");
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
