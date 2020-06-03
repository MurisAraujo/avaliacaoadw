/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.murilo.tads.avaliacao.controller;

import br.murilo.tads.avaliacao.model.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.murilo.tads.avaliacao.repository.UserRepository;

/**
 *
 * @author Murilo
 */

@Controller
public class UserController {
    
    @Autowired //injeção de depencencia
    private UserRepository pr;
    
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<User> users = pr.findAll();
        mv.addObject("user", users);
        return mv;
    }
    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os Campos Obrigatorios!");
            return "redirect:/";
        }
        System.out.println(user.senha);
        System.out.println(user.nome);
        System.out.println(user.userName);
        System.out.println(user.status);
        System.out.println(user.dataCadastro);
        pr.save(user);
        
        
        attributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!");
        return "redirect:/";
    }
    
    @RequestMapping(value="deleteUser/{id}", method=RequestMethod.POST)
    @ResponseBody
    public String deletarProduto(@PathVariable("id") long id ){
        User user = pr.findById(id);
        pr.delete(user);
        
        return "OK";
    }
    
    @RequestMapping(value="/editUser/{id}", method=RequestMethod.GET)
    @ResponseBody
    public User editarEvento(@PathVariable("id") long id){
        System.out.println(pr.findById(id) + "asfkljsdfljksad");
        return pr.findById(id);
    }
    
    @RequestMapping(value="/editarUser",method=RequestMethod.POST)
    public String editarProduto(@ModelAttribute("produto") User user, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
        return "redirect:/";
    }
    pr.save(user);
    return "redirect:/";
    }
    
    
    
}
 