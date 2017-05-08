package com.github.lky.mybatis;

import com.github.lky.mybatis.dao.ext.BookDao;
import com.github.lky.mybatis.dao.ext.UserQueryDao;
import com.github.lky.mybatis.entity.Book;
import com.github.lky.mybatis.entity.UserBook;
import com.github.lky.mybatis.model.BookModel;
import com.github.lky.mybatis.model.UserModel;
import com.github.lky.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages="com.github.lky.mybatis")
public class SpringMybaitsDemoApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMybaitsDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
        userService.create(produce());
	}

	private UserModel produce(){
		UserModel model = new UserModel();
		model.setName("李四");
		model.setAge(23);
		List<BookModel> books = new ArrayList<>();
		BookModel m = new BookModel();
		m.setName("红1黑2");
		m.setAuthor("不知道");
		books.add(m);
		BookModel m1 = new BookModel();
		m1.setName("oi");
		m1.setAuthor("也不知道");
		books.add(m1);
		model.setBooks(books);
		return model;
	}
}
