package com.github.lky.mybatis;

import com.github.lky.mybatis.dao.ext.BookDao;
import com.github.lky.mybatis.dao.ext.UserQueryDao;
import com.github.lky.mybatis.entity.Book;
import com.github.lky.mybatis.entity.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages="com.github.lky.mybatis")
public class SpringMybaitsDemoApplication implements CommandLineRunner {

	@Autowired
	private UserQueryDao userQueryDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringMybaitsDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
        UserBook userBook = userQueryDao.queryUser(1);
		System.out.println(userBook.getBookIds());
	}
}
