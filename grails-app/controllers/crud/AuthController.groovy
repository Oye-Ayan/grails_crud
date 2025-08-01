package crud

class AuthController {

    def index() {
        render(view: 'login') // shows login.gsp
    }

    def loginSubmit() {
        def email = request.getParameter('email')
        def password = request.getParameter('password')

        def user = User.findByEmailAndPassword(email, password)

        if (!user) {
            flash.message = "Invalid credentials"
            redirect(action: "index")
            return
        }

        session.user = user

        // Redirect based on role
        if (user.role == "admin") {
            redirect(controller: "admin", action: "index")
        } else {
            redirect(controller: "user", action: "index")
        }
    }

    def logout() {
        session.invalidate()
        redirect(action: "index")
    }
}
