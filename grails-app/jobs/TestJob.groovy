//package crud
//
//class TestJob {
//    AdminService adminService
//
//    static triggers = {
//        cron name: 'dailyEmailTrigger', cronExpression: '0 35 9 * * ?'
////        simple name: 'mySimpleTrigger', startDelay: 2000, repeatInterval: 600 // Repeats every 60 seconds (60000 milliseconds)
//    }
//
//    def execute() {
//        adminService.sendDailyReminderToDisabledUsers()
//    }
//}

package crud

class TestJob {
    AdminService adminService

    // Lock to prevent overlapping runs
    private static boolean isRunning = false

    static triggers = {
        // Every 5 minutes, between 9:30 AM (09:30) and 9:30 PM (21:30)
        cron name: 'emailJobTrigger', cronExpression: '0 0/5 9-21 * * ?'
    }

    def execute() {
        if (isRunning) {
            log.warn("Previous email job still running, skipping this run.")
            return
        }

        try {
            isRunning = true
            adminService.sendDailyReminderToDisabledUsers()
        } finally {
            isRunning = false
        }
    }
}
