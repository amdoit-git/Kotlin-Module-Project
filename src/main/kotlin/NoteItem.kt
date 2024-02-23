class NoteItem (override val name:String, val text:String) : Item {

    private val menu = ScreenMenu();

    override fun showMenu(){
        println("Заметка \"$name\"")
        println("----------")
        println(text)
        println("----------")
        menu.openMenu();
    }

    override fun addItem(){

    }
}