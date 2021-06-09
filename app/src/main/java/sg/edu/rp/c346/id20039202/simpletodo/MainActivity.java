package sg.edu.rp.c346.id20039202.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTask;
    Button btnAdd, btnClear;
    ListView lvTask;
    ArrayList<String> alTask;
    ArrayAdapter<String> aaTask;
    Spinner spnAddRemove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.buttonAddTask);
        btnClear = findViewById(R.id.buttonClearTask);
        lvTask = findViewById(R.id.listViewTask);
        spnAddRemove = findViewById(R.id.spinner);

        alTask = new ArrayList<>();

        aaTask = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alTask);
        lvTask.setAdapter(aaTask);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = etTask.getText().toString();
                alTask.add(newTask);
                aaTask.notifyDataSetChanged();
                etTask.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTask.clear();
                aaTask.notifyDataSetChanged();
            }
        });

        spnAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                etTask.setText("Spinner Item" + spnAddRemove.getSelectedItem() + "select");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}