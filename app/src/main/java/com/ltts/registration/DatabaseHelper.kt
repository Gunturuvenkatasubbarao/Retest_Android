import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.ltts.registration.User

val DATABASENAME = "UserDetails"
val TABLENAME = "Users_information"
val COL_username = "username"
val COL_password = "password"
val COL_email = "email"
val COL_phonenumber ="phonenumber"
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_username + " VARCHAR(256) PRIMARY KEY ," + COL_password + " VARCHAR(256)," +COL_email + " VARCHAR(256),"+COL_phonenumber+"Integer "
        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
   
    }
    fun insertData(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_username, user.username)
        contentValues.put(COL_password, user.password)
        contentValues.put(COL_email, user.email)
        contentValues.put(COL_phonenumber, user.phonenumber)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

}

class DatabaseHelper {

}


