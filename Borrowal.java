package com.library.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity @Table(name="borrowals")
public class Borrowal {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 public Long studentId, bookId;
 public LocalDate borrowDate, dueDate, returnDate;
 public double fine=0;
 public int rewardPoints=0;
}