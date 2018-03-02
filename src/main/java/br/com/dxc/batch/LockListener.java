package br.com.dxc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.dxc.exception.BusinessValidatorException;

public class LockListener implements JobExecutionListener {

    @Autowired
    private DataSource dataSource;
    private Connection con;
    private static int TIMEOUT = 5;
    private static String LOCK_INSERT = "INSERT INTO BATCH_JOB_EXECUTION_LOCK (JOB_EXECUTION_ID) VALUES (?)";
    private static String LOCK_DELETE = "DELETE FROM BATCH_JOB_EXECUTION_LOCK WHERE JOB_EXECUTION_ID = ?";
    private static String LOCK_SELECT_FOR_UPDATE = "SELECT * FROM BATCH_JOB_EXECUTION_LOCK WHERE JOB_EXECUTION_ID = ? FOR UPDATE";


    public void beforeJob(JobExecution jobExecution) {
        try {
            this.con = this.dataSource.getConnection();
            if (!this.insertLock(jobExecution)) {
                throw new BusinessValidatorException("Não foi possível inserir o lock");
            }
            this.con.commit();
            if (!this.obtainLock(jobExecution)) {
                throw new BusinessValidatorException("Não foi possível obter o lock");
            }
        } catch (Exception e) {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException ex) {
                }
            }
            throw new RuntimeException(e);
        }
    }

    public void afterJob(JobExecution jobExecution) {
        try {
            if (this.con == null || this.con.isClosed()) {
                return;
            }
            if (!this.releaseLock(jobExecution)) {
                throw new BusinessValidatorException("Não foi possível liberar o lock");
            }
            this.con.commit();
        } catch (Exception e) {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException ex) {
                }
            }
            throw new RuntimeException(e);
        } finally {
            if (this.con != null) {
                try {
                    this.con.close();
                } catch (SQLException ex2) {
                }
            }
        }
    }

    private boolean insertLock(JobExecution jobExecution) throws SQLException {
        try (final PreparedStatement ps = this.con.prepareStatement(LockListener.LOCK_INSERT)) {
            ps.setLong(1, jobExecution.getId());
            ps.setQueryTimeout(LockListener.TIMEOUT);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    private boolean obtainLock(JobExecution jobExecution) throws SQLException {
        try (PreparedStatement ps = this.con.prepareStatement(LockListener.LOCK_SELECT_FOR_UPDATE)) {
            ps.setLong(1, jobExecution.getId());
            ps.setQueryTimeout(LockListener.TIMEOUT);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            return false;
        }
    }

    private boolean releaseLock(JobExecution jobExecution) throws SQLException {
        try (PreparedStatement ps = this.con.prepareStatement(LockListener.LOCK_DELETE)) {
            ps.setLong(1, jobExecution.getId());
            ps.setQueryTimeout(LockListener.TIMEOUT);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }


}
