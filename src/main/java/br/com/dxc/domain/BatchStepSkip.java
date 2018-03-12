package br.com.dxc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "BATCH_STEP_SKIP")
public class BatchStepSkip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableGenerator(name = "batch-step-skip-gen", pkColumnValue = "batch_step_skip", allocationSize = 1000)
	@GeneratedValue(generator = "batch-step-skip-gen", strategy = GenerationType.TABLE)
    @Id
	@Column(name = "STEP_SKIP_ID")
	private Integer id;
	@NotNull
	private Long stepExecutionId;
	private Integer lineNumber;
	private String line;
	private String message;
	@Enumerated(EnumType.STRING)
	private BatchStepSkipTypeEnum type;

	public Integer getId() {
		return this.id;
	}

	public Long getStepExecutionId() {
		return this.stepExecutionId;
	}

	public Integer getLineNumber() {
		return this.lineNumber;
	}

	public String getLine() {
		return this.line;
	}

	public String getMessage() {
		return this.message;
	}

	public BatchStepSkipTypeEnum getType() {
		return this.type;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public void setStepExecutionId(final Long stepExecutionId) {
		this.stepExecutionId = stepExecutionId;
	}

	public void setLineNumber(final Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public void setLine(final String line) {
		this.line = line;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public void setType(final BatchStepSkipTypeEnum type) {
		this.type = type;
	}

	public enum BatchStepSkipTypeEnum {
		READ, PROCESS, WRITE;
	}
}
