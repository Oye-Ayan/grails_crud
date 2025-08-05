package crud

import grails.transaction.Transactional

@Transactional
class UserService {

    def changePassword(Long userId,String oldPassword, String newPassword) {
        def user = User.get(userId)
        if (!user) {
            return [status: 'Error', message: 'User not found']
        }

        if (user.password == oldPassword) {
            user.password = newPassword
            user.merge(flush: true)
            return [status: 'Success', message: 'Password changed']
        } else {
            return [status: 'Error', message: 'Incorrect old password']
        }
    }

    def purchaseBook(Long userId, Long bookId) {
        def user = User.get(userId)
        def book = Book.get(bookId)

        if (!user || !book) {
            return [status: 'Error', message: 'User or book not found']
        }

        // Always record purchase (even if already purchased)
        def purchase = new Purchase(user: user, book: book)
        purchase.save(flush: true)

        // But only add to the user's purchasedBooks list once
        if (!user.purchasedBooks.contains(book)) {
            user.addToPurchasedBooks(book)
            user.save(flush: true)
        }

        return [status: 'Success', message: "Book '${book.bookName}' purchased successfully!"]
    }

    def getMyPurchases(Long userId) {
        return Purchase.findAllByUser(User.get(userId))
    }


    def getMyBooks(Long userId) {
        def user = User.get(userId)
        return user?.purchasedBooks ?: []
    }



/////
//////// FROM GPT
//

    def getBooksSortedByPopularity() {
        def topBooksQuery = Purchase.createCriteria().list {
            projections {
                groupProperty("book")
                count("id", 'purchaseCount')
            }
            order("purchaseCount", "desc") // most purchased first
        }

        def topBooksList = topBooksQuery.collect { row ->
            def book = row[0]
            def count = row[1]
            return [book: book, count: count]
        }

        return topBooksList
    }


}
