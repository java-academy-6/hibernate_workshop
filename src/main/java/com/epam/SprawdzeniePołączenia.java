package com.epam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SprawdzeniePołączenia {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName ("org.h2.Driver");
        Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
        Statement st = conn.createStatement();
        st.executeUpdate("CREATE table nowa_tabela");
        conn.close();

    }
}

