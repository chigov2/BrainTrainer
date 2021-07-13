package techmarket.uno.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //1. прежде всего подготовить класс shared preferences
    private SharedPreferences pref;
    //3.
    private EditText editTextSave;
    private TextView tvData;
    private final String saveKey = "saveKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onClickSave(View view) {
        //4. для сохранения используем Editor
        SharedPreferences.Editor edit = pref.edit();//создаем Editor -  позволяет сохранять данные в хранилище
        edit.putString(saveKey,editTextSave.getText().toString());
        edit.apply();
    }

    public void onClickGet(View view) {
        editTextSave.setText(pref.getString(saveKey,"empty"));
        tvData.setText(pref.getString(saveKey,"Ничего нет в памяти"));

    }
    //.2
    private void init(){
        pref = getSharedPreferences("Test",MODE_PRIVATE);
        editTextSave = findViewById(R.id.editTextSave);
        tvData = findViewById(R.id.tvData);
        // из строки 34 копирум, чтобы при инициализации что-то иметь на экране
        editTextSave.setText(pref.getString(saveKey,"empty"));
        tvData.setText(pref.getString(saveKey,"empty"));
    }

}