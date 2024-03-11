package com.oak.sysbase.repository;

import com.oak.sysbase.model.Employee;
import com.oak.sysbase.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
/******************************************************************
 * <p>
 *
 * </p>
 * @author oak
 * @version 1.0
 * @date 2024/2/18 10:05
 ******************************************************************/
@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees() {
        final String sqlQuery = "SELECT * FROM employees";
        return jdbcTemplate.query(sqlQuery, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setSalary(rs.getBigDecimal("salary"));
            return employee;
        });
    }

    public boolean insertOne(Employee employee) {
        String sql = "INSERT INTO employees (id, first_name, last_name,salary) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,employee.getId());
                preparedStatement.setString(2, employee.getFirstName());
                preparedStatement.setString(3, employee.getLastName());
                preparedStatement.setBigDecimal(4,employee.getSalary());
            }
        }) > 0;
    }
}
