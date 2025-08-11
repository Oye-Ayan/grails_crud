package crud

class TestJob {
    AdminService adminService

    static triggers = {
        cron name: 'dailyEmailTrigger', cronExpression: '0 35 9 * * ?'
//        simple name: 'mySimpleTrigger', startDelay: 2000, repeatInterval: 600 // Repeats every 60 seconds (60000 milliseconds)
    }

    def execute() {
        adminService.sendDailyReminderToDisabledUsers()
    }
}