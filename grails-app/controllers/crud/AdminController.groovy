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
            render(view: 'addUser')
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
        try {adminService.addUser(firstName,lastName,email,phone,title,password,role,enabled)
            flash.message = "User has been Added successfully"
            redirect(action: "showUsers")
        } catch(Exception e) {
            result = [status: 'fail', message: 'Validation failed \n' +
                    ' Failed to Add a User', errors: e.message]
        }
        render(result as JSON)
    }



    def addBook() {
        Map result = [:]
        if (request.method == 'GET') {
            render(view: 'addBook')
            return
        }
       String bookName= request.getParameter('bookName')
        String bookAuthor= request.getParameter('bookAuthor')
        int bookEdition=request.getParameter('bookEdition').toInteger()
        double bookPrice= request.getParameter('bookPrice').toDouble()
        boolean bookAvailable= request.getParameter('bookAvailable').toBoolean()

        try {adminService.saveBook(bookName,bookAuthor,bookEdition,bookPrice,bookAvailable)
            flash.message = "Book has been Added successfully"
            redirect(action: "showBooks")
        } catch(Exception e) {
            result = [status: 'fail', message: 'Failed to add a book', errors: e.message]
            return result
        }
        render(result as JSON)
//        redirect(controller:"admin", action:"showBooks")
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
        Boolean enabled = request.getParameter('enabled')? request.getParameter('enabled').toBoolean() : user.enabled
        log.info("admin Enabled:$enabled")

        try {
            adminService.updateUser(email, firstName, lastName, phone, title, password, role, enabled)
            flash.message = "User has been updated successfully"
            redirect(action: "showUsers")
        } catch(Exception e) {
            result = [status: 'fail', message: 'Failed to Update User', errors: e.message]
        }
        render(result as JSON)

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
        int bookEdition=request.getParameter('bookEdition')?request.getParameter('bookEdition').toInteger():book.bookEdition
        double bookPrice= request.getParameter('bookPrice')?request.getParameter('bookPrice').toDouble():book.bookPrice
        Boolean bookAvailable= request.getParameter('bookAvailable')?request.getParameter('bookAvailable').toBoolean():book.bookAvailable
        println("admin Available status $bookAvailable")
        try {
            adminService.updateBook(bookName,bookAuthor,bookEdition,bookPrice,bookAvailable)
            flash.message = "Book has been updated successfully"
            redirect(action: "showBooks")
        }catch(Exception e) {
            result = [status: 'fail', message: 'Failed to Update Book', errors: e.message]
        }
        render(result as JSON)
//        redirect(controller:"admin", action: "showBooks")
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
            adminService.delUser(email)
            flash.message = "User has been deleted successfully"
            redirect(action: "showUsers")
        } catch (Exception e) {
            result = [status: 'fail', message: 'Error during deletion', error: e.message]
        }

        render(result as JSON)
        redirect(controller:"admin", action:"showUsers")
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
            flash.message = "Book Deleted successfully"
            redirect(action: "showBooks")
        } catch (Exception e) {
            result = [status: 'fail', message: 'Error during deletion', error: e.message]
        }

        render(result as JSON)
        redirect(controller:"admin", action:"showBooks")

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