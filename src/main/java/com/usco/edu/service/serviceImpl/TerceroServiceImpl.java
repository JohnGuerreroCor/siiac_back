package com.usco.edu.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ITerceroDao;
import com.usco.edu.entities.Tercero;
import com.usco.edu.service.ITerceroService;

@Service
public class TerceroServiceImpl implements ITerceroService {
	
	@Autowired
	private ITerceroDao terceroDao;

	@Override
	public List<Tercero> obtenerTerceroId(String id) {
		
		return terceroDao.obtenerTerceroId(id);
		
	}

	@Override
	public int registrar(Tercero tercero) {
		
		return terceroDao.registrar(tercero);
		
	}

	@Override
	public int actualizar(Tercero tercero) {
		
		return terceroDao.actualizar(tercero);
		
	}

}
