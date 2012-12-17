name := "NNTP Browser"

version := "0.1"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq( 
    "org.scalatest" %% "scalatest" % "1.6.1" % "test",
    "commons-net" % "commons-net" % "3.1",
    "org.mongodb" %% "casbah" % "2.4.1"
)

resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

