import java.util.Scanner

class MapNotes (val mutableMapNotes: MutableMap<String, String>) {

    // Класс MapNotes описывает структуру заметок в архиве <String, String>
    // Функция класса makeNote запрашивает название и содержание заметки и затем
    // с помощью функции addMapNotes записывает заметку в переданный ей архив
        private fun addMapNotes(
        mapNotes: MapNotes,
        keyNote: String,
        note: String
    ): MutableMap<String, String> {
        mapNotes.mutableMapNotes.plusAssign(keyNote to note)
        return mapNotes.mutableMapNotes
    }

    fun makeNote(mapNotes: MapNotes) {
        val input = Scanner(System.`in`)
        print("Введите название заметки: ")
        val keyNote = (input.nextLine())
        print("Введите содержание заметки: ")
        val note = (input.nextLine())
        addMapNotes(mapNotes, keyNote, note)
        println("Заметка добавлена")
        val countmapNotes = mapNotes.mutableMapNotes.size
        println("Теперь заметок: $countmapNotes")
    }

    fun delNote (mapNotes: MapNotes, keyNote: String) {
        mapNotes.mutableMapNotes.remove(keyNote)
    }
}


class MapArhiv (val mapArhiv : MutableMap<String,MapNotes>) {
    // Класс MapArhiv описывает структуру архивов в Мар-хранилище  <String,MapNotes>
    // Функция класса makeArhiv запрашивает название архива и затем
    // с помощью функции addMapNoteToArhiv добавляет этот архив в Мар-хранилище архивов
    private fun addMapNoteToArhiv (keyArhiv:String) {
        val mapNotesInArhiv = MapNotes( mutableMapOf())
        mapArhiv.plusAssign (keyArhiv to mapNotesInArhiv)
    }

    fun makeArhiv() {
        val input = Scanner(System.`in`)
        print("Введите название архива: ")
        val keyArhiv = (input.nextLine())
        //val mapNotes: MutableMap<String, String> = mutableMapOf()

        addMapNoteToArhiv (keyArhiv)
        println("Архив создан")
        val countmapArhives = mapArhiv.size
        println("Теперь количество архивов стало $countmapArhives")
    }
}
