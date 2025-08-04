package library

class User {
    String firstName
    String lastName
    String email
    String phone
    String title
    String password
    String role // 'user' or 'admin'
    boolean enabled = true

    static hasMany = [purchasedBooks: Book]

    static constraints = {
        email unique: true, nullable: false, email: true
        firstName nullable: false
        lastName nullable: false
        phone nullable: false
        title nullable: false
        password nullable: false
        role inList: ['user', 'admin']
    }
}