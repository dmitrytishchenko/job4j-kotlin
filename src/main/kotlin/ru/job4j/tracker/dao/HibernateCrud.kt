package ru.job4j.tracker.dao

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import ru.job4j.tracker.Item

fun main() {
    val registry = StandardServiceRegistryBuilder().configure().build()
    try {
        val sf = MetadataSources(registry).buildMetadata().buildSessionFactory()
        val item = create(
            Item(
                1,
                "itemName",
                "desc",
                "comments"
            ), sf
        )
        println(item)
        item.name = "Learn Hibernate"
        update(item, sf)
        println(item)
        val rsl = findById(item.id, sf)
        println(rsl)
        delete(rsl.id, sf)
        val list = findAllItem(sf)
        for (it in list) {
            println(it)
        }
    } finally {
        StandardServiceRegistryBuilder.destroy(registry)
    }
}

fun <T> SessionFactory.tx(block: Session.() -> T): T {
    val session = openSession()
    session.beginTransaction()
    val model = session.block()
    session.transaction.commit()
    session.close()
    return model
}

fun create(item: Item, sf: SessionFactory): Item = sf.tx { save(item); item }

fun update(item: Item, sf: SessionFactory) = sf.tx { update(item) }


fun delete(id: Int, sf: SessionFactory) {
    val item = findById(id, sf)
    sf.tx { delete(item) }
}

fun findAllItem(sf: SessionFactory): List<Item> =
    sf.tx { createQuery("from ru.job4j.tracker.Item").list() as List<Item> }

fun findById(id: Int, sf: SessionFactory): Item = sf.tx { get(Item::class.java, id) }
