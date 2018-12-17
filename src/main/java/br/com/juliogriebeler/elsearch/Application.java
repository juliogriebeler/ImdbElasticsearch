package br.com.juliogriebeler.elsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application { // implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        printElasticSearchInfo();
//
//        bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
//        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
//        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));
//
//        //fuzzey search
//        Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));
//
//        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");
//
//        books.forEach(x -> System.out.println(x));
//
//
//        
//    }



}