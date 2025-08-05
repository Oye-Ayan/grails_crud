package crud

import grails.transaction.Transactional


@Transactional
class AdminService {


    def mailService

    def sendWelcomeEmail(User user) {
        mailService.sendMail {
            to user.email
            subject "Welcome to Our Platform"
            body "Hi ${user.firstName},\n\nWelcome! Your account is ready.\n"
        }
    }
     def saveBook(
             String bookName,
             String bookAuthor,
             int bookEdition,
             double bookPrice,
             boolean bookAvailable){

         Book book = new Book(bookName: bookName, bookAuthor: bookAuthor, bookEdition: bookEdition, bookPrice: bookPrice, bookAvailable: bookAvailable )

         if (book.save(flush: true)) {
            return true
         } else {
         }

     }

    def updateBook(
            String bookName,
            String bookAuthor,
            int bookEdition,
            double bookPrice,
            boolean bookAvailable
    ){
        if(!bookName){
            return false
        }
        Book book=Book.findByBookName(bookName)
        if(!book){
            return false
        }
        book.bookAuthor= bookAuthor?: book.bookAuthor
        book.bookEdition= bookEdition?: book.bookEdition
        book.bookPrice=bookPrice?: book.bookPrice
        book.bookAvailable=bookAvailable?: book.bookAvailable
        if(book.save(flush:true)){
            return true
        }
        else
            return false
    }


    def delBook(
            String bookName
    ){  Map result=[:]
        if(!bookName){
            result=[status: 'fail', message: 'Book not Found']
            return false
        }
        Book book = Book.findByBookName(bookName)
        if(!book){
            result=[status:'Fail', message: 'Book not found']
            return false
        }
        if (book.delete(flush: true)){
            return true
        }
        else{
            return false
        }


    }

    def showBooks(){
        List<Book> books= Book.list()
        Map result =[
                status: 'Success',
                total : books.size(),
                books : books.collect { book ->
                    [
                            id           : book.id,
                            bookName     : book.bookName,
                            bookAuthor   : book.bookAuthor,
                            bookPrice    : book.bookPrice,
                            bookAvailable: book.bookAvailable,
                            bookEdition  : book.bookEdition
                    ]
                }
        ]
        return result
    }




    def saveUser(
            String firstName,
            String lastName,
            String email,
            String phone,
            String title,
            String password,
            String role
    ) {
        User user = new User(firstName: firstName, lastName: lastName, email: email,
                phone: phone, title: title, password: password, role: role)

        if (user.save(flush: true)) {
            sendWelcomeEmail(user)
            return true
        } else {
            user.errors.allErrors.each {
                println it.defaultMessage
            }
            return null
        }
    }



    def updateUser(
            String email,
            String firstName,
            String lastName,
            String phone,
            String title,
            String password,
            String role) {

        if (!email) {
            result = [status: 'fail', message: 'Email is required to identify user']
            return false
        }

        User user = User.findByEmail(email)
        if (!user) {
            result = [status: 'fail', message: 'User not found']
            return false
        }

        user.firstName = firstName ?: user.firstName
        user.lastName = lastName ?: user.lastName
        user.phone = phone ?: user.phone
        user.title = title ?: user.title
        user.password = password ?: user.password
        user.role = role ?: user.role

        if (user.save(flush: true)) {
            return true
        } else {
            result = [status: 'fail', message: 'Validation failed', errors: user.errors.allErrors]
            return false
        }
    }

    def delUser( String email){
        if(!email){
            result=[status: 'Failed', message: 'Email Not Found']
            return false
        }
        User user= User.findByEmail(email)
        if(!user){
            result=[status:'Failed', message: 'User not Found']
        }
        if(user.delete(flush: true)){
            return true
        }
        else{
            return false
        }
    }


    def showUsers() {
        List<User> users = User.list()
        if (!users) {
            return [status: 'Error', message: 'No users found', total: 0, users: []]
        }
        Map result= [
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
        return result
    }









}


