package br.com.dxc.domain;

import org.joda.time.*;

import com.fasterxml.jackson.annotation.*;

import org.hibernate.annotations.*;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "BATCH_JOB_EXECUTION")
public class BatchJobExecution implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long id;
    private Long version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_INSTANCE_ID")
    private BatchJobInstance jobInstance;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime startTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime endTime;
    private String status;
    private String exitCode;
    private String exitMessage;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime lastUpdated;
    private String jobConfigurationLocation;
    @JsonIgnoreProperties({ "jobExecution" })
    @BatchSize(size = 500)
    @OneToMany(mappedBy = "jobExecution", fetch = FetchType.LAZY)
    @OrderBy("id")
    private List<BatchStepExecution> stepExecutions;
    @ElementCollection(fetch = FetchType.LAZY)
    @BatchSize(size = 500)
    @CollectionTable(name = "BATCH_JOB_EXECUTION_PARAMS", joinColumns = { @JoinColumn(name = "JOB_EXECUTION_ID") })
    @MapKeyColumn(name = "KEY_NAME")
    private Map<String, BatchJobExecutionParams> params;
    
    public Long getId() {
        return this.id;
    }
    
    public Long getVersion() {
        return this.version;
    }
    
    public BatchJobInstance getJobInstance() {
        return this.jobInstance;
    }
    
    public LocalDateTime getCreateTime() {
        return this.createTime;
    }
    
    public LocalDateTime getStartTime() {
        return this.startTime;
    }
    
    public LocalDateTime getEndTime() {
        return this.endTime;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getExitCode() {
        return this.exitCode;
    }
    
    public String getExitMessage() {
        return this.exitMessage;
    }
    
    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }
    
    public String getJobConfigurationLocation() {
        return this.jobConfigurationLocation;
    }
    
    public List<BatchStepExecution> getStepExecutions() {
        return (List<BatchStepExecution>)this.stepExecutions;
    }
    
    public Map<String, BatchJobExecutionParams> getParams() {
        return (Map<String, BatchJobExecutionParams>)this.params;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public void setVersion(final Long version) {
        this.version = version;
    }
    
    public void setJobInstance(final BatchJobInstance jobInstance) {
        this.jobInstance = jobInstance;
    }
    
    public void setCreateTime(final LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public void setStartTime(final LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(final LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setExitCode(final String exitCode) {
        this.exitCode = exitCode;
    }
    
    public void setExitMessage(final String exitMessage) {
        this.exitMessage = exitMessage;
    }
    
    public void setLastUpdated(final LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    public void setJobConfigurationLocation(final String jobConfigurationLocation) {
        this.jobConfigurationLocation = jobConfigurationLocation;
    }
    
    public void setStepExecutions(final List<BatchStepExecution> stepExecutions) {
        this.stepExecutions = stepExecutions;
    }
    
    public void setParams(final Map<String, BatchJobExecutionParams> params) {
        this.params = params;
    }
}
