public class BinaryTree { // Задача 4
    static class Node {
        public int data;
        public Node left;
        public Node right;

        //Конструктор
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root; // Переменая экземпляра класса

    public BinaryTree() { // Определяет экземпляр в знач null по умолчанию
        this.root = null;
    }

    public boolean isBSTOrNot() { // Является ли бинарным деревом поиска или нет
        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        // текущее значение узла с помощью левого и правого узла + рекурсивно проверяет наличие левого и правого поддерева
        if(root.data >= minValue && root.data <= maxValue && isBSTOrNot(root.left, minValue, root.data) && isBSTOrNot(root.right, root.data, maxValue)){
            return true;
        }
        return false;
    }



    public static void main(String[] args) { // Создание объектов класса и проверка работы алгоритма

        BinaryTree bt = new BinaryTree();
        bt.root= new Node(8);
        bt.root.left= new Node(3);
        bt.root.right= new Node(10);
        bt.root.left.left= new Node(1);
        bt.root.left.right= new Node(6);
        System.out.println(bt.isBSTOrNot());
    }
}
