package library

class Purchase {
    User user
    Book book
    Date dateCreated

    static constraints = {
        user nullable: false
        book nullable: false
    }
}