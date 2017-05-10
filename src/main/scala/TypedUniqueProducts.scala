package com.au.mylearning.scalding

import com.twitter.scalding._

case class Transaction(id: Long, productId: Long, userId: Long, purchaseAmount: Double, itemDescription: String)
case class User(id: Long, email: String, location: String)

class TypedUniqueProducts(args: Args) extends Job(args) {

  val usersInput : TypedPipe[User]               = TypedPipe.from(List(User(1, "test1@abc.com", "US"),
                                                                       User(2, "test2@abc.com", "AU"),
                                                                       User(3, "test3@abc.com", "IN")))

  val transactionsInput : TypedPipe[Transaction] = TypedPipe.from(List(Transaction(1, 1, 1, 300, "product1"),
                                                                       Transaction(2, 1, 2, 300, "product1"),
                                                                       Transaction(3, 1, 2, 300, "product1"),
                                                                       Transaction(4, 2, 3, 100, "product2"),
                                                                       Transaction(5, 1, 3, 300, "product1")))


    transactionsInput.groupBy(_.userId)
    .join(usersInput.groupBy(_.id))
    .values
    .map{ case (t: Transaction, u: User) => (t.productId, u.location) }
    .distinct
    .groupBy{ case (productId, location) => productId }
    .size
    .write(TypedTsv[(Long, Long)](args("output")))
}