package crud

class UserController {
    UserService userService

    def beforeInterceptor = [action: this.&checkUserSession, except: ['index']]

    private def checkUserSession() {
        if (!session.user || session.user.role != 'user') {
            redirect(controller: 'login', action: 'index')
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
        def books = Book.list()
        render(view: "booksList", model: [books: books])
    }




    def changePassword() {
        def sessionUser = session.user
        String oldPassword=request.getParameter('oldPassword')
        String newPassword=request.getParameter('newPassword')

        def result = userService.changePassword(sessionUser.id,oldPassword, newPassword)
        flash.message = result.message
        redirect(action: 'userDashboard')
    }


    def purchaseBook() {
        def sessionUser = session.user
        def bookId = request.getParameter('bookId') as Long

        def result = userService.purchaseBook(sessionUser.id, bookId)
        flash.message = result.message
        redirect(action: 'booksList')
    }

    def myPurchases() {
        def sessionUser = session.user
        def purchases = userService.getMyPurchases(sessionUser.id)
        def topBooks = userService.getBooksSortedByPopularity()

        render(view: "myPurchases", model: [purchases: purchases, topBooks: topBooks])
    }



    def myBooks() {
        def sessionUser = session.user
        def myBooks = userService.getMyBooks(sessionUser.id)
        render(view: "myBooks", model: [books: myBooks])
    }


}
