package tn.iit.storemanagement.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.iit.storemanagement.dto.CategoryDto;
import tn.iit.storemanagement.services.CategoryService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/categories")
@RestController()
public class CategoryResource {

    private final Logger logger= LoggerFactory.getLogger (CategoryResource.class);
    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public CategoryDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting Category {}",id);
        return this.categoryService.findOne (id);
    }

    @GetMapping
    public Collection<CategoryDto> findAll(){
        this.logger.debug ("Getting all categories");
        return this.categoryService.findAll ();
    }

    @PostMapping
    public CategoryDto add(@Valid @RequestBody CategoryDto categoryDto){
        this.logger.debug ("Adding new Category {}",categoryDto.getName ());
        return this.categoryService.save (categoryDto);
    }

    @PutMapping
    public CategoryDto update(@Valid @RequestBody CategoryDto categoryDto){
        this.logger.debug ("Updating Category {} with {}",categoryDto.getId (),categoryDto.getName ());
        return this.categoryService.save (categoryDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Deleting Category {}",id);
        this.categoryService.deleteById (id);
    }

}
