//package crud
//
//class User {
//    String firstName
//    String lastName
//    String email
//    String phone
//    String title
//    String password
//    Boolean enabled
//    String role  // can be "admin" or "user"
//    static hasMany = [purchasedBooks: Book]
//
//    static constraints = {
//        email email: true, unique: true
//    }
//}
package crud

class User {
    String firstName
    String lastName
    String email
    String phone
    String title
    String password
    Boolean enabled
    String role  // "admin" or "user"

    static hasMany = [
            purchases: Purchase
    ]

    static mapping = {
        purchases cascade: 'all-delete-orphan'
    }

    static constraints = {
        email email: true, unique: true
    }
}
