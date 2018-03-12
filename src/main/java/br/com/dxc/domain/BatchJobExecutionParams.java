package br.com.dxc.domain;

import javax.persistence.*;
import org.joda.time.*;
import org.hibernate.annotations.*;
import java.io.Serializable;
import java.math.*;

@Embeddable
public class BatchJobExecutionParams implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "TYPE_CD")
    private String typeCd;
    @Column(name = "STRING_VAL")
    private String stringVal;
    @Column(name = "DATE_VAL")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime dateVal;
    @Column(name = "LONG_VAL")
    private Long longVal;
    @Column(name = "DOUBLE_VAL")
    private BigDecimal doubleVal;
    @Column(name = "IDENTIFYING")
    private String identifying;
    
    public String getTypeCd() {
        return this.typeCd;
    }
    
    public String getStringVal() {
        return this.stringVal;
    }
    
    public LocalDateTime getDateVal() {
        return this.dateVal;
    }
    
    public Long getLongVal() {
        return this.longVal;
    }
    
    public BigDecimal getDoubleVal() {
        return this.doubleVal;
    }
    
    public String getIdentifying() {
        return this.identifying;
    }
    
    public void setTypeCd(final String typeCd) {
        this.typeCd = typeCd;
    }
    
    public void setStringVal(final String stringVal) {
        this.stringVal = stringVal;
    }
    
    public void setDateVal(final LocalDateTime dateVal) {
        this.dateVal = dateVal;
    }
    
    public void setLongVal(final Long longVal) {
        this.longVal = longVal;
    }
    
    public void setDoubleVal(final BigDecimal doubleVal) {
        this.doubleVal = doubleVal;
    }
    
    public void setIdentifying(final String identifying) {
        this.identifying = identifying;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BatchJobExecutionParams)) {
            return false;
        }
        final BatchJobExecutionParams other = (BatchJobExecutionParams)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$typeCd = this.getTypeCd();
        final Object other$typeCd = other.getTypeCd();
        Label_0065: {
            if (this$typeCd == null) {
                if (other$typeCd == null) {
                    break Label_0065;
                }
            }
            else if (this$typeCd.equals(other$typeCd)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$stringVal = this.getStringVal();
        final Object other$stringVal = other.getStringVal();
        Label_0102: {
            if (this$stringVal == null) {
                if (other$stringVal == null) {
                    break Label_0102;
                }
            }
            else if (this$stringVal.equals(other$stringVal)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$dateVal = this.getDateVal();
        final Object other$dateVal = other.getDateVal();
        Label_0139: {
            if (this$dateVal == null) {
                if (other$dateVal == null) {
                    break Label_0139;
                }
            }
            else if (this$dateVal.equals(other$dateVal)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$longVal = this.getLongVal();
        final Object other$longVal = other.getLongVal();
        Label_0176: {
            if (this$longVal == null) {
                if (other$longVal == null) {
                    break Label_0176;
                }
            }
            else if (this$longVal.equals(other$longVal)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$doubleVal = this.getDoubleVal();
        final Object other$doubleVal = other.getDoubleVal();
        Label_0213: {
            if (this$doubleVal == null) {
                if (other$doubleVal == null) {
                    break Label_0213;
                }
            }
            else if (this$doubleVal.equals(other$doubleVal)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$identifying = this.getIdentifying();
        final Object other$identifying = other.getIdentifying();
        if (this$identifying == null) {
            if (other$identifying == null) {
                return true;
            }
        }
        else if (this$identifying.equals(other$identifying)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof BatchJobExecutionParams;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $typeCd = this.getTypeCd();
        result = result * 59 + (($typeCd == null) ? 0 : $typeCd.hashCode());
        final Object $stringVal = this.getStringVal();
        result = result * 59 + (($stringVal == null) ? 0 : $stringVal.hashCode());
        final Object $dateVal = this.getDateVal();
        result = result * 59 + (($dateVal == null) ? 0 : $dateVal.hashCode());
        final Object $longVal = this.getLongVal();
        result = result * 59 + (($longVal == null) ? 0 : $longVal.hashCode());
        final Object $doubleVal = this.getDoubleVal();
        result = result * 59 + (($doubleVal == null) ? 0 : $doubleVal.hashCode());
        final Object $identifying = this.getIdentifying();
        result = result * 59 + (($identifying == null) ? 0 : $identifying.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "BatchJobExecutionParams(typeCd=" + this.getTypeCd() + ", stringVal=" + this.getStringVal() + ", dateVal=" + this.getDateVal() + ", longVal=" + this.getLongVal() + ", doubleVal=" + this.getDoubleVal() + ", identifying=" + this.getIdentifying() + ")";
    }
}
