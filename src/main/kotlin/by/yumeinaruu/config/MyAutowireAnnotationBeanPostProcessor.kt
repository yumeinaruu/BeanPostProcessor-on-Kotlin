package by.yumeinaruu.config

import by.yumeinaruu.annotation.MyAutowire
import by.yumeinaruu.factory.ObjectFactory

class MyAutowireAnnotationBeanPostProcessor : BeanPostProcessor {
    override fun configure(t: Any) {
        for (field in t.javaClass.declaredFields) {
            if (field.isAnnotationPresent(MyAutowire::class.java)) {
                field.isAccessible = true
                val obj = ObjectFactory.getInstance().createBean(field.type)
                field.set(t, obj)
            }
        }
    }
}