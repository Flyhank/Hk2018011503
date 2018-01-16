package com.n9s.flyjet.hk2018011503;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickWrite(View v)
    {
        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);
            //Context.MODE_PRIVATE：為預設操作模式，代表該檔是私有資料，只能被應用本身訪問，
                // 在該模式下，寫入的內容會覆蓋原檔的內容

        SharedPreferences.Editor editor = sp.edit();
        EditText ed = (EditText) findViewById(R.id.editText);
        editor.putString("data1", ed.getText().toString());
        editor.commit();
    }

    public void clickRead(View v)
    {
        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);
        String str = sp.getString("data1", "");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(str);
    }

    public void clickSetting(View v)
    {
        Intent it = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(it);
    }

    public void clickRead1(View v)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this); //來源地
        String str = sp.getString("example_text", "");  //取甚?
        TextView tv = (TextView) findViewById(R.id.textView);   //放哪?
        tv.setText(str);    //放(顯示)甚?
    }

}
