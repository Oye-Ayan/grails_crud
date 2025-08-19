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

//    def sendDailyReminderToDisabledUsers() {
//        log.info("Running daily email job for disabled users at ${new Date()}")
//        println("EmailSchedulerService triggered at ${new Date()}")
//
//        List<User> disabledUsers = User.findAllByEnabled(false)
//        disabledUsers.each { user ->
//            try {
//                mailService.sendMail {
//                    to user.email
//                    subject "We're still waiting for you 😊"
//                    body "Hi ${user.firstName},\n\nIt looks like your account isn't enabled yet."
//                }
//                log.info("Email sent to ${user.email}")
//            } catch (Exception e) {
//                log.error("Failed to send email to ${user.email}: ${e.message}")
//            }
//        }
//    }

    // Track offset per day
    private static int offset = 0
    private static Date lastResetDate = null

    def sendDailyReminderToDisabledUsers() {
        Date now = new Date()

        // Reset offset at 9:30 AM each day
        if (!lastResetDate || lastResetDate.clearTime() != now.clearTime()) {
            offset = 0
            lastResetDate = now
            log.info("Resetting email offset for new day: ${now}")
        }

        log.info("Running daily email job at ${now}, starting offset: ${offset}")

        // Fetch next 5 disabled users
        List<User> disabledUsers = User.findAllByEnabled(false, [max: 5, offset: offset])

        if (!disabledUsers) {
            log.info("No more disabled users left to email today.")
            return
        }

        disabledUsers.each { user ->
            try {
                mailService.sendMail {
                    to user.email
                    subject "We're still waiting for you 😊"
                    body "Hi ${user.firstName},\n\nIt looks like your account isn't enabled yet."
                }
                log.info("Email sent to ${user.email}")
            } catch (Exception e) {
                log.error("Failed to send email to ${user.email}: ${e.message}")
            }
        }

        // Move offset for next run
        offset += disabledUsers.size()
        log.info("Updated offset to ${offset}")
    }

    //
     def saveBook(
             String bookName,
             String bookAuthor,
             int bookEdition,
             double bookPrice,
             boolean bookAvailable){

         Book book = new Book(bookName: bookName, bookAuthor: bookAuthor, bookEdition: bookEdition, bookPrice: bookPrice, bookAvailable: bookAvailable )
         try {
             book.save(flush: true)
             return true
         } catch (Exception e) {
             log.error("Failed to Add Book: ${e.message}")
             return false
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
        try {
            book.save(flush: true)
            return true
        } catch (Exception e) {
            log.error("Failed to Update Book: ${e.message}")
            return false
        }
    }

    def delBook(String bookName) {
        if (!bookName) {
            return false
        }
        Book book = Book.findByBookName(bookName)
        if (!book) {
            return false
        }
        // Delete related purchases
        Purchase.findAllByBook(book)*.delete(flush: true)
        try {
            book.delete(flush: true)
            return true
        } catch (Exception e) {
            log.error("Error deleting book: ${e.message}")
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
    def addUser(
            String firstName,
            String lastName,
            String email,
            String phone,
            String title,
            String password,
            String role,
            boolean enabled
    ) {
        def existingUser = User.findByEmail(email)
        if (existingUser) {
            return [status: "Error", message: "User already exists with this email"]
        }
        User user = new User(firstName: firstName, lastName: lastName, email: email,
                phone: phone, title: title, password: password, role: role, enabled: enabled)
        try {
            user.save(flush: true)
            sendWelcomeEmail(user)

            return true
        } catch (Exception e) {
            log.error("Failed to Add User: ${e.message}")
            return false
        }
    }

    def updateUser(
            String email,
            String firstName,
            String lastName,
            String phone,
            String title,
            String password,
            String role,
            boolean enabled
    ) {

        if (!email) {
            return false
        }

        User user = User.findByEmail(email)
        if (!user) {
            return false
        }

        user.firstName = firstName ?: user.firstName
        user.lastName = lastName ?: user.lastName
        user.phone = phone ?: user.phone
        user.title = title ?: user.title
        user.password = password ?: user.password
        user.role = role ?: user.role
        user.enabled= enabled?: user.enabled
//        println(enabled)
        try {
            user.save(flush: true)
            return true
        } catch (Exception e) {
            log.error("Failed to Update User: ${e.message}")
            return false
        }
    }

    def delUser( String email){
        if(!email){
            return false
        }
        User user= User.findByEmail(email)
        if(!user){
            result = [status: 'failed', message: 'User not Found']
            return result
        }
        try {
            user.delete(flush: true)
            return true
        } catch (Exception e) {
            log.error("Error deleting user: ${e.message}")
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


