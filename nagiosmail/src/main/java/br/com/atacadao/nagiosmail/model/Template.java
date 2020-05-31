package br.com.atacadao.nagiosmail.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Template {

	private Path path;
	private List<String> macros = new ArrayList<String>();
	private List<String> images = new ArrayList<String>();	
	private Charset charset = StandardCharsets.UTF_8;

	public Template(String fileName, List<String> macros, List<String> images) {
		this.macros = macros;
		this.images = images;
		this.path = Paths.get("/usr/local/nagiosql/nagiosmail/templates/" + fileName);

	}

	public String getConteudo() throws IOException {

		String texto = new String(Files.readAllBytes(path), charset);

		for (String valor : macros) {

			String[] var = valor.split(":");
			texto = texto.replace(var[0], var[1]);

		}

		return texto;

	}

	public List<String> getImages() {
		return images;
	}


}
