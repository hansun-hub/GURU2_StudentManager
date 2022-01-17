package com.example.studentmanagement

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class PersonnelList : AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_list)

        dbManager = DBManager(this, "personnel", null,1)
        sqlitedb = dbManager.readableDatabase

        layout = findViewById(R.id.personnel)
        var cursor: Cursor
        cursor = sqlitedb.rawQuery("SELECT * FROM personnel",null)

        var num: Int = 0
        while(cursor.moveToNext()){
            var str_name = cursor.getString(cursor.getColumnIndex("name")).toString()
            var str_gender = cursor.getString(cursor.getColumnIndex("gender")).toString()
            var str_tel = cursor.getString(cursor.getColumnIndex("tel")).toString()
            var age = cursor.getString(cursor.getColumnIndex("age")).toString()

            var layout_item: LinearLayout = LinearLayout(this)
            layout_item.id = num
            num++
        }
    }
}