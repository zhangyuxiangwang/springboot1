package com.jrj.elastic;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jrj.elastic.bean.Book;
import com.jrj.elastic.bean.BookRepository;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EsTests {
	
	@Autowired
	JestClient jestClient;
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void bookRepository(){
		Book book=new Book();
		book.setId(1);
		book.setAuthor("wangbin hello world");
		book.setBookName("xiaoshuo");
		book.setCount(111);
		book.setCreateTime(new Date());
		bookRepository.save(book);
	}
	
	
	@Test
	public void cun(){
		Book book=new Book();
		book.setId(1);
		book.setAuthor("wangbin hello world");
		book.setBookName("xiaoshuo");
		book.setCount(111);
		book.setCreateTime(new Date());
		Index index = new Index.Builder(book).index("jrj").type("book").build();
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void qu(){
		String json="{\n"+
					  "  \"query\":{\n"  +
					  "      \"match\":{ \n" +
					  "          \"author\":\"hello\" \n"+
					  "      } \n"+
					  "   } \n"+
					  " }";
		
		Search search = new Search.Builder(json).addIndex("jrj").addType("book").build();
		try {
			SearchResult result = jestClient.execute(search);
			System.out.println(result.getJsonObject());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
