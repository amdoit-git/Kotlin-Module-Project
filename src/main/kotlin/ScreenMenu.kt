import java.util.Scanner;
class ScreenMenu {
    fun openItem(item:Item){
        items.add(item);
        item.showMenu();
    }

    fun openMenu(){
        var option:Int? = null;

        while(option==null || option!=0) {
            println("Введите 0 для выхода")
            option = getInt();
        }

        this.closeItem()
    }

    fun openMenu(createItemTitle:String, list:List<Item>, onCreate: () -> Unit){

        val max = list.size + 1;

        while(true) {

            showMenu(createItemTitle, list);

            val option = getInt();

            when(option) {
                null -> println("Для выбора пункта меню введите цифру от 0 до $max");
                in 0..max -> {
                    when(option){
                        0 -> onCreate();
                        max -> this.closeItem();
                        else -> openItem(list.get(option - 1));
                    }
                    break;
                }
                else -> println("Введите цифру в диапазоне от 0 до $max");
            }
        }
    }

    private fun showMenu(createItemTitle:String, list:List<Item>){
        val max = list.size + 1;

        println(createItemTitle)

        for (i in list.indices) {
            println("${i + 1}. ${list[i].name}")
        }

        println("$max. Выход")
        println("Выберите пункт меню:")
    }

    internal fun getInt():Int?{

        val line = scanner.nextLine();

        return line.toIntOrNull()
    }

    internal fun getString(info:String, error:String):String{

        var line:String;

        do {
            println(info)
            line = scanner.nextLine();
            if(line.isBlank()){
                println(error)
            }
        }
        while (line.isBlank());

        return line;
    }

    private fun closeItem(){
        if(items.size>1){
            items.removeAt(items.lastIndex);
            items.get(items.lastIndex).showMenu();
        }
        else{
            println("Выход из программы")
        }
    }

    companion object{
        val scanner = Scanner(System.`in`);
        val items:MutableList<Item> = mutableListOf();
    }
}