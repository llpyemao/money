package llp.money.entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity
public class P2pcompany {
    @PrimaryKey(autoGenerate = true)
    private Long p2pcompanyId;
    private String name;
    private String url;
    private String bank;

    public Long getP2pcompanyId() {
        return p2pcompanyId;
    }

    public void setP2pcompanyId(Long p2pcompanyId) {
        this.p2pcompanyId = p2pcompanyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public P2pcompany() {

    }
}
