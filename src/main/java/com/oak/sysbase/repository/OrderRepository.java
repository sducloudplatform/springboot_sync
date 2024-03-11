package com.oak.sysbase.repository;

import com.oak.sysbase.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    插入单条数据
    public boolean insertOneOrder(Order order) {
        String sql = "INSERT INTO [order] (orderid, ordernumber, patient_uid,orgid,doctor_uid,stateid,updatetime) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, order.getOrderid());
                preparedStatement.setString(2, order.getOrdernumber());
                preparedStatement.setInt(3,order.getPatient_uid());
                preparedStatement.setInt(4,order.getOrgid());
                preparedStatement.setInt(5,order.getDoctor_uid());
                preparedStatement.setInt(6,order.getStateid());
//                Timestamp timestamp = new Timestamp(order.getUpdatetime().getTime());
//                System.out.println("timestamp:"+timestamp);
                preparedStatement.setTimestamp(7,new Timestamp(order.getUpdatetime().getTime()));
            }
        }) > 0;
    }

//    批量插入多条数据
    public int[] insertOrders(List<Order> orders) {
        String sql = "INSERT INTO [order] (orderid, ordernumber, patient_uid,orgid,doctor_uid,stateid,updatetime) VALUES (?, ?, ?, ?, ?, ?, ?)";

        BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Order order = orders.get(i);
                ps.setInt(1, order.getOrderid());
                ps.setString(2, order.getOrdernumber());
                ps.setInt(3,order.getPatient_uid());
                ps.setInt(4,order.getOrgid());
                ps.setInt(5,order.getDoctor_uid());
                ps.setInt(6,order.getStateid());
                ps.setTimestamp(7,new Timestamp(order.getUpdatetime().getTime()));
            }
            @Override
            public int getBatchSize() {
                return orders.size();
            }
        };
        int ans[]=jdbcTemplate.batchUpdate(sql, setter);
        return ans;
    }
}
