package tn.iit.storemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.storemanagement.dao.CategoryDao;
import tn.iit.storemanagement.dto.CategoryDto;
import tn.iit.storemanagement.mappers.CategoryMapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

@Transactional
@Service
public class CategoryService {

    private final CategoryDao categoryDao;
    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryDto save(CategoryDto categoryDto) {
         this.categoryDao.saveAndFlush (CategoryMapper.categoryDtoToCategory (categoryDto));
         return categoryDto;
    }
    public void deleteById(Long id){
        this.categoryDao.deleteById (id);
    }
    @Transactional(readOnly = true)
    public CategoryDto findOne(Long id){

        return CategoryMapper.categoryToCategoryDto (this.categoryDao.getOne (id));
    }
    @Transactional(readOnly = true)
    public Collection<CategoryDto> findAll(){
        return CategoryMapper.categoriesToCategoriesDtos (this.categoryDao.findAll ());
    }
}
