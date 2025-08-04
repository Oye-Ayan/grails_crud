package library

import grails.converters.JSON

class AdminController {
    AdminService adminService

    def beforeInterceptor = [action: this.&checkAdminSession]

    private def checkAdminSession() {
        if (!session.user || session.user.role != 'admin') {
            redirect(controller: "auth", action: "index")
            return false
        }
        return true
    }

    def index() {
        render(view: "index")
    }

    def adminDashboard() {
        render(view: "adminDashboard")
    }

    def addUser() {
        Map result = [:]
        if (request.method == 'GET') {
            render(view: 'addUser')
            return
        }
        String firstName = request.getParameter('firstName')
        String lastName = request.getParameter('lastName')
        String email = request.getParameter('email')
        String phone = request.getParameter('phone')
        String title = request.getParameter('title')
        String password = request.getParameter('password')
        String role = request.getParameter('role')
        result = adminService.saveUser(firstName, lastName, email, phone, title, password, role)
        render(result as JSON)
    }

    def addBook() {
        Map result = [:]
        if (request.method == 'GET') {
            render(view: 'addBook')
            return
        }
        String bookName = request.getParameter('bookName')
        String bookAuthor = request.getParameter('bookAuthor')
        int bookEdition = request.getParameter('bookEdition')?.toInteger() ?: 1
        double bookPrice = request.getParameter('bookPrice')?.toDouble() ?: 0.0
        boolean bookAvailable = request.getParameter('bookAvailable')?.toBoolean() ?: true
        result = adminService.saveBook(bookName, bookAuthor, bookEdition, bookPrice, bookAvailable)
        render(result as JSON)
    }

    def updateUser() {
        Map result = [:]
        String email = request.getParameter("email")
        if (!email) {
            result = [status: 'Fail', message: 'Email is required to identify user']
            render(result as JSON)
            return
        }
        String firstName = request.getParameter("firstName")
        String lastName = request.getParameter("lastName")
        String phone = request.getParameter("phone")
        String title = request.getParameter("title")
        String password = request.getParameter("password")
        String role = request.getParameter("role")
        result = adminService.updateUser(email, firstName, lastName, phone, title, password, role)
        render(result as JSON)
    }

    def updateBook() {
        Map result = [:]
        String bookName = request.getParameter('bookName')
        if (!bookName) {
            result = [status: 'Fail', message: 'Book Name is required to identify Book']
            render(result as JSON)
            return
        }
        String bookAuthor = request.getParameter('bookAuthor')
        int bookEdition = request.getParameter('bookEdition')?.toInteger() ?: 0
        double bookPrice = request.getParameter('bookPrice')?.toDouble() ?: 0.0
        boolean bookAvailable = request.getParameter('bookAvailable')?.toBoolean() ?: true
        result = adminService.updateBook(bookName, bookAuthor, bookEdition, bookPrice, bookAvailable)
        render(result as JSON)
    }

    def delUser() {
        Map result = [:]
        String email = request.getParameter("email")
        if (!email) {
            result = [status: 'Fail', message: 'Email is required to delete user']
            render(result as JSON)
            return
        }
        result = adminService.delUser(email)
        render(result as JSON)
    }

    def delBook() {
        Map result = [:]
        String bookName = request.getParameter('bookName')
        if (!bookName) {
            result = [status: 'Fail', message: 'Book Name is required to identify Book']
            render(result as JSON)
            return
        }
        result = adminService.delBook(bookName)
        render(result as JSON)
    }

    def showUsers() {
        Map result = adminService.showUsers()
        render(result as JSON)
    }

    def showBooks() {
        Map result = adminService.showBooks()
        render(result as JSON)
    }
}