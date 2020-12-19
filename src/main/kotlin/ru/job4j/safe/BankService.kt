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
        if (user != null) {
            users[user]?.add(account)
        }
    }

    private fun findByRequisite(passport: String, requisite: String): Account? {
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
    val user = bank.findByPassport("321")
    println(user?.name)
}