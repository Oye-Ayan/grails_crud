package crud

import grails.converters.JSON

class AdminController {
    AdminService adminService


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
                String firstName = request.getParameter('firstName')
                String lastName=request.getParameter('lastName')
                String email= request.getParameter('email')
                String phone= request.getParameter('phone')
                String title= request.getParameter('title')
                String password=request.getParameter('password')
                String role= request.getParameter('role')
//        User user=adminService.saveUser(firstName,lastName,email,phone,title,password,role)
        if (adminService.saveUser(firstName,lastName,email,phone,title,password,role)) {
            result=[status: 'success', message: "User Added"]

        } else {
            result = [status: 'fail', message: 'Validation failed']

        }
        render(result as JSON)

    }



    def addBook() {
        Map result = [:]
       String bookName= request.getParameter('bookName')
        String bookAuthor= request.getParameter('bookAuthor')
        int bookEdition=request.getParameter('bookEdition').toLong()
        double bookPrice= request.getParameter('bookPrice').toDouble()
        boolean bookAvailable= request.getParameter('bookAvailable')

        if (adminService.saveBook(bookName,bookAuthor,bookEdition,bookPrice,bookAvailable)) {
            result = [status: 'success', message: 'Book Added']
        } else {
            result = [status: 'fail', message: 'Validation failed']
        }

        render(view: 'addBook')
    }

//    def addBook() {
//        if (request.method == 'GET') {
//            render(view: 'addBook')
//            return
//        }
//
//        // POST: save book
//        Book book = new Book(
//                bookName: params.bookName,
//                bookAuthor: params.bookAuthor,
//                bookEdition: params.bookEdition,
//                bookPrice: params.bookPrice,
//                bookAvailable: params.bookAvailable,
//        )
//
//        if (book.save(flush: true)) {
//            flash.message = "Book added successfully"
////            render(result as JSON)
//            redirect(action: 'showBooks')
//        } else {
//            render(result as JSON)
//            render(view: 'addBook', model: [book: book])
//        }
//    }


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

        String firstName = request.getParameter("firstName") ?: user.firstName
        String lastName = request.getParameter("lastName") ?: user.lastName
        String phone = request.getParameter("phone") ?: user.phone
        String title = request.getParameter("title") ?: user.title
        String password = request.getParameter("password") ?: user.password
        String role = request.getParameter("role") ?: user.role


        if (adminService.updateUser(email, firstName, lastName, phone, title, password, role)) {
            result = [status: 'success', message: 'User updated']
        } else {
            result = [status: 'fail', message: 'Validation failed', errors: user.errors.allErrors]
        }

        render(view: 'updateUser')
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
        String bookAuthor= request.getParameter('bookAuthor')?:book.bookAuthor
        int bookEdition=request.getParameter('bookEdition').toLong()?:book.bookEdition
        println(bookEdition)
        double bookPrice= request.getParameter('bookPrice').toDouble()?:book.bookPrice
        boolean bookAvailable= request.getParameter('bookAvailable')?:book.bookAvailable

        try {
            adminService.updateBook(bookName,bookAuthor,bookEdition,bookPrice,bookAvailable)
            result = [status: 'success', message: 'Book updated']
        }catch(Exception e) {
            result = [status: 'fail', message: 'Validation failed', errors: e.message]
        }

        render(view: 'updateBook')    }


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
            adminService.delUser(email)
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
            adminService.delBook(bookName)
            result = [status: 'success', message: 'Book deleted']
        } catch (Exception e) {
            result = [status: 'fail', message: 'Error during deletion', error: e.message]
        }

        render(result as JSON)
    }


    def showUsers() {
        Map result = adminService.showUsers()
        [users: result.users]
    }

    def showBooks() {
        Map result = adminService.showBooks()
        [books: result.books]
    }

    def beforeInterceptor = [action: this.&checkAdminSession]

    private def checkAdminSession() {
        if (!session.user || session.user.role != 'admin') {
            redirect(controller: "login", action: "index")
            return false
        }


    }

}