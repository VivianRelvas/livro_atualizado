package application.controllers; //pacote de fazer a intermediação entre as camadas View (visualização -Front-end) e Model (modelo - Back-end)
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import application.repositories.LivroRepository;
import application.models.Livro;
import org.springframework.ui.Model;

@Controller  //essa anotação faz referência a proxima linha Java
@RequestMapping("/livro") 
public class LivroController {
    @Autowired
    private LivroRepository livrosRepo;
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", livrosRepo.findAll());
        return "list.jsp"; 

    }

  public String listar(){
    return "livro/list.jsp";
  }

  @RequestMapping("/insert")
  public String formInsert(){
    return "insert.jsp";
  }

@RequestMapping(value="/insert", method=RequestMethod.POST)  //Antes de usar o método é preciso importar
  public String saveInsert(@RequestParam("titulo")String titulo){
    
    Livro livro= new Livro(); //construtor recebendo um objeto
    livro.setTitulo(titulo); //o metodo set vai inserir o livro
    livrosRepo.save(livro); //objeto é livro minúsculo e fosse classe era Livro maiúsculo //Salvando o livro
    
    return "redirect:/livro/list";
  }

  @RequestMapping(value ="/delete/{id}") // procura o id do livro
  public String formDelete(Model model,@PathVariable int id){   //@ anotação   buscar pelo parâmetro id (codigo do livro)
   Optional<Livro>livro=livrosRepo.findById(id);    // classe <Livro>  e objeto do tipo livro recebe todos os livros que tem e seus ids
    
        if(!livro.isPresent())  // ! inverte o que é V vira F e vice-versa
          return "redirect:/livro/list";
        model.addAttribute("livro",livro.get()); //metodo get vai mostrar o livro
          return "/livro/delete.jsp";
  }

  @RequestMapping(value ="/delete", method=RequestMethod.POST) 
  public String confirmDelete(@RequestParam("id") int id){     
      livrosRepo.deleteById(id);
         return "redirect:/livro/list";
  }

}

