package br.com.atacadao.nagiosmail.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.FileSystemResource;

public class Template {

	private String diretorio;
	private List<Macro> macros = new ArrayList<>();
	private Charset charset = StandardCharsets.UTF_8;

	public Template(String diretorio, List<Macro> macros) {
		this.diretorio = diretorio;
		this.macros = macros;
	}

	public String getHtml() throws IOException {

		String texto = new String(Files.readAllBytes(this.getFileTemplate()), charset);

		for (Macro macro : macros) {
			texto = texto.replace(macro.getTipo(), macro.getValor());
		}

		return texto;

	}

	private Path getFileTemplate() {

		FileSystemResource res = new FileSystemResource(
				new File("/usr/local/nagiosql/nagiosmail/templates/" + diretorio + "/html/template.html"));

		return Paths.get(res.getPath());

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

	public List<FileSystemResource> getImages() {

		List<FileSystemResource> resources = new ArrayList<>();

		FileSystemResource res = new FileSystemResource(
				new File("/usr/local/nagiosql/nagiosmail/templates/" + this.diretorio + "/images/"));

		File[] files = res.getFile().listFiles();

		for (File file : files) {
			resources.add(new FileSystemResource(file));
		}

		return resources;

	}

	@Override
	public String toString() {
		return "Template [diretorio=" + diretorio + ", macros=" + macros + ", charset=" + charset + "]";
	}

}
