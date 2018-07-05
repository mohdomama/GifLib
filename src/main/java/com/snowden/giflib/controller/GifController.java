package com.snowden.giflib.controller;

import com.snowden.giflib.data.GifRepository;
import com.snowden.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String listFav(ModelMap modelMap) {
        List<Gif> favGifs = gifRepository.getAllFav();
        modelMap.put("gifs", favGifs);
        return "favorites";
    }

    @RequestMapping("/search")
    public String searchGifs(@RequestParam String search , ModelMap modelMap) {
        List<Gif> searchedGifs = gifRepository.getSearchedGifs(search);
        modelMap.put("gifs", searchedGifs);
        return "favorites";  // use favorites template because it does the same
    }
}
