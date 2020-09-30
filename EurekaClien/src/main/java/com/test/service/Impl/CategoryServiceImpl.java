package com.test.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.Bean.Category;
import com.test.dao.CategroryDao;
import com.test.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategroryDao, Category> implements CategoryService {
}
