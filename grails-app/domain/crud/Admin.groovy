package crud

class Admin {
        String firstName
        String lastName
        String email
        String phone
        String title
        String password
        Boolean enabled = true
        String role = "admin"

        static constraints = {
            email unique: true
        }
    }
