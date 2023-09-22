package com.example.myfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

// мейн класс
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // создание переменных
        // привязываем вьюшки через id
        val listView: ListView =  findViewById(R.id.listView)
        val userData: EditText = findViewById(R.id.userData)
        val button: Button = findViewById(R.id.button)

        // создаем пустой массив, для добавления в него тудушек
        val todos: MutableList<String> = mutableListOf()

        // Для работы с массивами в андроиде нужна спец. прослойка - адаптер,
        // в котором и прописывается весь функционал работы с массивом.

        // Создаем адаптер, на основе готового класса, передавая в параметры, опять же, готовый шаблон.
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        // и подключаем адаптер к переменной списка
        listView.adapter = adapter

        //условие при жмяканья пользователем на кнопку
        button.setOnClickListener{
            val text = userData.text.toString().trim() //дату юзера преобразуем в текстовый формат
            if(text != "")
                //если пользователь хоть, что-то написал: используем функцию добавления элемента в наш массив.
                adapter.insert(text, 0)
        }
    }
}