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
        try {
            def success = adminService.addUser(
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
        } catch (Exception e) {
            log.error("Error in addUser: ${e.message}", e)
            response.status = "Error while saving user"
        }
        return response
    }

    @Override
    DelUserResponse delUser(DelUserRequest request) {
        DelUserResponse response = new DelUserResponse()
        try {
            if (!request?.email) {
                response.status = "Email is required"
                return response
            }
            def success = adminService.delUser(request.email)
            response.status = success ? "User deleted" : "Failed to delete user"
        } catch (Exception e) {
            log.error("Error in delUser: ${e.message}", e)
            response.status = "Error while deleting user"
        }
        return response
    }

    @Override
    DelBookResponse delBook(DelBookRequest request) {
        DelBookResponse response = new DelBookResponse()
        try {
            if (!request?.bookName) {
                response.status = "Book name is required"
                return response
            }
            def success = adminService.delBook(request.bookName)
            response.status = success ? "Book Deleted Successfully" : "Book Not Found"
        } catch (Exception e) {
            log.error("Error in delBook: ${e.message}", e)
            response.status = "Error while deleting book"
        }
        return response
    }

    @Override
    UpdateUserResponse updateUser(UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse()
        try {
            if (!request?.email) {
                response.status = "Email is required"
                return response
            }
            def success = adminService.updateUser(
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
        } catch (Exception e) {
            log.error("Error in updateUser: ${e.message}", e)
            response.status = "Error while updating user"
        }
        return response
    }

    @Override
    UpdateBookResponse updateBook(UpdateBookRequest request) {
        UpdateBookResponse response = new UpdateBookResponse()
        try {
            if (!request?.bookName) {
                response.status = "Book name is required"
                return response
            }
            def success = adminService.updateBook(
                    request.bookName,
                    request.bookAuthor,
                    request.bookEdition,
                    request.bookPrice,
                    request.bookAvailable
            )
            response.status = success ? "Book Updated Successfully" : "Book Update Failed"
        } catch (Exception e) {
            log.error("Error in updateBook: ${e.message}", e)
            response.status = "Error while updating book"
        }
        return response
    }

    @Override
    ShowBooksResponse showBooks(ShowBooksRequest request) {
        ShowBooksResponse response = new ShowBooksResponse()
        try {
            def result = adminService.showBooks()
            response.books = result?.books ?: []
        } catch (Exception e) {
            log.error("Error in showBooks: ${e.message}", e)
            response.books = []
        }
        return response
    }

    @Override
    ShowUsersResponse showUsers(ShowUsersRequest request) {
        ShowUsersResponse response = new ShowUsersResponse()
        try {
            def result = adminService.showUsers()
            response.users = result?.users ?: []
        } catch (Exception e) {
            log.error("Error in showUsers: ${e.message}", e)
            response.users = []
        }
        return response
    }

    @Override
    SaveBookResponse saveBook(SaveBookRequest request) {
        SaveBookResponse response = new SaveBookResponse()
        try {
            if (!request?.bookName) {
                response.status = "Book name is required"
                return response
            }
            def success = adminService.saveBook(
                    request.bookName,
                    request.bookAuthor,
                    request.bookEdition,
                    request.bookPrice,
                    request.bookAvailable
            )
            response.status = success ? "Book Saved Successfully" : "Book Save Failed"
        } catch (Exception e) {
            log.error("Error in saveBook: ${e.message}", e)
            response.status = "Error while saving book"
        }
        return response
    }

    @Override
    GetUserPurchasesResponse getUserPurchases(GetUserPurchasesRequest request) {
        GetUserPurchasesResponse response = new GetUserPurchasesResponse()
        try {
            if (!request?.email) {
                response.status = "Email is required"
                return response
            }

            String emailNorm = request.email.trim().toLowerCase()
            def user = User.find("from User where lower(email) = :e", [e: emailNorm])

            if (!user) {
                response.status = "User Not Found"
                return response
            }

            response.status    = "Success"
            response.userId    = user.id
            response.firstName = user.firstName
            response.lastName  = user.lastName
            response.email     = user.email
            response.phone     = user.phone
            response.title     = user.title
            response.enabled   = user.enabled

            // purchased books
            List books = userService.getMyBooks(user.id) ?: []
            books.each { book ->
                response.purchasedBook.add(book.bookName ?: "")
            }

        } catch (Exception e) {
            log.error("Error in getUserPurchases: ${e.message}", e)
            response.status = "Error while fetching user purchases"
        }
        return response
    }
}
