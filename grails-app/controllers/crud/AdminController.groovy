package crud

import grails.converters.JSON

class AdminController {


    def index() {
        render(view: "index")
    }


    def adminDashboard() {
        render(view: "adminDashboard")
    }

//    def addUser() {
//        if (request.method == 'GET') {
//            render(view: 'addUser') // Show the form
//            return
//        }
//
//        // Else POST: process the form
//        User user = new User(
//                firstName: params.firstName,
//                lastName: params.lastName,
//                email: params.email,
//                phone: params.phone,
//                title: params.title,
//                password: params.password,
//                role: 'user'
//        )
//
//        if (user.save(flush: true)) {
//            flash.message = "User added successfully"
//            redirect(action: 'showUsers')
//        } else {
//            render(view: 'addUser', model: [user: user])
//        }
//    }
    def addUser() {
        Map result= [:]
        if (request.method == 'GET') {
            render(view: 'addUser') // Show the form
            return
        }

        // Else POST: process the form
        User user = new User(
                firstName: params.firstName,
                lastName: params.lastName,
                email: params.email,
                phone: params.phone,
                title: params.title,
                password: params.password,
                role: 'user'
        )

        if (user.save(flush: true)) {
            flash.message = "User added successfully"
            render(result as JSON)
            redirect(action: 'showUsers')

        } else {
            render(result as JSON)
            render(view: 'addUser', model: [user: user])

        }
    }



//    def addBook() {
//        Map result = [:]
//        Book book = new Book(
//                bookName: request.getParameter('bookName'),
//                bookAuthor: request.getParameter('bookAuthor'),
//                bookEdition: request.getParameter('bookEdition'),
//                bookPrice: request.getParameter('bookPrice'),
//                bookAvailable: request.getParameter('bookAvailable')
//        )
//
//        if (book.save(flush: true)) {
//            result = [status: 'success', message: 'Book Added']
//        } else {
//            result = [status: 'fail', message: 'Validation failed', errors: book.errors.allErrors]
//        }
//
//        render(result as JSON)
//    }

    def addBook() {
        if (request.method == 'GET') {
            render(view: 'addBook')
            return
        }

        // POST: save book
        Book book = new Book(
                bookName: params.bookName,
                bookAuthor: params.bookAuthor,
                bookEdition: params.bookEdition,
                bookPrice: params.bookPrice,
                bookAvailable: params.bookAvailable,
        )

        if (book.save(flush: true)) {
            flash.message = "Book added successfully"
//            render(result as JSON)
            redirect(action: 'showBooks')
        } else {
            render(result as JSON)
            render(view: 'addBook', model: [book: book])
        }
    }


    def updateUser() {
        Map result = [:]

        String email = request.getParameter("email")
        if (!email) {
            result = [status: 'fail', message: 'Email is required to identify user']
            render(result as JSON)
            return
        }

        User user = User.findByEmail(email)
        if (!user) {
            result = [status: 'fail', message: 'User not found']
            render(result as JSON)
            return
        }

        user.firstName = request.getParameter("firstName") ?: user.firstName
        user.lastName = request.getParameter("lastName") ?: user.lastName
        user.phone = request.getParameter("phone") ?: user.phone
        user.title = request.getParameter("title") ?: user.title
        user.password = request.getParameter("password") ?: user.password


        if (user.save(flush: true)) {
            result = [status: 'success', message: 'User updated']
        } else {
            result = [status: 'fail', message: 'Validation failed', errors: user.errors.allErrors]
        }

        render(result as JSON)
    }

    def updateBook() {
        Map result = [:]
        String bookName = request.getParameter('bookName')
        if (!bookName) {
            result = [status: 'fail', message: 'BOOK NAME is required to identify Book']
            render(result as JSON)
            return
        }

        Book book = Book.findByBookName(bookName)
        if (!book) {
            result = [status: 'fail', message: 'Book not found']
            render(result as JSON)
            return
        }
        book.bookAuthor = request.getParameter('bookAuthor') ?: book.bookAuthor
        book.bookAvailable = request.getParameter('bookAvailable') ?: book.bookAvailable
        book.bookPrice = request.getParameter('bookPrice') ?: book.bookPrice
        book.bookEdition = request.getParameter('bookEdition') ?: book.bookEdition

        if (book.save(flush: true)) {
            result = [status: 'success', message: 'Book updated']
        } else {
            result = [status: 'fail', message: 'Validation failed', errors: book.errors.allErrors]
        }

        render(result as JSON)
    }


    def delUser() {
        Map result = [:]

        String email = request.getParameter("email")
        if (!email) {
            result = [status: 'fail', message: 'Email is required to delete user']
            render(result as JSON)
            return
        }

        User user = User.findByEmail(email)
        if (!user) {
            result = [status: 'fail', message: 'User not found']
            render(result as JSON)
            return
        }

        try {
            user.delete(flush: true)
            result = [status: 'success', message: 'User deleted']
        } catch (Exception e) {
            result = [status: 'fail', message: 'Error during deletion', error: e.message]
        }

        render(result as JSON)
    }


    def delBook() {
        Map result = [:]
        String bookName = request.getParameter('bookName')
        if (!bookName) {
            result = [status: 'fail', message: 'BOOK NAME is required to identify Book']
            render(result as JSON)
            return
        }

        Book book = Book.findByBookName(bookName)
        if (!book) {
            result = [status: 'fail', message: 'Book not found']
            render(result as JSON)
            return
        }
        try {
            book.delete(flush: true)
            result = [status: 'success', message: 'Book deleted']
        } catch (Exception e) {
            result = [status: 'fail', message: 'Error during deletion', error: e.message]
        }

        render(result as JSON)
    }


    def showUsers() {
        Map result = [:]

        List<User> users = User.list()

        result = [
                status: 'success',
                total : users.size(),
                users : users.collect { user ->
                    [
                            id       : user.id,
                            firstName: user.firstName,
                            lastName : user.lastName,
                            email    : user.email,
                            phone    : user.phone,
                            title    : user.title,
                            enabled  : user.enabled
                    ]
                }
        ]
        render(view: "showUsers", model: [users: users])

        render(result as JSON)
    }

    def showBooks() {
        Map result = [:]
        List<Book> books = Book.list()

        result = [
                status: 'success',
                total : books.size(),
                books : books.collect { book ->
                    [
                            id           : book.id,
                            bookName     : book.bookName,
                            bookAuthor   : book.bookAuthor,
                            bookPrice    : book.bookPrice,
                            bookAvailable: book.bookAvailable,
                            bookEdition  : book.bookEdition
                    ]
                }
        ]

        render(view: "showBooks", model: [books: books])

        render(result as JSON)
    }

    def beforeInterceptor = [action: this.&checkAdminSession]

    private def checkAdminSession() {
        if (!session.user || session.user.role != 'admin') {
            redirect(controller: "login", action: "index")
            return false
        }


    }

}