package crud
import com.ericsson.schemas.vas.AddUserRequest
import com.ericsson.schemas.vas.AddUserResponse
import com.ericsson.schemas.vas.AdminPortType
import org.grails.cxf.utils.GrailsCxfEndpoint
import grails.transaction.Transactional


@Transactional
@GrailsCxfEndpoint()
class AdminSoapService implements AdminPortType {

    AdminService adminService

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
                false // set enabled default to true
        )

        if (success) {
            response.status = "User Saved Successfully"
        } else {
            response.status = "User Save Failed"
        }
        return response
    }
}