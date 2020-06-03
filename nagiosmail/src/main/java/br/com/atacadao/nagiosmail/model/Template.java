package br.com.atacadao.nagiosmail.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.FileSystemResource;

public class Template {

	private String fileName;
	private List<Macro> macros = new ArrayList<>();	
	private Charset charset = StandardCharsets.UTF_8;

	public Template(String fileName, List<Macro> macros) {		
		this.fileName = fileName;	
		this.macros = macros;
	}

	public String getHtml() throws IOException {		

		FileSystemResource res = new FileSystemResource(
				new File("/usr/local/nagiosql/nagiosmail/templates/" + fileName ));

		String texto = new String(Files.readAllBytes(Paths.get(res.getPath())), charset);

		for (Macro macro : macros) {			
			texto = texto.replace(macro.getTipo(), macro.getValor());
		}

		return texto;

	}

	/*
	 * private String getCorParaNotificacao(String tipo) {
	 * 
	 * 
	 * for(TipoNotificacao notificacao : TipoNotificacao.values() ) {
	 * if(tipo.equals(notificacao.name())) { return notificacao.getCor(); } }
	 * 
	 * return "black"; }
	 */

	public String[] getImages() {
		
		FileSystemResource res = new FileSystemResource(
				new File("c:/usr/local/nagiosql/nagiosmail/images/"));
		
		return res.getFile().list();
		
		
	}

}
