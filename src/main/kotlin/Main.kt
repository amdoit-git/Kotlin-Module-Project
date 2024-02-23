fun main(args: Array<String>) {

    val storage = StorageItem("мои архивы");

    val menu = ScreenMenu();

    menu.openItem(storage);

    println("Bye Bye!");
}