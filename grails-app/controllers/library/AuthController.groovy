package library

import grails.converters.JSON

class AuthController {

    def index() {
        render(view: 'login')
    }

    def loginSubmit() {
        def email = params.email
        def password = params.password
        def user = User.findByEmailAndPassword(email, password)
        if (!user) {
            render([status: 'error', message: 'Invalid credentials'] as JSON)
            return
        }
        session.user = user
        render([status: 'success', user: [
                id: user.id,
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.email,
                phone: user.phone,
                title: user.title,
                role: user.role,
                enabled: user.enabled
        ]] as JSON)
    }

    def logout() {
        session.invalidate()
        render([status: 'success', message: 'Logged out'] as JSON)
    }
}