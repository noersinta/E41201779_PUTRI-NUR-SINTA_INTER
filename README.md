# E41201779_PUTRI-NUR-SINTA_INTER

* Membuat list view dengan gambar. Pertama dengan membuat project baru kemudian
Buka xml nya. Kemudian tambahkan list view dengan gambar di bawah ini.
Tambahan menggunakan image dengan imageView *

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">


    <ImageView
        android:id="@+id/icon"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_marginBottom="5dp"
        android:layout_marginLeft="5dp"
        android:layout_marginRight="5dp"
        android:layout_marginTop="5dp"
        android:src="@mipmap/ic_launcher" />
    <TextView
        android:id="@+id/Itemname"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:paddingTop="5dp"/>

</LinearLayout>


/*Kemudian pada Java masukkan seperti berikut : */


package com.example.widget;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;


public class MainActivity extends ListActivity {
    String[] itemname ={
            "Sinta",
            "Miyuu",
            "Reiz",
            "Izumi",
            "Relly",
            "Vion",
            "Celvi",
            "Naez"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setListAdapter(new ArrayAdapter<String>(
                this, R.layout.mylist,
                R.id.Itemname,itemname));

    }

}
