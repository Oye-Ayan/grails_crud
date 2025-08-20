package crud

class TestJob {
    AdminService adminService

    static concurrent = false

    static triggers = {
        // Every 5 mins, bw 9AM  and 9PM (21)
        cron name: 'emailJobTrigger', cronExpression: '0 0/5 9-21 * * ?'
    }

    def execute() {
            adminService.sendDailyReminderToDisabledUsers()
    }
}
