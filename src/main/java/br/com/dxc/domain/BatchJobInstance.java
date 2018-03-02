package br.com.dxc.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DynamicUpdate
@Table(name = "BATCH_JOB_INSTANCE")
public class BatchJobInstance implements Serializable {
    @Id
    @Column(name = "JOB_INSTANCE_ID")
    private Long id;
    private Long version;
    private String jobName;
    private String jobKey;
    @JsonIgnoreProperties({ "jobInstance" })
    @BatchSize(size = 500)
    @OneToMany(mappedBy = "jobInstance", fetch = FetchType.LAZY)
    @OrderBy("id")
    private List<BatchJobExecution> jobExecutions;
    
    public Long getId() {
        return this.id;
    }
    
    public Long getVersion() {
        return this.version;
    }
    
    public String getJobName() {
        return this.jobName;
    }
    
    public String getJobKey() {
        return this.jobKey;
    }
    
    public List<BatchJobExecution> getJobExecutions() {
        return (List<BatchJobExecution>)this.jobExecutions;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public void setVersion(final Long version) {
        this.version = version;
    }
    
    public void setJobName(final String jobName) {
        this.jobName = jobName;
    }
    
    public void setJobKey(final String jobKey) {
        this.jobKey = jobKey;
    }
    
    public void setJobExecutions(final List<BatchJobExecution> jobExecutions) {
        this.jobExecutions = jobExecutions;
    }
}
