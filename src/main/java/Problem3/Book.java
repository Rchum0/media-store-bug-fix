package Problem3;

import java.util.UUID;

public abstract class Book implements StoreMediaOperations {
    UUID id;
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.id = UUID.randomUUID();
    }

    public Book(Book anotherBook) {
        this.id = anotherBook.id;
        this.title = anotherBook.title;
        this.author = anotherBook.author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID newId) {
        this.id = newId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    @Override
    public boolean equals(Object obj) {
/*
        System.out.println("I am testing to see org book is equal too ");
        System.out.println("Test " + this);
        System.out.println("Test obj " + obj);
        System.out.println("------------------");
*/
        if (obj == this) {
            return true;
        }
/*
        System.out.println("I am testing to see org book id and title ");
        System.out.println("What is book?  " + id);
        System.out.println("What is book?  " + title);
        System.out.println("------------------");
*/
        if (!(obj instanceof Book)) {
            return false;
        }

        Book theOtherBook = (Book) obj;
/*
        System.out.println("I am testing to see what other org book id and title is  ");
        System.out.println("What is  the other book?  " + theOtherBook.id);
        System.out.println("What is the other book?  " + theOtherBook.title);
        System.out.println("------------------");
*/

        // bug is here
        // Quiz: add unit tests to catch this bug.
        // The bug is caught when
        //  1. newly add tests fail while all old tests still pass
        //  2. remove the bug and use the fix below, all tests pass

/*
        return id.equals(theOtherBook.id) &&
                author.equals(theOtherBook.author) &&
                title.equals(theOtherBook.title);
*/

        // fix is here
         return id.equals(theOtherBook.id);
    }
}