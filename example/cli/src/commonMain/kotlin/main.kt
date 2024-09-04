import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import kotlinx.coroutines.runBlocking

class Teachers : CliktCommand(){
    override fun run() {
        val client = createSuaiRaspClient {  }
        
        runBlocking {
            client.teachers().forEach {
                echo(it.name)
            }
        }
    }
}


class Info : CliktCommand(){
    
    override fun run() {
        val client = createSuaiRaspClient {  }

        runBlocking {
            echo(client.info())
        }
    }
}

class SuaiCLI : CliktCommand(){
    override fun run() = Unit
}

fun main(args: Array<String>) = SuaiCLI().subcommands(Teachers(), Info()).main(args)