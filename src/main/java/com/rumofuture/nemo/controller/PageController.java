package com.rumofuture.nemo.controller;

import com.rumofuture.nemo.model.domain.Page;
import com.rumofuture.nemo.model.entity.Response;
import com.rumofuture.nemo.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 漫画分页数据 API
 *
 * @author 王振琦  2018/1/7
 */
@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping(value = "pages")
    public Response<Page> actionSave(@RequestBody Page page) {
        pageService.save(page);
        return new Response<>(page);
    }

    @DeleteMapping(value = "pages")
    public Response<Page> actionDeletePage(@PathVariable(value = "id") Integer id) {
        pageService.delete(id);
        return new Response<>();
    }

    @PutMapping(value = "pages")
    public Response<Page> actionUpdate(@RequestBody Page page) {
        pageService.update(page);
        return new Response<>();
    }

    @GetMapping(value = "books/{id}/pages")
    public Response<List<Page>> actionQueryPageListByBook(
            @PathVariable("id") Integer id,
            @RequestParam("index") Integer index
    ) {
        List<Page> pageList = pageService.queryListByBook(id, index);
        return new Response<>(pageList);
    }
}
