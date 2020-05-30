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
	private List<Parametro> variaveis = new ArrayList<Parametro>();
	private Charset charset = StandardCharsets.UTF_8;

	public Template(String fileName, List<Parametro> vars) {
		this.variaveis = vars;
		this.path = Paths.get("c:/home/templates/" + fileName);

	}

	public String getConteudoAlterado() throws IOException {

		String texto = new String(Files.readAllBytes(path), charset);

		for (Parametro p : variaveis) {

			String[] var = p.getValor().split(":");
			texto = texto.replace(var[0], var[1]);
		}

		return texto;

	}

}
