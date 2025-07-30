package crud

class Book {

    String bookName
    String bookAuthor
    String bookEdition
    String bookPrice
    String bookAvailable

    static belongsTo = [User]  // optional
    static hasMany = [buyers: User] // reverse

    static constraints = {
    }
}
