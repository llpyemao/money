package llp.money.dao;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import llp.money.entity.P2pVE;


@Dao
public interface P2pVEDao {
    @Query("SELECT P2pcompany.p2pcompanyId AS p2pcompanyId, P2pcompany.name AS companyName ,"
            + " P2pcompany.url AS url, P2pcompany.bank AS bank ,"
            + " P2p.p2pId AS p2pId, P2p.type AS type ,"
            + " P2p.principal AS principal, P2p.rate AS rate ,"
            + " P2p.rateActual AS rateActual, P2p.interest AS interest ,"
            + " P2p.dateActual AS dateActual, P2p.isNormal AS isNormal ,"
            + " P2p.dateFrom AS dateFrom, P2p.dateEnd AS dateEnd "
            + " FROM P2p, P2pcompany "
            + " WHERE P2p.p2pcompanyId = P2pcompany.p2pcompanyId ORDER BY P2p.p2pcompanyId DESC")
    public List<P2pVE> loadAll();

    @Query("SELECT P2pcompany.p2pcompanyId AS p2pcompanyId, P2pcompany.name AS companyName ,"
            + " P2pcompany.url AS url, P2pcompany.bank AS bank ,"
            + " P2p.p2pId AS p2pId, P2p.type AS type ,"
            + " P2p.principal AS principal, P2p.rate AS rate ,"
            + " P2p.rateActual AS rateActual, P2p.interest AS interest ,"
            + " P2p.dateActual AS dateActual, P2p.isNormal AS isNormal ,"
            + " P2p.dateFrom AS dateFrom, P2p.dateEnd AS dateEnd "
            + " FROM P2p, P2pcompany "
            + " WHERE P2p.p2pcompanyId = P2pcompany.p2pcompanyId ORDER BY P2p.p2pcompanyId DESC")
    public abstract DataSource.Factory<Integer, P2pVE> loadAllForPaging();


}
