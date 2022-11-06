public class test_array {
    public static void main(String[] args){
        Array_ls.checkRuntime();
    }
}
// ArrayList имеет прямые ссылки на каждый элемент в списке, тогда как LinkedList проходит по списку сначала, чтобы добраться до n-элемента.
// Этим можно объяснить такую разницу в скорости