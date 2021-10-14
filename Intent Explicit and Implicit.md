//Laman xml dengan Implicit dan Explicit
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_height="match_parent"
    android:layout_width="match_parent"
    tools:context=".MainActivity">
    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="60dp"
        android:ems="10"
        android:text=""
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.575"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:inputType="textUri" />
//membuat button Explicit
    <Button
        android:id="@+id/explicit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="15dp"
        android:layout_marginTop="20dp"
        android:layout_marginRight="8dp"
        android:text="Enter"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.541"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />
//membuat button implicit
    <Button
        android:id="@+id/implicit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="156dp"
        android:layout_marginLeft="15dp"
        android:layout_marginTop="80dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:text="Enter from browser"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.564"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />
</androidx.constraintlayout.widget.ConstraintLayout>

//membuat layout di secondary activity
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Activity kedua"
        android:textStyle="bold"
        android:textSize="40dp"
        android:textAlignment="center"
        android:layout_marginTop="150dp"
        android:layout_alignParentStart="true"
        tools:ignore="MissingConstraints"
        android:gravity="center_horizontal"
        android:layout_gravity="center_horizontal">

    </TextView>

</androidx.constraintlayout.widget.ConstraintLayout>

//kemudian buat sebuah code di MainActivity.Java
package com.example.appintent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

class MainActivity extends AppCompatActivity View.OnClickListener{

        Button explicitinent;
        Button implicitintent;

@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCrate(savedInstanceState);
        setContentView(R.layout.activity_main);
        explicitintent=(Button)findViewById(R.id.expicit);
        explicitintent.setOnClickListener(this);
        implicitintent=(Button)findViewById(R.id.implicit);
        implicitintent.setOnclickListener(this);

}
public void onClick (View v){
switch (v.getId()){
    case R.id.explicitintent:
        Intent explicit = new Intent(Intent.MainActivity.this, SecondActivity.class);
        startActivity(explicit);
        break;
        case R.id.implicitintent:
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.masbilly.com"));
        startActivity(implicit);
        break;
        default:
            break;
        }
    }
}
// dan membuat code di secondactivity.java
package com.example.appintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
