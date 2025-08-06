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
                boolean enabled=request.getParameter('enabled').toBoolean()
//        User user=adminService.saveUser(firstName,lastName,email,phone,title,password,role)
        println(enabled)
        if (adminService.saveUser(firstName,lastName,email,phone,title,password,role,enabled)) {

            result=[status: 'success', message: "User Added"]

        } else {
            result = [status: 'fail', message: 'Validation failed \n' +
                    ' All fields are required']

        }
        render(result as JSON)
        render(view: 'showUsers')

    }



    def addBook() {
        Map result = [:]
        if (request.method == 'GET') {
            render(view: 'addBook') // Show the form
            return
        }
       String bookName= request.getParameter('bookName')
        String bookAuthor= request.getParameter('bookAuthor')
        int bookEdition=request.getParameter('bookEdition').toInteger()
        double bookPrice= request.getParameter('bookPrice').toDouble()
        boolean bookAvailable= request.getParameter('bookAvailable').toBoolean()

        if (adminService.saveBook(bookName,bookAuthor,bookEdition,bookPrice,bookAvailable)) {
            result = [status: 'success', message: 'Book Added']
        } else {
            result = [status: 'fail', message: 'Validation failed \n All fields are required']
        }
        render(result as JSON)
        render(view: 'showBooks')
    }


    def updateUser() {
        Map result = [:]
        if (request.method == 'GET') {
            render(view: 'updateUser')
            return
        }
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
        Boolean enabled=request.getParameter('enabled')?:user.enabled
        log.info("admin Enabled:$enabled")

        if (adminService.updateUser(email, firstName, lastName, phone, title, password, role, enabled)) {
            result = [status: 'success', message: 'User updated']
        } else {
            result = [status: 'fail', message: 'Validation failed', errors: user.errors.allErrors]
        }
//        render(result as JSON)
        redirect(controller:"admin", action:"showUsers")
    }

    def updateBook() {
        Map result = [:]
        if (request.method == 'GET') {
            render(view: 'updateBook')
            return
        }
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
        int bookEdition=request.getParameter('bookEdition')?request.getParameter('bookEdition').toLong():book.bookEdition
        double bookPrice= request.getParameter('bookPrice')?request.getParameter('bookPrice').toDouble():book.bookPrice
        Boolean bookAvailable= request.getParameter('bookAvailable')?request.getParameter('bookAvailable').toBoolean():book.bookAvailable
        println("admin Available status $bookAvailable")
        try {
            adminService.updateBook(bookName,bookAuthor,bookEdition,bookPrice,bookAvailable)

            result = [status: 'success', message: 'Book updated']
        }catch(Exception e) {
            result = [status: 'fail', message: 'Validation failed', errors: e.message]
        }
//        render(result as JSON)
        redirect(controller:"admin", action: "showBooks")    }


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