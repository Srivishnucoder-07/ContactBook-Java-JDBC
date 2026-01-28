package com.contactbook;

import java.sql.*;

public class ContactDAO {

    public void addContact(Contact c) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO contacts(name, phone, email) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getEmail());
            ps.executeUpdate();
            System.out.println("Contact added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewContacts() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contacts");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("phone") + " | " +
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchContact(String name) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM contacts WHERE name LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getString("name") + " | " +
                    rs.getString("phone") + " | " +
                    rs.getString("email")
                );
            }

            if (!found) {
                System.out.println("No contact found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

