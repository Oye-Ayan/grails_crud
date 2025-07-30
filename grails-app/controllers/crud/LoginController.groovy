package crud

class LoginController {

    def index() {
        render(view: "login")
    }



    def login() {
        String email = params.email
        String password = params.password

        def user = User.findByEmailAndPassword(email, password)

        if (user) {
            session.user = user

            if (user.role == "admin") {
                redirect(controller: "admin", action: "index") // redirect to admin dashboard
            } else {
                redirect(controller: "user", action: "index") // redirect to user dashboard
            }

        } else {
            flash.message = "Invalid email or password"
            redirect(action: "index")
        }
    }

    def logout() {
        session.invalidate()
        redirect(action: "index")
    }
}
