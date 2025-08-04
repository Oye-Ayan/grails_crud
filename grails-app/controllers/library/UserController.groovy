package library

import grails.converters.JSON

class UserController {
    UserService userService

    def beforeInterceptor = [action: this.&checkUserSession, except: ['index']]

    private def checkUserSession() {
        if (!session.user || session.user.role != 'user') {
            redirect(controller: 'auth', action: 'index')
            return false
        }
        return true
    }

    def index() {
        render(view: "index")
    }

    def userDashboard() {
        render(view: "userDashboard")
    }

    def booksList() {
        Map result = adminService.showBooks()
        render(result as JSON)
    }

    def changePassword() {
        Map result = [:]
        def sessionUser = session.user
        String oldPassword = request.getParameter('oldPassword')
        String newPassword = request.getParameter('newPassword')
        result = userService.changePassword(sessionUser.id, oldPassword, newPassword)
        render(result as JSON)
    }

    def purchaseBook() {
        Map result = [:]
        def sessionUser = session.user
        def bookId = request.getParameter('bookId')?.toLong()
        if (!bookId) {
            result = [status: 'Fail', message: 'Book ID is required']
            render(result as JSON)
            return
        }
        result = userService.purchaseBook(sessionUser.id, bookId)
        render(result as JSON)
    }

    def myPurchases() {
        Map result = userService.getMyPurchases(session.user.id)
        render(result as JSON)
    }

    def myBooks() {
        Map result = userService.getMyBooks(session.user.id)
        render(result as JSON)
    }

    def booksSortedByPopularity() {
        Map result = userService.getBooksSortedByPopularity(session.user.id)
        render(result as JSON)
    }
}