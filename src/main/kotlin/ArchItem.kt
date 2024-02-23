class ArchItem(override val name:String) : Item  {

    private val list: MutableList<NoteItem> = mutableListOf();
    private val menu = ScreenMenu();

    override fun showMenu(){
        println("Меню архива \"$name\" ->")
        menu.openMenu("0. Создать заметку", list, ::addItem);
    }

    override fun addItem(){
        val name = menu.getString("Введите название заметки:", "Название не можен быть пустым!");
        val text = menu.getString("Введите текст заметки:", "Текст заметки не можен быть пустым!");
        val note = NoteItem(name, text);
        list.add(note);
        println("Заметка \"$name\" создана")
        this.showMenu();
    }
}