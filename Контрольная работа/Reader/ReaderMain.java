public class ReaderMain {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Легостаев ", 213779 , " Прикладная информатика ", "09.08.2000 ", "123456 ");
        Reader reader2 = new Reader("Сидоров ", 111111, " Прикладная информатика ", "09.09.2000 ", "141414 ");
        Reader[] readers = {reader1, reader2};

        Book book1 = new Book("Приключения");
        Book book2 = new Book("Словарь");
        Book book3 = new Book("Энциклопедия");
        Book[] books = {book1, book2, book3};

        printReaders(readers);
        printBooks(books);

        reader1.takeBook(2);
        reader2.takeBook("Энциклопедия");
        //reader1.takeBook(book1, book2, book3);


        reader1.returnBook("Приключения");
        reader2.returnBook("Энциклопедия");
        reader2.returnBook(1);
    }

    private static void printBooks(Book[] books){
            System.out.println("Список книг: ");
            for (Book book : books) {
                System.out.println(book.infoB());
            }
            System.out.println();
        }

        private static void printReaders(Reader[] readers){
            System.out.println("Список посетителей: ");
            for (Reader reader: readers) {
                System.out.println(reader.infoR());
            }
            System.out.println();
        }

    }
