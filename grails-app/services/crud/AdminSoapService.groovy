//import com.ericsson.schemas.vas.AddUserRequest
//import com.ericsson.schemas.vas.AddUserResponse
//import com.ericsson.schemas.vas.AdminPortType
//import crud.User
//import org.grails.cxf.utils.GrailsCxfEndpoint
//
//import javax.jws.WebParam
//import javax.transaction.Transactional
//
//
//@Transactional
//@GrailsCxfEndpoint
//class AdminSoapService implements AdminPortType {
//
//
//
//    @Override
//    AddUserResponse addUser(@WebParam(name = "addUserRequest", targetNamespace = "http://schemas.ericsson.com/vas/", partName = "addUserRequest") AddUserRequest addUserRequest) {
//        AddUserResponse response= new AddUserResponse()
//        if(
//            !addUserRequest.firstName||
//            !addUserRequest.lastName ||
//            !addUserRequest.email    ||
//            !addUserRequest.phone    ||
//            !addUserRequest.title    ||
//            !addUserRequest.password ||
//            !addUserRequest.role
//        ){
//            response.status ="All Fields Are Required"
//            return response
//        } else if (User.findByEmail(addUserRequest.email)){
//            response.status="Email Already Registered"
//            return response
//        }else{
//            User user= new User(
//                    firstName: addUserRequest.firstName,
//                    lastName: addUserRequest.lastName,
//                    email: addUserRequest.email,
//                    phone: addUserRequest.phone,
//                    title: addUserRequest.title,
//                    password: addUserRequest.password,
//                    role: addUserRequest.role
//            )
//            if (user.save(flush:true)){
//                response.status="User Saved Successfully"
//                return response
//            } else {
//                response.status="User Save Failed"
//                return response
//            }
//        }
//
//    }
//}