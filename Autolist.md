/*Cara membuat Autolist yang pertama membuka dulu laman xml nya, kemudian memasukkan kode sebagai berikut : */
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
    android:layout_height="match_parent" android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin" tools:context=".MainActivity">

    <AutoCompleteTextView
        android:id="@+id/ac1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentRight="true"
        android:layout_marginTop="23dp"
        android:ems="10"
        android:hint="Isikan Nama Kota  di Indonesia" >

        <requestFocus />
    </AutoCompleteTextView>


</RelativeLayout>
/*Kemudian pergi ke mainActivity.Java dan memasukkan link sebagai berikut : */

package com.example.widget;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
    AutoCompleteTextView act;
    ArrayAdapter<String> adapter;
    String[] item = {"Aceh","Jakarta",Pekanbaru","Palembang","Pekalongan","Jember","Banyuwangi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act = (AutoCompleteTextView) findViewById(R.id.ac1);

        //membuat adapter untuk menampilkan list item
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, item);

        //menerapkan adapter pada objek act
        act.setAdapter(adapter);
    }
}
