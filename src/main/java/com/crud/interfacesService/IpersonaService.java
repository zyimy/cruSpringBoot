package com.crud.interfacesService;

import java.util.List;
import java.util.Optional;

import com.crud.modelo.Persona;

public interface IpersonaService {

	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona persona);
	public void delete(int id);
}
