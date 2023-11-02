package com.usco.edu.service;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.usco.edu.dto.FotoAntigua;

public interface IFotoCarnetService {

	String subirFoto(MultipartFile file, String perCodigo, int uaa, String user, HttpServletRequest request);

	ByteArrayInputStream mirarFoto(String codigo, String user, HttpServletResponse response);
	
	FotoAntigua mirarFotoAntigua(String codigo, String user);

}
