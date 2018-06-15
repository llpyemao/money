package llp.money.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import llp.money.dao.P2pDao;
import llp.money.dao.P2pVEDao;
import llp.money.dao.P2pcompanyDao;
import llp.money.entity.P2p;
import llp.money.entity.P2pcompany;

@Database(entities = {P2pcompany.class,P2p.class}, version = 2,  exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    @SuppressWarnings("WeakerAccess")
    public abstract P2pcompanyDao p2pcompanyDao();

    @SuppressWarnings("WeakerAccess")
    public abstract P2pDao p2pDao();

    @SuppressWarnings("WeakerAccess")
    public abstract P2pVEDao p2pVEDao();
    /** The only instance */
    private static AppDatabase sInstance;

    /**
     * Gets the singleton instance of SampleDatabase.
     *
     * @param context The context.
     * @return The singleton instance of SampleDatabase.
     */
    public static synchronized AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room
                    .databaseBuilder(context.getApplicationContext(), AppDatabase.class, "money")
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return sInstance;
    }
}
