//ActivityMain1.java
package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    private int STORAGE_PERMISSION_CODE = 23;
    private Object Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText2);
    }

    public void next(View view){
        String packcageContext;
        Intent intent = new Intent(packcageContext: MainActivity.this, MainActivity2.class);
        startActivity(Intent);
    }
    public void savePublic (View view){
        ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        String info = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);// folder Name
        File myFile = new File(folder, "myData1.txt");// Filename
        writeData(myFile, info);
        editText.setText("");
    }

    public void savePrivate (View view){
        String info = editText.getText().toString();
        File folder = getExternalFilesDirs("arvita");// folder Name
        File myFile = new File(folder, "myData2.txt");// Filename
        writeData(myFile, info);
        editText.setText("");
    }
    private void writeData(File myFile, String info) {
    FileOutputStream   fileOutputStream = null;
    try {
        System.out.println("YES");
        fileOutputStream = new FileOutputStream(myFile);
        Toast.makeText(this, "Done" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
    } catch (Exception e){
        e.printStackTrace();
    }finally {
        if (fileOutputStream !=null){
            try {
                fileOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    }

}


//ActivityMain2.java

package com.example.tugas1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showText = (TextView) findViewById(R.id.getText);
    }

    public void back(View view){
        Intent intent = new Intent( MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void getPublic (View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);// folder Name
        File myFile = new File(folder, "myData1.txt");// Filename
        String text = getdata(myFile);
        if (text != null){
            showText.setText(text);
        } else {
            showText.setText("No Data");
        }
    }

    public void getPrivate(View view){
        File folder = getExternalFilesDirs("arvita");// folder Name
        File myFile = new File(folder, "myData2.txt");// Filename
        String text = getdata(myFile);
        if (text != null){
            showText.setText(text);
        } else {
            showText.setText("No Data");
        }
    }
    private String getdata(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new fileInputStream(myFile);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while ((i = fileInputStream.read()) != -1){
                buffer.append((char) i);
            }
            return  buffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileInputStream !=null){
                try{
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

