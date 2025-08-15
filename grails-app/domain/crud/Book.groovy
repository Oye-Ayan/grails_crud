package crud

class Book {

    String bookName
    String bookAuthor
    Integer bookEdition
    Double bookPrice
    Boolean bookAvailable

    static belongsTo = [User]
    static hasMany = [buyers: User, purchases: Purchase]

    static mapping = {
        buyers cascade: 'all-delete-orphan'
        purchases cascade: 'all-delete-orphan'
    }

    static constraints = {
        bookName blank: false, unique: true
        bookAuthor blank: false
        bookEdition min: 1
        bookPrice min: 0.0d
    }
}
