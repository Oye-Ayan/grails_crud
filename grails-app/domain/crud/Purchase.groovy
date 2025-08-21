package crud

class Purchase {
    User user
    Book book
    Date date = new Date()

    static belongsTo = [user: User, book: Book]

    static constraints = {
        user nullable: false
        book nullable: false
    }
//    static List<Map> getBooksSortedByPopularity() {
//        def topBooksQuery = Purchase.createCriteria().list {
//            projections {
//                groupProperty("book")      // group by book
//                count("id", 'purchaseCount') // count purchases
//            }
//            order("purchaseCount", "desc")
//        }
//        return topBooksQuery.collect { row ->
//            [book: row[0], count: row[1]]
//        }
//    }
    static namedQueries = {
        booksSortedByPopularity {
            projections {
                groupProperty("book")       // group by book
                count("id", "purchaseCount") // har book ka total purchase count
            }
            order("purchaseCount", "desc") // bought most top pr
        }
    }
}
