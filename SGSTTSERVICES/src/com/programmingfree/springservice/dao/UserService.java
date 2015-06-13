package com.programmingfree.springservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.springservice.domain.User;
import com.programmingfree.springservice.utility.DBUtility;


public class UserService {
	
	private Connection connection;

	public UserService() {
		connection = DBUtility.getConnection();
	}
	
	public int getUserCount(){
		int count=0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) as count from tblUser");		
			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	
	}

	public void addUser(User user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into estado_incidencia(idestado_incidencia,descripcion) values (?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, user.getUserid());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from tblUser where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update tblUser set lastname=?,email=?" +
							"where userid=?");
			// Parameters start with 1			
			preparedStatement.setString(1, user.getLastName());
			preparedStatement.setString(2, user.getEmail());			
			preparedStatement.setInt(3, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers(int userId) {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idservicio_detalle from servicio_detalle where idchofer=? and ESTADO=1 limit 15");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();

				user.setFirstName(rs.getString("idservicio_detalle"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	
	
	public List<User> getAllincidencias() {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT descripcion,idtipo_incidencia from tipo_incidencia limit 45");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();

				user.setFirstName(rs.getString("descripcion"));
				user.setLastName(rs.getString("idtipo_incidencia"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from tblUser where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getNombretrasladista(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT nombre , apellido FROM chofer WHERE idchofer=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {

				user.setFirstName(rs.getString("nombre"));
				user.setLastName(rs.getString("apellido"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getHoraFecha(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("select FECHA from servicio_detalle where idservicio_detalle=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("FECHA"));
				
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getHoraFechaSistema(){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT sysdate() as Datetime_sistema");
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("Datetime_sistema"));
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getOrigenDestino(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT descripcion FROM servicio WHERE idservicio=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("descripcion"));
				
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	public User getidDetalleservicio(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idservicio_detalle from servicio_detalle where idservicio_detalle=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idservicio_detalle"));
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getDetalleservicio(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idservicio_detalle from Servicio where idservicio=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idservicio_detalle"));
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getIdDescripcionservicio(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idtipo_servicio from servicio where idservicio=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idtipo_servicio"));
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getDescripcionservicio(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT descripcion from tipo_servicio where idtipo_servicio=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("descripcion"));
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}

	public User getNombrepax(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT PAX from File where idFile=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("Pax"));
		
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	public User getidPax(int userId){
		User user = new User();
		try{	
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idFile from servicio_detalle where idservicio_detalle=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idFile"));
				
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	public User getidservicio(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idservicio from servicio_detalle where idservicio_detalle=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idservicio"));
				
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	public User getidtrasl(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idtrasladista from servicio_detalle where idservicio_detalle=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idtrasladista"));
				
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getidtipoincidencia(String id){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idtipo_incidencia from tipo_incidencia where descripcion=?");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idtipo_incidencia"));
				
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	public User getNombreTrasl(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT nombre,apellido from trasladista where idtrasladista=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("nombre"));
				user.setLastName(rs.getString("apellido"));
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User Insert(int id,String des){
		User user = new User();
		try{
					PreparedStatement preparedStatement = connection
					.prepareStatement("insert into estado_incidencia(idestado_incidencia,descripcion) values (?,?)");
					
					
					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, des);
					 preparedStatement.executeUpdate();
					
					} catch (SQLException e) {
					e.printStackTrace();
					}
		return user;
	}

//FALTA COMPLETAR LOGIN------------------------------------------------------------------------------------------
	
	public User Login(String nombre){
		User user = new User();
		try{
					PreparedStatement preparedStatement = connection
					.prepareStatement("select idchofer from chofer where nombre=?");
					preparedStatement.setString(1,nombre);
					
					ResultSet rs = preparedStatement.executeQuery();
					
					if(rs.next()){
						
						user.setUserid(rs.getInt("idchofer"));		
					}
				} catch(SQLException e){
					e.printStackTrace();
				}
		return user;
	}
	
	public User Login2(String dni){
		User user = new User();
		try{
					PreparedStatement preparedStatement = connection
					.prepareStatement("select idchofer from chofer where dni=?");
					preparedStatement.setString(1,dni);
					ResultSet rs = preparedStatement.executeQuery();
					
					if(rs.next()){
						
						user.setUserid(rs.getInt("idchofer"));		
					}
				} catch(SQLException e){
					e.printStackTrace();
				}
		return user;
	}

//INSERTAR INCIDENCIAS-----------------------------------------------------------------------------------------------
	
	public User Insertincidencia(int idinc,String desc,String idestadoinc,String idtipoinc,String idserv,String fecha,String fecha2){
		User user = new User();
		try{
					PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT into incidencia(idincidencia,descripcion,idestado_incidencia,idtipo_incidencia,idservicio_detalle,FECHA_REGISTRO,FECHA_MODIFICACION) value (?,?,?,?,?,?,?)");		
					preparedStatement.setInt(1, idinc);
					preparedStatement.setString(2, desc);
					preparedStatement.setString(3,idestadoinc);
					preparedStatement.setString(4,idtipoinc);
					preparedStatement.setString(5,idserv);
					preparedStatement.setString(6,fecha);
					preparedStatement.setString(7,fecha2);
					 preparedStatement.executeUpdate();
					
					} catch (SQLException e) {
					e.printStackTrace();
					}
		return user;
	}
	

	
	public User idincidencias(){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("select count(*) from incidencia;");
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setUserid(rs.getInt("count(*)"));
				
				
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User cambiarestadoservicio(String id){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("UPDATE servicio_detalle SET ESTADO=4 WHERE idservicio_detalle=?");
			preparedStatement.setString(1, id);
			 preparedStatement.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getIdCliente(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT idCliente from File where idFile=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("idCliente"));		
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
		
	public User getNombreCliente(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT Nombre from Cliente where idCliente=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("Nombre"));		
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public User getOrigen(String id){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT Origen , destino from servicio where descripcion=?");
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()){
				
				user.setFirstName(rs.getString("origen"));
				user.setLastName(rs.getString("destino"));		
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> getDescripcion() {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT DESCRIPCION FROM SERVICIO limit 15");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();

				user.setFirstName(rs.getString("DESCRIPCION"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
}



