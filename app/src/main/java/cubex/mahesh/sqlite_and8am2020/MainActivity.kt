package cubex.mahesh.sqlite_and8am2020

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val _ID = "_id"
    val EMP_ID = "ID"
    val EMP_NAME = "NAME"
    val EMP_DESIG = "DESIG"
    val EMP_DEPT = "DEPT"
    val TABLE_NAME = "employee"

    var dBase : SQLiteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dBase = openOrCreateDatabase("nit8am20",
           Context.MODE_PRIVATE, null )
            var cquery =
                "create table if not exists $TABLE_NAME($_ID integer primary key autoincrement, $EMP_ID number,$EMP_NAME varchar(50),$EMP_DESIG varchar(50),$EMP_DEPT varchar(50))"
            dBase?.execSQL(cquery)

    }

    fun insert(v:View){
        var cvalues = ContentValues();
        cvalues.put(EMP_ID,et1.text.toString().toInt());
        cvalues.put(EMP_NAME, et2.text.toString());
        cvalues.put(EMP_DESIG,et3.text.toString());
        cvalues.put(EMP_DEPT,et4.text.toString());

       val status = dBase?.insert(TABLE_NAME,null,
                cvalues)
        if(status != -1.toLong()){
            Toast.makeText(this@MainActivity,
                "Row Insertion success", Toast.LENGTH_LONG).show()
            et1.setText("") ;  et2.setText("");  et3.setText("");  et4.setText("");
        }else{
            Toast.makeText(this@MainActivity,
                "Row Insertion Failed...", Toast.LENGTH_LONG).show()
        }
    }
    fun read(v:View){

    }
    fun update(v:View){

    }
    fun delete(v:View){

    }
}
