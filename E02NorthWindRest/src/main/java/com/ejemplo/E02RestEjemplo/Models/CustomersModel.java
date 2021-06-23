package com.ejemplo.E02RestEjemplo.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ejemplo.E02RestEjemplo.DBFactory.DBFactory;
import com.ejemplo.E02RestEjemplo.Entities.Customer;



public class CustomersModel {
    
    Connection conexion = null;

    public CustomersModel() throws SQLException {
	DataSource ds = DBFactory.getMySQLDataSource();
	conexion = ds.getConnection();
    }

    public Customer read(Integer id) {
	Customer cliente = null;
	Statement sentencia = null;

	String sql = "SELECT `id`, `supplier_ids`, `product_code`, `product_name`, "
			+ "`description`, `standard_cost`, `list_price` , `reorder_level`,"
			+ "`target_level`, `quantity_per_unit`, `discontinued`, `minimum_reorder_quantity`,  "
			+ "`category`, `attachments` " + "FROM products "
			+ "WHERE id = " + id;

	try {
	    sentencia = conexion.createStatement();
	    ResultSet rs = sentencia.executeQuery(sql);
	    while (rs.next()) { // Si hay un cliente que existe
		cliente = new Customer(
			rs.getInt("id"),
			rs.getString("supplier_ids"),
			rs.getString("product_code"),
			rs.getString("product_name"),
			rs.getString("description"),
			rs.getDouble("standard_cost"),
			rs.getDouble("list_price"),
			rs.getInt("reorder_level"),
			rs.getInt("target_level"),
			rs.getString("quantity_per_unit"),
			rs.getBoolean("discontinued"),
			rs.getInt("minimum_reorder_quantity"),
			rs.getString("category"),
			rs.getBlob("attachments"));
			};
	    
	} catch (SQLException e) {
	    System.err.println("Error en read de Clientes: " + e.getMessage());
	    return null;
	}

	return cliente;
    }

    /**
     * 
     * @param cliente
     * @return Devuelve el id del registro recien insertado
     */
    public Integer insert(Customer cliente) throws  SQLException {
	Integer id = null;
	PreparedStatement ps = null;
	String sql = "INSERT INTO products ( "
			+ "`supplier_ids`, `product_code`, `product_name`, "
			+ "`description`, `standard_cost`, `list_price` , `reorder_level`,"
			+ "`target_level`, `quantity_per_unit`, `discontinued`, `minimum_reorder_quantity`, "
			+ "`category`, `attachments`) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	try {
	    ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    ps.setString(1, cliente.getSupplier_ids());
	    ps.setString(2, cliente.getProductCode());
	    ps.setString(3, cliente.getProductName());
	    ps.setString(4, cliente.getDescription());
	    ps.setDouble(5, cliente.getStandardCost());
	    ps.setDouble(6, cliente.getListPrice());
	    ps.setInt(7, cliente.getReorderLevel());
	    ps.setInt(8, cliente.getTargetLevel());
	    ps.setString(9, cliente.getQuantityPerUnit());
		ps.setBoolean(10, cliente.getDiscontinued());
		ps.setInt(11, cliente.getMinimumReorderQuantity());
	    ps.setString(12, cliente.getCategory());
	    ps.setBlob(13, cliente.getAttachments());
	    if (ps.executeUpdate() > 0) {
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
		    id = rs.getInt(1);
		}
	    }

	} catch (SQLException e) {
	    System.err.println("Error al insertar producto: " + e.getMessage());
	    throw e;
	}

	return id;
    }

    public Boolean delete(Integer idcliente) throws SQLException {
	Boolean resultado = false;

	PreparedStatement ps = null;
	String sql = "DELETE FROM products where id = ?";
	try {
	    ps = conexion.prepareStatement(sql);

	    ps.setInt(1, idcliente);

	    resultado = (ps.executeUpdate() > 0);

	} catch (SQLException e) {
	    System.err.println("Error al borrar producto: " + e.getMessage());
	    throw e;
	}

	return resultado;
    }

    public Boolean update(Customer cliente) throws SQLException  {
	Boolean resultado = false;

	PreparedStatement ps = null;
	String sql = "UPDATE products set "
		+ "supplier_ids = ?, "
		+ "product_code = ?, "
		+ "product_name = ?, "
		+ "description = ?, "
		+ "standard_cost = ?, "
		+ "list_price = ?, "
		+ "reorder_level  = ?, "
		+ "target_level = ?, "
		+ "quantity_per_unit = ?, "
		+ "discontinued = ?, "
		+ "minimum_reorder_quantity = ?, "
		+ "category = ?, "
		+ "attachments = ? "
		+ "where id = ?";
	try {
	    ps = conexion.prepareStatement(sql);
	    ps.setString(1, cliente.getSupplier_ids());
	    ps.setString(2, cliente.getProductCode());
	    ps.setString(3, cliente.getProductName());
	    ps.setString(4, cliente.getDescription());
	    ps.setDouble(5, cliente.getStandardCost());
	    ps.setDouble(6, cliente.getListPrice());
	    ps.setInt(7, cliente.getReorderLevel());
	    ps.setInt(8, cliente.getTargetLevel());
	    ps.setString(9, cliente.getQuantityPerUnit());
	    ps.setInt(10, cliente.getMinimumReorderQuantity());
	    ps.setBoolean(11, cliente.getDiscontinued()); 
	    ps.setString(12, cliente.getCategory());
	    ps.setBlob(13, cliente.getAttachments());
	    ps.setInt(14, cliente.getId());

	    resultado = (ps.executeUpdate() > 0);

	} catch (SQLException e) {
	    System.err.println("Error al actualizar producto: " + e.getMessage());
	    throw e;
	}

	return resultado;
    }

    public ArrayList<Customer> lista(String filtro, Integer limite, Integer offset)

    {
	ArrayList<Customer> clientes = new ArrayList<Customer>();
	Statement sentencia = null;

	String sql = "SELECT `id`, "
		+ "supplier_ids , "
		+ "`product_code`, "
		+ "`product_name`, "
		+ "`description`, "
		+ "`standard_cost`, "
		+ "`list_price`, "
		+ "`reorder_level` , "
		+ "`target_level`,"
		+ "`quantity_per_unit`, "
		+ "`discontinued`, "
		+ "`minimum_reorder_quantity`, "
		+ "`category`, "
		+ "`attachments` " 
		+ "FROM products ";

	try {
	    if (filtro != null)
		sql += " WHERE " + filtro;
	    if (limite != null)
		sql += " LIMIT " + limite;
	    if (offset != null)
		sql += " OFFSET " + offset;
	    sentencia = conexion.createStatement();
	    ResultSet rs = sentencia.executeQuery(sql);
	    while (rs.next()) { // Si todavía hay un cliente lo añado al array
		clientes.add(new Customer(
				rs.getInt("id"),
				rs.getString("supplier_ids"),
				rs.getString("product_code"),
				rs.getString("product_name"),
				rs.getString("description"),
				rs.getDouble("standard_cost"),
				rs.getDouble("list_price"),
				rs.getInt("reorder_level"),
				rs.getInt("target_level"),
				rs.getString("quantity_per_unit"),
				rs.getBoolean("discontinued"),
				rs.getInt("minimum_reorder_quantity"),
				rs.getString("category"),
				rs.getBlob("attachments")));
				};
	  
	} catch (SQLException e) {
	    System.err.println("Error en leer los productos: " + e.getMessage());
	    return null;
	}

	return clientes;
    }

}
