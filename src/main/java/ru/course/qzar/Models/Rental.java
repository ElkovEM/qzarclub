package ru.course.qzar.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

// Информация о брони
/*
1. Имя
2. Дата
3. Телефонный номер
4. Электронная почта
5. Предпочтительная Арена
6. Количество игроков
7. Примечания
 */

@Data
@Entity
@Table(name = "rentals")
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer")
    private String customer;
    @Column(name = "date")
    private Date date;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "arena_id")
    private int arena_id;
    @Column(name = "players")
    private int players;
    @Column(name = "notes")
    private int notes;

}