package com.snowden.giflib.data;

import com.snowden.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1,"aragorn"),
            new Category(2,"legolas"),
            new Category(3,"gimli")
    );

    public Category findByName(String name) {
        for (Category category : ALL_CATEGORIES) {
            if(category.getName().equals(name)){
                return category;
            }
        }
        return null;
    }

    public Category findById(int id) {
        for (Category category : ALL_CATEGORIES) {
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
}
