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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(UUID id) {

        if (this.id == id) {
            System.out.println("Made it");
        } else if (!(this.id == id)) {
            System.out.println("Not Equal");
            return;
        }

    }

    public void setTitle(String title) {

        if (title.equals(title)) {
            System.out.println("fail");
        } else if (!(title.equals(title))) {
            this.title = title;
        }
    }

    public void setAuthor(String author) {
        if (author.equals(author)) {
            return;
        } else if (!(author.equals(author))) {
            this.author = author;
        }
    }

    @Override
    public boolean equals(Object obj) {

        System.out.println("I am testing to see org book is equal too ");
        System.out.println("Test " + this);
        System.out.println("Test obj " + obj);
        System.out.println("------------------");

        if (obj == this) {
            return true;
        }

        System.out.println("I am testing to see org book id and title ");
        System.out.println("What is book?  " + id);
        System.out.println("What is book?  " + title);
        System.out.println("------------------");

        if (!(obj instanceof Book)) {
            return false;
        }

        Book theOtherBook = (Book) obj;

        System.out.println("I am testing to see what other org book id and title is  ");
        System.out.println("What is  the other book?  " + theOtherBook.id);
        System.out.println("What is the other book?  " + theOtherBook.title);
        System.out.println("------------------");


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
/*
 So when running the the bug code the assertFalse is always going to be false.
 Since we are using the && keyword we are going to compare if all the statements would equal true
 and since the ids are never going to equal true its gonna return false. So that means it first checks
 if the id is false then checks author then its going to return false.
 */
