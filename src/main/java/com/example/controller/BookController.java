package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Book;
import com.example.entity.MyBookList;
import com.example.service.BookService;
import com.example.service.MyBookListService;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService myBookListService;
	
	@RequestMapping("/")
	public String hoemPage() {
		return "home";
	}
	
	@RequestMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@RequestMapping("/avialable_books")
	public ModelAndView avialableBooks() {
		
		List<Book> list = bookService.getAllBooks();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("avialableBook");
//		m.addObject("Book",list);
//		return m;
		
		return new ModelAndView("avialableBook","Book",list);
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book b) {
		
		bookService.save(b);
		return "redirect:/avialable_books";
	}
		
	@RequestMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> mbl = myBookListService.getAllMyBooks();
		model.addAttribute("BookList",mbl);
		return "myBooks";		
	}
	
	  @RequestMapping("/mylist/{id}") 
	  public String getMylist(@PathVariable("id")Integer id) {
		  Book b = bookService.getbookById(id); 
		  MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
	      myBookListService.saveMyBooks(mb); 
	      return "redirect:/my_books";
	  }
	  
	  
	  @RequestMapping("/editBook/{id}")
	  public String bookEdit(@PathVariable("id") Integer id,Model model) {
		  Book b = bookService.getbookById(id);
		  model.addAttribute("Book", b);
		  return "bookEdit";
	  }
	  
	  @RequestMapping("/deleteBook/{id}")
	  public String deleteBook(@PathVariable("id") Integer id) {
		  bookService.deletebyId(id);
		  return "redirect:/avialable_books";
	  }
	 
}
