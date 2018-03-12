package br.com.dxc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "BATCH_JOB_EXECUTION_LOCK")
public class BatchJobExecutionLock implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long id;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
}
