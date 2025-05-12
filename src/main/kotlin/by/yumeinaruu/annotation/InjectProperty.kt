package by.yumeinaruu.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class InjectProperty(
    val value: String = ""
)
