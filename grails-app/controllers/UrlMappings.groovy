class UrlMappings {

    static mappings = {
        // --- Root ---
        "/"(controller: "auth", action: "index")

        // --- Authentication Routes ---
        "/login"(controller: "auth", action: "index")
        "/login/submit"(controller: "auth", action: "loginSubmit")
        "/logout"(controller: "auth", action: "logout")

        // --- Admin Routes ---
        "/admin"(controller: "admin", action: "index")
        "/admin/dashboard"(controller: "admin", action: "adminDashboard")

        "/admin/addUser"(controller: "admin", action: "addUser")
        "/admin/updateUser"(controller: "admin", action: "updateUser")
        "/admin/deleteUser"(controller: "admin", action: "delUser")
        "/admin/showUsers"(controller: "admin", action: "showUsers")

        "/admin/addBook"(controller: "admin", action: "addBook")
        "/admin/updateBook"(controller: "admin", action: "updateBook")
        "/admin/deleteBook"(controller: "admin", action: "delBook")
        "/admin/showBooks"(controller: "admin", action: "showBooks")

        // --- User Routes ---
        "/user"(controller: "user", action: "index")

        "/user/changePass"(controller: "user", action: "changePass")
        "/user/changePassword"(controller: "user", action: "changePassword")

        "/user/booksList"(controller: "user", action: "booksList")
        "/user/purchaseBook"(controller: "user", action: "purchaseBook")
        "/user/myPurchases"(controller: "user", action: "myPurchases")
        "/user/myBooks"(controller: "user", action: "myBooks")

        // --- Error Routes ---
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
