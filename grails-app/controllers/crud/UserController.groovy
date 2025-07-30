package crud

class UserController {

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


//    def changePassword() {
//        def user = session.user
//        if (!user) {
//            redirect(controller: "login", action: "index")
//            return
//        }
//
//        String oldPass = params.oldPassword
//        String newPass = params.newPassword
//
//        if (user.password == oldPass) {
//            user.password = newPass
//            user.save(flush: true)
//            flash.message = "Password changed"
//        } else {
//            flash.message = "Incorrect old password"
//        }
//
//        redirect(action: "userDashboard")
//    }
//
//    def beforeInterceptor = [action: this.&checkUserSession]

    def changePassword() {
        def sessionUser = session.user
        if (!sessionUser) {
            redirect(controller: "login", action: "index")
            return
        }

        def user = User.get(sessionUser.id) // Safely fetch a fresh copy from DB

        String oldPass = params.oldPassword
        String newPass = params.newPassword

        if (user.password == oldPass) {
            user.password = newPass
            user.merge(flush: true) // ✅ Use merge to avoid identity conflict
            flash.message = "Password changed"
        } else {
            flash.message = "Incorrect old password"
        }

        redirect(action: "userDashboard")
    }

//    private def checkUserSession() {
//        if (!session.user || session.user.role != 'user') {
//            redirect(controller: "login", action: "index")
//            return false
//        }
//    }

    def purchaseBook() {
        def sessionUser = session.user
        if (!sessionUser) {
            redirect(controller: "login", action: "index")
            return
        }

        def user = User.get(sessionUser.id)
        def bookId = params.bookId as Long
        def book = Book.get(bookId)

        if (book && !user.purchasedBooks.contains(book)) {
            user.addToPurchasedBooks(book)
            user.save(flush: true)
            flash.message = "Book '${book.bookName}' purchased successfully!"
        } else {
            flash.message = "Book already purchased or not found!"
        }

        redirect(action: "booksList")
    }


    def myBooks() {
        def sessionUser = session.user
        if (!sessionUser) {
            redirect(controller: "login", action: "index")
            return
        }

        def user = User.get(sessionUser.id)
        def myBooks = user.purchasedBooks
        render(view: "myBooks", model: [books: myBooks])
    }


}
