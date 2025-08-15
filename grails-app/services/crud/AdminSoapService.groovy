package crud
import com.ericsson.schemas.vas.*
import org.grails.cxf.utils.GrailsCxfEndpoint
import grails.transaction.Transactional

@Transactional
@GrailsCxfEndpoint()
class AdminSoapService implements AdminPortType {

    AdminService adminService
    UserService userService

    @Override
    AddUserResponse addUser(AddUserRequest addUserRequest) {
        AddUserResponse response = new AddUserResponse()

        boolean success = adminService.addUser(
                addUserRequest.firstName,
                addUserRequest.lastName,
                addUserRequest.email,
                addUserRequest.phone,
                addUserRequest.title,
                addUserRequest.password,
                addUserRequest.role,
                false
        )

        response.status = success ? "User Saved Successfully" : "User Save Failed"
        return response
    }

    @Override
    DelUserResponse delUser(DelUserRequest request) {
        DelUserResponse response = new DelUserResponse()
        println("Printting $request")
        println("Printting email $request.email")
        boolean success = adminService.delUser(request.email)
            println("succes is $success")
            if(success){
                response.status="User deleted"
            } else{
                response.status="failed to delete user"
            }
        return response
    }

    @Override
    DelBookResponse delBook(DelBookRequest request) {
        DelBookResponse response = new DelBookResponse()
        boolean success = adminService.delBook(request.bookName)
        response.status = success ? "Book Deleted Successfully" : "Book Not Found"
        return response
    }

    @Override
    UpdateUserResponse updateUser(UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse()
        boolean success = adminService.updateUser(
                request.email,
                request.firstName,
                request.lastName,
                request.phone,
                request.title,
                request.password,
                request.role,
                request.enabled
        )
        response.status = success ? "User Updated Successfully" : "User Update Failed"
        return response
    }

    @Override
    UpdateBookResponse updateBook(UpdateBookRequest request) {
        UpdateBookResponse response = new UpdateBookResponse()
        boolean success = adminService.updateBook(
                request.bookName,
                request.bookAuthor,
                request.bookEdition,
                request.bookPrice,
                request.bookAvailable
        )
        response.status = success ? "Book Updated Successfully" : "Book Update Failed"
        return response
    }

    @Override
    ShowBooksResponse showBooks(ShowBooksRequest request) {
        ShowBooksResponse response = new ShowBooksResponse()
        List<String> books = adminService.showBooks()
        response.books = books ?: []
        return response
    }

    @Override
    ShowUsersResponse showUsers(ShowUsersRequest request) {
        ShowUsersResponse response = new ShowUsersResponse()
        List<String> users = adminService.showUsers()
        response.users = users ?: []
        return response
    }

    @Override
    SaveBookResponse saveBook(SaveBookRequest request) {
        SaveBookResponse response = new SaveBookResponse()
        boolean success = adminService.saveBook(
                request.bookName,
                request.bookAuthor,
                request.bookEdition,
                request.bookPrice,
                request.bookAvailable
        )
        response.status = success ? "Book Saved Successfully" : "Book Save Failed"
        return response
    }

    @Override
    GetUserPurchasesResponse getUserPurchases(GetUserPurchasesRequest request) {
        GetUserPurchasesResponse response = new GetUserPurchasesResponse()

        if (!request?.email) {
            response.status = "Error: Email is required"
            return response
        }

        String emailNorm = request.email.trim().toLowerCase()
        def user = User.find("from User where lower(email) = :e", [e: emailNorm])

        if (!user) {
            response.status = "User Not Found"
            return response
        }

        response.status = "Success"
        response.userId = user.id
        response.firstName = user.firstName
        response.lastName  = user.lastName
        response.email     = user.email
        response.phone     = user.phone
        response.title     = user.title
        response.enabled   = user.enabled
        // Get user's purchased books
        List books = userService.getMyBooks(user.id) ?: []
        books.each { book ->
            response.purchasedBook.add(book.bookName ?: "")
        }
        return response
    }
}
