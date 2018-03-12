package br.com.dxc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "BATCH_STEP_EXECUTION")
public class BatchStepExecution implements Serializable {
    @Id
    @Column(name = "STEP_EXECUTION_ID")
    private Long id;
    private Long version;
    private String stepName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID")
    private BatchJobExecution jobExecution;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime startTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime endTime;
    private String status;
    private Long commitCount;
    private Long readCount;
    private Long filterCount;
    private Long writeCount;
    private Long readSkipCount;
    private Long writeSkipCount;
    private Long processSkipCount;
    private Long rollbackCount;
    private String exitCode;
    private String exitMessage;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime lastUpdated;
    
    public Long getId() {
        return this.id;
    }
    
    public Long getVersion() {
        return this.version;
    }
    
    public String getStepName() {
        return this.stepName;
    }
    
    public BatchJobExecution getJobExecution() {
        return this.jobExecution;
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
    
    public Long getCommitCount() {
        return this.commitCount;
    }
    
    public Long getReadCount() {
        return this.readCount;
    }
    
    public Long getFilterCount() {
        return this.filterCount;
    }
    
    public Long getWriteCount() {
        return this.writeCount;
    }
    
    public Long getReadSkipCount() {
        return this.readSkipCount;
    }
    
    public Long getWriteSkipCount() {
        return this.writeSkipCount;
    }
    
    public Long getProcessSkipCount() {
        return this.processSkipCount;
    }
    
    public Long getRollbackCount() {
        return this.rollbackCount;
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
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public void setVersion(final Long version) {
        this.version = version;
    }
    
    public void setStepName(final String stepName) {
        this.stepName = stepName;
    }
    
    public void setJobExecution(final BatchJobExecution jobExecution) {
        this.jobExecution = jobExecution;
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
    
    public void setCommitCount(final Long commitCount) {
        this.commitCount = commitCount;
    }
    
    public void setReadCount(final Long readCount) {
        this.readCount = readCount;
    }
    
    public void setFilterCount(final Long filterCount) {
        this.filterCount = filterCount;
    }
    
    public void setWriteCount(final Long writeCount) {
        this.writeCount = writeCount;
    }
    
    public void setReadSkipCount(final Long readSkipCount) {
        this.readSkipCount = readSkipCount;
    }
    
    public void setWriteSkipCount(final Long writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }
    
    public void setProcessSkipCount(final Long processSkipCount) {
        this.processSkipCount = processSkipCount;
    }
    
    public void setRollbackCount(final Long rollbackCount) {
        this.rollbackCount = rollbackCount;
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
}
