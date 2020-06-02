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
	private List<String> macros = new ArrayList<String>();
	private List<String> images = new ArrayList<String>();
	private Charset charset = StandardCharsets.UTF_8;

	public Template(String fileName, List<String> macros, List<String> images) {
		this.macros = macros;
		this.images = images;
		this.fileName = fileName;	

	}

	public String getConteudo() throws IOException {		

		FileSystemResource res = new FileSystemResource(
				new File("c:/usr/local/nagiosql/nagiosmail/templates/" + fileName ));

		String texto = new String(Files.readAllBytes(Paths.get(res.getPath())), charset);

		for (String valor : macros) {

			String[] var = valor.split(":");
			
			if(var[0].equals("NOTIFICATIONTYPE")) {				
				texto = texto.replace("NOTIFICATIONCOLOR", getCorParaNotificacao(var[1]));
			}
			
			texto = texto.replace(var[0], var[1]);

		}

		return texto;

	}

	private String getCorParaNotificacao(String tipo) {
		

		for(TipoNotificacao notificacao : TipoNotificacao.values() ) {
			if(tipo.equals(notificacao.name())) {		
				return notificacao.getCor();
			}
		}
		
		return "black";
	}

	public List<String> getImages() {
		return images;
	}

}
