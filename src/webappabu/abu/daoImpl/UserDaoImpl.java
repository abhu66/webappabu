/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappabu.abu.daoImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import webappabu.abu.dao.UserDao;
import webappabu.abu.model.User;
import webappabu.abu.utils.KoneksiDB;

/**
 *
 * @author khoerulAbu
 */
public class UserDaoImpl implements UserDao{

    private final Connection connection;

    public UserDaoImpl() throws IOException, SQLException {
        connection = KoneksiDB.getConnection();
    }

    @Override
    public void addUser(User user) {
      try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO [dbo].[User] values (?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, user.getNama());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getJob());
            preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<User> getAllUsers() {
      List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [dbo].[User]");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setJob(rs.getString("job"));
                user.setTanggal(rs.getDate("tanggal"));
                users.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }
}
