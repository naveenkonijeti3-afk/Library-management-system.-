package com.library.controller;
import com.library.model.*; import com.library.repo.*; import com.library.service.*; import org.springframework.web.bind.annotation.*; import java.util.*;

@RestController @RequestMapping("/api") @CrossOrigin(origins="*")
public class LibraryController {
 final LibraryService service; final StudentRepository students; final BookRepository books; final BorrowalRepository borrowals;
 public LibraryController(LibraryService s,StudentRepository st,BookRepository b,BorrowalRepository br){service=s;students=st;books=b;borrowals=br;}

 @PostMapping("/auth/login") public Map<String,Object> login(@RequestBody Map<String,String> x){return service.login(x.get("username"),x.get("password"),x.get("role"));}

 @GetMapping("/books") public List<Book> books(){return books.findAll();}
 @PostMapping("/books") public Book addBook(@RequestBody Book b){b.availableQuantity=b.quantity;return books.save(b);}
 @DeleteMapping("/books/{id}") public void deleteBook(@PathVariable Long id){books.deleteById(id);}

 @GetMapping("/students") public List<Student> students(){return students.findAll();}
 @GetMapping("/students/{id}") public Student student(@PathVariable Long id){return students.findById(id).orElseThrow();}
 @PostMapping("/students") public Student addStudent(@RequestBody Student s){return students.save(s);}
 @DeleteMapping("/students/{id}") public void deleteStudent(@PathVariable Long id){students.deleteById(id);}

 @PostMapping("/borrowals/borrow") public Borrowal borrow(@RequestBody Map<String,Long> x){return service.borrow(x.get("studentId"),x.get("bookId"));}
 @PostMapping("/borrowals/{id}/return") public Map<String,Object> ret(@PathVariable Long id){Borrowal b=service.returnBook(id);return Map.of("message",b.fine>0?"Late return: fine ₹"+b.fine:"On-time return: 10 reward points earned","borrowal",b);}
 @GetMapping("/borrowals") public List<Borrowal> all(){return borrowals.findAll();}
 @GetMapping("/borrowals/student/{id}") public List<Borrowal> mine(@PathVariable Long id){return borrowals.findByStudentId(id);}

 @GetMapping("/librarian/stats") public Map<String,Object> stats(){
  int total=books.findAll().stream().mapToInt(b->b.quantity).sum();
  int available=books.findAll().stream().mapToInt(b->b.availableQuantity).sum();
  return Map.of("Total Books",total,"Available Books",available,"Students",students.count(),"Borrowals",borrowals.count());
 }
}