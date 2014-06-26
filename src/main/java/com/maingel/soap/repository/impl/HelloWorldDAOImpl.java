package com.maingel.soap.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.maingel.soap.domain.User;
import com.maingel.soap.repository.IHelloWorldDAO;

@Repository
public class HelloWorldDAOImpl implements IHelloWorldDAO {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldDAOImpl.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public String sayHi(String text) {
		logger.info("Execute sayHi!");
		
		return "Hello " + text;
	}

	@Override
	public User findUserById(long id) {
		logger.info("Execute findUserById!");
		
		String findUserSql = " SELECT id, name, gender, age FROM soap_cxf_test_user WHERE id=? ";
		List<User> users = this.jdbcTemplate.query(findUserSql, new Object[]{id}, new ParameterizedRowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getInt("gender"));
				user.setAge(rs.getInt("age"));
				return user;
			}
			
		});
		return users.get(0);
	}
	
	@Override
	public List<User> findAllUser() {
		logger.info("Execute findAllUser!");
		
		String findUserSql = " SELECT id, name, gender, age FROM soap_cxf_test_user ";
		return this.jdbcTemplate.query(findUserSql, new ParameterizedRowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getInt("gender"));
				user.setAge(rs.getInt("age"));
				return user;
			}
			
		});
	}

	@Override
	public String addUser(User user) {
		logger.info("Execute addUser!");
		
		String addUserSql = " INSERT INTO soap_cxf_test_user (name, gender, age) VALUES (?, ?, ?) ";
		this.jdbcTemplate.update(addUserSql, new Object[]{user.getName(), user.getGender(), user.getAge()});
		return "SUCCESS";
	}

	@Override
	public String addAllUser(final List<User> users) {
		logger.info("Execute addAllUser!");
		
		String addUserSql = " INSERT INTO soap_cxf_test_user (name, gender, age) VALUES (?, ?, ?) ";
		this.jdbcTemplate.batchUpdate(addUserSql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, users.get(i).getName());
				ps.setInt(2, users.get(i).getGender());
				ps.setInt(3, users.get(i).getAge());
			}
			
			@Override
			public int getBatchSize() {
				return users.size();
			}
		});
		return "SUCCESS";
	}

}
