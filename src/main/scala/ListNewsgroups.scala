import scala.util.Properties

import org.apache.commons.net.nntp.NNTPClient;
import org.apache.commons.net.nntp.NewsgroupInfo;

object Main extends App {
  def getClient(hostname: String, port: Int, username: String, password: String): NNTPClient = {
    val client = new NNTPClient()
    client.connect(hostname, port)
    if (!username.isEmpty & !password.isEmpty) {
      client.authenticate(username, password)
    }
    client
  }

  def getNewsgroups(client: NNTPClient) = Option(client.listNewsgroups())

  val hostname = "news.newshosting.com"
  val port = 119  // Remember, non-SSL for now
  val username = Properties.envOrElse("USERNAME", "")
  val password = Properties.envOrElse("PASSWORD", "")
  val client = getClient(hostname, port, username, password)
  getNewsgroups(client) match {
      case Some(x: Array[NewsgroupInfo]) => println(x.length + " newsgroups found")
      case None => println("Error with client connection.  Check ${USERNAME} and ${PASSWORD}")
  }
}

