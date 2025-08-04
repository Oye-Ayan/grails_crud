package library

import grails.transaction.Transactional

@Transactional
class UserService {

    def changePassword(Long userId, String oldPassword, String newPassword) {
        Map result = [:]
        def user = User.get(userId)
        if (!user) {
            result = [status: 'Error', message: 'User not found']
            return result
        }
        if (user.password == oldPassword) {
            user.password = newPassword
            if (user.save(flush: true)) {
                result = [status: 'Success', message: 'Password changed']
            } else {
                result = [status: 'Error', message: 'Failed to save new password']
            }
        } else {
            result = [status: 'Error', message: 'Incorrect old password']
        }
        return result
    }

    def purchaseBook(Long userId, Long bookId) {
        Map result = [:]
        def user = User.get(userId)
        def book = Book.get(bookId)
        if (!user || !book) {
            result = [status: 'Error', message: 'User or book not found']
            return result
        }
        if (!book.bookAvailable) {
            result = [status: 'Error', message: 'Book is not available']
            return result
        }
        def purchase = new Purchase(user: user, book: book)
        if (purchase.save(flush: true)) {
            if (!user.purchasedBooks.contains(book)) {
                user.addToPurchasedBooks(book)
                user.save(flush: true)
            }
            result = [status: 'Success', message: "Book '${book.bookName}' purchased successfully!"]
        } else {
            result = [status: 'Error', message: 'Failed to save purchase']
        }
        return result
    }

    def getMyPurchases(Long userId) {
        Map result = [:]
        def purchases = Purchase.findAllByUser(User.get(userId))
        result = [
                status: 'Success',
                total: purchases.size(),
                purchases: purchases.collect { purchase ->
                    [
                            id: purchase.id,
                            book: [
                                    id: purchase.book.id,
                                    bookName: purchase.book.bookName,
                                    bookAuthor: purchase.book.bookAuthor,
                                    bookPrice: purchase.book.bookPrice,
                                    bookAvailable: purchase.book.bookAvailable,
                                    bookEdition: purchase.book.bookEdition
                            ],
                            dateCreated: purchase.dateCreated
                    ]
                }
        ]
        if (!purchases) {
            result = [status: 'Error', message: 'No purchases found', total: 0, purchases: []]
        }
        return result
    }

    def getMyBooks(Long userId) {
        Map result = [:]
        def user = User.get(userId)
        def books = user?.purchasedBooks ?: []
        result = [
                status: 'Success',
                total: books.size(),
                books: books.collect { book ->
                    [
                            id: book.id,
                            bookName: book.bookName,
                            bookAuthor: book.bookAuthor,
                            bookPrice: book.bookPrice,
                            bookAvailable: book.bookAvailable,
                            bookEdition: book.bookEdition
                    ]
                }
        ]
        if (!books) {
            result = [status: 'Error', message: 'No books purchased', total: 0, books: []]
        }
        return result
    }

    def getBooksSortedByPopularity(Long userId) {
        Map result = [:]
        def user = User.get(userId)
        def topBooksQuery = Purchase.createCriteria().list {
            projections {
                groupProperty("book")
                count("id", 'purchaseCount')
            }
            order("purchaseCount", "desc")
        }
        def topBooksList = topBooksQuery.collect { row ->
            def book = row[0]
            def count = row[1]
            [
                    book: [
                            id: book.id,
                            bookName: book.bookName,
                            bookAuthor: book.bookAuthor,
                            bookPrice: book.bookPrice,
                            bookAvailable: book.bookAvailable,
                            bookEdition: book.bookEdition
                    ],
                    count: count
            ]
        }
        def userPurchased = user?.purchasedBooks ?: []
        def sorted = topBooksList.sort { a, b ->
            def aInUser = userPurchased.contains(a.book) ? 0 : 1
            def bInUser = userPurchased.contains(b.book) ? 0 : 1
            aInUser <=> bInUser
        }
        result = [
                status: 'Success',
                total: sorted.size(),
                topBooks: sorted
        ]
        if (!sorted) {
            result = [status: 'Error', message: 'No books available', total: 0, topBooks: []]
        }
        return result
    }
}