package library

class Admin {
    String email
    String password

    static constraints = {
        email unique: true, nullable: false, email: true
        password nullable: false
    }
}