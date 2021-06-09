package sg.edu.rp.c346.id20023243.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etIndex;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;
    //to declare array list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndex = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddColour);
        btnRemove = findViewById(R.id.buttonRemoveColour);
        btnUpdate = findViewById(R.id.buttonUpdateColour);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        //to create the array list
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                alColours);
        //this to refer to current activity
        lvColour.setAdapter(aaColour);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.add(pos, newColour);
                aaColour.notifyDataSetChanged();//to update listView

                etElement.setText(""); //so that empty for next colour
                etIndex.setText("");

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();//to update listView
                etIndex.setText("");

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.set(pos, newColour);
                aaColour.notifyDataSetChanged();//to update listView

                etElement.setText(""); //so that empty for next colour
                etIndex.setText("");
            }
        });

        lvColour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        alColours.get(position), Toast.LENGTH_LONG).show();
                etIndex.setText(""+position); //when user click on the item, the index position will be shown in etIndex
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}