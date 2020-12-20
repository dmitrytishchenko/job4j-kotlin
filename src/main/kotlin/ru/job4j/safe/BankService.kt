package ru.job4j.safe


class BankService {
    private val users: HashMap<User, ArrayList<Account>> = HashMap()

    fun addUser(user: User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByPassport(passport: String): User? {
        for (user in users.keys) {
            if (user.passport == passport) {
                return user
            }
        }
        return null
    }

    fun addAccount(passport: String, account: Account) {
        val user = findByPassport(passport)
        users[user]?.add(account)
    }

    fun findByRequisite(passport: String, requisite: String): Account? {
        val user = findByPassport(passport) ?: return null
        return users[user]!!.stream().filter { it.requisite == requisite }.findFirst().orElse(null)
    }

    fun transferMoney(
        srcPassport: String,
        srcRequisite: String,
        destPassport: String,
        destRequisite: String,
        amount: Double
    ): Boolean {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, destRequisite)
        val rsl = source != null && dest != null
        if (rsl) {
            source!!.balance = source.balance - amount
            dest!!.balance = dest.balance + amount
        }
        return rsl
    }
}

fun main() {
    val bank = BankService()
    bank.addUser(User("Dmitri", "321"))
    bank.addUser(User("Ben", "123"))
    val user1 = bank.findByPassport("321")
    val user2 = bank.findByPassport("123")
    println(user1?.name)
    println(user2?.name)
    val account1 = Account("some requisite1", 500.0)
    println(account1.requisite)
    val account2 = Account("some requisite2", 100.0)
    println(account2.requisite)
    bank.addAccount("321", account1)
    bank.addAccount("123", account2)
    println(bank.findByRequisite("321", account1.requisite)?.balance)
    println(bank.findByRequisite("123", account2.requisite)?.balance)
    println(
        bank.transferMoney(
            "321", account1.requisite,
            "123", account2.requisite, 900.0
        )
    )

}