name := "playing"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "org.scalaz" %% "scalaz-core" % "7.1.4",
  "com.lihaoyi" % "ammonite-repl" % "0.4.8" % "test" cross CrossVersion.full
)

initialCommands in (Test, console) := """ammonite.repl.Repl.run("")"""