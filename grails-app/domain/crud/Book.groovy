package crud

class Book {

    String bookName
    String bookAuthor
    int bookEdition
    double bookPrice
    boolean bookAvailable

    static belongsTo = [User]
    static hasMany = [buyers: User]

    static constraints = {
    }
}
