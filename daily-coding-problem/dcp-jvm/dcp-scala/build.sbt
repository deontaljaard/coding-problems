lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      version := "0.1",
      scalaVersion := "2.13.1"
    )),
    name := "dcp-scala"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
