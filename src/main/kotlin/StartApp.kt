class StartApp {
    fun startApp() {

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
                when (keyReturned) {
                    "exitMenu" -> {
                        levelMenu = MenuLevel.ArhivMenu                     // если вернет exitMenu -> перейти в меню Архивов
                    }
                    "noteCreated" -> {

                    }
                    else -> {
                        print("Содержание заметки $keyReturned : ")
                        println(mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.get(keyReturned)?.toString())
                        println("1. Удалить заметку")
                        println("2. Вернуться")
                        val actionNote=menu.readMenu(2)
                       if (actionNote==1) {mapArhiv.mapArhiv[keyForMap]?.mutableMapNotes?.remove(keyReturned) }
                    }
                }
            }

            println ("================================")
        } while (keyReturned!="exitApp")
        println("Вы вышли из программы")
    }
}