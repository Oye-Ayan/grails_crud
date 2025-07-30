package crud

class User {
    String firstName
    String lastName
    String email
    String phone
    String title
    String password
    Boolean enabled = true
    String role = "user" // can be "admin" or "user"
    static hasMany = [purchasedBooks: Book]

    static constraints = {
        email unique: true
    }
}
