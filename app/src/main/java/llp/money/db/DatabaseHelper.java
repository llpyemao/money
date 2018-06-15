package llp.money.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//根据sql文件生成数据库//根据sql文件生成数据库//根据sql文件生成数据库
public class DatabaseHelper extends SQLiteOpenHelper {
    private Context mContext;
    public DatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //根据sql文件生成数据库
        executeAssetsSQL(db, "money.sql");
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).
                show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 数据库不升级
        if (newVersion <= oldVersion) {
            return;
        }
//        Configuration.oldVersion = oldVersion;

        int changeCnt = newVersion - oldVersion;
        for (int i = 0; i < changeCnt; i++) {
            // 依次执行updatei_i+1文件 由1更新到2 [1-2]，2更新到3 [2-3]
            String schemaName = "update" + (oldVersion + i) + "_"
                    + (oldVersion + i + 1) + ".sql";
            executeAssetsSQL(db, schemaName);
        }
    }


    public void executeAssetsSQL(SQLiteDatabase db, String sqlFileName) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    mContext.getAssets().open("schema/"+sqlFileName)
            ));
            Log.i("database","路径:" + sqlFileName);
            String line;
            String buffer = "";
            //开启事务
            db.beginTransaction();
            while ((line = in.readLine()) != null) {
                if(!line.trim().startsWith("--")){//消除注释行
                    buffer += line;
                    if (line.trim().endsWith(";")) {
                        db.execSQL(buffer.replace(";", ""));
                        Log.i("database","路径:" + buffer);
                        buffer = "";
                    }
                }
            }
            //设置事务标志为成功，当结束事务时就会提交事务
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e("db-error", e.toString());
        } finally {
            //事务结束
            db.endTransaction();
            try {
                if (in != null)
                    in.close();
            } catch (Exception e) {
                Log.e("db-error", e.toString());
            }
        }
    }
}
