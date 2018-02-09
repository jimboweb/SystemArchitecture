import java.io.File.separator

fun joinOptions(options: Collection<String>) = options.joinToString(
        prefix ="[", postfix = "]"
)
