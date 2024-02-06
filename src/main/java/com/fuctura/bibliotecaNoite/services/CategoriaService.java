package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.dtos.CategoriaDTO;
import com.fuctura.bibliotecaNoite.exceptions.DataIntegrityViolationException;
import com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException;
import com.fuctura.bibliotecaNoite.exceptions.ObjectNotFoundException;
import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.repositories.CategoriaRopository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRopository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Long id) {
        //Quando for fazer uma busca de um objeto, usamos o Optional
        Optional<Categoria> cat = categoriaRepository.findById(id);

        //Outra forma de usar, com o Lambda:
        //return cat.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));

        //se o ID da busca existir, retorne a requisição.
        if(cat.isPresent()) {
            return cat.get();
        }
        //se não, retorne esse tratamento de erro.
        throw new ObjectNotFoundException("Categoria não encontrada abestado!");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    //Aqui nessa função de Categoria save(passamos como parâmetro: a CategoriaDTO
    public Categoria save(CategoriaDTO categoriaDTO) {
        //O método criado para consultar por nome é passado aqui, antes de salvar.
        findByNome(categoriaDTO);

        categoriaDTO.setId(null);
        return categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
        //Aqui ela faz um retorno do Repository(Banco) e salva, com parâmetro do mapeamento, nas duas classes.
    }

    public Categoria upDate(CategoriaDTO categoriaDTO) {
        findById(categoriaDTO.getId());
        findByNome(categoriaDTO);
        return categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
    }

    public void delete(Long id) {
        findById(id);
        //Instancio um Optional de Categoria(principal) e adiocio a variável: cat
        Optional<Categoria> cat = categoriaRepository.findById(id);

        //Se Categoria, pegando livros com o .getLivros() não possuir livros, deleta. se não, lança mensagem de erro.
        if(!cat.get().getLivros().isEmpty()) {
            throw new DataIntegrityViolationException("Essa Categoria possui Livros, não pode ser deletada.");
        }
        categoriaRepository.deleteById(id);
    }

    //Método criado para fazer uma consulta por nome passando: CategoriaDTO
    private void findByNome(CategoriaDTO categoriaDTO) {
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDTO.getNome());

        //Se a categoria estiver presente no Banco e o nome da CategoriaDTO for o mesmo da classe Categoria, lança a mensagem de erro.
        if(cat.isPresent() && cat.get().getNome().equals(categoriaDTO.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com esse nome: " + categoriaDTO.getNome());
        }
    }
}
