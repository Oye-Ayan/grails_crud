//package crud
//
//class Purchase {
//    User user
//    Date date = new Date()
//    Book book
//
//
//
//    static constraints = {
//    }
//}
package crud

class Purchase {
    User user
    Book book
    Date date = new Date()

    static belongsTo = [user: User, book: Book]

    static constraints = {
    }
}
