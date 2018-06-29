package llp.money.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import llp.money.entity.P2pcompany;

@Dao
public interface P2pcompanyDao {
    @Query("select * from P2pcompany ")
    List<P2pcompany> getAll();

    @Query("SELECT * FROM P2pcompany WHERE p2pcompanyId IN (:p2pcompanyIds)")
    List<P2pcompany> loadAllByIds(long[] p2pcompanyIds);

    @Query("SELECT * FROM P2pcompany WHERE name=:name")
    P2pcompany findByName(String name);

    @Query("SELECT distinct name FROM P2pcompany")
    List<String> getNames();

    @Query("SELECT p2pcompanyId FROM P2pcompany where name=:name")
    Long getIdByName( String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(P2pcompany p2pcompany);

    @Insert
    long[] insertAll(P2pcompany... p2pcompanys);

    @Delete
    void delete(P2pcompany p2pcompany);



}
