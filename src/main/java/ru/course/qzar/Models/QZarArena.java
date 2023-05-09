package ru.course.qzar.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Информация о игровой арене
/*
1. Наименование
2. Описание арены
3. Размер арены
4. Максимальное количество игроков
5. Используемая технология оборудования
 */

@Data
@Entity
@Table(name = "qzararena")
@AllArgsConstructor
@NoArgsConstructor
public class QZarArena {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "size")
    private String size;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "tech")
    private String tech;
}