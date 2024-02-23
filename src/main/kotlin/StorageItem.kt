class StorageItem (override val name:String) : Item {

    private val list:MutableList<ArchItem> = mutableListOf();
    private val menu = ScreenMenu();

    override fun showMenu(){
        println("Список архивов ->")
        menu.openMenu("0. Создать архив", list, ::addItem);
    }

    override fun addItem(){
        val name = menu.getString("Введите название архива:", "Название не можен быть пустым!");
        val arch = ArchItem(name);
        list.add(arch);
        println("Архив \"$name\" создан")
        this.showMenu();
    }
}