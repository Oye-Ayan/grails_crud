package library

class BootStrap {
    def init = { servletContext ->
        if (!User.findByEmail('admin@example.com')) {
            new User(
                    firstName: 'Admin',
                    lastName: 'User',
                    email: 'admin@example.com',
                    phone: '1234567890',
                    title: 'Admin',
                    password: 'admin123',
                    role: 'admin',
                    enabled: true
            ).save(flush: true)
        }
    }
    def destroy = {}
}