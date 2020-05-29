package br.com.atacadao.nagiosmail.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Template {

	private Path path;
	private Charset charset = StandardCharsets.UTF_8;

	public Template(String fileName) {

		this.path = Paths.get("c:" + File.separator + "home" + File.separator + fileName);

	}

	public void adicionaValores(String[] args) throws IOException {

		String texto = this.getConteudo();

		for (int a = 4; a < args.length; a++) {
			String[] vars = args[a].split(":");
			
			System.out.println("Alterando " + vars[0]);
			System.out.println(" para " + vars[1]);
			
			texto = texto.replace(vars[0], vars[1]);
		}

		Files.write(path, texto.getBytes(charset));

	}

	public String getConteudo() throws IOException {

		return new String(Files.readAllBytes(path), charset);

	}

}
