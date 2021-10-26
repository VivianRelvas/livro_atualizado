package application.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import application.repositories.LivroRepository;
import application.models.Livro;
import org.springframework.ui.Model;

@Controller
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

@RequestMapping(value="/insert", method=RequestMethod.POST) //ANTES DE USAR ESTE METODO TEM QUE IMPORTAR
  public String saveInsert(@RequestParam("titulo")String titulo){
    
    Livro livro= new Livro(); //construtor recebendo um objeto
    livro.setTitulo(titulo); //o set vai inserir o livro
    livrosRepo.save(livro); //objeto é livro minúsculo e fosse classe era Livro maiúsculo
    
    return "redirect:/livro/list";
  }
}
