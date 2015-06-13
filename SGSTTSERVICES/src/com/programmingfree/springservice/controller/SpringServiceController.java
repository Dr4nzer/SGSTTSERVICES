package com.programmingfree.springservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.programmingfree.springservice.dao.UserService;
import com.programmingfree.springservice.domain.User;


@RestController
@RequestMapping("/service/user/")
public class SpringServiceController {
	
	UserService userService=new UserService();	
	  //NOMBRE TRASLADISTA 	    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getUser(@PathVariable int id) {
		User user=userService.getNombretrasladista(id);
		return user;
	}
	
	  //FECHA Y HORA DEL SERVICIO
	@RequestMapping(value = "/HoraFecha/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getFechaHora(@PathVariable int id) {
		User user=userService.getHoraFecha(id);
		return user;
	}
	
	  //FECHA Y HORA DEL SISTEMA	
	@RequestMapping(value = "/HoraFechaSistema/", method = RequestMethod.GET,headers="Accept=application/json")
	public User getFechaHorasistema() {
		User user=userService.getHoraFechaSistema();
		return user;
	}
	
	  //ORIGEN Y DESTINO DEL SERVICIO
	@RequestMapping(value = "/OrigenDestino/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getOrigenDestino(@PathVariable int id) {
		User user=userService.getOrigenDestino(id);
		return user;
	}
	
	  //ID DETALLE SERVICIO
	@RequestMapping(value = "/idDetalleservicio/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getiddetalleservicio(@PathVariable int id) {
		User user=userService.getidDetalleservicio(id);
		return user;
	}
	
	  //ID TIPO DESCRIPCION SERVICIO
	@RequestMapping(value = "/IdDescripcionservicio/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getIdDescripcionservicio(@PathVariable int id) {
		User user=userService.getIdDescripcionservicio(id);
		return user;
	}
	
	  //DESCRIPCION SERVICIO
	@RequestMapping(value = "/Descripcionservicio/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getDescripcionservicio(@PathVariable int id) {
		User user=userService.getDescripcionservicio(id);
		return user;
	}
	
	  //ID PAX 
	@RequestMapping(value = "/idPax/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getidPax(@PathVariable int id) {
		User user=userService.getidPax(id);
		return user;
	}
	
	
	  //NOMBRE PAX 
	@RequestMapping(value = "/Nombrepax/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getNombrepax(@PathVariable int id) {
		User user=userService.getNombrepax(id);
		return user;
	}
	
	@RequestMapping(value="/lista/{id}",method = RequestMethod.GET,headers="Accept=application/json")
	public List<User> getAllUsers(@PathVariable int id) {
		List<User> users=userService.getAllUsers(id);
		return users;
	}
	
	//LISTA INCIDENCIAS
	@RequestMapping(value="/listaincidencias/",method = RequestMethod.GET,headers="Accept=application/json")
	public List<User> getAllincidencias() {
		List<User> users=userService.getAllincidencias();
		return users;
	}
	
	//ID INCIDENCIAS
	@RequestMapping(value = "/idincidencias/", method = RequestMethod.GET,headers="Accept=application/json")
	public User getidincidencias() {
		User user=userService.idincidencias();
		return user;
	}
	
	  //ID SERVICIO
	@RequestMapping(value = "/idservicio/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getidservicio(@PathVariable int id) {
		User user=userService.getidservicio(id);
		return user;
	}
	
	  //ID CHOFER
	@RequestMapping(value = "/getidloginusuario/{nombre}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getLoginc(@PathVariable String nombre) {
		User user=userService.Login(nombre);
		return user;
	}
	
	  //ID CHOFER
	@RequestMapping(value = "/getidloginpassword/{dni}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getLogin(@PathVariable String dni) {
		User user=userService.Login2(dni);
		return user;
	}
	
	//ID DEL TRASLADISTA
	@RequestMapping(value = "/idtrasl/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getidtrasl(@PathVariable int id) {
		User user=userService.getidtrasl(id);
		return user;
	}
	
	//ID TIPO INCIDENCIA
	@RequestMapping(value = "/idtipoincidencia/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getidtipoincidencia(@PathVariable String id) {
		User user=userService.getidtipoincidencia(id);
		return user;
	}
	
	
	//Nombre Apellido Trasladista
	@RequestMapping(value = "/nombretrasl/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getNombreTrasl(@PathVariable int id) {
		User user=userService.getNombreTrasl(id);
		return user;
	}
	
	
	//Nombre Apellido Trasladista
	@RequestMapping(value = "/getDetalleservicio/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getDetalleservicio(@PathVariable int id) {
		User user=userService.getDetalleservicio(id);
		return user;
	}
	
	//INSERTAR
	@RequestMapping(value = "/insert/{id}/as/{des}", method = RequestMethod.GET,headers="Accept=application/json")
	public User insert(@PathVariable  int id,@PathVariable String des) {
		User user=userService.Insert(id,des);
		return user;
	}
	
	//CAMBIAR ESTADO SERVICIO	
	@RequestMapping(value = "/cambiarestadoservicio/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User cambiarestado(@PathVariable String id) {
		User user=userService.cambiarestadoservicio(id);
		return user;
	}
	
	//INSERTAR INCIDENCIA
	@RequestMapping(value = "/insertinc/{idinc}/zx/{desc}/cv/{idestadoinc}/bn/{idtipoinc}/ml/{idserv}/kj/{fecha}/ej/{fecha2}", method = RequestMethod.GET,headers="Accept=application/json")
	public User insert(@PathVariable int idinc,@PathVariable String desc,@PathVariable String idestadoinc,@PathVariable String idtipoinc,@PathVariable String idserv,@PathVariable String fecha,@PathVariable String fecha2) {
		User user=userService.Insertincidencia(idinc,desc,idestadoinc,idtipoinc,idserv,fecha,fecha2);
		return user;
	}
	
	@RequestMapping(value = "/getIdCliente/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getIdCliente(@PathVariable int id) {
		User user=userService.getIdCliente(id);
		return user;
	}
	
	@RequestMapping(value = "/getNombreCliente/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getNombreCliente(@PathVariable int id) {
		User user=userService.getNombreCliente(id);
		return user;
	}
	
	@RequestMapping(value = "/getOrigendestino/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getOrigendestino(@PathVariable String id) {
		User user=userService.getOrigen(id);
		return user;
	}
	
	@RequestMapping(value="/listadescripcion",method = RequestMethod.GET,headers="Accept=application/json")
	public List<User> getDescripcion() {
		List<User> users=userService.getDescripcion();
		return users;
	}
}

	