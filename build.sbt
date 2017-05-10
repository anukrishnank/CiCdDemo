scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test"

libraryDependencies ++= Seq(
  "com.twitter" %% "scalding-core" % "0.14.0",
  "org.apache.hadoop" % "hadoop-core" % "1.0.0",
  "org.scalatest" %% "scalatest" % "2.2.4",
  "junit" % "junit" % "4.9"
)

initialCommands in console := """
                                |import com.twitter.scalding._
                                |import com.twitter.scalding.mathematics._
                              """.stripMargin

resolvers += "Concurrent Maven Repo" at "http://conjars.org/repo"

