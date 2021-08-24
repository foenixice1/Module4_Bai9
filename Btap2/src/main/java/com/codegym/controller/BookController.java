package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Oder;
import com.codegym.service.BookSer;
import com.codegym.service.OderSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookSer bookSer;

    @Autowired
    OderSer oderSer;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", bookSer.findAll());
        return modelAndView;
    }

    @GetMapping("/oder/{idBook}")
    public ModelAndView oder(@PathVariable int idBook) throws Exception {
        Book book = bookSer.findById(idBook);
        if (book.getCount() == 0) {
            throw  new Exception();
        }
        book.setCount(book.getCount() - 1);

        Oder oder = new Oder();
        int code = (int) (Math.random() * (999999 - 100000) + 10000);
        oder.setCode(code);

        int milis = (int) System.currentTimeMillis();
        oder.setDate(new Date(milis));

        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);

        oderSer.save(oder);
        bookSer.save(book);

        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }


















}
