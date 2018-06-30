package com.rumofuture.nemo.controller;

import com.rumofuture.nemo.model.domain.Book;
import com.rumofuture.nemo.model.domain.User;
import com.rumofuture.nemo.model.entity.Response;
import com.rumofuture.nemo.service.BookService;
import com.rumofuture.nemo.util.constant.RespStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 漫画册数据API
 *
 * @author 王振琦  2018/1/7
 */
@RestController
public class BookController extends NemoController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "books")
    Response<Book> actionSaveBook(@RequestBody Book book) {
        User user = getHttpSessionUser();
        book.setAuthor(user);
        bookService.save(book);
        return new Response<>(book);
    }

    @DeleteMapping(value = "books/{id}")
    Response<Book> actionDeleteBook(@PathVariable(value = "id") Integer id) {
        bookService.delete(id);
        return new Response<>(RespStatus.SUCCESS);
    }

    @PutMapping(value = "books")
    Response<Book> actionUpdateBook(@RequestBody Book book) {
        bookService.update(book);
        return new Response<>();
    }

    @GetMapping(value = "users/{id}/books")
    Response<List<Book>> actionQueryBookListByAuthor(
            @PathVariable(value = "id") Integer id,
            @RequestParam(value = "index") Integer index,
            @RequestParam(value = "own") Boolean own
    ) {
        List<Book> bookList = bookService.findListByUser(id, index, own);
        return new Response<>(bookList);
    }

    @GetMapping(value = "books")
    Response<List<Book>> actionQueryBookListByStyle(
            @RequestParam(value = "style") String style,
            @RequestParam(value = "index") Integer index
    ) {
        List<Book> bookList = bookService.findListByStyle(style, index);
        return new Response<>(bookList);
    }
}
