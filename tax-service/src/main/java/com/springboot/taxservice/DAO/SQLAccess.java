package com.springboot.taxservice.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springboot.taxservice.model.Trader;

/**
 * This class is used as data access object. It contains methods for fetching data from DB.
 * @author Matej
 * 
 */
public class SQLAccess {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    
    /**
	 * Connects to DB, executes query via PreparedStatement that queries for TAX_RATE, TAX_AMOUNT and TAX_TYPE columns in
	 * DB based on provided traderId. Returns Trader object
	 * @param  traderId id of a trader whose data is needed
	 * @return 			object Trader with data
	 */
    public Trader getTraderInfoFromDB(int traderId) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/tax_data?user=root&password=root");
            
            preparedStatement = connect.prepareStatement("SELECT TAX_RATE, TAX_AMOUNT, TAX_TYPE_ID FROM TRADER WHERE ID = ?");
            preparedStatement.setInt(1, traderId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            
            return new Trader(resultSet.getBigDecimal("TAX_RATE"), resultSet.getBigDecimal("TAX_AMOUNT"), resultSet.getInt("TAX_TYPE_ID"));
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Closes resultSet, preparedStatement and connect class variables.
     */
    private void close() throws Exception{
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            
            if (preparedStatement != null) {
            	preparedStatement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        	throw e;
        }
    }

}