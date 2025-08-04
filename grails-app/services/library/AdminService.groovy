package library

import grails.transaction.Transactional

@Transactional
class AdminService {

    def saveBook(String bookName, String bookAuthor, int bookEdition, double bookPrice, boolean bookAvailable) {
        Map result = [:]
        Book book = new Book(bookName: bookName, bookAuthor: bookAuthor, bookEdition: bookEdition, bookPrice: bookPrice, bookAvailable: bookAvailable)

        if (book.save(flush: true)) {
            result = [status: 'Success', message: 'Book added successfully']
        } else {
            result = [status: 'Fail', message: 'Validation failed', errors: book.errors.allErrors]
        }
        return result
    }

    def updateBook(String bookName, String bookAuthor, int bookEdition, double bookPrice, boolean bookAvailable) {
        Map result = [:]
        if (!bookName) {
            result = [status: 'Fail', message: 'Book Name is required']
            return result
        }
        Book book = Book.findByBookName(bookName)
        if (!book) {
            result = [status: 'Fail', message: 'Book Not Found']
            return result
        }
        book.bookAuthor = bookAuthor ?: book.bookAuthor
        book.bookEdition = bookEdition ?: book.bookEdition
        book.bookPrice = bookPrice ?: book.bookPrice
        book.bookAvailable = bookAvailable ?: book.bookAvailable
        if (book.save(flush: true)) {
            result = [status: 'Success', message: 'Book updated successfully']
        } else {
            result = [status: 'Fail', message: 'Validation failed', errors: book.errors.allErrors]
        }
        return result
    }

    def delBook(String bookName) {
        Map result = [:]
        if (!bookName) {
            result = [status: 'Fail', message: 'Book Name is required']
            return result
        }
        Book book = Book.findByBookName(bookName)
        if (!book) {
            result = [status: 'Fail', message: 'Book not found']
            return result
        }
        book.delete(flush: true)
        result = [status: 'Success', message: 'Book deleted successfully']
        return result
    }

    def showBooks() {
        List<Book> books = Book.list()
        Map result = [
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
        return result
    }

    def saveUser(String firstName, String lastName, String email, String phone, String title, String password, String role) {
        Map result = [:]
        User user = new User(firstName: firstName, lastName: lastName, email: email, phone: phone, title: title, password: password, role: role)

        if (user.save(flush: true)) {
            result = [status: 'Success', message: 'User added successfully']
        } else {
            result = [status: 'Fail', message: 'Validation failed', errors: user.errors.allErrors]
        }
        return result
    }

    def updateUser(String email, String firstName, String lastName, String phone, String title, String password, String role) {
        Map result = [:]
        if (!email) {
            result = [status: 'Fail', message: 'Email is required to identify user']
            return result
        }
        User user = User.findByEmail(email)
        if (!user) {
            result = [status: 'Fail', message: 'User not found']
            return result
        }
        user.firstName = firstName ?: user.firstName
        user.lastName = lastName ?: user.lastName
        user.phone = phone ?: user.phone
        user.title = title ?: user.title
        user.password = password ?: user.password
        user.role = role ?: user.role
        if (user.save(flush: true)) {
            result = [status: 'Success', message: 'User updated successfully']
        } else {
            result = [status: 'Fail', message: 'Validation failed', errors: user.errors.allErrors]
        }
        return result
    }

    def delUser(String email) {
        Map result = [:]
        if (!email) {
            result = [status: 'Fail', message: 'Email is required']
            return result
        }
        User user = User.findByEmail(email)
        if (!user) {
            result = [status: 'Fail', message: 'User not found']
            return result
        }
        user.delete(flush: true)
        result = [status: 'Success', message: 'User deleted successfully']
        return result
    }

    def showUsers() {
        List<User> users = User.list()
        Map result = [
                status: 'Success',
                message: 'Users retrieved successfully',
                total: users.size(),
                users: users.collect { user ->
                    [
                            id: user.id,
                            firstName: user.firstName,
                            lastName: user.lastName,
                            email: user.email,
                            phone: user.phone,
                            title: user.title,
                            enabled: user.enabled
                    ]
                }
        ]
        if (!users) {
            result = [status: 'Error', message: 'No users found', total: 0, users: []]
        }
        return result
    }
}