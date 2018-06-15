package llp.money.entity;

import java.util.Date;

public class P2pVE {
    private Long p2pcompanyId;
    private String companyName;
    private String url;
    private String bank;

    private Long p2pId;
    private String type;//产品名称
    private Double principal;//本金
    private Double rate;//预期利率
    private Double rateActual;//实际利率
    private Double interest;//实际利息
    private Date dateFrom;//起始日期
    private Date dateEnd;//预期结束日期
    private Date dateActual;//实际结束日期
    private Integer isNormal;//状态，比如是否正常

    public Long getP2pcompanyId() {
        return p2pcompanyId;
    }

    public void setP2pcompanyId(Long p2pcompanyId) {
        this.p2pcompanyId = p2pcompanyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public Long getP2pId() {
        return p2pId;
    }

    public void setP2pId(Long p2pId) {
        this.p2pId = p2pId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRateActual() {
        return rateActual;
    }

    public void setRateActual(Double rateActual) {
        this.rateActual = rateActual;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateActual() {
        return dateActual;
    }

    public void setDateActual(Date dateActual) {
        this.dateActual = dateActual;
    }

    public Integer getIsNormal() {
        return isNormal;
    }

    public void setIsNormal(Integer isNormal) {
        this.isNormal = isNormal;
    }
}
