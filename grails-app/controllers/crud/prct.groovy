//import crud.User
//import grails.converters.JSON
//
//class prct{
//    def saveUser(String name,
//                 Long phone,
//                 String email,
//            int age){
//        Map result= [:]
//        User user= new User(name: name, phone: phone, email: email)
//        try{user.save(flush:true)
//        }catch(Exception e){
//            result=[status: "failed", error:e.message]
//        }
//        render(result as JSON)
//    }
//
//    def updateUser(
//            String email,
//            String name,
//            Long phone,
//            int age
//    ){ if(!email){
//        result=[status: 'fail', message:'not found']
//    }
//    User user= User.findByEmail(email)
//        if(!user){
//            result=[status: 'fail', message:'not found']
//        }
//       user.name= name?:user.name
//        user.phone= phone?:phone
//        user.age=age?:age
//        if (user.save(flush: true)) {
//            return true
//        } else {
//            result = [status: 'fail', message: 'Validation failed', errors: user.errors.allErrors]
//            return false
//        }
//
//
//    }
//}