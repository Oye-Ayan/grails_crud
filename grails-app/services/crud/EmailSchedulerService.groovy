//package crud
//
//import org.springframework.scheduling.annotation.Scheduled
//
//class EmailSchedulerService {
//
//    def mailService
//
//    @Scheduled(cron = "0 45 16 * * ?")
//
//    void sendDailyReminderToDisabledUsers() {
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
//}


//package crud
//
//import groovy.transform.CompileStatic
//import org.springframework.scheduling.annotation.Scheduled
//
//@CompileStatic
//class EmailSchedulerService {
//
////    def mailService
//    AdminService adminService
//
//    @Scheduled(initialDelay = 5000L, fixedDelay = 5000L) // Every 30 seconds
//    void runReminderJob() {
//        println "EmailSchedulerService triggered at ${new Date()}"
//        adminService.sendDailyReminderToDisabledUsers()
//        println "EmailSchedulerService triggered at ${new Date()}"
//
//    }
//
//
//}
