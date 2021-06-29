package com.felipersumiya.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipersumiya.domain.Usuario;
import com.felipersumiya.dto.UsuarioDto;
import com.felipersumiya.repositories.ComicsRepository;
import com.felipersumiya.repositories.UsuarioRepository;



@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ComicsRepository comicsRepository;

	
	public List<Usuario> findAll() {

		return usuarioRepository.findAll();

	}
	
	public Usuario findById(Long id) {
		
		Optional<Usuario> usuario =  usuarioRepository.findById(id);	
		return usuario.get();
		
	}

	public Usuario inserir(Usuario usuario) {

		return usuarioRepository.save(usuario);

	}
	
	public Usuario converteDto (UsuarioDto usuarioDto) {
		
		 return new Usuario(usuarioDto.getId(), usuarioDto.getNome(), usuarioDto.getCpf(), usuarioDto.getEmail(), usuarioDto.getDataNascimento());
		
	}
	
	/*public void insereListaComicUsuario(Usuario usuario, List<Comics> listComics) {
		
		Comics comics = new Comics();
		usuario.getComics().addAll(listComics);
		usuarioRepository.save(usuario);
		
		//salvar todos os itens da lista com o usuario;
		comics.setUsuario(usuario);
		comicsRepository.save(comics);
		
		
	}*/
	
	/*public void inserComicUsuario(Long idUsuario, Long idComic) {
		
		Comics comic = new Comics();
		Usuario usuario = new Usuario();
		usuario = usuarioRepository.getById(idUsuario);
		comic = comicsRepository.getById(idComic);
		//salvar comic em usuario.
		usuario.getComics().add(comic);
		usuarioRepository.save(usuario);
		
		//necessario fazer a comunicação com o COmicService.
		comic.setUsuario(usuario);
		comicsRepository.save(comic);
	
	
		// recupera o comic do banco
		//compara para ver se é o mesmo e se possui algum id de usuario
		//Se possuir. inserir(updata) usuario em Comic
		//Inserir Comic em usuario
		
	}*/
	
	
	

}
