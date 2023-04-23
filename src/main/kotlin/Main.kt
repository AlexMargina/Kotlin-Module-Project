/*
Приложение ЗАМЕТКИ
версия v.1
2023.04.23  by AlexMargina
 */

fun main() {
    println("Приложение Заметки. Добрый день!") // поздоровайтесь с пользователем
    var levelMenu = MenuLevel.ArhivMenu     // Задаем уровень меню - уровни описаны в Enum class MenuLevel (val level: String)

    val mapArhiv = MapArhiv(mutableMapOf())           // создаем карту, содержащая список всех архивов

    val menu = MenuSelect()                         // Создаем обьект класса MenuSelect
    var keyReturned : Any? = ""                              //переменная, в которой будет приниматься результат функций класса MenuSelect

    //Зацикливаем всю работу по вызову разных меню до момента выбора пункта меню Выход из программы в Главном меню
    do {
        println(" ")                                        // Это для красоты, отделить одно меню от другого
        if (levelMenu == MenuLevel.ArhivMenu){
            // 1. Создаем меню выбранного уровня. Функция makeMenu возвращает выбор пользователя в переменную keyReturned
             keyReturned = menu.makeMenu(levelMenu, mapArhiv)

             if (mapArhiv.mapArhiv.contains(keyReturned)) {   //проверка если есть такой архив
                 levelMenu = MenuLevel.NoteMenu                 // то открываем его, переключая уровень меню
                 println ("================================")
                 println("Выбран архив $keyReturned")
             }
          }
        val keyForMap = keyReturned.toString()                  // сохраним ключ только что переданного архива для его открытия

        if (levelMenu == MenuLevel.NoteMenu){
            // 2. Создаем меню ЗАМЕТОК. Функция makeMenu возвращает выбор пользователя в переменную keyReturned

            val keyReturned = menu.makeMenu(levelMenu, mapArhiv, keyForMap) //  в данном случае вместе с mapArhiv передаем ключ выбранного архива
            if (keyReturned=="exitMenu") {
                levelMenu = MenuLevel.ArhivMenu                     // если вернет exitMenu -> перейти в меню Архивов
            } else if (keyReturned!="noteCreated"){
                print("Содержание заметки $keyReturned : ")
                println(mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.get(keyReturned)?.toString())
            }
        }

        println ("================================")
    } while (keyReturned!="exitApp")
    println("Вы вышли из программы")
}


/*
Критерии успешного выполнения задания:

+ Есть меню с возможностью добавления и просмотра архивов.
+ Есть меню с возможностью добавления и просмотра заметок.
+ Есть возможность добавлять и просматривать текст заметок.
+ Не должно быть повторений одного и того же кода. Вся логика по считыванию ввода пользователя и вывода пунктов на экран должна переиспользовать один и тот же код.
+ Ошибочный ввод пользователя должен корректно обрабатываться.
+ Из любого меню можно выйти и попасть на предыдущее меню или выйти из программы, если это просмотр архива.
+ Приложение успешно компилируется и выполняется без ошибок.
+ Весь код не написан в одном файле Main.
+ Весь код приложения написан на Kotlin.

https://practicum.yandex.ru/learn/android-developer/courses/c56e01c2-2c98-456a-98d6-95752312dfdf/sprints/127054/topics/0dba50a8-6cca-4c01-bc51-f2d4fc68d162/lessons/f32f7fa4-ecb7-4551-a214-55a3be6dd067/:

*/
