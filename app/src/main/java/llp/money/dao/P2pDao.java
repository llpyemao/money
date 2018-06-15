package llp.money.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import llp.money.entity.P2p;

@Dao
public interface P2pDao {
    @Query("SELECT COUNT(*) FROM P2p" )
    int count();

    @Query("select * from P2p")
    List<P2p> getAll();


    @Query("SELECT * FROM P2p WHERE p2pId IN (:p2pIds)")
    List<P2p> getByIds(long[] p2pIds);

    @Query("SELECT * FROM P2p WHERE p2pId=:p2pId")
    P2p getById(long p2pId);



    /**
     * Inserts a p2p into the table.     *
     * @param p2p A new p2p.
     * @return The row ID of the newly inserted p2p.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(P2p p2p);

    /**
     * Inserts multiple p2ps into the database     *
     * @param p2ps An array of new p2ps.
     * @return The row IDs of the newly inserted p2ps.
     */
    @Insert
    long[]  insertAll(P2p[] p2ps);

    @Delete
    int  delete(P2p p2p);

    /**
     * Update the p2p. The p2p is identified by the row ID.
     * @param p2p The p2p to update.
     * @return A number of p2p updated. This should always be {@code 1}.
     */
    @Update
    int update(P2p p2p);
}
