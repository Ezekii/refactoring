package br.com.dxc.core.quartz;

import static org.quartz.TriggerKey.triggerKey;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.jdbcjobstore.PostgreSQLDelegate;
import org.quartz.spi.ClassLoadHelper;
import org.slf4j.Logger;

public class ColmeiaDelegate extends PostgreSQLDelegate {

	public ColmeiaDelegate(Logger log, String tablePrefix, String schedName, // NOSONAR
			String instanceId, ClassLoadHelper classLoadHelper) {
		super(log, tablePrefix, schedName, instanceId, classLoadHelper);
	}

	/**
	 * <p>
	 * Get the names of all of the triggers that have misfired.
	 * </p>
	 * 
	 * @param conn
	 *            the DB Connection
	 * @return an array of <code>{@link
	 * org.quartz.utils.Key}</code> objects
	 */
	public List<TriggerKey> selectMisfiredTriggers(Connection conn, long ts)
			throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String select = "SELECT * FROM " + TABLE_PREFIX_SUBST
					+ TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = "
					+ SCHED_NAME_SUBST + " AND NOT (" + COL_MISFIRE_INSTRUCTION
					+ " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY
					+ ") AND " + COL_NEXT_FIRE_TIME + " < ? " + "ORDER BY "
					+ COL_PRIORITY + " DESC, " + COL_NEXT_FIRE_TIME + " ASC ";

			ps = conn.prepareStatement(rtp(select));
			ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
			rs = ps.executeQuery();

			List<TriggerKey> list = new LinkedList<TriggerKey>();
			while (rs.next()) {
				String triggerName = rs.getString(COL_TRIGGER_NAME);
				String groupName = rs.getString(COL_TRIGGER_GROUP);
				list.add(triggerKey(triggerName, groupName));
			}
			return list;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
	}

	public List<TriggerKey> selectMisfiredTriggersInState(Connection conn,
			String state, long ts) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String select = "SELECT " + COL_TRIGGER_NAME + ", "
					+ COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST
					+ TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = "
					+ SCHED_NAME_SUBST + " AND NOT (" + COL_MISFIRE_INSTRUCTION
					+ " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY
					+ ") AND " + COL_NEXT_FIRE_TIME + " < ? AND "
					+ COL_TRIGGER_STATE + " = ? " + "ORDER BY " + COL_PRIORITY
					+ " DESC, " + COL_NEXT_FIRE_TIME + " ASC ";

			rs = executeMisfiredTriggersInState(conn, select, state, ts);

			List<TriggerKey> list = new LinkedList<TriggerKey>();
			while (rs.next()) {
				String triggerName = rs.getString(COL_TRIGGER_NAME);
				String groupName = rs.getString(COL_TRIGGER_GROUP);
				list.add(triggerKey(triggerName, groupName));
			}
			return list;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
	}

	private ResultSet executeMisfiredTriggersInState(Connection conn,
			String select, String state1, long ts)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement(rtp(select));
		ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
		ps.setString(2, state1);
		return ps.executeQuery();
	}

	public boolean hasMisfiredTriggersInState(Connection conn, String state1,
			long ts, int count, List<TriggerKey> resultList)
			throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String select = "SELECT " + COL_TRIGGER_NAME + ", "
					+ COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST
					+ TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = "
					+ SCHED_NAME_SUBST + " AND NOT (" + COL_MISFIRE_INSTRUCTION
					+ " = " + Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY
					+ ") AND " + COL_NEXT_FIRE_TIME + " < ? " + "AND "
					+ COL_TRIGGER_STATE + " = ? " + "ORDER BY " + COL_PRIORITY
					+ " DESC, " + COL_NEXT_FIRE_TIME + " ASC ";

			rs = executeMisfiredTriggersInState(conn, select, state1, ts);

			boolean hasReachedLimit = false;
			while (rs.next() && (hasReachedLimit == false)) {
				if (resultList.size() == count) {
					hasReachedLimit = true;
				} else {
					String triggerName = rs.getString(COL_TRIGGER_NAME);
					String groupName = rs.getString(COL_TRIGGER_GROUP);
					resultList.add(triggerKey(triggerName, groupName));
				}
			}

			return hasReachedLimit;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
	}

	public List<TriggerKey> selectMisfiredTriggersInGroupInState(
			Connection conn, String groupName, String state, long ts)
			throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String select = "SELECT " + COL_TRIGGER_NAME + " FROM "
					+ TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
					+ COL_SCHEDULER_NAME + " = " + SCHED_NAME_SUBST
					+ " AND NOT (" + COL_MISFIRE_INSTRUCTION + " = "
					+ Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY
					+ ") AND " + COL_NEXT_FIRE_TIME + " < ? AND "
					+ COL_TRIGGER_GROUP + " = ? AND " + COL_TRIGGER_STATE
					+ " = ? " + "ORDER BY " + COL_PRIORITY + " DESC, "
					+ COL_NEXT_FIRE_TIME + " ASC ";

			ps = conn.prepareStatement(rtp(select));
			ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
			ps.setString(2, groupName);
			ps.setString(3, state);
			rs = ps.executeQuery();

			List<TriggerKey> list = new LinkedList<TriggerKey>();
			while (rs.next()) {
				String triggerName = rs.getString(COL_TRIGGER_NAME);
				list.add(triggerKey(triggerName, groupName));
			}
			return list;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
	}

	@Override
	public List<TriggerKey> selectTriggerToAcquire(Connection conn,
			long noLaterThan, long noEarlierThan, int maxCount)
			throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TriggerKey> nextTriggers = new LinkedList<TriggerKey>();
		try {
			String select = "SELECT " + COL_TRIGGER_NAME + ", "
					+ COL_TRIGGER_GROUP + ", " + COL_NEXT_FIRE_TIME + ", "
					+ COL_PRIORITY + " FROM " + TABLE_PREFIX_SUBST
					+ TABLE_TRIGGERS + " WHERE " + COL_SCHEDULER_NAME + " = "
					+ SCHED_NAME_SUBST + " AND " + COL_TRIGGER_STATE
					+ " = ? AND " + COL_NEXT_FIRE_TIME + " <= ? " + "AND ("
					+ COL_MISFIRE_INSTRUCTION + " = -1 OR ("
					+ COL_MISFIRE_INSTRUCTION + " != -1 AND "
					+ COL_NEXT_FIRE_TIME + " >= ?)) " + "ORDER BY "
					+ COL_PRIORITY + " DESC, " + COL_NEXT_FIRE_TIME + " ASC ";

			ps = conn.prepareStatement(rtp(select));

			// Set max rows to retrieve
			int max;
			if (maxCount < 1) {
				max = 1; // we want at least one trigger back.
			} else {
				max = maxCount;
			}
			ps.setMaxRows(max);

			// Try to give jdbc driver a hint to hopefully not pull over more
			// than the few rows we actually need.
			// Note: in some jdbc drivers, such as MySQL, you must set maxRows
			// before fetchSize, or you get exception!
			ps.setFetchSize(max);

			ps.setString(1, STATE_WAITING);
			ps.setBigDecimal(2, new BigDecimal(String.valueOf(noLaterThan)));
			ps.setBigDecimal(3, new BigDecimal(String.valueOf(noEarlierThan)));
			rs = ps.executeQuery();

			while (rs.next() && nextTriggers.size() <= maxCount) {
				nextTriggers.add(triggerKey(rs.getString(COL_TRIGGER_NAME),
						rs.getString(COL_TRIGGER_GROUP)));
			}

			return nextTriggers;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
	}

}